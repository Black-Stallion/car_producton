package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarSpecial;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarSpecialPO;

public interface CarSpecialService {
List<CarSpecial> find() throws Exception; 
	
	List<CarSpecial> find1(String id) throws Exception; 
	
	List<CarSpecial> findByNature(String string) throws Exception; 
	
	List<CarSpecial> get() throws Exception;
	
	EUDataGridResult getList(int page, int rows, CarSpecial carSpecial) throws Exception;
	EUDataGridResult getList1(int page, int rows, CarSpecial carSpecial,String id) throws Exception;
	
	CarSpecial findByCarNumber(String id);
	
	CarSpecial get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarSpecialPO carSpecial) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(CarSpecialPO carSpecial) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarSpecialPO carSpecial) throws Exception;
    
    EUDataGridResult searchCarSpecialByCarSpecialDriverfrom(Integer page, Integer rows, String string) throws Exception;
	
	EUDataGridResult searchCarSpecialByCarSpecialAA(Integer page, Integer rows,
			String string) throws Exception;
	
	EUDataGridResult searchCarSpecialByCarSpecialName(Integer page, Integer rows,
			String string) throws Exception;
}
