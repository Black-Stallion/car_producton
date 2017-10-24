package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarFold;
import org.hqu.production_ms.domain.CarFoldExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarFoldPO;
import org.hqu.production_ms.mapper.CarFoldMapper;
import org.hqu.production_ms.service.CarFoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarFoldServiceImpl implements CarFoldService {
	@Autowired
	CarFoldMapper carFoldMapper;
	@Override
	public List<CarFold> find() throws Exception {
		CarFoldExample example = new CarFoldExample();
		return carFoldMapper.selectByExample(example);
	}

	@Override
	public List<CarFold> find1(String id) throws Exception {
		CarFoldExample example = new CarFoldExample();
		return carFoldMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarFold carFold) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarFold> list = carFoldMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarFold> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarFold carFold, String id) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarFold> list = carFoldMapper.find1(id);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarFold> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CarFold get(int string) throws Exception {
		return carFoldMapper.selectSingleCarFold(string);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carFoldMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carFoldMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarFoldPO carFold) throws Exception {
		int i = carFoldMapper.insert(carFold);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarFoldPO carFold) throws Exception {
		int i = carFoldMapper.updateByPrimaryKey(carFold);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public CustomResult update(CarFoldPO carFold) throws Exception {
		int i = carFoldMapper.updateByPrimaryKeySelective(carFold);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public List<CarFold> searchCarFoldByCarFoldName(String carFoldName) throws Exception {
		CarFoldExample example = new CarFoldExample();
		CarFoldExample.Criteria criteria = example.createCriteria();
		criteria.andUserLike(carFoldName);
		return carFoldMapper.selectByExample(example);
	}

	@Override
	public List<CarFold> searchCarFoldByCarFoldId(int foldId) throws Exception {
		CarFoldExample example = new CarFoldExample();
		CarFoldExample.Criteria criteria = example.createCriteria();
		criteria.andFoldIdEqualTo(foldId);
		return carFoldMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarFoldByCarFoldBrand(Integer page, Integer rows, String brand) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarFold> list = carFoldMapper.searchCarFoldByCarFoldDriverfrom(brand);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarFold> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarFoldByCarFoldCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarFold> list = carFoldMapper.searchCarFoldByCarFoldAA(carXH);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarFold> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarFoldByCarFoldBrand1(Integer page, Integer rows,String id, String brand) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarFold> list = carFoldMapper.searchCarFoldByCarFoldDriverfrom1(id,brand);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarFold> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarFoldByCarFoldCarXH1(Integer page, Integer rows, String id,String carXH) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarFold> list = carFoldMapper.searchCarFoldByCarFoldAA1(id,carXH);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarFold> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

}
