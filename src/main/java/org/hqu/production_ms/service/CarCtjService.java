package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarCtj;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCtjPO;

public interface CarCtjService {
	List<CarCtj> find() throws Exception; 
	
	List<CarCtj> find1(String id) throws Exception; 
	
	List<CarCtj> findByNature(String string) throws Exception; 
	
	List<CarCtj> get() throws Exception;
	
	EUDataGridResult getList1(int page, int rows,CarCtj carCtj,String id) throws Exception;
	EUDataGridResult getList(int page, int rows, CarCtj carCtj) throws Exception;
	
	CarCtj get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarCtjPO carCtj) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(CarCtjPO carCtj) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarCtjPO carCtj) throws Exception;
    
    EUDataGridResult searchCarCtjByCarCtj1(Integer page, Integer rows, String args) throws Exception;
	
    EUDataGridResult searchCarCtjByCarCtj2(Integer page, Integer rows, String args) throws Exception;
    
    EUDataGridResult searchCarCtjByCarCtj3(Integer page, Integer rows, String args,String str1) throws Exception;
    
    EUDataGridResult searchCarCtjByCarCtj4(Integer page, Integer rows, String args,String str1,String str) throws Exception;
    
    EUDataGridResult searchCarCtjByCarCtj5(Integer page, Integer rows,String args) throws Exception;
    
    EUDataGridResult searchCarCtjByCarCtj6(Integer page, Integer rows, String args, String args1) throws Exception;

    EUDataGridResult searchCarCtjByCarCtj7(Integer page, Integer rows, String args,String st) throws Exception;
    
    EUDataGridResult searchCarCtjByCarCtj8(Integer page, Integer rows, String args,String str,String str1) throws Exception;
    EUDataGridResult searchCarCtjByCarCtj9(Integer page, Integer rows, String args,String str,String str1,String str4) throws Exception;
    EUDataGridResult searchCarCtjByCarCtj10(Integer page, Integer rows, String args,String str) throws Exception;
    EUDataGridResult searchCarCtjByCarCtj11(Integer page, Integer rows, String args,String str,String str1) throws Exception;

}
