package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarApplyPO;

public interface CarApplyService {
	List<CarApply> find(String id) throws Exception; 
	List<CarApply> finds(String id,String id2) throws Exception; 
	List<CarApply> find4() throws Exception; 
	
	List<CarApply> findb() throws Exception; 
	List<CarApply> find2(String id) throws Exception; 
	List<CarApply> find2s(String id,String id2) throws Exception; 
	
	CarApply findByBian(String string)throws Exception;
	EUDataGridResult getList(int page, int rows, CarApply carApply,String id) throws Exception;
	EUDataGridResult getLists(int page, int rows, CarApply carApply,String id,String id2) throws Exception;
	EUDataGridResult getList1(int page, int rows, CarApply carApply) throws Exception;
	
	CarApply get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarApplyPO carApply) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarApplyPO carApply) throws Exception;
    
    CustomResult update(CarApplyPO carApply) throws Exception;
    
    List<CarApply> searchCarApplyByCarApplyName(String carApplyName) throws Exception;

	List<CarApply> searchCarApplyByCarApplyId(int carApplyId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarApplyByCarApplyBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarApplyByCarApplyCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarApplyByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
	
	EUDataGridResult searchCarApplyByCarApplyBrand1(Integer page, Integer rows,String id,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarApplyByCarApplyCarXH1(Integer page, Integer rows,String id,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarApplyByCheckNums1(Integer page, Integer rows,String id,
			String checkNums) throws Exception;
}
