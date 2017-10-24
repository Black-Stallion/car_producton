package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarApply;
import org.hqu.production_ms.domain.CarApplyExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarApplyPO;
import org.hqu.production_ms.mapper.CarApplyMapper;
import org.hqu.production_ms.service.CarApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarApplyServiceImpl implements CarApplyService{
	@Autowired
	CarApplyMapper carApplyMapper;
	@Override
	public List<CarApply> find(String id) throws Exception {
		CarApplyExample example = new CarApplyExample();
		return carApplyMapper.selectByExample(example);
	}
	@Override
	public List<CarApply> finds(String id,String id2) throws Exception {
		CarApplyExample example = new CarApplyExample();
		return carApplyMapper.selectByExample(example);
	}
	@Override
	public List<CarApply> find4() throws Exception {
		CarApplyExample example = new CarApplyExample();
		return carApplyMapper.selectByExample(example);
	}
	public List<CarApply> findb() throws Exception {
		System.out.println(carApplyMapper.findb());
		return carApplyMapper.findb();
	}
	public List<CarApply> find2(String id) throws Exception {
		return carApplyMapper.find2(id);
	}
	public List<CarApply> find2s(String id,String ids) throws Exception {
		return carApplyMapper.find2s(id,ids);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarApply carApply,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarApply> list = carApplyMapper.find(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarApply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getLists(int page, int rows, CarApply carApply,String id,String ids) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarApply> list = carApplyMapper.finds(id,ids);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarApply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarApply carApply) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarApply> list = carApplyMapper.find4();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarApply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarApply get(int carApplyId) throws Exception {
		return carApplyMapper.selectSingleCarApply(carApplyId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carApplyMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carApplyMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarApplyPO carApply) throws Exception {
		int i = carApplyMapper.insert(carApply);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarApplyPO carApply) throws Exception {
		int i = carApplyMapper.updateByPrimaryKey(carApply);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarApplyPO carApply) throws Exception {
		int i = carApplyMapper.updateByPrimaryKeySelective(carApply);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarApply> searchCarApplyByCarApplyName(String applyname) throws Exception {
		CarApplyExample example = new CarApplyExample();
		CarApplyExample.Criteria criteria = example.createCriteria();
		criteria.andApplynameLike(applyname);
		return carApplyMapper.selectByExample(example);
	}

	@Override
	public List<CarApply> searchCarApplyByCarApplyId(int carApplyId) throws Exception {
		CarApplyExample example = new CarApplyExample();
		CarApplyExample.Criteria criteria = example.createCriteria();
		criteria.andApplyIdEqualTo(carApplyId);
		return carApplyMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarApplyByCarApplyBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarApply> list = carApplyMapper.searchCarApplyByCarApplyDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarApply> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarApplyByCarApplyCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarApply> list = carApplyMapper.searchCarApplyByCarApplyAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarApply> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarApplyByCheckNums(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarApply> list = carApplyMapper.searchCarApplyByCarApplyName(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarApply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	
	@Override
	public CarApply findByBian(String string) throws Exception {
		return carApplyMapper.findByBian(string);
	}
	@Override
	public EUDataGridResult searchCarApplyByCarApplyBrand1(Integer page, Integer rows, String id,String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarApply> list = carApplyMapper.searchCarApplyByCarApplyDriverfrom1(id,brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarApply> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarApplyByCarApplyCarXH1(Integer page, Integer rows, String id,String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarApply> list = carApplyMapper.searchCarApplyByCarApplyAA1(id,carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarApply> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarApplyByCheckNums1(Integer page, Integer rows, String id,String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarApply> list = carApplyMapper.searchCarApplyByCarApplyName1(id,checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarApply> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	
}
