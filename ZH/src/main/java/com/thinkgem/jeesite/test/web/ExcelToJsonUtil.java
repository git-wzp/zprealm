package com.thinkgem.jeesite.test.web;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelToJsonUtil {


    @Test
    public void excelToJson() throws Exception {

        //读取excel文件
        String filepath = "G:\\TempFile\\2018年8月30日\\tmp001.xls";
//        读取json模板文件
        String jsonmb = "G:\\TempFile\\2018年8月30日\\json.txt";
//        创建字节流
        InputStream inputStream = new FileInputStream(filepath);
//        存储数据的map
        Map<String, String> map = new LinkedHashMap<String, String>();
//        获取工作表
        Workbook wb = null;
        if (filepath.endsWith("xlsx")) {
            wb = new XSSFWorkbook(inputStream);
        } else if (filepath.endsWith("xls")) {
            wb = new HSSFWorkbook(inputStream);
        }

//        获取第一个sheet页
        Sheet sheet = wb.getSheetAt(0);
//        获取sheet页总行数
        int rows = sheet.getPhysicalNumberOfRows();
//        遍历每一行 获取每一行的总列数，遍历每一个单元格
//        for (int  j  = 0; j < rows; j++) {
//            Row row = sheet.getRow(j);
//            int cells = row.getPhysicalNumberOfCells();
//            int j;
//            for (j = 0; j < cells; j++) {
//                Cell cell = row.getCell(j);
//                String stringCellValue = cell.getStringCellValue();
//
//            }
//        }
//      需求明确 直接读取第一第二行数据

        Row row0 = sheet.getRow(0);
        Row row1 = sheet.getRow(1);
        int cells = row0.getPhysicalNumberOfCells();
        int j;
        for (j = 1; j < cells; j++) {
            Cell cell0 = row0.getCell(j);
            Cell cell1 = row1.getCell(j);

//            key值
            String stringCellValue = (String) getCellFormatValue(cell0);
            if(stringCellValue.indexOf("_TIME")!=-1){
//                cell1.setCellType(Cell.CELL_TYPE_FORMULA);
                System.out.println();
            }
//            value值
            String stringCellValue1 = (String) getCellFormatValue(cell1);

            if (stringCellValue1 == null || stringCellValue1 == "") {
                stringCellValue1 = "";
            }
            map.put(stringCellValue, stringCellValue1);
        }
//        对照赋值操作

//       模板map
        FileInputStream fileInputStream = new FileInputStream(jsonmb);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String json = bufferedReader.readLine();
        LinkedHashMap<String, String> map1 = JSONObject.parseObject(json, LinkedHashMap.class, Feature.OrderedField);
        LinkedHashMap<String, String> map2 = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = map.get(key);
            if (value == null || value == "") {
                value = "";
            }
            map2.put(key, value);
        }
        String s = JSONUtils.toJSONString(map2);
        s = s.replace(",",",  ");
        s = s.replace(":",": ");
        System.out.println(filepath+"json转换：");
        System.out.println(s);

    }

    public static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    cellValue = ((String) cellValue).replace(".0","");
                    break;
                }
                case Cell.CELL_TYPE_FORMULA: {
                    //判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //转换为日期格式YYYY-mm-dd
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        cellValue = format.format(date);

                    } else {
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }
}
