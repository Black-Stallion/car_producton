package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.authority.SysUserExample;
import org.hqu.production_ms.domain.authority.SysUserRole;
import org.hqu.production_ms.domain.authority.SysUserRoleExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.UserPO;
import org.hqu.production_ms.mapper.authority.SysUserMapper;
import org.hqu.production_ms.mapper.authority.SysUserRoleMapper;
import org.hqu.production_ms.service.UserService;
import org.hqu.production_ms.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	SysUserMapper sysUserMapper;
	
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, SysUser sysUser) throws Exception{
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.find(sysUser);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows,String id) throws Exception{
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.find1(id);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult getLists(int page, int rows,String id) throws Exception{
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.finds1(id,id);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public SysUser get(String id) throws Exception{
		return sysUserMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<SysUser> find() throws Exception{
		return sysUserMapper.find();
	}
	
	@Override
	public List<SysUser> find2(String id) throws Exception{
		return sysUserMapper.find2(id);
	}
	@Override
	public List<SysUser> findByUserNameAndId(String username, String id) throws Exception{
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		if(id != null){
			criteria.andIdNotEqualTo(id);
		}
		List<SysUser> sysUserList = sysUserMapper.selectByExample(example);
		return sysUserList;
	}
	
	@Override
	public CustomResult delete(String id) throws Exception{
		int i = sysUserMapper.deleteByPrimaryKey(id);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		//删除用户角色表中的记录
		int k = sysUserRoleMapper.deleteBatchByUserId(ids);
		int i = sysUserMapper.deleteBatch(ids);
		if(i>0 && k>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(UserPO userPO) throws Exception{
		//在业务层整合处理
		SysUserRole sysUserRole = new SysUserRole();
		//补全字段
		sysUserRole.setId(IDUtils.genStringId());
		sysUserRole.setSysUserId(userPO.getId());
		sysUserRole.setSysRoleId(userPO.getRoleId());
		//存用户角色表
		int k = sysUserRoleMapper.insert(sysUserRole);
		//存用户表
		int i = sysUserMapper.insert(userPO);
		if(i>0 && k>0){
			return CustomResult.build(200, "新增用户信息成功");
		}else{
			return CustomResult.build(101, "新增用户信息失败");
		}
	}

	@Override
	public CustomResult update(UserPO userPO) throws Exception{
		int i = sysUserMapper.updateByPrimaryKeySelective(userPO);
		if(i>0){
			return CustomResult.build(200, "修改用户信息成功");
		}else{
			return CustomResult.build(101, "修改用户信息失败");
		}
	}

	@Override
	public CustomResult updateAll(UserPO userPO) throws Exception{
		//在业务层整合处理
		SysUserRole sysUserRole = new SysUserRole();
		//补全字段
		sysUserRole.setSysRoleId(userPO.getRoleId());
		//修改用户角色表
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(userPO.getId());
		int k = sysUserRoleMapper.updateByExampleSelective(sysUserRole, example);
		
		int i = sysUserMapper.updateByPrimaryKey(userPO);
		if(i>0 && k>0){
			return CustomResult.build(200, "修改用户信息成功");
		}else{
			return CustomResult.build(101, "修改用户信息失败");
		}
	}
	
	@Override
	public CustomResult changeStatus(String[] ids) throws Exception{
		int i = sysUserMapper.changeStatus(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public List<SysUser> searchSysUserBySysUserName(String sysUserName) throws Exception{
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameLike(sysUserName);
		return sysUserMapper.selectByExample(example);
	}
	
	@Override
	public List<SysUser> searchSysUserBySysUserId(String sysUserId) throws Exception{
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andIdLike(sysUserId);
		return sysUserMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchUserByUserId(Integer page, Integer rows,
			String userId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.searchUserByUserId(userId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchUserByUserName(Integer page, Integer rows,
			String userName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.searchUserByUserName(userName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchUserByRoleName(Integer page, Integer rows,
			String roleName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.searchUserByRoleName(roleName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult searchUserByUserId1(Integer page, Integer rows,String id,
			String userId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.searchUserByUserId1(id,userId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchUserByUserName1(Integer page, Integer rows,String id,
			String userName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.searchUserByUserName1(id,userName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchUserByRoleName1(Integer page, Integer rows,String id,
			String roleName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.searchUserByRoleName1(id,roleName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
