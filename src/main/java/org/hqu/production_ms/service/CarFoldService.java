package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarFold;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarFoldPO;

public interface CarFoldService {
	List<CarFold> find() throws Exception; 
	
	List<CarFold> find1(String id) throws Exception; 
	
	EUDataGridResult getList(int page, int rows, CarFold carFold) throws Exception;
	
	EUDataGridResult getList1(int page, int rows, CarFold carFold,String id) throws Exception;
	
	CarFold get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarFoldPO carFold) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarFoldPO carFold) throws Exception;
    
    CustomResult update(CarFoldPO carFold) throws Exception;
    
    List<CarFold> searchCarFoldByCarFoldName(String carFoldName) throws Exception;

	List<CarFold> searchCarFoldByCarFoldId(int carFoldId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarFoldByCarFoldBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarFoldByCarFoldCarXH(Integer page, Integer rows,
			String carXH) throws Exception;
	//根据品牌查找车型信息
		EUDataGridResult searchCarFoldByCarFoldBrand1(Integer page, Integer rows,String id,
				String brand) throws Exception;

		//根据车型查找车型信息
		EUDataGridResult searchCarFoldByCarFoldCarXH1(Integer page, Integer rows,String id,
				String carXH) throws Exception;

}
