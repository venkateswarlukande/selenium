package com.venkat.day41.assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public static int getRowCount(String Xlfile, String sheet) throws IOException {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int rownum = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rownum;
	}

	public static int getCellCount(String Xlfile, String sheet, int rownum) throws IOException {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		int cellnum = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellnum;
	}

	public static String getCellData(String Xlfile, String sheet, int rownum, int celnum) throws IOException {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		cell = row.getCell(celnum);

		String data;

		try {
			// data = cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}

		return data;

	}

	public static void setCellData(String Xlfile, String sheet, int rownum, int celnum, String data)throws IOException {
		
		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		
		cell = row.createCell(celnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(Xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}
	
	public static void fillGreenColor(String Xlfile, String sheet, int rownum, int celnum) throws IOException {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		cell = row.getCell(celnum);

		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(Xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}
	
	public static void fillRedColor(String Xlfile, String sheet, int rownum, int celnum) throws IOException {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		cell = row.getCell(celnum);

		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(Xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}

}
