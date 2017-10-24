package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarCompany;
import org.hqu.production_ms.domain.CarCompanyExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCompanyPO;
import org.hqu.production_ms.mapper.CarCompanyMapper;
import org.hqu.production_ms.service.CarCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarCompanyServiceImpl implements CarCompanyService{
	@Autowired
	CarCompanyMapper carMapper;
	@Override
	public List<CarCompany> find() throws Exception {
		CarCompanyExample example = new CarCompanyExample();
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarCompany carCompany) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarCompany> list = carMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarCompany> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<CarCompany> find1(String id) throws Exception {
		CarCompanyExample example = new CarCompanyExample();
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarCompany carCompany,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarCompany> list = carMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarCompany> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<CarCompany> gets() throws Exception {
		return carMapper.find();
	}

	@Override
	public List<CarCompany> gets1(String id) throws Exception {
		return carMapper.find1(id);
	}
	
	@Override
	public CarCompany get(int carCompanyId) throws Exception {
		return carMapper.selectSingleCarCompany(carCompanyId);
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
	public CustomResult insert(CarCompanyPO carCompany) throws Exception {
		int i = carMapper.insert(carCompany);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarCompanyPO carCompany) throws Exception {
		int i = carMapper.updateByPrimaryKey(carCompany);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public CustomResult update(CarCompanyPO carCompany) throws Exception {
		int i = carMapper.updateByPrimaryKeySelective(carCompany);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public List<CarCompany> searchCarCompanyByCarCompanyName(String carCompanyName) throws Exception {
		CarCompanyExample example = new CarCompanyExample();
		CarCompanyExample.Criteria criteria = example.createCriteria();
		criteria.andNameLike(carCompanyName);
		return carMapper.selectByExample(example);
	}

	@Override
	public List<CarCompany> searchCarCompanyByCarCompanyId(int carCompanyId) throws Exception {
		CarCompanyExample example = new CarCompanyExample();
		CarCompanyExample.Criteria criteria = example.createCriteria();
		criteria.andCompanyIdEqualTo(carCompanyId);
		return carMapper.selectByExample(example);
	}

}
