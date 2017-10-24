package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.UserPO;

public interface UserService {
	
	EUDataGridResult getList(int page, int rows, SysUser sysUser) throws Exception;
	
	EUDataGridResult getList1(int page, int rows,String id) throws Exception;
	EUDataGridResult getLists(int page, int rows,String id) throws Exception;
	
	SysUser get(String string) throws Exception;
	
	List<SysUser> find() throws Exception;
	
	List<SysUser> find2(String id) throws Exception;
	
	List<SysUser> findByUserNameAndId(String username, String id) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(UserPO userPO) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(UserPO userPO) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(UserPO userPO) throws Exception;
    
    CustomResult changeStatus(String[] ids) throws Exception;
    
    List<SysUser> searchSysUserBySysUserName(String sysUserName) throws Exception;

	List<SysUser> searchSysUserBySysUserId(String sysUserId) throws Exception;

	EUDataGridResult searchUserByUserId(Integer page, Integer rows,
			String userId) throws Exception;

	EUDataGridResult searchUserByUserName(Integer page, Integer rows,
			String userName) throws Exception;

	EUDataGridResult searchUserByRoleName(Integer page, Integer rows,
			String roleName) throws Exception;
	EUDataGridResult searchUserByUserId1(Integer page, Integer rows,String id,
			String userId) throws Exception;

	EUDataGridResult searchUserByUserName1(Integer page, Integer rows,String id,
			String userName) throws Exception;

	EUDataGridResult searchUserByRoleName1(Integer page, Integer rows,String id,
			String roleName) throws Exception;
}
