package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarTool;
import org.hqu.production_ms.domain.CarToolExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarToolPO;
import org.hqu.production_ms.mapper.CarToolMapper;
import org.hqu.production_ms.service.CarToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarToolServiceImpl implements CarToolService {
	@Autowired
	CarToolMapper technicalMapper;
	@Override
	public List<CarTool> find() throws Exception {
		CarToolExample example = new CarToolExample();
		return technicalMapper.selectByExample(example);
	}
	
	public List<CarTool> find1(String id) throws Exception {
		CarToolExample example = new CarToolExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarTool carTool) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarTool> list = technicalMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarTool> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	
	@Override
	public EUDataGridResult getList1(int page, int rows, CarTool carTool,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarTool> list = technicalMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarTool> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public CarTool get(int carToolId) throws Exception {
		return technicalMapper.selectSingleCarTool(carToolId);
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
	public CustomResult insert(CarToolPO carTool) throws Exception {
		int i = technicalMapper.insert(carTool);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarToolPO carTool) throws Exception {
		int i = technicalMapper.updateByPrimaryKey(carTool);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public CustomResult update(CarToolPO carTool) throws Exception {
		int i = technicalMapper.updateByPrimaryKeySelective(carTool);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public List<CarTool> searchCarToolByCarToolName(String ToolName) throws Exception {
		CarToolExample example = new CarToolExample();
		CarToolExample.Criteria criteria = example.createCriteria();
		criteria.andToolnameLike(ToolName);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public List<CarTool> searchCarToolByCarToolId(int carToolId) throws Exception {
		CarToolExample example = new CarToolExample();
		CarToolExample.Criteria criteria = example.createCriteria();
		criteria.andToolIdEqualTo(carToolId);
		return technicalMapper.selectByExample(example);
	}
	

	@Override
	public EUDataGridResult searchCarToolByCarToolBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarTool> list = technicalMapper.searchCarToolByCarToolDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarTool> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

}
