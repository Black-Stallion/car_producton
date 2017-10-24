package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarType;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarTypePO;

public interface CarTypeService {
	
	List<CarType> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarType carType) throws Exception;
	
	CarType get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarTypePO carType) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarTypePO carType) throws Exception;
    
    CustomResult update(CarTypePO carType) throws Exception;
    
    List<CarType> searchCarTypeByCarTypeName(String carTypeName) throws Exception;

	List<CarType> searchCarTypeByCarTypeId(int carTypeId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarTypeByCarTypeBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarTypeByCarTypeCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarTypeByCheckNums(Integer page, Integer rows,
			int checkNums) throws Exception;
}
