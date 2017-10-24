package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarOut;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarOutPO;

public interface CarOutService {
	List<CarOut> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarOut carOut) throws Exception;
	
	List<CarOut> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarOut carOut,String id) throws Exception;
	
	CarOut get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarOutPO carOut) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarOutPO carOut) throws Exception;
    
    CustomResult update(CarOutPO carOut) throws Exception;
    
    List<CarOut> searchCarOutByCarOutName(String carOutName) throws Exception;

	List<CarOut> searchCarOutByCarOutId(int carOutId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarOutByCarOutBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarOutByCarOutCarXH(Integer page, Integer rows,
			String carXH) throws Exception;
	
	//根据品牌查找车型信息
		EUDataGridResult searchCarOutByCarOutBrand1(Integer page, Integer rows,String id,
				String brand) throws Exception;

		//根据车型查找车型信息
		EUDataGridResult searchCarOutByCarOutCarXH1(Integer page, Integer rows,String id,
				String carXH) throws Exception;


	//根据荷载人数查找车型信息
	EUDataGridResult searchCarOutByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
}
