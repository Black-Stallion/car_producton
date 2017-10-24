package org.hqu.production_ms.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.authority.SysRole;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.RolePO;
import org.hqu.production_ms.service.RoleService;
import org.hqu.production_ms.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SysRolePermissionService sysRolePermissionService;
	
	@RequestMapping("/get/{roleId}")
	@ResponseBody
	public SysRole getItemById(@PathVariable String roleId) throws Exception{
		SysRole sysRole = roleService.get(roleId);
		return sysRole;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "role_list";
	}
	
	@RequestMapping("/permission")
	public String permission() throws Exception{
		return "role_permission";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<SysRole> getData() throws Exception{
		return roleService.find();
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> roleAddJudge() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();  
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isPermitted("role:add")){
			map.put("msg", "您没有权限，请切换用户登录！");
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "role_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> roleEditJudge() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();  
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isPermitted("role:edit")){
			map.put("msg", "您没有权限，请切换用户登录！");
		}
		return map;
	}

	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "role_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, SysRole role) throws Exception{
		EUDataGridResult result = roleService.getList(page, rows, role);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> insert(RolePO role) throws Exception {
		Calendar now = Calendar.getInstance();  
		int year =  now.get(Calendar.YEAR);  
		String month = now.get(Calendar.MONTH) + 1 + "";  
        int day =  now.get(Calendar.DAY_OF_MONTH);  
        int hour =  now.get(Calendar.HOUR_OF_DAY);  
        int minute = now.get(Calendar.MINUTE);  
        int second =  now.get(Calendar.SECOND);  
        String did = "jz"+year+month+day+hour+minute+second;
        role.setRoleId(did);
		Map<String,Object> map = new HashMap<String,Object>(); 
		if(roleService.findByRoleNameAndId(role.getRoleName(), role.getRoleId()).size()>0){
			map.put("msg", "该角色名已经存在，请更换角色名！");
			map.put("label", "1");
		}else if(roleService.get(role.getRoleId()) != null){
			map.put("msg", "该角色编号已经存在，请更换角色编号！");
			map.put("label", "2");
		}else{
			CustomResult result = roleService.insert(role);
			if(result.getStatus() == 200){
				map.put("msg", "新增角色成功！");
				map.put("label", "200");
			}else{
				map.put("msg", "新增角色失败！");
				map.put("label", "0");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(RolePO role) throws Exception {
		CustomResult result = roleService.update(role);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private Map<String,Object> updateAll(RolePO role) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>(); 
		if(roleService.findByRoleNameAndId(role.getRoleName(), role.getRoleId()).size()>0){
			map.put("msg", "该角色名已经存在，请更换角色名！");
			map.put("label", "1");
		}else{
			CustomResult result = roleService.updateAll(role);
			if(result.getStatus() == 200){
				map.put("msg", "更新角色成功！");
				map.put("label", "200");
			}else{
				map.put("msg", "更新角色失败！");
				map.put("label", "0");
			}
		}
		return map;
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> roleDeleteJudge() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();  
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isPermitted("role:delete")){
			map.put("msg", "您没有权限，请切换用户登录！");
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = roleService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = roleService.deleteBatch(ids);
		if(result.getStatus()==200){
			sysRolePermissionService.deleteBatch(ids);
			return result;
		}else{
			return result;
		}
	}
	
	//搜索
	@RequestMapping("/search_role_by_roleId")
	@ResponseBody
	public EUDataGridResult searchRoleByRoleId(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = roleService.searchRoleByRoleId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_role_by_roleName")
	@ResponseBody
	public EUDataGridResult searchRoleByRoleName(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = roleService.searchRoleByRoleName(page, rows, searchValue);
		return result;
	}
}
