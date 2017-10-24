package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarDeploy;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarDeployPO;

public interface CarDeployService {
	
	List<CarDeploy> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarDeploy carDie) throws Exception;
	
	List<CarDeploy> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarDeploy carDie,String id) throws Exception;
	
	CarDeploy get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarDeployPO carDie) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarDeployPO carDie) throws Exception;
    
    CustomResult update(CarDeployPO carDie) throws Exception;
    
    List<CarDeploy> searchCarDeployByCarDeployName(String carDieName) throws Exception;

	List<CarDeploy> searchCarDeployByCarDeployId(int carDieId) throws Exception;
	//根据品牌查找车型信息
		EUDataGridResult searchCarDeployByCarDeployBrand(Integer page, Integer rows,
				String brand) throws Exception;

		//根据车型查找车型信息
		EUDataGridResult searchCarDeployByCarDeployCarXH(Integer page, Integer rows,
				String carXH) throws Exception;
		
		//根据品牌查找车型信息
			EUDataGridResult searchCarDeployByCarDeployBrand1(Integer page, Integer rows,String id,
					String brand) throws Exception;

			//根据车型查找车型信息
			EUDataGridResult searchCarDeployByCarDeployCarXH1(Integer page, Integer rows,String id,
					String carXH) throws Exception;

}
