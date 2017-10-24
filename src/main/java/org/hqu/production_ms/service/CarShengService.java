package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarSheng;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarShengPO;

public interface CarShengService {
List<CarSheng> find() throws Exception; 
	
	List<CarSheng> find1(String id) throws Exception; 
	
	List<CarSheng> findByNature(String string) throws Exception; 
	
	List<CarSheng> get() throws Exception;
	
	EUDataGridResult getList(int page, int rows, CarSheng carSheng) throws Exception;
	EUDataGridResult getList1(int page, int rows, CarSheng carSheng,String id) throws Exception;
	
	CarSheng findByCarNumber(String id);
	
	CarSheng get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarShengPO carSheng) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(CarShengPO carSheng) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarShengPO carSheng) throws Exception;
    
    EUDataGridResult searchCarShengByCarShengDriverfrom(Integer page, Integer rows, String string) throws Exception;
	
	EUDataGridResult searchCarShengByCarShengAA(Integer page, Integer rows,
			String string) throws Exception;
	
	EUDataGridResult searchCarShengByCarShengName(Integer page, Integer rows,
			String string) throws Exception;
}
