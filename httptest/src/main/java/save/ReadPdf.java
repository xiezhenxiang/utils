package save;

import net.sf.json.JSONArray;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.*;
import java.util.*;

public class ReadPdf {

    public static void main(String[] args) throws IOException {

        String filePath = "C:/Users/hiekn-hai/Desktop/end3.xls";
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
        // 获取sheet页
        HSSFSheet sheet = wb.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();// 获取总行数
        String class_1 = "", class_2 = "", class_3 = "";

        List<Map> dataList = new ArrayList<Map>();

        for (int i = 1; i <= rowNum; i++) {

            Map<String, String> data = new HashMap<String, String>();
            HSSFRow row = (HSSFRow) sheet.getRow(i);
            // 列标
            if (row != null && row.getCell(0) != null && !row.getCell(0).getStringCellValue().trim().equals("")) {
                int cellNum = 0;

                //第一个单元格
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim();

                    if(value.equals("序号")){
                        HSSFRow row2 = (HSSFRow) sheet.getRow(i - 1);
                        if (row2.getCell(0) != null) {
                            row2.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                            String classValue = row2.getCell(0).getStringCellValue().trim().replaceAll("\\.", "").replaceAll("\\d+", "");
                            String classArr [] = classValue.split("-");
                            class_1 = classArr[0];
                            if(classArr.length == 2){
                                class_2 = classArr[1];
                                class_3 = "";
                            }else if(classArr.length == 3){
                                class_2 = classArr[1];
                                class_3 = classArr[2];
                            }
                        }
                    }

                    if (value != null && !"".equals(value)) {
                        int count = 0;
                        for(int j = 0; j < value.length(); j ++){
                            if(value.charAt(j) == '-' && Character.isDigit(value.charAt(j + 1))){
                                count += 1;
                            }
                        }
                        if(count != 2){
                            continue;
                        }


                    } else {
                        continue;
                    }
                } else {
                    continue;
                }

                data.put("class_1", class_1);
                if(!class_2.equals("")){
                    data.put("class_2", class_2);
                }
                if(!class_3.equals("")){
                    data.put("class_3", class_3);
                }

                //ICS分类
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", "").replaceAll("\n", "")
                            .replaceAll("\r", "");

                    if (value != null && !"".equals(value)) {
                        data.put("ics", value);
                    } else {
                        data.put("ics", "");
                    }
                } else {
                    data.put("ics", "");
                }

                //GB分类
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", "").replaceAll("\n", "")
                            .replaceAll("\r", "");

                    if (value != null && !"".equals(value)) {
                        data.put("ccs", value);
                    } else {
                        data.put("ccs", "");
                    }
                } else {
                    data.put("ccs", "");
                }

                //标准号
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", "").replaceAll("\n", "")
                            .replaceAll("\r", "");

                    if (value != null && !"".equals(value)) {
                        data.put("num", value);
                    } else {
                        data.put("num", "");
                    }
                } else {
                    data.put("num", "");
                }

                //中文名字
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", "").replaceAll("\n", "")
                            .replaceAll("\r", "");

                    if (value != null && !"".equals(value)) {
                        data.put("name", value);
                    } else {
                        data.put("name", "");
                    }
                } else {
                    data.put("name", "");
                }

                //代替标准
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", "").replaceAll("\n", "")
                            .replaceAll("\r", "");

                    if (value != null && !"".equals(value)) {
                        data.put("sub_num", value);
                    } else {
                        data.put("sub_num", "");
                    }
                } else {
                    data.put("sub_num", "");
                }

                //采用关系
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", "").replaceAll("\n", "")
                            .replaceAll("\r", "");

                    if (value != null && !"".equals(value)) {
                        data.put("relation", value);
                    } else {
                        data.put("relation", "");
                    }
                } else {
                    data.put("relation", "");
                }

                //发布曰期
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", "").replaceAll("\n", "")
                            .replaceAll("\r", "");

                    if (value != null && !"".equals(value)) {
                        data.put("issue_date", value);
                    } else {
                        data.put("issue_date", "");
                    }
                } else {
                    data.put("issue_date", "");
                }

                //实施曰期
                cellNum++;
                if (row.getCell(cellNum) != null) {

                    row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                    String value = row.getCell(cellNum).getStringCellValue().trim().replaceAll("\n\r", "").replaceAll("\n", "")
                            .replaceAll("\r", "");

                    if (value != null && !"".equals(value)) {
                        data.put("carryon_date", value);
                    } else {
                        data.put("carryon_date", "");
                    }
                } else {
                    data.put("carryon_date", "");
                }

                dataList.add(data);
            }
        }

        Writer write = new OutputStreamWriter(new FileOutputStream("C:/Users/hiekn-hai/Desktop/data.json"), "UTF-8");
        write.write(JSONArray.fromObject(dataList).toString().replaceAll(",\\{", ",\n{"));
        write.flush();
        write.close();
        //System.out.println(ob);
    }
}
