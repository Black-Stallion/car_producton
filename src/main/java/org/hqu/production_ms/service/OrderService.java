package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarRegisterPO;



public interface OrderService {
	
	List<CarRegister> find() throws Exception; 
	
	EUDataGridResult getList(int page, int rows, CarRegister carRegister) throws Exception;
	
	CarRegister get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarRegisterPO carRegister) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(CarRegisterPO carRegister) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarRegisterPO carRegister) throws Exception;
    
    CustomResult updateNote(CarRegisterPO carRegister) throws Exception;

    CustomResult changeStatus(String[] ids) throws Exception;

    //根据订单id查找订单信息
    EUDataGridResult searchCarByCarId(int page, int rows, int carId) throws Exception;
	
    //根据客户名称查找订单信息
	EUDataGridResult searchOrderByCustomName(int page, int rows,
			String customName) throws Exception;
	
	//根据产品名称查找订单信息
	EUDataGridResult searchOrderByProductName(int page, int rows,
			String productName) throws Exception;
}
