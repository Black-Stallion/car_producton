package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarYouapply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYouapplyPO;

public interface CarYouapplyService {
	List<CarYouapply> find1(String id) throws Exception; 
	List<CarYouapply> find() throws Exception; 
	List<CarYouapply> find3(String id) throws Exception; 
	List<CarYouapply> find2() throws Exception; 
	EUDataGridResult getList1(int page, int rows, CarYouapply carYouapply,String id) throws Exception;
	EUDataGridResult getList(int page, int rows, CarYouapply carYouapply) throws Exception;
	
	CarYouapply get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarYouapplyPO carYouapply) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarYouapplyPO carYouapply) throws Exception;
    
    CustomResult update(CarYouapplyPO carYouapply) throws Exception;
    
    List<CarYouapply> searchCarYouapplyByCarYouapplyName(String carYouapplyName) throws Exception;

	List<CarYouapply> searchCarYouapplyByCarYouapplyId(int carYouapplyId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarYouapplyByCarYouapplyBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarYouapplyByCarYouapplyCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	EUDataGridResult searchCarYouapplyByCarYouapplyBrand1(Integer page, Integer rows,String id,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarYouapplyByCarYouapplyCarXH1(Integer page, Integer rows,String id,
			String carXH) throws Exception;

}
