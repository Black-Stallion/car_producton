package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.DriverStudey;
import org.hqu.production_ms.domain.DriverStudeyExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.DriverStudeyPO;
import org.hqu.production_ms.mapper.DriverStudeyMapper;
import org.hqu.production_ms.service.DriverStudeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class DriverStudeyServiceImpl implements DriverStudeyService {
	@Autowired
	DriverStudeyMapper driverStudeyMapper;
	@Override
	public List<DriverStudey> find() throws Exception {
		DriverStudeyExample example = new DriverStudeyExample();
		return driverStudeyMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, DriverStudey driverStudey) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<DriverStudey> list = driverStudeyMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<DriverStudey> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<DriverStudey> find1(String id) throws Exception {
		DriverStudeyExample example = new DriverStudeyExample();
		return driverStudeyMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, DriverStudey driverStudey,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<DriverStudey> list = driverStudeyMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<DriverStudey> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public DriverStudey get(int driverStudeyId) throws Exception {
		return driverStudeyMapper.selectSingleDriverStudey(driverStudeyId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = driverStudeyMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = driverStudeyMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(DriverStudeyPO driverStudey) throws Exception {
		int i = driverStudeyMapper.insert(driverStudey);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增月检记录信息失败");
		}
	}

	@Override
	public CustomResult updateAll(DriverStudeyPO driverStudey) throws Exception {
		int i = driverStudeyMapper.updateByPrimaryKey(driverStudey);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改月检记录信息失败");
		}
	}

	@Override
	public CustomResult update(DriverStudeyPO DriverStudey) throws Exception {
		int i = driverStudeyMapper.updateByPrimaryKeySelective(DriverStudey);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改月检记录信息失败");
		}
	}


}
