package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarYouapprove;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYouapprovePO;

public interface CarYouapproveService {
	List<CarYouapprove> find(String string) throws Exception;  
	List<CarYouapprove> find1(String name,String id) throws Exception;  
	EUDataGridResult getList1(int page, int rows, CarYouapprove carYouapprove,String string) throws Exception;
	EUDataGridResult getList(int page, int rows, CarYouapprove carYouapprove,String name,String id) throws Exception;
	
	CarYouapprove get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarYouapprovePO carYouapprove) throws Exception;
	
	CustomResult updateById(CarYouapprovePO carYouapprove) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarYouapprovePO carYouapprove) throws Exception;
    
    CustomResult update(CarYouapprovePO carYouapprove) throws Exception;
    
    List<CarYouapprove> searchCarYouapproveByCarYouapproveName(String carYouapproveName) throws Exception;

	List<CarYouapprove> searchCarYouapproveByCarYouapproveId(int carYouapproveId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarYouapproveByCarYouapproveBrand(Integer page, Integer rows,
			String brand,String name) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarYouapproveByCarYouapproveCarXH(Integer page, Integer rows,
			String carXH,String name) throws Exception;
	//根据品牌查找车型信息
		EUDataGridResult searchCarYouapproveByCarYouapproveBrand1(Integer page, Integer rows,String id,
				String brand,String name) throws Exception;

		//根据车型查找车型信息
		EUDataGridResult searchCarYouapproveByCarYouapproveCarXH1(Integer page, Integer rows,String id,
				String carXH,String name) throws Exception;
}
