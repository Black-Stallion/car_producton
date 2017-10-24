package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarBig;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarBigPO;

public interface CarBigService {
	List<CarBig> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarBig carBig) throws Exception;
	List<CarBig> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarBig carBig,String id) throws Exception;
	
	CarBig get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarBigPO carBig) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarBigPO carBig) throws Exception;
    
    CustomResult update(CarBigPO carBig) throws Exception;
    
    List<CarBig> searchCarBigByCarBigName(String carBigName) throws Exception;

	List<CarBig> searchCarBigByCarBigId(int carBigId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarBigByCarBigBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarBigByCarBigCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarBigByCarId(Integer page, Integer rows,
			int checkNums) throws Exception;
	//根据荷载人数查找车型信息
		EUDataGridResult searchCarBig1(Integer page, Integer rows,
				String checkNums) throws Exception;
		EUDataGridResult searchCarBig2(Integer page, Integer rows,
				String checkNums) throws Exception;
		EUDataGridResult searchCarBig1s(Integer page, Integer rows,String id,
				String checkNums) throws Exception;
		EUDataGridResult searchCarBig2s(Integer page, Integer rows,String id,
				String checkNums) throws Exception;
}
