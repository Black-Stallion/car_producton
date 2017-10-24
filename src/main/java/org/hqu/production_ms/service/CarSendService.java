package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarSend;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarSendPO;

public interface CarSendService {
	List<CarSend> find() throws Exception;  
	List<CarSend> findStat() throws Exception;  
	List<CarSend> findStat1(String id) throws Exception;  
//	List<CarSend> find1(String id) throws Exception; 
	EUDataGridResult getList(int page, int rows, CarSend carSend) throws Exception;
	
	List<CarSend> find1(String id) throws Exception;  
//	List<CarSend> find1(String id) throws Exception; 
	EUDataGridResult getList1(int page, int rows, CarSend carSend,String id) throws Exception;
	
	List<CarSend> finds(String id,String ids) throws Exception;  
//	List<CarSend> find1(String id) throws Exception; 
	EUDataGridResult getLists(int page, int rows, CarSend carSend,String id,String ids) throws Exception;
	
	EUDataGridResult getListByD(int page, int rows, String id) throws Exception;
	CarSend get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarSendPO carSend) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarSendPO carSend) throws Exception;
    
    CustomResult update(CarSendPO carSend) throws Exception;
    
    List<CarSend> searchCarSendByCarSendName(String carSendName) throws Exception;

	List<CarSend> searchCarSendByCarSendId(int carSendId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarSendByCarSendBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarSendByCarSendCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarSendByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
	EUDataGridResult searchCarSendByCarSendBrand1(Integer page, Integer rows,String id,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarSendByCarSendCarXH1(Integer page, Integer rows,String id,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarSendByCheckNums1(Integer page, Integer rows,String id,
			String checkNums) throws Exception;
	
	EUDataGridResult findByCarId(Integer page, Integer rows,int id) throws Exception;
	
}
