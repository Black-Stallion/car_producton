package org.hqu.production_ms.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hqu.production_ms.domain.CarYou;
import org.hqu.production_ms.domain.po.CarDriverPO;
import org.springframework.beans.factory.annotation.Autowired;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class uploadExcel {
	@Autowired
	public List<CarDriverPO> loadScoreInfo(String xlsPath) throws IOException, ParseException{  
		
	   List<CarDriverPO> temp = new ArrayList<CarDriverPO>();  
//	FileInputStream fileIn = new FileInputStream(xlsPath);  
//	//根据指定的文件输入流导入Excel从而产生Workbook对象  
//	HSSFWorkbook wb0 = new HSSFWorkbook(fileIn);  
//	//获取Excel文档中的第一个表单  
//	HSSFSheet sht0 = wb0.getSheetAt(0);  
//	//对Sheet中的每一行进行迭代  
//	        for (Row r : sht0) {  
//	        //如果当前行的行号（从0开始）未达到2（第三行）则从新循环  
//	if(r.getRowNum()<1){  
//	continue;  
//	}  
	   FileInputStream fis=new FileInputStream(xlsPath);  
       Workbook wk;
       Sheet sheet = null;
	try {
		wk = Workbook.getWorkbook(fis);
		sheet=wk.getSheet(0);  
	} catch (BiffException e1) {
		e1.printStackTrace();
	}  
       //获取第一张Sheet表   
      
       //获取总行数  
int rowNum=sheet.getRows();  
//从数据行开始迭代每一行  
       for(int i=2;i<rowNum;i++){  
	//创建实体类  
    	   CarDriverPO info=new CarDriverPO();  
	//取出当前行第1个单元格数据，并封装在info实体stuName属性上  
	info.setDrviername(sheet.getCell(1,i).getContents()); 
	if(sheet.getCell(2,i).getContents().equals("男"))
	{
		int t= 1;
		info.setSex(t);  	
	}else{
		int t= 2;
		info.setSex(t);  
	}
		info.setDepartmentName(sheet.getCell(3,i).getContents().trim());
		info.setCulture(sheet.getCell(4,i).getContents());
		if(sheet.getCell(5,i).getType()==CellType.DATE){  
			DateCell dateCell=(DateCell)sheet.getCell(5,i);  
			//DateCell的getDate()方法取得单元格的日期型数据  
			System.out.println(dateCell.getDate());
			info.setBirthday(dateCell.getDate());  
			} 
		info.setFirstzheng(sheet.getCell(6,i).getContents());
		info.setCartype(sheet.getCell(7,i).getContents());
		info.setDrivernum(sheet.getCell(8,i).getContents());
		if(sheet.getCell(9,i).getType()==CellType.DATE){  
			DateCell dateCell=(DateCell)sheet.getCell(9,i);  
			//DateCell的getDate()方法取得单元格的日期型数据  
			info.setWorktime(dateCell.getDate());  
			} 
		info.setIssueorgan(sheet.getCell(10,i).getContents());
		if(sheet.getCell(11,i).getType()==CellType.DATE){  
			DateCell dateCell=(DateCell)sheet.getCell(11,i);  
			//DateCell的getDate()方法取得单元格的日期型数据  
			info.setChecktime(dateCell.getDate());  
			} 
	temp.add(info);  
	        }  
       	fis.close();      
	    return temp;      
	    }  
	
	public List<CarYou> loadYou(String xlsPath) throws IOException, ParseException{  
		
		   List<CarYou> temp = new ArrayList<CarYou>();  
//		FileInputStream fileIn = new FileInputStream(xlsPath);  
//		//根据指定的文件输入流导入Excel从而产生Workbook对象  
//		HSSFWorkbook wb0 = new HSSFWorkbook(fileIn);  
//		//获取Excel文档中的第一个表单  
//		HSSFSheet sht0 = wb0.getSheetAt(0);  
//		//对Sheet中的每一行进行迭代  
//		        for (Row r : sht0) {  
//		        //如果当前行的行号（从0开始）未达到2（第三行）则从新循环  
//		if(r.getRowNum()<1){  
//		continue;  
//		}  
		   FileInputStream fis=new FileInputStream(xlsPath);  
	       Workbook wk;
	       Sheet sheet = null;
		try {
			wk = Workbook.getWorkbook(fis);
			sheet=wk.getSheet(0);  
		} catch (BiffException e1) {
			e1.printStackTrace();
		}  
	       //获取第一张Sheet表   
	      
	       //获取总行数  
	int rowNum=sheet.getRows();  
	//从数据行开始迭代每一行  
	       for(int i=4;i<rowNum;i++){  
		//创建实体类   
	    	   CarYou info=new CarYou();  
		//取出当前行第1个单元格数据，并封装在info实体stuName属性上  
	    	   if(sheet.getCell(1,i).getContents()==null || sheet.getCell(1,i).getContents().trim().equals("")){
	    		  break;
	    	   }else{
	    		   if(sheet.getCell(1,i).getContents().trim()!="" && sheet.getCell(1,i).getContents()!=null){
		    		   info.setYounumber(sheet.getCell(1,i).getContents()); 
		    		   }
		    		   if(sheet.getCell(2,i).getContents().trim()!="" && sheet.getCell(2,i).getContents()!=null){
		    				info.setDepartmentName(sheet.getCell(2,i).getContents().trim());
		    			}if(sheet.getCell(3,i).getContents()!=""&&sheet.getCell(3,i).getContents()!=null){
		    				info.setBeiyong2(new BigDecimal(sheet.getCell(3,i).getContents().trim()));
		    			System.out.println(sheet.getCell(3,i).getContents());
		    			System.out.println(new BigDecimal(sheet.getCell(3,i).getContents().trim()));
		    			}
		    			temp.add(info); 
	    	   }
		      }  
	       	fis.close();      
		    return temp;      
		    }  
}
