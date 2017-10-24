package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarYou;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYouPO;

public interface CarYouService {
	List<CarYou> find() throws Exception;  
	List<CarYou> find1(String id) throws Exception;  
	List<CarYou> find3() throws Exception;  
	List<CarYou> find4(String id) throws Exception;  
	List<CarYou> find5() throws Exception;  
	List<CarYou> find6(String id) throws Exception;  
	EUDataGridResult getList1(int page, int rows, CarYou carYou) throws Exception;
	EUDataGridResult getList(int page, int rows, CarYou carYou,String id) throws Exception;
	EUDataGridResult getList3(int page, int rows, CarYou carYou) throws Exception;
	EUDataGridResult getList4(int page, int rows, CarYou carYou,String id) throws Exception;
	
	CarYou get(int string) throws Exception;
	
	CarYou get12(String string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarYouPO carYou) throws Exception;
	
	CustomResult updateById(CarYouPO carYou) throws Exception;
	
	CustomResult updateByYouId(CarYou carYou) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarYouPO carYou) throws Exception;
    
    CustomResult update(CarYouPO carYou) throws Exception;
    

	List<CarYou> searchCarYouByCarYouId(int carYouId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarYouByCarYouBrand(Integer page, Integer rows,
			String brand) throws Exception;
	
	//根据品牌查找车型信息
		EUDataGridResult searchCarYouByCarYouBrand1(Integer page, Integer rows,String id,
				String brand) throws Exception;

}
