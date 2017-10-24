package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.ProcessMeasureCheck;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.ProcessMeasureCheckPO;
import org.hqu.production_ms.mapper.ProcessMeasureCheckMapper;
import org.hqu.production_ms.service.PMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PMeasureCheckServiceImpl implements PMeasureCheckService{

	@Autowired
	ProcessMeasureCheckMapper processMeasureCheckMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, ProcessMeasureCheck processMeasureCheck) throws Exception{
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<ProcessMeasureCheckPO> list = processMeasureCheckMapper.find(processMeasureCheck);

		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ProcessMeasureCheckPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = processMeasureCheckMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(ProcessMeasureCheck processMeasureCheck) throws Exception{
		int i = processMeasureCheckMapper.insert(processMeasureCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增工序计量质检信息失败");
		}
	}

	@Override
	public CustomResult updateAll(ProcessMeasureCheck processMeasureCheck) throws Exception{
		int i = processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工序计量质检信息失败");
		}
	}

	@Override
	public CustomResult updateNote(ProcessMeasureCheck processMeasureCheck) throws Exception{
		
		int i = processMeasureCheckMapper.updateNote(processMeasureCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工序计量质检备注失败");
		}
	}

	@Override
	public EUDataGridResult searchPMeasureCheckByPMeasureCheckId(int page,
			int rows, String pMeasureCheckId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<ProcessMeasureCheckPO> list = processMeasureCheckMapper.searchPMeasureCheckByPMeasureCheckId(pMeasureCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ProcessMeasureCheckPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
