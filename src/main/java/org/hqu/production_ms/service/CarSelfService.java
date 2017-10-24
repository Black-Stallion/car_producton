package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarSelf;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarSelfPO;

public interface CarSelfService {
	List<CarSelf> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarSelf carSelf) throws Exception;
	
	List<CarSelf> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarSelf carSelf,String id) throws Exception;
	
	CarSelf get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarSelfPO carSelf) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarSelfPO carSelf) throws Exception;
    
    CustomResult update(CarSelfPO carSelf) throws Exception;
    
    List<CarSelf> searchCarSelfByCarSelfName(String carSelfName) throws Exception;

	List<CarSelf> searchCarSelfByCarSelfId(int carSelfId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarSelfByCarSelfBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarSelfByCarSelfCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据品牌查找车型信息
		EUDataGridResult searchCarSelfByCarSelfBrand1(Integer page, Integer rows,String id,
				String brand) throws Exception;

		//根据车型查找车型信息
		EUDataGridResult searchCarSelfByCarSelfCarXH1(Integer page, Integer rows,String id,
				String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarSelfByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
}
