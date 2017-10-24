package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarYouka;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYoukaPO;

public interface CarYoukaService {
	List<CarYouka> find() throws Exception;  
	List<CarYouka> find1(String id) throws Exception;  
	EUDataGridResult getList1(int page, int rows, CarYouka carYouka) throws Exception;
	EUDataGridResult getList(int page, int rows, CarYouka carYouka,String id) throws Exception;
	
	CarYouka get(int string) throws Exception;
	
	CarYouka findByCarId(int carId)throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarYoukaPO carYouka) throws Exception;
	
	CustomResult updateById(CarYoukaPO carYouka) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarYoukaPO carYouka) throws Exception;
    
    CustomResult update(CarYoukaPO carYouka) throws Exception;
    

	List<CarYouka> searchCarYoukaByCarYoukaId(int carYoukaId) throws Exception;

	EUDataGridResult searchCarYoukaByCarYoukaBrand(Integer page, Integer rows,
			String brand) throws Exception;

	EUDataGridResult searchCarYoukaByCarYoukaCarXH(Integer page, Integer rows,
			String carXH) throws Exception;
	
		EUDataGridResult searchCarYoukaByCarYoukaBrand1(Integer page, Integer rows,String id,String brand) throws Exception;

		EUDataGridResult searchCarYoukaByCarYoukaCarXH1(Integer page, Integer rows,String id,
				String carXH) throws Exception;

}
