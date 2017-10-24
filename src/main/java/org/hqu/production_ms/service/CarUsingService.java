package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarUsing;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarUsingPO;

public interface CarUsingService {

	List<CarUsing> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarUsing CarUsing) throws Exception;
	
	List<CarUsing> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarUsing CarUsing,String id) throws Exception;
	
	CarUsing get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarUsingPO CarUsing) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarUsingPO CarUsing) throws Exception;
    
    CustomResult update(CarUsingPO CarUsing) throws Exception;
    
    
	//根据使用年查询
	EUDataGridResult searchCarUsingByCarUsingYear(Integer page, Integer rows,
			int year) throws Exception;

	//根据设备查询
	EUDataGridResult searchCarUsingByCarUsingCarId(Integer page, Integer rows,
			int carnumber) throws Exception;
	//根据使用年查询
		EUDataGridResult searchCarUsingByCarUsing1(Integer page, Integer rows,
				String year) throws Exception;
		EUDataGridResult searchCarUsingByCarUsing2(Integer page, Integer rows,
				String year) throws Exception;
		EUDataGridResult searchCarUsingByCarUsing1s(Integer page, Integer rows,String id,
				String year) throws Exception;
		EUDataGridResult searchCarUsingByCarUsing2s(Integer page, Integer rows,String id,
				String year) throws Exception;

	
}
