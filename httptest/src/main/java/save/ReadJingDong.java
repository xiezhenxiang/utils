package save;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.util.JSON;
import impl.ApacheHttpReader;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import org.bson.Document;
import org.bson.conversions.Bson;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadJingDong{
    private  static MongoClient mongoClient=null;

    public static void main(String[] args) throws Exception {

       /* ApacheHttpReader reader = new ApacheHttpReader();
        String ipStr = null;

        ipStr = reader.readSource("http://api.ip.data5u.com/dynamic/get.html?order=f90eebe0a0e9fb9f99a602d7204cd6a5&sep=3");

        String ip = ipStr.substring(0, ipStr.indexOf(":"));
        Integer port = Integer.parseInt(ipStr.substring(ipStr.indexOf(":")+1).trim());
        ApacheHttpReader apacheHttpReader = new ApacheHttpReader(ip,port);*/

        MongoCollection<DBObject> db = mongoClient().getDatabase("jingdong").getCollection("phone", DBObject.class);
        MongoCursor<DBObject> dbOb = db.find().iterator();
        int cnt = 1;
        while (dbOb.hasNext()){
            DBObject dbObject = dbOb.next();
            String url = (String) dbObject.get("url");
            String price = (String) dbObject.get("price");
            String html = (String) dbObject.get("html");
            BasicDBObject bson = new BasicDBObject();

            bson.put("url", url);

            html = html.replaceAll("\n\r", "").replaceAll("\n", "").replaceAll("\r", "")
                    .replaceAll("\t", "").replaceAll(" ", "");

            String imgStr = html.substring(html.indexOf("imageList:[") + 11, html.indexOf("]", html.indexOf("imageList:[")));

            String imgUrls[] = imgStr.split(",");
            for(int i = 0; i < imgUrls.length; i ++){
                imgUrls[i] = "https://img10.360buyimg.com/n1/" + imgUrls[i].replaceAll("\"", "");
            }

            bson.put("imgUrls", imgUrls);

            String pinpai = "";
            if(html.indexOf("<dt>品牌") > 0) {
                pinpai = html.substring(html.indexOf("<dt>品牌") + 15, html.indexOf("</dd", html.indexOf("<dt>品牌")));
            }else if(html.indexOf("品牌：") > 0){
                int start = html.substring(0, html.indexOf("</a>", html.indexOf("品牌："))).lastIndexOf(">") + 1;
                pinpai = html.substring( start, html.indexOf("</a>", html.indexOf("品牌：")));
            }

            String s;
            String xinghao = "";
            if(html.indexOf("对外宣传") > 0){
                s = html.substring(html.indexOf("对外宣传"));
                try {
                    xinghao = s.substring(s.indexOf("<dd>") + 4, s.indexOf("</dd>", s.indexOf("<dd>"))).trim();
                }catch (Exception e){
                    xinghao = "以官网信息为准";
                }
            }

            String name = pinpai + xinghao;
            bson.put("name", name);
            double d = 0.0;
            try{

                d = Double.parseDouble(price);

            }catch (Exception e){
                continue;
            }
            bson.put("price", d);
            bson.put("brand", pinpai);
            bson.put("model", xinghao);
            String ruwangxinghao = "";

            if(html.indexOf("或者入网型号") > 0) {
                s = html.substring(html.indexOf("或者入网型号"));
                try {
                    ruwangxinghao = s.substring(s.indexOf("<dd>") + 4, s.indexOf("</dd>", s.indexOf("<dd>"))).trim();
                }catch (Exception e){
                    ruwangxinghao = "以官网信息为准";
                }
            }
            bson.put("netModel", ruwangxinghao);
            String shangshinianfen = html.substring(html.indexOf("<dt>上市年份") + 17, html.indexOf("</dd", html.indexOf("<dt>上市年份")));
            bson.put("publicYear", shangshinianfen);
            String shangshiyuefen = html.substring(html.indexOf("<dt>上市月份") + 17, html.indexOf("</dd", html.indexOf("<dt>上市月份")));
            bson.put("publicMonth", shangshiyuefen);
            String jishenyanse = html.substring(html.indexOf("<dt>机身颜色") + 17, html.indexOf("</dd", html.indexOf("<dt>机身颜色")));
            bson.put("color", jishenyanse);
            String pingmuchicun = html.substring(html.indexOf("<dt>主屏幕尺寸") + 22, html.indexOf("</dd", html.indexOf("<dt>主屏幕尺寸")));
            bson.put("creenSize", pingmuchicun);
            String zhongliang = html.substring(html.indexOf("商品毛重") + 5, html.indexOf("</li>", html.indexOf("商品毛重")));
            bson.put("weight", zhongliang);
            String jishencaizhi = "";
            if(html.indexOf("机身材质") >0) {
                s = html.substring(html.indexOf("机身材质"));
                jishencaizhi = html.substring(html.indexOf("<dt>机身材质") + 19, html.indexOf("</dd", html.indexOf("<dt>机身材质")));
            }
            bson.put("material", jishencaizhi);

            String houdu = html.substring(html.indexOf("<dt>机身厚度") + 21, html.indexOf("</dd", html.indexOf("<dt>机身厚度")));
            bson.put("thickness", houdu);

            String caozuoxitong = "以官网信息为准";

            if(html.indexOf("操作系统") > 0) {
                s = html.substring(html.indexOf("操作系统"));
                caozuoxitong = html.substring(html.indexOf("<dt>操作系统") + 17, html.indexOf("</dd", html.indexOf("<dt>操作系统")));
            }
            bson.put("system", caozuoxitong);
            String cpuxinghao = "";
            if(html.indexOf("CPU型号") > 0){

                s = html.substring(html.indexOf("CPU型号"));
                cpuxinghao = html.substring(html.indexOf("<dt>CPU型号") + 18, html.indexOf("</dd", html.indexOf("<dt>CPU型号")));
            }
            bson.put("cpuModel", cpuxinghao);
            String cpuheshu = "";
            if(html.indexOf("CPU核数") > 0){

                s = html.substring(html.indexOf("CPU核数"));
                cpuheshu = html.substring(html.indexOf("<dt>CPU核数") + 18, html.indexOf("</dd", html.indexOf("<dt>CPU核数")));
            }
            bson.put("cpuKernel", cpuheshu);
            String jishenneicun = "";
            if(html.indexOf("机身的存储空间") > 0) {
                s = html.substring(html.indexOf("机身的存储空间"));
                try {
                    jishenneicun = s.substring(s.indexOf("<dd>") + 4, s.indexOf("</dd>", s.indexOf("<dd>"))).trim();
                }catch (Exception e){
                    jishenneicun = "以官网信息为准";
                }
            }
            bson.put("storageMemory", jishenneicun);

            String yunxingneicun = "";
            if(html.indexOf("机型的运行内存") > 0) {
                s = html.substring(html.indexOf("机型的运行内存"));
                try{
                    yunxingneicun = s.substring(s.indexOf("<dd>") + 4, s.indexOf("</dd>", s.indexOf("<dd>"))).trim();
                }catch (Exception e){
                    yunxingneicun = "以官网信息为准";
                }
            }
            bson.put("runMemory", yunxingneicun);

            String dianchi = html.substring(html.indexOf("<dt>电池容量（mAh）") + 22, html.indexOf("</dd", html.indexOf("<dt>电池容量（mAh）")));

            bson.put("batteryCapacity", dianchi);

            String qianchi = html.substring(html.indexOf("<dt>前置摄像头") + 18, html.indexOf("</dd", html.indexOf("<dt>前置摄像头")));
            bson.put("frontCamera", qianchi);

            String houzhi = html.substring(html.indexOf("<dt>后置摄像头") + 18, html.indexOf("</dd", html.indexOf("<dt>后置摄像头")));
            bson.put("rearCamera", houzhi);

            String fenbian = html.substring(html.indexOf("<dt>分辨率") + 16, html.indexOf("</dd", html.indexOf("<dt>分辨率")));

            if(fenbian.length() > 60){
                fenbian = "";
            }
            bson.put("resolution", fenbian);

            MongoCollection<DBObject> db2 = mongoClient().getDatabase("jingdong").getCollection("data2", DBObject.class);
            db2.insertOne(bson);

            System.out.println(cnt ++);

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
