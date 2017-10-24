package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarKeepApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarKeepApplyPO;

public interface CarKeepApplyService {
List<CarKeepApply> find() throws Exception; 
	
	List<CarKeepApply> find1(String id) throws Exception; 
	
	CarKeepApply findByBian(String string)throws Exception;
	
	EUDataGridResult getList(int page, int rows, CarKeepApply carKeepApply) throws Exception;
	EUDataGridResult getList1(int page, int rows, CarKeepApply carKeepApply,String id) throws Exception;
	
	CarKeepApply get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarKeepApplyPO carKeepApply) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarKeepApplyPO carKeepApply) throws Exception;
    
    CustomResult update(CarKeepApplyPO carKeepApply) throws Exception;
    
    List<CarKeepApply> searchCarKeepApplyByCarKeepApplyName(String carKeepApplyName) throws Exception;

	List<CarKeepApply> searchCarKeepApplyByCarKeepApplyId(int carKeepApplyId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarKeepApplyByCarKeepApplyBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarKeepApplyByCarKeepApplyCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarKeepApplyByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
	//根据荷载人数查找车型信息
		EUDataGridResult searchCarKeepApplyByCarId(Integer page, Integer rows,
				String checkNums) throws Exception;
}
