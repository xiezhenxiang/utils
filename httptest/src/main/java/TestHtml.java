
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.UpdateResult;
import impl.ApacheHttpReader;
import org.bson.conversions.Bson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class TestHtml {

    private  static MongoClient mongoClient=null;

    public static void main(String[] args) throws Exception {





    }

    public static synchronized MongoClient mongoClient(){
        if(mongoClient == null){
            MongoClientOptions options = MongoClientOptions.builder().connectTimeout(100000).maxWaitTime(1000000).build();
            mongoClient =  new MongoClient(new ServerAddress("192.168.1.156", 27017), options);
        }
        return mongoClient;
    }
}