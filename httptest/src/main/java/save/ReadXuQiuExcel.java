package save;
import net.sf.json.JSONArray;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import util.DBUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadXuQiuExcel {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Administrator\\Desktop\\需求列表.xls";
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

                String title = "", sourceOrg = "", publicTime = "", type = "76", subject = "" , vocation = "", tag = "", author ="", content = "", way = "1"
                        , sum = "", contactsName = "", contactsTel = "", contactsEmail = "", leaderAddr = "", leaderBranch = "", leaderCountry = "", status = "1";


                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        title = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        sourceOrg = value;
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
                        tag = value;
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
                        contactsName = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        contactsTel = value;
                    }
                }
                cellNum ++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && ! "".equals(value)) {
                        contactsEmail = value;
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

                type = "[";
                for(int j = 0; j < typeArr.length; j ++){
                    type += "\"" + typeArr[j] +"\"" + ",";
                }

                type = type.substring(0, type.length() - 1) + "]";

                String tagArr[] = tag.split(",");

                tag = "[";
                for(int j = 0; j < tagArr.length; j ++){
                    tag += "\"" + tagArr[j] +"\"" + ",";
                }

                tag = tag.substring(0, tag.length() - 1) + "]";

                sql += "insert into tb_outcome (title, way, sourceOrg, publicTime, type, subject, vocation, tag, author, content, sum, contactsName, contactsTel, contactsEmail, leaderAddr"
                        + ", leaderBranch, leaderCountry, status, addTime) values(" + "\"" + title + "\",\"" + way + "\",\"" + sourceOrg
                        + "\"," + (publicTime.equals("")?(null):("\"" + publicTime + "\""))  + ",'" + type + "',\"" + subject + "\",\"" + vocation
                        + "\",'" + tag + "',\"" + author + "\",\""  + content + "\",\"" + sum + "\",\"" + contactsName  + "\",\"" + contactsTel+ "\",\"" + contactsEmail
                        + "\",\"" + leaderAddr + "\",\"" + leaderBranch + "\",\"" + leaderCountry + "\",\"" + status + "\",\"" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\")";

                sql += ";\n";

            }
        }

        Writer write = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\sql.txt"), "UTF-8");
        write.write(sql);
        write.flush();
        write.close();
    }
}
