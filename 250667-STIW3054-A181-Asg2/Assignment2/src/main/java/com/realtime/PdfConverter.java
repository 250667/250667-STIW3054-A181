package com.realtime;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfConverter {
    public static ArrayList<Excel> excelData = new ArrayList<Excel>();

    public static void readExcel(){
        try {
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Admin\\Desktop\\250667-STIW3054-A181-A2\\Assignment2.xlsx");
            XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet=workbook.getSheet("ChessResult");
            Iterator<Row> rows=sheet.iterator();

            while (rows.hasNext()){
                Row row = rows.next();//read rows from excel document
                String c0=row.getCell(0).toString();
                String c2 = row.getCell(2).toString();
                String c3 = row.getCell(3).toString();
                String c4 = row.getCell(4).toString();
                String c5 = row.getCell(5).toString();
                String c6 = row.getCell(6).toString();
                excelData.add(new Excel(c0,c2,c3,c4,c5,c6));//store into arraylist
            }
            workbook.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convert(){
        try {
            Document document = new Document();
            PdfPTable table = new PdfPTable(new float[]{3, 12, 4, 4, 4, 9});//content size of pdf table

                for (int i = 0; i < PdfConverter.excelData.size(); i++) {//get value from arraylist
                    table.addCell(PdfConverter.excelData.get(i).getC0());
                    table.addCell(PdfConverter.excelData.get(i).getC2());
                    table.addCell(PdfConverter.excelData.get(i).getC3());
                    table.addCell(PdfConverter.excelData.get(i).getC4());
                    table.addCell(PdfConverter.excelData.get(i).getC5());
                    table.addCell(PdfConverter.excelData.get(i).getC6());
                }
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Admin\\Desktop\\250667-STIW3054-A181-A2\\Assignment2.pdf"));
                document.open();
                document.add(table);
                document.close();
                System.out.println("Converted successfully to pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
