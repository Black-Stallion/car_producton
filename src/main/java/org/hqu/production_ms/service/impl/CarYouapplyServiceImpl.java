package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarYouapply;
import org.hqu.production_ms.domain.CarYouapplyExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYouapplyPO;
import org.hqu.production_ms.mapper.CarYouapplyMapper;
import org.hqu.production_ms.service.CarYouapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarYouapplyServiceImpl implements CarYouapplyService {
	@Autowired
	CarYouapplyMapper carYouapplyMapper;
	@Override
	public List<CarYouapply> find1(String id) throws Exception {
		CarYouapplyExample example = new CarYouapplyExample();
		return carYouapplyMapper.selectByExample(example);
	}

	@Override
	public List<CarYouapply> find() throws Exception {
		CarYouapplyExample example = new CarYouapplyExample();
		return carYouapplyMapper.selectByExample(example);
	}
	
	@Override
	public List<CarYouapply> find3(String id) throws Exception {
		return carYouapplyMapper.find1(id);
	}

	@Override
	public List<CarYouapply> find2() throws Exception {
		return carYouapplyMapper.find();
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarYouapply carYouapply, String id) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYouapply> list = carYouapplyMapper.find1(id);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYouapply> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarYouapply carYouapply) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYouapply> list = carYouapplyMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYouapply> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CarYouapply get(int string) throws Exception {
		return carYouapplyMapper.selectSingleCarYouapply(string);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carYouapplyMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carYouapplyMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarYouapplyPO carYouapply) throws Exception {
		int i = carYouapplyMapper.insert(carYouapply);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarYouapplyPO carYouapply) throws Exception {
		int i = carYouapplyMapper.updateByPrimaryKey(carYouapply);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarYouapplyPO carYouapply) throws Exception {
		int i = carYouapplyMapper.updateByPrimaryKeySelective(carYouapply);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarYouapply> searchCarYouapplyByCarYouapplyName(String carYouapplyName) throws Exception {
		CarYouapplyExample example = new CarYouapplyExample();
		CarYouapplyExample.Criteria criteria = example.createCriteria();
		criteria.andApplynameLike(carYouapplyName);
		return carYouapplyMapper.selectByExample(example);
	}

	@Override
	public List<CarYouapply> searchCarYouapplyByCarYouapplyId(int carYouapplyId) throws Exception {
		CarYouapplyExample example = new CarYouapplyExample();
		CarYouapplyExample.Criteria criteria = example.createCriteria();
		criteria.andYapplyIdEqualTo(carYouapplyId);
		return carYouapplyMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarYouapplyByCarYouapplyBrand(Integer page, Integer rows, String brand)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYouapply> list = carYouapplyMapper.searchCarYouapplyByCarYouapplyDriverfrom(brand);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYouapply> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYouapplyByCarYouapplyCarXH(Integer page, Integer rows, String carXH)
			throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYouapply> list = carYouapplyMapper.searchCarYouapplyByCarYouapplyAA(carXH);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYouapply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarYouapplyByCarYouapplyBrand1(Integer page, Integer rows, String id, String brand)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarYouapply> list = carYouapplyMapper.searchCarYouapplyByCarYouapplyDriverfrom1(id,brand);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYouapply> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYouapplyByCarYouapplyCarXH1(Integer page, Integer rows, String id, String carXH)
			throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYouapply> list = carYouapplyMapper.searchCarYouapplyByCarYouapplyAA1(id,carXH);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYouapply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

}
