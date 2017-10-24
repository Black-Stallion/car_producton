package org.hqu.production_ms.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hqu.production_ms.domain.CarCtj;
import org.hqu.production_ms.domain.CarWbtj;
import org.hqu.production_ms.domain.CarYdtjIn;
import org.hqu.production_ms.domain.CarYdtjOut;
import org.hqu.production_ms.domain.CarYdtjRemove;
import org.hqu.production_ms.domain.CarYdtjSelf;


import java.text.SimpleDateFormat;


public class ExportExcel {
	
	private HSSFWorkbook wb;
	public void downlond(HttpServletResponse response, List<CarCtj> list) {
		wb = new HSSFWorkbook();  
	//建立新的sheet对象（excel的表单）  
	HSSFSheet sheet=wb.createSheet("车辆统计表");  
	//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
	HSSFRow row1=sheet.createRow(0);  
	//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
	HSSFCell cell=row1.createCell(0);  
	      //设置单元格内容  
	cell.setCellValue("济南通信段车辆统计一览表");  
	//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
	sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));  
	//在sheet里创建第二行  
	HSSFRow row2=sheet.createRow(1);      
	// 表字段名
	row2.createCell(0).setCellValue("序号");
	row2.createCell(1).setCellValue("车牌号");
	row2.createCell(2).setCellValue("车型名称");
	row2.createCell(3).setCellValue("所属部门");
	row2.createCell(4).setCellValue("机动车所有人");
	row2.createCell(5).setCellValue("登记机关");
	row2.createCell(6).setCellValue("车辆颜色");
	row2.createCell(7).setCellValue("登记日期"); 
	for (int i = 2; i < list.size() + 2; i++) {     
	//在sheet里创建第三行  
	      HSSFRow row3=sheet.createRow(i);  
	    row3.createCell(0).setCellValue(String.valueOf(i-1));
	  	row3.createCell(1).setCellValue(list.get(i - 2).getCarnumber());
	  	row3.createCell(2).setCellValue(list.get(i - 2).getCarType().getTypename());
	  	row3.createCell(3).setCellValue(list.get(i - 2).getDepartment().getDepartmentName());
	  	row3.createCell(4).setCellValue(list.get(i - 2).getUsername());
	  	row3.createCell(5).setCellValue(list.get(i - 2).getJigan());
	  	row3.createCell(6).setCellValue(list.get(i - 2).getColor());
	  	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate = list.get(i - 2).getDengjitiem();
		String appDateStr = sf.format(appDate);
	  	row3.createCell(7).setCellValue(appDateStr);   
	  //.....省略部分代码  
	}
	  
	//输出Excel文件  
	    OutputStream output;
		try {
			
			 response.reset();  
			    //response.addHeader("Content-disposition", "attachment; filename=details.xls"); 
			 response.setContentType("application/vnd.ms-excel;charset=utf-8");    
			    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("济南通信段车辆统计报表.xls","UTF-8"));
			    output = response.getOutputStream();
			    wb.write(output);  
			    output.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	   
	}
	public void downlond1(HttpServletResponse response, List<CarYdtjIn> list) {
		
		//创建HSSFWorkbook对象(excel的文档对象)  
	      wb = new HSSFWorkbook();  
	//建立新的sheet对象（excel的表单）  
	HSSFSheet sheet=wb.createSheet("车辆调入表");  
	//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
	HSSFRow row1=sheet.createRow(0);  
	//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
	HSSFCell cell=row1.createCell(0);  
	      //设置单元格内容  
	cell.setCellValue("济南通信段车辆调入一览表");  
	//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
	sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));  
	//在sheet里创建第二行  
	HSSFRow row2=sheet.createRow(1);      
	// 表字段名
	row2.createCell(0).setCellValue("序号");
	row2.createCell(1).setCellValue("车牌号");
	row2.createCell(2).setCellValue("调入人");
	row2.createCell(3).setCellValue("调入部门");
	row2.createCell(4).setCellValue("调出部门");
	row2.createCell(5).setCellValue("调入时间");
	row2.createCell(6).setCellValue("调拨文号");
	row2.createCell(7).setCellValue("车辆性质"); 
	for (int i = 2; i < list.size() + 2; i++) {     
	//在sheet里创建第三行  
	      HSSFRow row3=sheet.createRow(i);  
	    row3.createCell(0).setCellValue(String.valueOf(i-1));
	  	row3.createCell(1).setCellValue(list.get(i - 2).getCarRegister().getCarnumber());
	  	row3.createCell(2).setCellValue(list.get(i - 2).getRbieyong2());
	  	row3.createCell(3).setCellValue(list.get(i - 2).getDepartment().getDepartmentName());
	  	row3.createCell(4).setCellValue(list.get(i - 2).getDepartment1().getDepartmentName());
	  	
	  	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate = list.get(i - 2).getRemovetime();
		String appDateStr = sf.format(appDate);
	  	row3.createCell(5).setCellValue(appDateStr);   
	  	row3.createCell(6).setCellValue(list.get(i - 2).getRemovenum());
	  	row3.createCell(7).setCellValue(list.get(i - 2).getRbeiyong1());
	  //.....省略部分代码  
	}
	  
	//输出Excel文件  
	    OutputStream output;
		try {
			
			 response.reset();  
			    //response.addHeader("Content-disposition", "attachment; filename=details.xls"); 
			 response.setContentType("application/vnd.ms-excel;charset=utf-8");    
			    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("济南通信段车辆调入统计报表.xls","UTF-8"));
			    output = response.getOutputStream();
			    wb.write(output);  
			    output.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	public void downlond4(HttpServletResponse response, List<CarYdtjOut> list) {
		//创建HSSFWorkbook对象(excel的文档对象)  
	     wb = new HSSFWorkbook();  
	//建立新的sheet对象（excel的表单）  
	HSSFSheet sheet=wb.createSheet("车辆调出表");  
	//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
	HSSFRow row1=sheet.createRow(0);  
	//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
	HSSFCell cell=row1.createCell(0);  
	      //设置单元格内容  
	cell.setCellValue("济南通信段车辆调出一览表");  
	//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
	sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));  
	//在sheet里创建第二行  
	HSSFRow row2=sheet.createRow(1);      
	// 表字段名
	row2.createCell(0).setCellValue("序号");
	row2.createCell(1).setCellValue("车牌号");
	row2.createCell(2).setCellValue("调出人");
	row2.createCell(3).setCellValue("调入部门");
	row2.createCell(4).setCellValue("调出部门");
	row2.createCell(5).setCellValue("调出时间");
	row2.createCell(6).setCellValue("调拨文号");
	row2.createCell(7).setCellValue("车辆性质"); 
	for (int i = 2; i < list.size() + 2; i++) {     
	//在sheet里创建第三行  
	      HSSFRow row3=sheet.createRow(i);  
	    row3.createCell(0).setCellValue(String.valueOf(i-1));
	  	row3.createCell(1).setCellValue(list.get(i - 2).getCarRegister().getCarnumber());
	  	row3.createCell(2).setCellValue(list.get(i - 2).getRbieyong2());
	  	row3.createCell(3).setCellValue(list.get(i - 2).getDepartment2().getDepartmentName());
	  	row3.createCell(4).setCellValue(list.get(i - 2).getDepartment3().getDepartmentName());
	  	
	  	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate = list.get(i - 2).getRemovetime();
		String appDateStr = sf.format(appDate);
	  	row3.createCell(5).setCellValue(appDateStr);   
	  	row3.createCell(6).setCellValue(list.get(i - 2).getRemovenum());
	  	row3.createCell(7).setCellValue(list.get(i - 2).getRbeiyong1());
	  //.....省略部分代码  
	}
	  
	//输出Excel文件  
	    OutputStream output;
		try {
			
			 response.reset();  
			    //response.addHeader("Content-disposition", "attachment; filename=details.xls"); 
			 response.setContentType("application/vnd.ms-excel;charset=utf-8");    
			    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("济南通信段车辆调出统计报表.xls","UTF-8"));
			    output = response.getOutputStream();
			    wb.write(output); 
			    output.flush();
			    output.close();  
			    response.flushBuffer();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	public void downlond5(HttpServletResponse response, List<CarYdtjSelf> list) {
		//创建HSSFWorkbook对象(excel的文档对象)  
	     wb = new HSSFWorkbook();  
	//建立新的sheet对象（excel的表单）  
	HSSFSheet sheet=wb.createSheet("车辆段内调配表");  
	//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
	HSSFRow row1=sheet.createRow(0);  
	//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
	HSSFCell cell=row1.createCell(0);  
	      //设置单元格内容  
	cell.setCellValue("济南通信段车辆段内调配一览表");  
	//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
	sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));  
	//在sheet里创建第二行  
	HSSFRow row2=sheet.createRow(1);      
	// 表字段名
	row2.createCell(0).setCellValue("序号");
	row2.createCell(1).setCellValue("车牌号");
	row2.createCell(2).setCellValue("调配人");
	row2.createCell(3).setCellValue("调入车间");
	row2.createCell(4).setCellValue("调出车间");
	row2.createCell(5).setCellValue("调配时间");
	row2.createCell(6).setCellValue("调拨文号");
	row2.createCell(7).setCellValue("车辆性质"); 
	for (int i = 2; i < list.size() + 2; i++) {     
	//在sheet里创建第三行  
	      HSSFRow row3=sheet.createRow(i);  
	    row3.createCell(0).setCellValue(String.valueOf(i-1));
	  	row3.createCell(1).setCellValue(list.get(i - 2).getCarRegister().getCarnumber());
	  	row3.createCell(2).setCellValue(list.get(i - 2).getRbieyong2());
	  	row3.createCell(3).setCellValue(list.get(i - 2).getDepartment5().getDepartmentName());
	  	row3.createCell(4).setCellValue(list.get(i - 2).getDepartment6().getDepartmentName());
	  	
	  	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate = list.get(i - 2).getRemovetime();
		String appDateStr = sf.format(appDate);
	  	row3.createCell(5).setCellValue(appDateStr);   
	  	row3.createCell(6).setCellValue(list.get(i - 2).getRemovenum());
	  	row3.createCell(7).setCellValue(list.get(i - 2).getRbeiyong1());
	  //.....省略部分代码  
	}
	  
	//输出Excel文件  
	    OutputStream output;
		try {
			
			 response.reset();  
			    //response.addHeader("Content-disposition", "attachment; filename=details.xls"); 
			 response.setContentType("application/vnd.ms-excel;charset=utf-8");    
			    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("济南通信段车辆段内调配统计报表.xls","UTF-8"));
			    output = response.getOutputStream();
			    wb.write(output);  
			    output.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	public void downlond6(HttpServletResponse response, List<CarYdtjRemove> list) {
		//创建HSSFWorkbook对象(excel的文档对象)  
	     wb = new HSSFWorkbook();  
	//建立新的sheet对象（excel的表单）  
	HSSFSheet sheet=wb.createSheet("车辆购入表");  
	//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
	HSSFRow row1=sheet.createRow(0);  
	//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
	HSSFCell cell=row1.createCell(0);  
	      //设置单元格内容  
	cell.setCellValue("济南通信段车辆购入一览表");  
	//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
	sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));  
	//在sheet里创建第二行  
	HSSFRow row2=sheet.createRow(1);      
	// 表字段名
	row2.createCell(0).setCellValue("序号");
	row2.createCell(1).setCellValue("车牌号");
	row2.createCell(2).setCellValue("购入人");
	row2.createCell(3).setCellValue("购入部门");
	row2.createCell(4).setCellValue("购入时间");
	row2.createCell(5).setCellValue("调拨文号");
	row2.createCell(6).setCellValue("车辆性质"); 
	for (int i = 2; i < list.size() + 2; i++) {     
	//在sheet里创建第三行  
	      HSSFRow row3=sheet.createRow(i);  
	    row3.createCell(0).setCellValue(String.valueOf(i-1));
	  	row3.createCell(1).setCellValue(list.get(i - 2).getCarRegister().getCarnumber());
	  	row3.createCell(2).setCellValue(list.get(i - 2).getRbieyong2());
	  	row3.createCell(3).setCellValue(list.get(i - 2).getDepartment().getDepartmentName());
	  	
	  	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate = list.get(i - 2).getRemovetime();
		String appDateStr = sf.format(appDate);
	  	row3.createCell(4).setCellValue(appDateStr);   
	  	row3.createCell(5).setCellValue(list.get(i - 2).getRemovenum());
	  	row3.createCell(6).setCellValue(list.get(i - 2).getRbeiyong1());
	  //.....省略部分代码  
	}
	  
	//输出Excel文件  
	    OutputStream output;
		try {
			
			 response.reset();  
			    //response.addHeader("Content-disposition", "attachment; filename=details.xls"); 
			 response.setContentType("application/vnd.ms-excel;charset=utf-8");    
			    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("济南通信段车辆购入统计报表.xls","UTF-8"));
			    output = response.getOutputStream();
			    wb.write(output);  
			    output.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	public void downlond2(HttpServletResponse response, List<CarWbtj> list) {
		//创建HSSFWorkbook对象(excel的文档对象)  
	      wb = new HSSFWorkbook();  
	//建立新的sheet对象（excel的表单）  
	HSSFSheet sheet=wb.createSheet("车辆保养表");  
	//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
	HSSFRow row1=sheet.createRow(0);  
	//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
	HSSFCell cell=row1.createCell(0);  
	      //设置单元格内容  
	cell.setCellValue("济南通信段车辆保养一览表");  
	//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
	sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));  
	//在sheet里创建第二行  
	HSSFRow row2=sheet.createRow(1);      
	// 表字段名
	row2.createCell(0).setCellValue("序号");
	row2.createCell(1).setCellValue("保养车辆");
	row2.createCell(2).setCellValue("当前里程(/公里)");
	row2.createCell(3).setCellValue("所在部门");
	row2.createCell(4).setCellValue("开始日期");
	row2.createCell(5).setCellValue("截止日期");
	row2.createCell(6).setCellValue("保养级别或保养项目"); 
	row2.createCell(7).setCellValue("厂家名称"); 
	for (int i = 2; i < list.size() + 2; i++) {     
	//在sheet里创建第三行  
	      HSSFRow row3=sheet.createRow(i);  
	    row3.createCell(0).setCellValue(String.valueOf(i-1));
	  	row3.createCell(1).setCellValue(list.get(i - 2).getCarRegister().getCarnumber());
	  	row3.createCell(2).setCellValue(list.get(i - 2).getIntervalkm());
	  	row3.createCell(3).setCellValue(list.get(i - 2).getDepartment().getDepartmentName());
	  	SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate1 = list.get(i - 2).getStartdate();
		String appDateStr1 = sf1.format(appDate1);
	  	row3.createCell(4).setCellValue(appDateStr1);   
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate = list.get(i - 2).getEnddate();
		String appDateStr = sf.format(appDate);
	  	row3.createCell(5).setCellValue(appDateStr);   
	  	row3.createCell(6).setCellValue(list.get(i - 2).getRepairtype());
	  	row3.createCell(7).setCellValue(list.get(i - 2).getSuppliername());
	  //.....省略部分代码  
	}
	  
	//输出Excel文件  
	    OutputStream output;
		try {
			
			 response.reset();  
			    //response.addHeader("Content-disposition", "attachment; filename=details.xls"); 
			 response.setContentType("application/vnd.ms-excel;charset=utf-8");    
			    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("济南通信段车辆保养统计报表.xls","UTF-8"));
			    output = response.getOutputStream();
			    wb.write(output);  
			    output.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
