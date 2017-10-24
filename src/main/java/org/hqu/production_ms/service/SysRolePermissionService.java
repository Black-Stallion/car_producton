package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.custom.CustomResult;

public interface SysRolePermissionService {
	CustomResult deleteBatch(String[] ids) throws Exception;
}
