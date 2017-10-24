package org.hqu.production_ms.service.impl;

import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.mapper.authority.SysRolePermissionMapper;
import org.hqu.production_ms.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysRolePermissionServiceImple implements SysRolePermissionService{
	@Autowired
	SysRolePermissionMapper sysRolePermissionMapper;
	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = sysRolePermissionMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

}
