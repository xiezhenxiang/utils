package  save;
import net.sf.json.JSONArray;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import util.DBUtils;

import java.io.*;
import java.util.*;

public class ReadAgentExcel {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Administrator\\Desktop\\用户列表(1).xls";
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
        // 获取sheet页
        HSSFSheet sheet = wb.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();// 获取总行数
        System.out.println(132);
        String sql = "";

        for (int i = 1; i <= rowNum; i++) {

            String guid = "", name = "", alias = "", gender = "", phone = "", fax = "", birthday = "", mailbox = "", branch = "", address = "", titleType = "", userType = ""
                    ,firmType = "", orgCode = "", praImage = "", taxNum = "", education = "", honor = "", major = "", greenType = "76", workOn = "", brief = "", status = "1"
                    , auditStatus = "1", addTime = "";


            HSSFRow row = (HSSFRow) sheet.getRow(i);
            // 列标
            if (row != null && row.getCell(0) != null && !row.getCell(0).getStringCellValue().trim().equals(null)) {
                int cellNum = 0;

                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        guid = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        name = value;
                    }
                }
                if (name.equals("")) {
                    continue;
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        alias = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        gender = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        phone = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        fax = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        birthday = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        mailbox = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        branch = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        address = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        titleType = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        userType = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", "").replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        firmType = value;
                    }
                }
                cellNum++;
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        orgCode = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        praImage = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        taxNum = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        education = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim();

                    if (value != null && !"".equals(value)) {
                        honor = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        major = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        greenType = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        workOn = value;
                    }
                }
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);

                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        brief = value;
                    }
                }
                cellNum++;

                cellNum++;

                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", null).replaceAll("\n", null)
                            .replaceAll("\r", null).replaceAll("\"", "'");

                    if (value != null && !"".equals(value)) {
                        addTime = value;
                    }
                }

                String typeArr[] = greenType.split(",");
                greenType = "[";
                for(int j = 0; j < typeArr.length; j ++){
                    greenType += "\"" + typeArr[j] +"\"" + ",";
                }

                greenType = greenType.substring(0, greenType.length() - 1) + "]";

                    sql += "insert into tb_agent (guid, name, alias, gender, phone, fax, birthday, mailbox, branch, address, titleType, userType, firmType, orgCode, praImage"
                            + ", taxNum, education, honor, major, greenType, workOn, brief, status, auditStatus, addTime) values(" + "\"" + guid + "\",\"" + name + "\",\"" + alias
                            + "\",\"" + gender + "\",\"" + phone + "\",\"" + fax + "\",\"" + birthday + "\",\"" + mailbox + "\",\"" + branch + "\",\"" + address + "\",\"" + titleType + "\",\"" + userType
                            + "\",\"" + firmType + "\",\"" + orgCode + "\",\"" + praImage + "\",\"" + taxNum + "\",\"" + education + "\",\"" + honor + "\",\"" + major + "\",'" + greenType
                            + "',\"" + workOn + "\",\"" + brief + "\",\"" + status + "\",\"" + auditStatus + "\",\"" + addTime + "\")";

                    sql += ";\n";
            }
        }

        System.out.println(sql);
    }
}
