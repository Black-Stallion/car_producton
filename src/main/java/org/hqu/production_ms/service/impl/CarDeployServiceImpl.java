package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarDeploy;
import org.hqu.production_ms.domain.CarDeployExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarDeployPO;
import org.hqu.production_ms.mapper.CarDeployMapper;
import org.hqu.production_ms.service.CarDeployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarDeployServiceImpl implements CarDeployService{
	@Autowired
	CarDeployMapper technicalMapper;
	@Override
	public List<CarDeploy> find() throws Exception {
		CarDeployExample example = new CarDeployExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarDeploy carDeploy) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarDeploy> list = technicalMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarDeploy> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<CarDeploy> find1(String id) throws Exception {
		CarDeployExample example = new CarDeployExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarDeploy carDeploy,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarDeploy> list = technicalMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarDeploy> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public CarDeploy get(int carDeployId) throws Exception {
		return technicalMapper.selectSingleCarDeploy(carDeployId);
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
	public CustomResult insert(CarDeployPO carDeploy) throws Exception {
		int i = technicalMapper.insert(carDeploy);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarDeployPO carDeploy) throws Exception {
		int i = technicalMapper.updateByPrimaryKey(carDeploy);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarDeployPO carDeploy) throws Exception {
		int i = technicalMapper.updateByPrimaryKeySelective(carDeploy);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarDeploy> searchCarDeployByCarDeployName(String driverFrom) throws Exception {
		CarDeployExample example = new CarDeployExample();
		CarDeployExample.Criteria criteria = example.createCriteria();
		criteria.andBei1Like(driverFrom);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public List<CarDeploy> searchCarDeployByCarDeployId(int carDeployId) throws Exception {
		CarDeployExample example = new CarDeployExample();
		CarDeployExample.Criteria criteria = example.createCriteria();
		criteria.andDeployIdEqualTo(carDeployId);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarDeployByCarDeployBrand(Integer page, Integer rows, String brand) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarDeploy> list = technicalMapper.searchCarDeployByCarDeployDriverfrom(brand);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarDeploy> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarDeployByCarDeployCarXH(Integer page, Integer rows, String carXH) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarDeploy> list = technicalMapper.searchCarDeployByCarDeployAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarDeploy> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarDeployByCarDeployBrand1(Integer page, Integer rows, String id, String brand)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarDeploy> list = technicalMapper.searchCarDeployByCarDeployDriverfrom1(id,brand);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarDeploy> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarDeployByCarDeployCarXH1(Integer page, Integer rows, String id, String carXH)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarDeploy> list = technicalMapper.searchCarDeployByCarDeployAA1(id,carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarDeploy> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}


}
