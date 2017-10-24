package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.DriverCheck;
import org.hqu.production_ms.domain.DriverCheckExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.DriverCheckPO;
import org.hqu.production_ms.mapper.DriverCheckMapper;
import org.hqu.production_ms.service.DriverCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class DriverCheckServiceImpl implements DriverCheckService {
	@Autowired
	DriverCheckMapper driverCheckMapper;
	@Override
	public List<DriverCheck> find() throws Exception {
		DriverCheckExample example = new DriverCheckExample();
		return driverCheckMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, DriverCheck driverCheck) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<DriverCheck> list = driverCheckMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<DriverCheck> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<DriverCheck> find1(String id) throws Exception {
		DriverCheckExample example = new DriverCheckExample();
		return driverCheckMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, DriverCheck driverCheck,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<DriverCheck> list = driverCheckMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<DriverCheck> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public DriverCheck get(int driverCheckId) throws Exception {
		return driverCheckMapper.selectSingleDriverCheck(driverCheckId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = driverCheckMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = driverCheckMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(DriverCheckPO driverCheck) throws Exception {
		int i = driverCheckMapper.insert(driverCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增行驶里程记录记录信息失败");
		}
	}

	@Override
	public CustomResult updateAll(DriverCheckPO driverCheck) throws Exception {
		int i = driverCheckMapper.updateByPrimaryKey(driverCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改行驶里程记录记录信息失败");
		}
	}

	@Override
	public CustomResult update(DriverCheckPO DriverCheck) throws Exception {
		int i = driverCheckMapper.updateByPrimaryKeySelective(DriverCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改行驶里程记录记录信息失败");
		}
	}


	@Override
	public EUDataGridResult searchDriverCheckBydrivernum(Integer page, Integer rows, String drivernum) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<DriverCheck> list = driverCheckMapper.searchDriverCheckBydrivernum(drivernum);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<DriverCheck> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchDriverCheckBycarnum(Integer page, Integer rows, String carnum) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DriverCheck> list = driverCheckMapper.searchDriverCheckBycarnum(carnum);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DriverCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}


}
