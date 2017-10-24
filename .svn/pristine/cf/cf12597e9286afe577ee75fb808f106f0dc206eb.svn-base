package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarHandover;
import org.hqu.production_ms.domain.CarHandoverExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarHandoverPO;
import org.hqu.production_ms.mapper.CarHandoverMapper;
import org.hqu.production_ms.service.CarHandoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarHandoverServiceImpl implements CarHandoverService {
	@Autowired
	CarHandoverMapper technicalMapper;
	@Override
	public List<CarHandover> find() throws Exception {
		CarHandoverExample example = new CarHandoverExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarHandover carHandover) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarHandover> list = technicalMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarHandover> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarHandover get(int carHandoverId) throws Exception {
		return technicalMapper.selectSingleCarHandover(carHandoverId);
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
	public CustomResult insert(CarHandoverPO carHandover) throws Exception {
		int i = technicalMapper.insert(carHandover);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarHandoverPO carHandover) throws Exception {
		int i = technicalMapper.updateByPrimaryKey(carHandover);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarHandoverPO carHandover) throws Exception {
		int i = technicalMapper.updateByPrimaryKeySelective(carHandover);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarHandover> searchCarHandoverByCarHandoverName(String driverFrom) throws Exception {
		CarHandoverExample example = new CarHandoverExample();
		CarHandoverExample.Criteria criteria = example.createCriteria();
		criteria.andNewcaruserLike(driverFrom);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public List<CarHandover> searchCarHandoverByCarHandoverId(int carHandoverId) throws Exception {
		CarHandoverExample example = new CarHandoverExample();
		CarHandoverExample.Criteria criteria = example.createCriteria();
		criteria.andHandoverIdEqualTo(carHandoverId);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarHandoverByCarHandoverBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarHandover> list = technicalMapper.searchCarHandoverByCarHandoverDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarHandover> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarHandoverByCarHandoverCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarHandover> list = technicalMapper.searchCarHandoverByCarHandoverAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarHandover> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarHandoverByCheckNums(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarHandover> list = technicalMapper.searchCarHandoverByCarHandoverName(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarHandover> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

}
