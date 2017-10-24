package org.hqu.production_ms.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hqu.production_ms.domain.authority.SysPermission;
import org.hqu.production_ms.domain.authority.SysRole;
import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.service.RoleService;
import org.hqu.production_ms.service.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created on 2016年9月6日 
 *
 * 自定义shiro realm
 *
 * @author  megagao
 * @version  0.0.1
 */
public class CustomRealm extends AuthorizingRealm {
	
	/**
	 * 注入service AuthorizationFilter
	 */
	@Autowired
	private SysService sysService;
	
	@Autowired
	private RoleService roleService;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 设置realm的名称
	 */
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	/**
	 * realm的认证方法，从数据库查询用户信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		// token是用户输入的用户名和密码 
		// 第一步从token中取出用户名
		String username = (String) token.getPrincipal();
		
		// 第二步：根据用户输入的username从数据库查询
		SysUser sysUser = null;
		
		try {
			sysUser = sysService.getSysUserByName(username);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 如果查询不到返回null
		if(sysUser==null){
			return null;
		}
		
		String password = sysUser.getPassword();

		// 如果查询到返回认证信息AuthenticationInfo
		//activeUser就是用户身份信息
		ActiveUser activeUser = new ActiveUser();
		
		activeUser.setUserid(sysUser.getId());
		activeUser.setUsername(sysUser.getUsername());
		activeUser.setUserStatus(sysUser.getLocked());
		
		SysRole sysRole = null;
		try {
			sysRole = roleService.findRoleByUserId(sysUser.getId());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		activeUser.setRolename(sysRole.getRoleName());
		activeUser.setRoleStatus(sysRole.getAvailable());
		activeUser.setRoleId(sysRole.getRoleId());
		
		log.info(activeUser.getUsername());
		log.info(activeUser.getUserDepartmentId());
		
		//根据用户id取出菜单
		List<SysPermission> menus  = null;
		try {
			//通过service取出菜单 
			menus = sysService.findMenuListByUserId(sysUser.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将用户菜单设置到activeUser
		activeUser.setMenus(menus);

		//ByteSource q = ByteSource.Util.bytes(sysUser.getSalt());
		//将activeUser设置simpleAuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				activeUser, password, this.getName());

		return simpleAuthenticationInfo;
	}
	
	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		//从 principals获取主身份信息
		//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
		ActiveUser activeUser =  (ActiveUser) principals.getPrimaryPrincipal();
		
		//根据身份信息获取权限信息
		//从数据库获取到权限数据
		List<SysPermission> permissionList = null;
		
		try {
			permissionList = sysService.findPermissionListByUserId(activeUser.getUserid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//单独定一个集合对象 
		List<String> permissions = new ArrayList<String>();
		if(permissionList!=null){
			for(SysPermission sysPermission:permissionList){
				//将数据库中的权限标签 符放入集合
				permissions.add(sysPermission.getPercode());
			}
		}
		
		//查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}
	
	//清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
}
