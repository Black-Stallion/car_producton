package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarCheck;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCheckPO;

public interface CarCheckService {

	List<CarCheck> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarCheck carCheck) throws Exception;
	List<CarCheck> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarCheck carCheck,String id) throws Exception;
	
	CarCheck get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarCheckPO carCheck) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarCheckPO carCheck) throws Exception;
    
    CustomResult update(CarCheckPO carCheck) throws Exception;
    
    
	//根据使用年查询
	EUDataGridResult searchCarCheckByCarCheckYear(Integer page, Integer rows,
			int year) throws Exception;

	//根据设备查询
	EUDataGridResult searchCarCheckByCarCheckCarId(Integer page, Integer rows,
			int carnumber) throws Exception;
	EUDataGridResult searchCarCheckByCarCheck1(Integer page, Integer rows,
			String carnumber) throws Exception;
	EUDataGridResult searchCarCheckByCarCheck2(Integer page, Integer rows,
			String carnumber) throws Exception;
	EUDataGridResult searchCarCheckByCarCheck1s(Integer page, Integer rows,String id,
			String carnumber) throws Exception;
	EUDataGridResult searchCarCheckByCarCheck2s(Integer page, Integer rows,String id,
			String carnumber) throws Exception;

}
