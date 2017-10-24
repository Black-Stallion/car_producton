package org.hqu.production_ms.util;

import java.io.InputStream;
import java.util.Properties;

public class Image_fileUtile {
	
	public String fileName(){
		 Properties prop = new Properties();
		try{
		 InputStream in = this.getClass().getClassLoader().getResourceAsStream("fileimage.properties");
		  prop.load(in);     ///加载属性列表
		  String name = prop.getProperty("file");
		  in.close();
		return name;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String imageName(){
		 Properties prop = new Properties();
			try{
			 InputStream in = this.getClass().getClassLoader().getResourceAsStream("fileimage.properties");
			  prop.load(in);     ///加载属性列表
			  String name = prop.getProperty("image");
			  in.close();
		return name;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String uploadName(){
		 Properties prop = new Properties();
			try{
			 InputStream in = this.getClass().getClassLoader().getResourceAsStream("fileimage.properties");
			  prop.load(in);     ///加载属性列表
			  String name = prop.getProperty("upload");
			  in.close();
		return name;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
