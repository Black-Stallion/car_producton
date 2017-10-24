package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarTool;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarToolPO;

public interface CarToolService {
	
	List<CarTool> find() throws Exception;  
	
	List<CarTool> find1(String id) throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarTool carTool) throws Exception;
	
	EUDataGridResult getList1(int page, int rows, CarTool carTool,String id) throws Exception;
	
	CarTool get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarToolPO carTool) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarToolPO carTool) throws Exception;
    
    CustomResult update(CarToolPO carTool) throws Exception;
    
    List<CarTool> searchCarToolByCarToolName(String carToolName) throws Exception;

	List<CarTool> searchCarToolByCarToolId(int carToolId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarToolByCarToolBrand(Integer page, Integer rows,
			String brand) throws Exception;

}
