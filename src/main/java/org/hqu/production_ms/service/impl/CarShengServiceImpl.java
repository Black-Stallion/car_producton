package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarSheng;
import org.hqu.production_ms.domain.CarShengExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarShengPO;
import org.hqu.production_ms.mapper.CarShengMapper;
import org.hqu.production_ms.service.CarShengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarShengServiceImpl implements CarShengService{
	@Autowired
	CarShengMapper carShengMapper;
	@Override
	public List<CarSheng> find() throws Exception {
		CarShengExample example = new CarShengExample();
		return carShengMapper.selectByExample(example);
	}
	
	@Override
	public List<CarSheng> find1(String id) throws Exception {
		CarShengExample example = new CarShengExample();
		return carShengMapper.selectByExample(example);
	}
	
	@Override
	public List<CarSheng> findByNature(String string) throws Exception {
		return carShengMapper.findByNature(string);
	}
	
	@Override
	public List<CarSheng> get() throws Exception {
			List<CarSheng> list = carShengMapper.get();
			return list;
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarSheng carSheng) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSheng> list = carShengMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSheng> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarSheng carSheng,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSheng> list = carShengMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSheng> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarSheng get(int carShengId) throws Exception {
		return carShengMapper.selectSingleCarSheng(carShengId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carShengMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carShengMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarShengPO carSheng) throws Exception {
		int i = carShengMapper.insert(carSheng);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarShengPO carSheng) throws Exception {
		int i = carShengMapper.updateByPrimaryKey(carSheng);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public CustomResult update(CarShengPO carSheng) throws Exception {
		int i = carShengMapper.updateByPrimaryKeySelective(carSheng);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public EUDataGridResult searchCarShengByCarShengDriverfrom(Integer page, Integer rows, String string)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarSheng> list = carShengMapper.searchCarShengByCarShengDriverfrom(string);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarSheng> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarShengByCarShengAA(Integer page, Integer rows, String string) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSheng> list = carShengMapper.searchCarShengByCarShengAA(string);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSheng> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarShengByCarShengName(Integer page, Integer rows, String string) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarSheng> list = carShengMapper.searchCarShengByCarShengName(string);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarSheng> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CarSheng findByCarNumber(String id) {
		return carShengMapper.findByCarNumber(id);
	}
}
