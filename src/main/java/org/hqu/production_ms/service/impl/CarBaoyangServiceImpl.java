package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarBaoyang;
import org.hqu.production_ms.domain.CarBaoyangExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarBaoyangPO;
import org.hqu.production_ms.mapper.CarBaoyangMapper;
import org.hqu.production_ms.service.CarBaoyangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarBaoyangServiceImpl implements CarBaoyangService{
	@Autowired
	CarBaoyangMapper carBaoyangMapper;
	@Override
	public List<CarBaoyang> find() throws Exception {
		CarBaoyangExample example = new CarBaoyangExample();
		return carBaoyangMapper.selectByExample(example);
	}
	
	@Override
	public List<CarBaoyang> find1() throws Exception {
		CarBaoyangExample example = new CarBaoyangExample();
		return carBaoyangMapper.selectByExample(example);
	}
	

	@Override
	public EUDataGridResult getList(int page, int rows,CarBaoyang carCtj,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarBaoyang> list = carBaoyangMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarBaoyang> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarBaoyang carBaoyang) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarBaoyang> list = carBaoyangMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarBaoyang> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carBaoyangMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarBaoyangPO carBaoyang) throws Exception {
		int i = carBaoyangMapper.insert(carBaoyang);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarBaoyangPO carBaoyang) throws Exception {
		int i = carBaoyangMapper.updateByPrimaryKey(carBaoyang);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarBaoyangPO carBaoyang) throws Exception {
		int i = carBaoyangMapper.updateByPrimaryKeySelective(carBaoyang);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carBaoyangMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CarBaoyang get(int string) throws Exception {
			return carBaoyangMapper.selectSingleCarBaoyang(string);
	}
	@Override
	public CarBaoyang get1(int string) throws Exception {
			return carBaoyangMapper.find2(string);
	}

	@Override
	public boolean find2(int id) throws Exception {
		CarBaoyang c = null;
		c = carBaoyangMapper.find2(id);
		if(c==null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public CustomResult updateById(CarBaoyangPO carBaoyang) throws Exception {
		int i = carBaoyangMapper.updateById(carBaoyang);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "保养修改失败");
		}
	}

}
