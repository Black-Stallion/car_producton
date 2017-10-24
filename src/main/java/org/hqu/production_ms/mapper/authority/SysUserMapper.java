package org.hqu.production_ms.mapper.authority;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.authority.SysUserExample;
import org.hqu.production_ms.domain.po.UserPO;

public interface SysUserMapper {
	//扩展的mapper接口方法
	List<UserPO> find(SysUser record);
	
	List<UserPO> find1(String id);
	List<UserPO> finds1(String id,String id1);
	
	List<SysUser> find();
	
	List<SysUser> find2(String id);
	
	List<SysUser> findByDep(String id);
	
	int deleteBatch(String[] ids);
	
	int changeStatus(String[] ids);
	
	
	
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserPO userPO);

    int insertSelective(UserPO userPO);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(UserPO userPO);

    int updateByPrimaryKey(UserPO userPO);

	List<UserPO> searchUserByUserId(String userId);
	SysUser searchUserByid(String userId);

	List<UserPO> searchUserByUserName(String userName);

	List<UserPO> searchUserByRoleName(String roleName);
	
	List<UserPO> searchUserByUserId1(String id,String userId);

	List<UserPO> searchUserByUserName1(String id,String userName);

	List<UserPO> searchUserByRoleName1(String id,String roleName);
}