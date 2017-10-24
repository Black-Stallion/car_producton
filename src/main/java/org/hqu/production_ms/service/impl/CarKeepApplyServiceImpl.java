package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarKeepApply;
import org.hqu.production_ms.domain.CarKeepApplyExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarKeepApplyPO;
import org.hqu.production_ms.mapper.CarKeepApplyMapper;
import org.hqu.production_ms.service.CarKeepApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarKeepApplyServiceImpl implements CarKeepApplyService {
	@Autowired
	CarKeepApplyMapper carKeepApplyMapper;
	@Override
	public List<CarKeepApply> find() throws Exception {
		CarKeepApplyExample example = new CarKeepApplyExample();
		return carKeepApplyMapper.selectByExample(example);
	}
	public List<CarKeepApply> find1(String id) throws Exception {
		return carKeepApplyMapper.find1(id);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarKeepApply carKeepApply) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarKeepApply> list = carKeepApplyMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarKeepApply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarKeepApply carKeepApply,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarKeepApply> list = carKeepApplyMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarKeepApply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public CarKeepApply get(int carKeepApplyId) throws Exception {
		return carKeepApplyMapper.selectSingleCarKeepApply(carKeepApplyId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carKeepApplyMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carKeepApplyMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarKeepApplyPO carKeepApply) throws Exception {
		int i = carKeepApplyMapper.insert(carKeepApply);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarKeepApplyPO carKeepApply) throws Exception {
		int i = carKeepApplyMapper.updateByPrimaryKey(carKeepApply);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarKeepApplyPO carKeepApply) throws Exception {
		int i = carKeepApplyMapper.updateByPrimaryKeySelective(carKeepApply);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarKeepApply> searchCarKeepApplyByCarKeepApplyName(String applyname) throws Exception {
		CarKeepApplyExample example = new CarKeepApplyExample();
		CarKeepApplyExample.Criteria criteria = example.createCriteria();
		criteria.andApplynameLike(applyname);
		return carKeepApplyMapper.selectByExample(example);
	}

	@Override
	public List<CarKeepApply> searchCarKeepApplyByCarKeepApplyId(int carKeepApplyId) throws Exception {
		CarKeepApplyExample example = new CarKeepApplyExample();
		CarKeepApplyExample.Criteria criteria = example.createCriteria();
		criteria.andApplyIdEqualTo(carKeepApplyId);
		return carKeepApplyMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarKeepApplyByCarKeepApplyBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarKeepApply> list = carKeepApplyMapper.searchCarKeepApplyByCarKeepApplyDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarKeepApply> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarKeepApplyByCarKeepApplyCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarKeepApply> list = carKeepApplyMapper.searchCarKeepApplyByCarKeepApplyAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarKeepApply> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarKeepApplyByCheckNums(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarKeepApply> list = carKeepApplyMapper.searchCarKeepApplyByCarKeepApplyName(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarKeepApply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult searchCarKeepApplyByCarId(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarKeepApply> list = carKeepApplyMapper.searchCarKeepApplyByCarId(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarKeepApply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public CarKeepApply findByBian(String string) throws Exception {
		return carKeepApplyMapper.findByBian(string);
	}

}
