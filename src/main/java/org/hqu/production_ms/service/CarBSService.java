package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarBS;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface CarBSService {
	List<CarBS> find() throws Exception;  
	List<CarBS> find1(String id) throws Exception;  
	
	List<CarBS> finds() throws Exception;  
	List<CarBS> finds1(String id) throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarBS carBig) throws Exception;
	EUDataGridResult getList1(int page, int rows, CarBS carBig,String id) throws Exception;
	
}
