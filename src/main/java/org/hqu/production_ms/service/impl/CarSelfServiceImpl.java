package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarSelf;
import org.hqu.production_ms.domain.CarSelfExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarSelfPO;
import org.hqu.production_ms.mapper.CarSelfMapper;
import org.hqu.production_ms.service.CarSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarSelfServiceImpl implements CarSelfService {
	@Autowired
	CarSelfMapper technicalMapper;
	@Override
	public List<CarSelf> find() throws Exception {
		CarSelfExample example = new CarSelfExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarSelf carSelf) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSelf> list = technicalMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSelf> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	
	@Override
	public List<CarSelf> find1(String id) throws Exception {
		CarSelfExample example = new CarSelfExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarSelf carSelf,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSelf> list = technicalMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSelf> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarSelf get(int carSelfId) throws Exception {
		return technicalMapper.selectSingleCarSelf(carSelfId);
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
	public CustomResult insert(CarSelfPO carSelf) throws Exception {
		int i = technicalMapper.insert(carSelf);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarSelfPO carSelf) throws Exception {
		int i = technicalMapper.updateByPrimaryKey(carSelf);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarSelfPO carSelf) throws Exception {
		int i = technicalMapper.updateByPrimaryKeySelective(carSelf);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarSelf> searchCarSelfByCarSelfName(String driverFrom) throws Exception {
		CarSelfExample example = new CarSelfExample();
		CarSelfExample.Criteria criteria = example.createCriteria();
		criteria.andOutorganLike(driverFrom);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public List<CarSelf> searchCarSelfByCarSelfId(int carSelfId) throws Exception {
		CarSelfExample example = new CarSelfExample();
		CarSelfExample.Criteria criteria = example.createCriteria();
		criteria.andSelfIdEqualTo(carSelfId);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarSelfByCarSelfBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarSelf> list = technicalMapper.searchCarSelfByCarSelfDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarSelf> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarSelfByCarSelfCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarSelf> list = technicalMapper.searchCarSelfByCarSelfAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarSelf> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarSelfByCarSelfBrand1(Integer page, Integer rows,String id, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarSelf> list = technicalMapper.searchCarSelfByCarSelfDriverfrom1(id,brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarSelf> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarSelfByCarSelfCarXH1(Integer page, Integer rows,String id,String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarSelf> list = technicalMapper.searchCarSelfByCarSelfAA1(id,carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarSelf> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarSelfByCheckNums(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSelf> list = technicalMapper.searchCarSelfByCarSelfName(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSelf> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
}
