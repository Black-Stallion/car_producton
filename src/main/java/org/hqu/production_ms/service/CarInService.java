package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarIn;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarInPO;

public interface CarInService {
	List<CarIn> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarIn carIn) throws Exception;
List<CarIn> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarIn carIn,String id) throws Exception;
	
	CarIn get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarInPO carIn) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarInPO carIn) throws Exception;
    
    CustomResult update(CarInPO carIn) throws Exception;
    
    List<CarIn> searchCarInByCarInName(String carInName) throws Exception;

	List<CarIn> searchCarInByCarInId(int carInId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarInByCarInBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarInByCarInCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据品牌查找车型信息
		EUDataGridResult searchCarInByCarInBrand1(Integer page, Integer rows,String id,
				String brand) throws Exception;

		//根据车型查找车型信息
		EUDataGridResult searchCarInByCarInCarXH1(Integer page, Integer rows,String id,
				String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarInByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
}
