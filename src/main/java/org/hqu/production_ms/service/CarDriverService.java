package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarDriver;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarDriverPO;

public interface CarDriverService {
	List<CarDriver> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarDriver carDriver) throws Exception;
	List<CarDriver> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarDriver carDriver,String id) throws Exception;
	
	List<CarDriver> gets() throws Exception;
	List<CarDriver> gets1(String id) throws Exception;
	CarDriver get(int string) throws Exception;
	CarDriver getDep(String string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarDriverPO carDriver) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarDriverPO carDriver) throws Exception;
    
    CustomResult update(CarDriverPO carDriver) throws Exception;
    
    List<CarDriver> searchCarDriverByCarDriverName(String carDriverName) throws Exception;

	List<CarDriver> searchCarDriverByCarDriverId(int carDriverId) throws Exception;

	
	EUDataGridResult searchCarDriverByCarDriverName(Integer page, Integer rows,
			String name) throws Exception;

	
	EUDataGridResult searchCarDriverByCarDrivernum(Integer page, Integer rows,
			String drivenum) throws Exception;

	EUDataGridResult searchCarDriverByCarDriverName1(Integer page, Integer rows,String id,
			String name) throws Exception;

	
	EUDataGridResult searchCarDriverByCarDrivernum1(Integer page, Integer rows,String id,
			String drivenum) throws Exception;

	
}
