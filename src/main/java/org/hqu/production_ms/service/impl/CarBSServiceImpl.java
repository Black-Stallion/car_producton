package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarBS;
import org.hqu.production_ms.domain.CarBSExample;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.CarBSMapper;
import org.hqu.production_ms.service.CarBSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarBSServiceImpl implements CarBSService{
	@Autowired
	CarBSMapper carMapper;
	@Override
	public List<CarBS> find() throws Exception {
		CarBSExample example = new CarBSExample();
		return carMapper.selectByExample(example);
	}
	@Override
	public List<CarBS> find1(String id) throws Exception {
		CarBSExample example = new CarBSExample();
		return carMapper.selectByExample(example);
	}
	
	@Override
	public List<CarBS> finds() throws Exception {
		return carMapper.find();
	}
	@Override
	public List<CarBS> finds1(String id) throws Exception {
		return carMapper.find1(id);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarBS carBig) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarBS> list = carMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarBS> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarBS carBig,String id ) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarBS> list = carMapper.find1(id);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarBS> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
