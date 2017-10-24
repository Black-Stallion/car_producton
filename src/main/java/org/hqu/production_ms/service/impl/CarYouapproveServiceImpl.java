package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarYouapprove;
import org.hqu.production_ms.domain.CarYouapproveExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYouapprovePO;
import org.hqu.production_ms.mapper.CarYouapproveMapper;
import org.hqu.production_ms.service.CarYouapproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarYouapproveServiceImpl implements CarYouapproveService {
	@Autowired
	CarYouapproveMapper carYouapproveMapper;
	@Override
	public List<CarYouapprove> find(String string) throws Exception {
		CarYouapproveExample example = new CarYouapproveExample();
		return carYouapproveMapper.selectByExample(example);
	}
	@Override
	public List<CarYouapprove> find1(String name,String id) throws Exception {
		CarYouapproveExample example = new CarYouapproveExample();
		return carYouapproveMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarYouapprove carYouapprove,String string) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYouapprove> list = carYouapproveMapper.find(string);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYouapprove> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList(int page, int rows, CarYouapprove carYouapprove,String name,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYouapprove> list = carYouapproveMapper.find1(name,id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYouapprove> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarYouapprove get(int carYouapproveId) throws Exception {
		return carYouapproveMapper.selectSingleCarYouapprove(carYouapproveId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carYouapproveMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carYouapproveMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarYouapprovePO carYouapprove) throws Exception {
		int i = carYouapproveMapper.insert(carYouapprove);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarYouapprovePO carYouapprove) throws Exception {
		int i = carYouapproveMapper.updateByPrimaryKey(carYouapprove);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public CustomResult update(CarYouapprovePO carYouapprove) throws Exception {
		int i = carYouapproveMapper.updateByPrimaryKeySelective(carYouapprove);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public List<CarYouapprove> searchCarYouapproveByCarYouapproveName(String applyname) throws Exception {
		CarYouapproveExample example = new CarYouapproveExample();
		CarYouapproveExample.Criteria criteria = example.createCriteria();
		criteria.andApplynameLike(applyname);
		return carYouapproveMapper.selectByExample(example);
	}

	@Override
	public List<CarYouapprove> searchCarYouapproveByCarYouapproveId(int carYouapproveId) throws Exception {
		CarYouapproveExample example = new CarYouapproveExample();
		CarYouapproveExample.Criteria criteria = example.createCriteria();
		criteria.andYapplyIdEqualTo(carYouapproveId);
		return carYouapproveMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarYouapproveByCarYouapproveBrand(Integer page, Integer rows, String brand,String name) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarYouapprove> list = carYouapproveMapper.searchCarYouapproveByCarYouapproveDriverfrom(brand,name);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarYouapprove> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarYouapproveByCarYouapproveCarXH(Integer page, Integer rows, String carXH,String name) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarYouapprove> list = carYouapproveMapper.searchCarYouapproveByCarYouapproveAA(carXH,name);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYouapprove> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarYouapproveByCarYouapproveBrand1(Integer page, Integer rows, String id, String brand,String name) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarYouapprove> list = carYouapproveMapper.searchCarYouapproveByCarYouapproveDriverfrom1(id,brand,name);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarYouapprove> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarYouapproveByCarYouapproveCarXH1(Integer page, Integer rows, String id,String carXH,String name) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarYouapprove> list = carYouapproveMapper.searchCarYouapproveByCarYouapproveAA1(id,carXH,name);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYouapprove> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public CustomResult updateById(CarYouapprovePO carYouapprove) throws Exception {
		int i = carYouapproveMapper.updateById(carYouapprove);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "审批失败");
		}
	}

}
