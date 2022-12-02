package com.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.common.IOUtil;

public class Screenshot_ExcelCell {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM/Image_into_excel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
	
		//get the Image using Input Stream
		InputStream input=new FileInputStream("./ScreenShots/OrangeHRMLoginFailedScreenshots/AALavanya@19.png");
		
		
		
		//convert image into arraybytes
		byte[] bytes=IOUtils.toByteArray(input);
		
		//add into workbook and get the index
		int index_id=workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		
		//close the stream
		input.close();
		
		//create the anvas to image
		XSSFDrawing drawing=sheet.createDrawingPatriarch();
		
		//set the row and col 
		ClientAnchor anchor=new XSSFClientAnchor();
		
		anchor.setCol1(5);
		anchor.setRow1(6);
		
		//invoke picture
		
		XSSFPicture my_picture=drawing.createPicture(anchor, index_id);
		my_picture.resize(1, 1);

		
		FileOutputStream out=new FileOutputStream(new File("./src/com/OrangeHRM/Image_into_excel.xlsx"));
		workbook.write(out);
		
	
		
	}

}
