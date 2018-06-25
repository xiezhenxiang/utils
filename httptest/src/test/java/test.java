
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.UpdateResult;
import impl.ApacheHttpReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {

    private  static MongoClient mongoClient=null;

    public static void main(String[] args) throws Exception {

        ApacheHttpReader reader = new ApacheHttpReader();
        String ipStr = null;

        ipStr = reader.readSource("http://api.ip.data5u.com/dynamic/get.html?order=f90eebe0a0e9fb9f99a602d7204cd6a5&sep=3");

        String ip = ipStr.substring(0, ipStr.indexOf(":"));
        Integer port = Integer.parseInt(ipStr.substring(ipStr.indexOf(":")+1).trim());
        ApacheHttpReader apacheHttpReader = new ApacheHttpReader(ip,port);


        String html = "";
        String url = "https://ccc-x.jd.com/dsp/nc?ext=aHR0cDovL2l0ZW0uamQuY29tLzEyMzk3MDQ3MDg1Lmh0bWw&log=-nBrJWEvd1R_kVyAlpS7KuBu4ndobLnkTC0X9-xzOlILEev89Xq_ym-3_LzAJnUyFMTDveRpVcL9xk-w-JrsDd6as3iLKO8N63rbfqWzSWvGLOQEr_axOMgU0NDKR5gmDqP1BBR1cjjlElPN_hVSmhr7HmirfHZ-fpsYPZyY_wfjOnl00VEb8WvvROW3WfjkH_p1EhkHifWZFv0Z_AFv9S22RqRoGZCAGicfGibCdXUmQm4jqCzibrIUkDF_ikBtDGNx6E2NhdQslm94EPZapeHHACVB8ybT3uw4e3yHsyai1TjhK5aCZsSflybgFTPx0VnV6v9GAsEU0tSWpi1wLKxje1Ouy7apPeiXraNG6fv784WSeJoOF6ojsksMOMgU_Qm3wlafkY01ElefbFT_476Tkk_C9joV4AjZZIV7IuE&v=404";
        html = apacheHttpReader.readSource(url, HttpReader.UTF_8, "_user_identify_=b15cd160-1457-3a2e-9e2a-eb0e7cce0cf1; uID=462975; sID=a24dbe198f68c7e4e8272fa2d3da2614; JSESSIONID=aaa7tkLRHUx_V6Tiv5Jiw; Hm_lvt_37854ae85b75cf05012d4d71db2a355a=1520563327,1520649699,1520675513,1521020670; Hm_lvt_ddf0d99bc06024e29662071b7fc5044f=1520563327,1520649699,1520675514,1521020673; Hm_lpvt_37854ae85b75cf05012d4d71db2a355a=1521025099; Hm_lpvt_ddf0d99bc06024e29662071b7fc5044f=1521025099");
        System.out.println(html);

        System.out.println("end");
    }

    public static synchronized MongoClient mongoClient(){
        if(mongoClient == null){
            MongoClientOptions options = MongoClientOptions.builder().connectTimeout(100000).maxWaitTime(1000000).build();
            mongoClient =  new MongoClient(new ServerAddress("192.168.1.156", 27017), options);
        }
        return mongoClient;
    }
}