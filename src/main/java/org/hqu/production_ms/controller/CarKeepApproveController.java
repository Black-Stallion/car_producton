package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarKeepApprove;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarKeepApprovePO;
import org.hqu.production_ms.service.CarKeepApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carKeepApprove")
public class CarKeepApproveController {
	@Autowired
	private CarKeepApproveService carKeepApproveService;
	
	@RequestMapping("/get/{carKeepApproveId}")
	@ResponseBody
	public CarKeepApprove getItemById(@PathVariable int technicalId) throws Exception{
		CarKeepApprove carKeepApprove = carKeepApproveService.get(technicalId);
		return carKeepApprove;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarKeepApprove> getData(HttpSession session) throws Exception{
		String name = (String) session.getAttribute("username");
		String id = (String) session.getAttribute("departmentId");
		List<CarKeepApprove> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			list = carKeepApproveService.find(name);
		}else{
			list = carKeepApproveService.find1(id,name);
		}
		
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carKeepApprove_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carKeepApproveAddJudge() throws Exception{
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>(); 
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carKeepApprove:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carKeepApprove_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carKeepApproveEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carKeepApprove:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carKeepApprove_edit";
	}
	
//	@RequestMapping("/list/{d}")
//	@ResponseBody
//	public EUDataGridResult getList(Integer page, Integer rows, CarKeepApprove carKeepApprove,String string) throws Exception{
//		EUDataGridResult result = carKeepApproveService.getList(page, rows, carKeepApprove,string);
//		return result;
//	}
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarKeepApprove carKeepApprove,HttpSession session) throws Exception{
		String name = (String) session.getAttribute("username");
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
		result = carKeepApproveService.getList(page, rows, carKeepApprove,name);
		}else{
			result = carKeepApproveService.getList1(page, rows, carKeepApprove,id,name);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarKeepApprovePO carKeepApprove, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carKeepApproveService.insert(carKeepApprove);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarKeepApprovePO cCarKeepApprove, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carKeepApproveService.update(cCarKeepApprove);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarKeepApprovePO cCarKeepApprove, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carKeepApproveService.updateAll(cCarKeepApprove);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carKeepApproveDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carKeepApprove:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carKeepApproveService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carKeepApproveService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carKeepApprove_by_brand")
	@ResponseBody
	public EUDataGridResult searchCarKeepApproveByCarKeepApproveBrand(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carKeepApproveService.searchCarKeepApproveByCarKeepApproveBrand(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carKeepApprove_by_carxh")
	@ResponseBody
	public EUDataGridResult searchCarKeepApproveByCarKeepApproveCarXH(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carKeepApproveService.searchCarKeepApproveByCarKeepApproveCarXH(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carKeepApprove_by_checknums")
	@ResponseBody
	public EUDataGridResult searchCarKeepApproveByDepartmentCheckNums(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carKeepApproveService.searchCarKeepApproveByCheckNums(page, rows, searchValue);
		return result;
	}
}
