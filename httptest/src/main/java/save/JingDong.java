package save;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.UpdateResult;
import impl.ApacheHttpReader;
import impl.HttpReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class JingDong {

    private  static MongoClient mongoClient=null;

    public static void main(String[] args) throws Exception {

        ApacheHttpReader reader = new ApacheHttpReader();
        String ipStr = null;

        ipStr = reader.readSource("http://api.ip.data5u.com/dynamic/get.html?order=f90eebe0a0e9fb9f99a602d7204cd6a5&sep=3");

        String ip = ipStr.substring(0, ipStr.indexOf(":"));
        Integer port = Integer.parseInt(ipStr.substring(ipStr.indexOf(":")+1).trim());
        ApacheHttpReader apacheHttpReader = new ApacheHttpReader(ip,port);

        for(int i = 191; i < 200; i += 2) {

            String html = "";
            try {
                String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&page=" + i;
                html = apacheHttpReader.readSource(url, HttpReader.UTF_8, "_user_identify_=b15cd160-1457-3a2e-9e2a-eb0e7cce0cf1; uID=462975; sID=a24dbe198f68c7e4e8272fa2d3da2614; JSESSIONID=aaa7tkLRHUx_V6Tiv5Jiw; Hm_lvt_37854ae85b75cf05012d4d71db2a355a=1520563327,1520649699,1520675513,1521020670; Hm_lvt_ddf0d99bc06024e29662071b7fc5044f=1520563327,1520649699,1520675514,1521020673; Hm_lpvt_37854ae85b75cf05012d4d71db2a355a=1521025099; Hm_lpvt_ddf0d99bc06024e29662071b7fc5044f=1521025099");
            }catch (Exception e){

                Thread.sleep(100);
                try {
                    ipStr = reader.readSource("http://api.ip.data5u.com/dynamic/get.html?order=f90eebe0a0e9fb9f99a602d7204cd6a5&sep=3");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                ip = ipStr.substring(0, ipStr.indexOf(":"));
                port = Integer.parseInt(ipStr.substring(ipStr.indexOf(":") + 1).trim());
                apacheHttpReader = new ApacheHttpReader(ip, port);
                i -= 2;
                continue;
            }

            int pos = 0;
            while(pos < html.length() && html.indexOf("p-price", pos) > 0){

                pos = html.indexOf("p-price", pos);
                if(pos <= 70767 && i == 191){
                    pos += 10;
                    continue;
                }
                String price = html.substring(html.indexOf("<i>", pos) + 3, html.indexOf("</i>", pos));

                String url = html.substring(html.indexOf("href=", pos) + 6, html.indexOf("\"", html.indexOf("href=", pos) + 6));
                if(url.startsWith("//"))
                    url = "https:" + url;

                String html2 = "";
                while(true) {
                    try {
                        html2 = apacheHttpReader.readSource(url, HttpReader.UTF_8, "_user_identify_=b15cd160-1457-3a2e-9e2a-eb0e7cce0cf1; uID=462975; sID=a24dbe198f68c7e4e8272fa2d3da2614; JSESSIONID=aaa7tkLRHUx_V6Tiv5Jiw; Hm_lvt_37854ae85b75cf05012d4d71db2a355a=1520563327,1520649699,1520675513,1521020670; Hm_lvt_ddf0d99bc06024e29662071b7fc5044f=1520563327,1520649699,1520675514,1521020673; Hm_lpvt_37854ae85b75cf05012d4d71db2a355a=1521025099; Hm_lpvt_ddf0d99bc06024e29662071b7fc5044f=1521025099");
                    }catch (Exception e){
                        Thread.sleep(100);
                        try {
                            ipStr = reader.readSource("http://api.ip.data5u.com/dynamic/get.html?order=f90eebe0a0e9fb9f99a602d7204cd6a5&sep=3");
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        ip = ipStr.substring(0, ipStr.indexOf(":"));
                        port = Integer.parseInt(ipStr.substring(ipStr.indexOf(":") + 1).trim());
                        apacheHttpReader = new ApacheHttpReader(ip, port);
                        continue;
                    }
                    break;
                }
                BasicDBObject bson = new BasicDBObject();
                bson.put("url", url);
                bson.put("price", price);
                bson.put("html", html2);
                MongoCollection<DBObject> db = mongoClient().getDatabase("jingdong").getCollection("phone", DBObject.class);
                MongoCursor<DBObject> dbOb = db.find().iterator();
                boolean isExist = false;
                while (dbOb.hasNext()){
                    DBObject dbObject = dbOb.next();
                    String urlIN = (String) dbObject.get("url");
                    if(urlIN != null && urlIN.equals(url)){
                        isExist = true;
                        break;
                    }
                }
                if(!isExist){
                    db.insertOne(bson);
                }

                System.out.println("pos: " + pos);
                pos += 10;
            }

            System.out.println("i: " + i);
        }
    }


    public static synchronized MongoClient mongoClient(){
        if(mongoClient == null){
            MongoClientOptions options = MongoClientOptions.builder().connectTimeout(100000).maxWaitTime(1000000).build();
            mongoClient =  new MongoClient(new ServerAddress("192.168.1.156", 27017), options);
        }
        return mongoClient;
    }
}