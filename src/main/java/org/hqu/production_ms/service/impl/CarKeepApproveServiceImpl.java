package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarKeepApprove;
import org.hqu.production_ms.domain.CarKeepApproveExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarKeepApprovePO;
import org.hqu.production_ms.mapper.CarKeepApproveMapper;
import org.hqu.production_ms.service.CarKeepApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarKeepApproveServiceImpl implements CarKeepApproveService {
	@Autowired
	CarKeepApproveMapper carKeepApproveMapper;
	@Override
	public List<CarKeepApprove> find(String string) throws Exception {
		CarKeepApproveExample example = new CarKeepApproveExample();
		return carKeepApproveMapper.selectByExample(example);
	}
	@Override
	public List<CarKeepApprove> find1(String id,String name) throws Exception {
		CarKeepApproveExample example = new CarKeepApproveExample();
		return carKeepApproveMapper.selectByExample(example);
	}
	@Override
	public List<CarKeepApprove> find5() throws Exception {
		CarKeepApproveExample example = new CarKeepApproveExample();
		return carKeepApproveMapper.selectByExample(example);
	}

//	@Override
//	public EUDataGridResult getList(int page, int rows, CarKeepApprove carKeepApprove,String string) throws Exception {
//		//分页处理
//				PageHelper.startPage(page, rows);
//				List<CarKeepApprove> list = carKeepApproveMapper.find(string);
//				//创建一个返回值对象
//				EUDataGridResult result = new EUDataGridResult();
//				result.setRows(list);
//				//取记录总条数
//				PageInfo<CarKeepApprove> pageInfo = new PageInfo<>(list);
//				result.setTotal(pageInfo.getTotal());
//				return result;
//	}
	@Override
	public EUDataGridResult getList(int page, int rows, CarKeepApprove carKeepApprove,String name) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarKeepApprove> list = carKeepApproveMapper.find(name);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarKeepApprove> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarKeepApprove carKeepApprove,String id,String name) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarKeepApprove> list = carKeepApproveMapper.find1(id,name);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarKeepApprove> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarKeepApprove get(int carKeepApproveId) throws Exception {
		return carKeepApproveMapper.selectSingleCarKeepApprove(carKeepApproveId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carKeepApproveMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carKeepApproveMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarKeepApprovePO carKeepApprove) throws Exception {
		int i = carKeepApproveMapper.insert(carKeepApprove);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarKeepApprovePO carKeepApprove) throws Exception {
		int i = carKeepApproveMapper.updateByPrimaryKey(carKeepApprove);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarKeepApprovePO carKeepApprove) throws Exception {
		int i = carKeepApproveMapper.updateByPrimaryKeySelective(carKeepApprove);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarKeepApprove> searchCarKeepApproveByCarKeepApproveName(String applyname) throws Exception {
		CarKeepApproveExample example = new CarKeepApproveExample();
		CarKeepApproveExample.Criteria criteria = example.createCriteria();
		criteria.andApplynameLike(applyname);
		return carKeepApproveMapper.selectByExample(example);
	}

	@Override
	public List<CarKeepApprove> searchCarKeepApproveByCarKeepApproveId(int carKeepApproveId) throws Exception {
		CarKeepApproveExample example = new CarKeepApproveExample();
		CarKeepApproveExample.Criteria criteria = example.createCriteria();
		criteria.andApplyIdEqualTo(carKeepApproveId);
		return carKeepApproveMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarKeepApproveByCarKeepApproveBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarKeepApprove> list = carKeepApproveMapper.searchCarKeepApproveByCarKeepApproveDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarKeepApprove> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarKeepApproveByCarKeepApproveCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarKeepApprove> list = carKeepApproveMapper.searchCarKeepApproveByCarKeepApproveAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarKeepApprove> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarKeepApproveByCheckNums(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarKeepApprove> list = carKeepApproveMapper.searchCarKeepApproveByCarKeepApproveName(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarKeepApprove> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
}
