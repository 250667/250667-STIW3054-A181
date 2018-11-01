
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

public class ExcelConverter {
    public static void convert() throws IOException{
        
            table tbl = new table();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("List Products");
            
            Row rowHeading = sheet.createRow(0);
            rowHeading.createCell(0).setCellValue("Table Hearder");
            rowHeading.createCell(1).setCellValue("Table Data");
            
            //Set Font
            for(int i=0; i<2; i++){
                CellStyle stylerowHeading = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                font.setFontHeightInPoints((short) 11);
                stylerowHeading.setFont(font);
                stylerowHeading.setVerticalAlignment(CellStyle.ALIGN_CENTER);
                rowHeading.getCell(i).setCellStyle(stylerowHeading);
            }
            
            int r =1;
            for(table result : test.TestData()){
                Row row = sheet.createRow(r++);
                //Theader Column
                Cell cellId = row.createCell(0);
                cellId.setCellValue(result.getTheader());
                //Tdata Column
                Cell cellName = row.createCell(1);
                cellName.setCellValue(result.getTdata()); 
            }
            //Autofit
            for(int i=0; i<6; i++){
                sheet.autoSizeColumn(i);
            }
            //save to Excel file
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Admin\\Music\\assignment1.xls"));
            workbook.write(out);
            out.close();
            workbook.close();
            System.out.println("Converted successfully excel file...");  
    }
}
