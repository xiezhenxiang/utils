import net.sf.json.JSONArray;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import util.DBUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {

        String filePath = "C:/Users/hiekn-hai/Desktop/需求列表.xls";
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
        // 获取sheet页
        HSSFSheet sheet = wb.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();// 获取总行数
        String sql = "";

        for (int i = 1; i <= rowNum; i++) {


            HSSFRow row = (HSSFRow) sheet.getRow(i);
            // 列标
            if (row != null && row.getCell(0) != null && !row.getCell(0).getStringCellValue().trim().equals(null)) {
                int cellNum = 0;

                String needName = "", needBranch = "", publicTime = "", type = "76", subject = "" , vocation = "", kw = "", author ="", source = "", content = "", way = "1"
                        , sum = "", leaderName = "", leaderPhone = "", leaderMaix = "", leaderAddr = "", leaderBranch = "", leaderCountry = "", checkStatus = "1";


                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        needName = value;
                    } 
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        needBranch = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        publicTime = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        type = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        subject = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        vocation = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        kw = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        author = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        source = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {
                    try {
                        row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                        String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                                .replaceAll("\r", "").replaceAll("\"", "'");

                        if (value != null && !"".equals(value)) {
                            content = value;
                        }
                    }catch (Exception e){}
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        sum = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        leaderName = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        leaderPhone = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        leaderMaix = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        leaderAddr = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        leaderBranch = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        leaderCountry = value;
                    }
                }


                String typeArr[] = type.split(",");


                for(int j = 0; j < typeArr.length; j ++){
                    sql += "insert into tb_outcome (needName, way, needBranch, publicTime, type, subject, vocation, kw, author, source, content, sum, leaderName, leaderPhone, leaderMaix, leaderAddr"
                            + ", leaderBranch, leaderCountry, checkStatus, addTime) values(" + "\"" + needName + "\",\"" + way + "\",\"" + needBranch
                            + "\"," + (publicTime.equals("")?(null):("\"" + publicTime + "\""))  + ",\"" + typeArr[j] + "\",\"" + subject + "\",\"" + vocation
                            + "\",\"" + kw + "\",\"" + author + "\",\"" + source + "\",\"" + content + "\",\"" + sum + "\",\"" + leaderName  + "\",\"" + leaderPhone+ "\",\"" + leaderMaix
                            + "\",\"" + leaderAddr + "\",\"" + leaderBranch + "\",\"" + leaderCountry + "\",\"" + checkStatus + "\",\"" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\")";

                    sql += ";\n";
                }

            }
        }

        Writer write = new OutputStreamWriter(new FileOutputStream("C:/Users/hiekn-hai/Desktop/sql.txt"), "UTF-8");
        write.write(sql);
        write.flush();
        write.close();
    }
}
