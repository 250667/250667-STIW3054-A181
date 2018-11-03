package com.realtime;

import java.io.IOException;

/**
 * KISHOK KUMAR SELVARAJA  250667
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ExcelConverter.TestData();
        ExcelConverter.convert();
        PdfConverter.readExcel();
        PdfConverter.convert();
    }
}
