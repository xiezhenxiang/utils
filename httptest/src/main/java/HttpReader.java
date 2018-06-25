import java.io.Closeable;


/**
 * 
 *
 *
 *
 * @author pzn
 * @since 1.7
 * @version 1.0
 */
public interface HttpReader extends Closeable {


    

    final String HTTP_GET = "get";
    final String HTTP_POST = "post";

    final String GB_K = "gbk";
    final String GB_2312 = "gb2312";
    final String GB_18030 = "gb18030";
    final String UTF_8 = "utf-8";
    final String ISO_8859_1 = "iso-8859-1";


    String readSource(String url);

    String readSource(String url, String charset);

    String readSource(String url, String charset, String cookie);

    String readSource(String url, String charset, String cookie, String requestType, String params);
    
    void close();

}
