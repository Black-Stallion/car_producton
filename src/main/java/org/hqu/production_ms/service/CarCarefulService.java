package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarCareful;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCarefulPO;

public interface CarCarefulService {
	List<CarCareful> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarCareful carCareful) throws Exception;
	
	CarCareful get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarCarefulPO carCareful) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarCarefulPO carCareful) throws Exception;
    
    CustomResult update(CarCarefulPO carCareful) throws Exception;
    
    List<CarCareful> searchCarCarefulByCarCarefulName(String carCarefulName) throws Exception;

	List<CarCareful> searchCarCarefulByCarCarefulId(int carCarefulId) throws Exception;
}
