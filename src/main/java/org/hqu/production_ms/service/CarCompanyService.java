package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarCompany;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCompanyPO;

public interface CarCompanyService {
	List<CarCompany> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarCompany carCompany) throws Exception;
	
	List<CarCompany> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, CarCompany carCompany,String id) throws Exception;
	
	List<CarCompany> gets() throws Exception; 
	
	List<CarCompany> gets1(String id) throws Exception;  
	
	CarCompany get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarCompanyPO carCompany) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarCompanyPO carCompany) throws Exception;
    
    CustomResult update(CarCompanyPO carCompany) throws Exception;
    
    List<CarCompany> searchCarCompanyByCarCompanyName(String carCompanyName) throws Exception;

	List<CarCompany> searchCarCompanyByCarCompanyId(int carCompanyId) throws Exception;
}
