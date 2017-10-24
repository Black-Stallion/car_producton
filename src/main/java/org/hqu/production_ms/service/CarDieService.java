package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarDie;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarDiePO;

public interface CarDieService {
	List<CarDie> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarDie carDie) throws Exception;
	List<CarDie> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarDie carDie,String id) throws Exception;
	
	CarDie get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarDiePO carDie) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarDiePO carDie) throws Exception;
    
    CustomResult update(CarDiePO carDie) throws Exception;
    
    List<CarDie> searchCarDieByCarDieName(String carDieName) throws Exception;

	List<CarDie> searchCarDieByCarDieId(int carDieId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarDieByCarDieBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarDieByCarDieCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarDieByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
}
