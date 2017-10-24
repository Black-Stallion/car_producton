package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarHandover;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarHandoverPO;

public interface CarHandoverService {
List<CarHandover> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarHandover carHandover) throws Exception;
	
	CarHandover get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarHandoverPO carHandover) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarHandoverPO carHandover) throws Exception;
    
    CustomResult update(CarHandoverPO carHandover) throws Exception;
    
    List<CarHandover> searchCarHandoverByCarHandoverName(String carHandoverName) throws Exception;

	List<CarHandover> searchCarHandoverByCarHandoverId(int carHandoverId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarHandoverByCarHandoverBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarHandoverByCarHandoverCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarHandoverByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
}
