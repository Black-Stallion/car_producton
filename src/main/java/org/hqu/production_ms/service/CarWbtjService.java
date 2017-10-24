package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarWbtj;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarWbtjPO;

public interface CarWbtjService {
	List<CarWbtj> find() throws Exception; 
	
	List<CarWbtj> find1() throws Exception; 
	
	List<CarWbtj> findByNature(String string) throws Exception; 
	
	List<CarWbtj> get() throws Exception;
	
	EUDataGridResult getList(int page, int rows,String id) throws Exception;
	EUDataGridResult getList1(int page, int rows, CarWbtj carWbtj) throws Exception;
	
	CarWbtj get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarWbtjPO carWbtj) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(CarWbtjPO carWbtj) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarWbtjPO carWbtj) throws Exception;
    
    EUDataGridResult searchCarWbtjByCarWbtj1(Integer page, Integer rows, String args) throws Exception;
	
    EUDataGridResult searchCarWbtjByCarWbtj2(Integer page, Integer rows, String args) throws Exception;
    
    EUDataGridResult searchCarWbtjByCarWbtj3(Integer page, Integer rows, String args,String str1) throws Exception;
    
    EUDataGridResult searchCarWbtjByCarWbtj4(Integer page, Integer rows, String args,String str1,String str) throws Exception;
    
    EUDataGridResult searchCarWbtjByCarWbtj5(Integer page, Integer rows,String args) throws Exception;
    
    EUDataGridResult searchCarWbtjByCarWbtj6(Integer page, Integer rows, String args, String args1) throws Exception;

    EUDataGridResult searchCarWbtjByCarWbtj7(Integer page, Integer rows, String args,String st) throws Exception;
    
 EUDataGridResult searchCarWbtjByCarWbtj8(Integer page, Integer rows, String args,String str,String str1) throws Exception;
    
    EUDataGridResult searchCarWbtjByCarWbtj9(Integer page, Integer rows, String args,String str4,String str,String str1) throws Exception;
 EUDataGridResult searchCarWbtjByCarWbtj10(Integer page, Integer rows, String args,String str) throws Exception;
    
    EUDataGridResult searchCarWbtjByCarWbtj11(Integer page, Integer rows, String args,String str4,String str) throws Exception;
}
