package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarKeep;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface CarKeepService {
	List<CarKeep> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarKeep carKeep) throws Exception;
List<CarKeep> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarKeep carKeep,String id) throws Exception;
	
	CarKeep get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarKeep carKeep) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarKeep carKeep) throws Exception;
    
    CustomResult update(CarKeep carKeep) throws Exception;
    
    List<CarKeep> searchCarKeepByCarKeepName(String carKeepName) throws Exception;

	List<CarKeep> searchCarKeepByCarKeepId(int carKeepId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarKeepByCarKeepBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarKeepByCarKeepCarXH(Integer page, Integer rows,
			String carXH) throws Exception;
	//根据品牌查找车型信息
	EUDataGridResult searchCarKeepByCarKeepBrand1(Integer page, Integer rows,String id,
				String brand) throws Exception;

		//根据车型查找车型信息
	EUDataGridResult searchCarKeepByCarKeepCarXH1(Integer page, Integer rows,String id,
				String carXH) throws Exception;
		//根据车型查找车型信息
	EUDataGridResult searchCarKeepByCarId(Integer page, Integer rows,int id) throws Exception;


}
