package org.hqu.production_ms.service.impl;

import org.hqu.production_ms.domain.authority.SysUserRole;
import org.hqu.production_ms.mapper.authority.SysUserRoleMapper;
import org.hqu.production_ms.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	@Override
	public SysUserRole findRoleID(String id) {
		return sysUserRoleMapper.findRoleID(id);
	}

}
