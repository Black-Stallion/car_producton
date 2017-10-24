package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarTechnical;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarTechnicalPO;

public interface CarTechnicalService {
	
	List<CarTechnical> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarTechnical carTechnical) throws Exception;
	
	CarTechnical get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarTechnicalPO carTechnical) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarTechnicalPO carTechnical) throws Exception;
    
    CustomResult update(CarTechnicalPO carTechnical) throws Exception;
    
    List<CarTechnical> searchCarTechnicalByCarTechnicalName(String carTechnicalName) throws Exception;

	List<CarTechnical> searchCarTechnicalByCarTechnicalId(int carTechnicalId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarTechnicalByCarTechnicalBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarTechnicalByCarTechnicalCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarTechnicalByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
}
