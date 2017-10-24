package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarIn;
import org.hqu.production_ms.domain.CarInExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarInPO;
import org.hqu.production_ms.mapper.CarInMapper;
import org.hqu.production_ms.service.CarInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarInServiceImpl implements CarInService {

	@Autowired
	CarInMapper technicalMapper;
	@Override
	public List<CarIn> find() throws Exception {
		CarInExample example = new CarInExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarIn carIn) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarIn> list = technicalMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarIn> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<CarIn> find1(String id) throws Exception {
		CarInExample example = new CarInExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarIn carIn,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarIn> list = technicalMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarIn> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public CarIn get(int carInId) throws Exception {
		return technicalMapper.selectSingleCarIn(carInId);
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
	public CustomResult insert(CarInPO carIn) throws Exception {
		int i = technicalMapper.insert(carIn);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增调入车辆信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarInPO carIn) throws Exception {
		int i = technicalMapper.updateByPrimaryKey(carIn);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarInPO carIn) throws Exception {
		int i = technicalMapper.updateByPrimaryKeySelective(carIn);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarIn> searchCarInByCarInName(String driverFrom) throws Exception {
		CarInExample example = new CarInExample();
		CarInExample.Criteria criteria = example.createCriteria();
		criteria.andOutorganLike(driverFrom);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public List<CarIn> searchCarInByCarInId(int carInId) throws Exception {
		CarInExample example = new CarInExample();
		CarInExample.Criteria criteria = example.createCriteria();
		criteria.andInIdEqualTo(carInId);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarInByCarInBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarIn> list = technicalMapper.searchCarInByCarInDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarIn> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarInByCarInCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarIn> list = technicalMapper.searchCarInByCarInAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarIn> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarInByCarInBrand1(Integer page, Integer rows, String brand,String id) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarIn> list = technicalMapper.searchCarInByCarInDriverfrom1(id,brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarIn> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarInByCarInCarXH1(Integer page, Integer rows, String carXH,String id) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarIn> list = technicalMapper.searchCarInByCarInAA1(id,carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarIn> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarInByCheckNums(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarIn> list = technicalMapper.searchCarInByCarInName(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarIn> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
}
