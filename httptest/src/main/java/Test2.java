import org.apache.commons.io.FileUtils;
import util.EncodingDetect;
import java.io.File;

public class Test2{


    public static void main(String[] args) throws Exception {

        String filePath = "C:/Users/hiekn-hai/Desktop/test.txt";
        String fileEncode= EncodingDetect.getJavaEncode(filePath);
        String fileContent= FileUtils.readFileToString(new File(filePath),fileEncode);

        System.out.println(fileContent);
    }
}
