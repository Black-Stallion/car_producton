package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarMoney;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface CarMoneyService {
	List<CarMoney> find() throws Exception; 
	EUDataGridResult getList(int page, int rows, CarMoney carKeep) throws Exception;
	CustomResult insert(CarMoney carKeep) throws Exception;
}
