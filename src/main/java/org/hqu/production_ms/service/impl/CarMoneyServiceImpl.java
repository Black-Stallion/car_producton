package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarMoneyExample;
import org.hqu.production_ms.domain.CarMoney;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.CarMoneyMapper;
import org.hqu.production_ms.service.CarMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarMoneyServiceImpl implements CarMoneyService{
	@Autowired
	CarMoneyMapper carMoneyMapper;
	@Override
	public List<CarMoney> find() throws Exception {
		CarMoneyExample example = new CarMoneyExample();
		return carMoneyMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarMoney carKeep) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarMoney> list = carMoneyMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarMoney> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CustomResult insert(CarMoney carKeep) throws Exception {
		int i = carMoneyMapper.insert(carKeep);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "油卡充值失败");
		}
	}

}
