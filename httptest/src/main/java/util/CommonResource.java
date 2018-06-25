package util;

import java.io.IOException;
import java.util.Properties;

public class CommonResource {


    static Properties props = new Properties();
    static {
        try {
            props.load(CommonResource.class.getClassLoader().getResourceAsStream("tagging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            // 直接退出jvm
            System.exit(1);
        }
    }
    public static final String DB_TYPE = props.getProperty("db_type", "mongodb");
    public static final String INDBURL = props.getProperty("in_db_url", "123");
    public static final Integer INDBPORT = Integer.parseInt(props.getProperty("in_db_port", "19130"));
    public static final String INDBDB = props.getProperty("in_db_db", "admin");
    public static final String INDBTABLE = props.getProperty("in_db_table", "123456");
    public static final String OUTDBURL = props.getProperty("dedup_db_db", "123");
    public static final String OUTDBPORT = props.getProperty("dedup_db_table", "19130");


    public static final String ZWINDBDB = props.getProperty("zw_db", "admin");
    public static final String ZWINDBTABLE = props.getProperty("zw_db_table", "123456");
    public static final String ZWOUTDBURL = props.getProperty("dedup_zw_db", "123");
    public static final String ZWOUTDBPORT = props.getProperty("dedup_zw_table", "19130");

    public static final String ES_IP = props.getProperty("es_ip", "123");
    public static final String ES_NAME = props.getProperty("es_name", "19130");
    public static final Integer ES_PORT = Integer.parseInt(props.getProperty("es_port", "19130"));

    public static final String ES_OTHER_IP = props.getProperty("es_ip_other", "123");
    public static final String ES_NAME_OTHER = props.getProperty("es_name_other", "19130");
    public static final Integer ES_OTHER_PORT = Integer.parseInt(props.getProperty("es_port_other", "19130"));

}
