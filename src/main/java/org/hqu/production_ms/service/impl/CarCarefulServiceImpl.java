package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarCareful;
import org.hqu.production_ms.domain.CarCarefulExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCarefulPO;
import org.hqu.production_ms.mapper.CarCarefulMapper;
import org.hqu.production_ms.service.CarCarefulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarCarefulServiceImpl implements CarCarefulService{
	@Autowired
	CarCarefulMapper carMapper;
	@Override
	public List<CarCareful> find() throws Exception {
		CarCarefulExample example = new CarCarefulExample();
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarCareful carCareful) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarCareful> list = carMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarCareful> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarCareful get(int carCarefulId) throws Exception {
		return carMapper.selectSingleCarCareful(carCarefulId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarCarefulPO carCareful) throws Exception {
		int i = carMapper.insert(carCareful);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarCarefulPO carCareful) throws Exception {
		int i = carMapper.updateByPrimaryKey(carCareful);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public CustomResult update(CarCarefulPO carCareful) throws Exception {
		int i = carMapper.updateByPrimaryKeySelective(carCareful);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public List<CarCareful> searchCarCarefulByCarCarefulName(String carCarefulName) throws Exception {
		CarCarefulExample example = new CarCarefulExample();
		CarCarefulExample.Criteria criteria = example.createCriteria();
		criteria.andNameLike(carCarefulName);
		return carMapper.selectByExample(example);
	}

	@Override
	public List<CarCareful> searchCarCarefulByCarCarefulId(int carCarefulId) throws Exception {
		CarCarefulExample example = new CarCarefulExample();
		CarCarefulExample.Criteria criteria = example.createCriteria();
		criteria.andCarefulIdEqualTo(carCarefulId);
		return carMapper.selectByExample(example);
	}

}
