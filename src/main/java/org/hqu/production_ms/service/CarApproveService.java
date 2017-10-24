package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarApprove;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarApprovePO;

public interface CarApproveService {
	List<CarApprove> find(String string) throws Exception;  
	List<CarApprove> find1(String name,String id) throws Exception;  
	List<CarApprove> find2(String name,String id,String id2) throws Exception;  
	EUDataGridResult getList1(int page, int rows, CarApprove carApprove,String string) throws Exception;
	EUDataGridResult getList(int page, int rows, CarApprove carApprove,String name,String id) throws Exception;
	EUDataGridResult getLists(int page, int rows, CarApprove carApprove,String name,String id,String ids) throws Exception;
	
	CarApprove get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarApprovePO carApprove) throws Exception;
	
	CustomResult updateById(CarApprovePO carApprove) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarApprovePO carApprove) throws Exception;
    
    CustomResult update(CarApprovePO carApprove) throws Exception;
    
    List<CarApprove> searchCarApproveByCarApproveName(String carApproveName) throws Exception;

	List<CarApprove> searchCarApproveByCarApproveId(int carApproveId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarApproveByCarApproveBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarApproveByCarApproveCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

	//根据荷载人数查找车型信息
	EUDataGridResult searchCarApproveByCheckNums(Integer page, Integer rows,
			String checkNums) throws Exception;
}
