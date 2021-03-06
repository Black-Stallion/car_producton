package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarKeep;
import org.hqu.production_ms.domain.CarKeepExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.CarKeepMapper;
import org.hqu.production_ms.service.CarKeepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarKeepServiceImpl implements CarKeepService {
	@Autowired
	CarKeepMapper technicalMapper;
	@Override
	public List<CarKeep> find() throws Exception {
		CarKeepExample example = new CarKeepExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarKeep carKeep) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarKeep> list = technicalMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarKeep> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<CarKeep> find1(String id) throws Exception {
		CarKeepExample example = new CarKeepExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarKeep carKeep,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarKeep> list = technicalMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarKeep> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarKeep get(int carKeepId) throws Exception {
		return technicalMapper.selectSingleCarKeep(carKeepId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = technicalMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = technicalMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarKeep carKeep) throws Exception {
		int i = technicalMapper.insert(carKeep);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarKeep carKeep) throws Exception {
		int i = technicalMapper.updateByPrimaryKey(carKeep);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarKeep carKeep) throws Exception {
		int i = technicalMapper.updateByPrimaryKeySelective(carKeep);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarKeep> searchCarKeepByCarKeepName(String driverFrom) throws Exception {
		CarKeepExample example = new CarKeepExample();
		CarKeepExample.Criteria criteria = example.createCriteria();
		criteria.andCarnumLike(driverFrom);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public List<CarKeep> searchCarKeepByCarKeepId(int carKeepId) throws Exception {
		CarKeepExample example = new CarKeepExample();
		CarKeepExample.Criteria criteria = example.createCriteria();
		criteria.andKeepIdEqualTo(carKeepId);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarKeepByCarKeepBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarKeep> list = technicalMapper.searchCarKeepByCarKeepDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarKeep> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarKeepByCarKeepCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarKeep> list = technicalMapper.searchCarKeepByCarKeepAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarKeep> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarKeepByCarKeepBrand1(Integer page, Integer rows,String id, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarKeep> list = technicalMapper.searchCarKeepByCarKeepDriverfrom1(id,brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarKeep> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarKeepByCarKeepCarXH1(Integer page, Integer rows,String id, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarKeep> list = technicalMapper.searchCarKeepByCarKeepAA1(id,carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarKeep> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarKeepByCarId(Integer page, Integer rows,int id) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarKeep> list = technicalMapper.searchCarKeepByCarId(id);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarKeep> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
