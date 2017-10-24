package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarYouapprove;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYouapprovePO;
import org.hqu.production_ms.service.CarYouapproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carYouapprove")
public class CarYouapproveController {
	@Autowired
	private CarYouapproveService carYouapproveService;
	
	@RequestMapping("/get/{carYouapproveId}")
	@ResponseBody
	public CarYouapprove getItemById(@PathVariable int technicalId) throws Exception{
		CarYouapprove carYouapprove = carYouapproveService.get(technicalId);
		return carYouapprove;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarYouapprove> getData(HttpSession session) throws Exception{
		String name = (String) session.getAttribute("username");
		String id = (String) session.getAttribute("departmentId");
		List<CarYouapprove> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			list = carYouapproveService.find(name);
		}else{
			list = carYouapproveService.find1(id,name);
		}
		
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carYouapprove_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carYouapproveAddJudge() throws Exception{
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
			if(!subject.isPermitted("carYouapprove:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carYouapprove_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carYouapproveEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYouapprove:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	@RequestMapping(value="/update_id")
	@ResponseBody
	private CustomResult updateById(@Valid CarYouapprovePO carApprove, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carYouapproveService.updateById(carApprove);
	}
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carYouapprove_edit";
	}
	
//	@RequestMapping("/list/{d}")
//	@ResponseBody
//	public EUDataGridResult getList(Integer page, Integer rows, CarYouapprove carYouapprove,String string) throws Exception{
//		EUDataGridResult result = carYouapproveService.getList(page, rows, carYouapprove,string);
//		return result;
//	}
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarYouapprove carYouapprove,HttpSession session) throws Exception{
		String name = (String) session.getAttribute("username");
		EUDataGridResult result  = carYouapproveService.getList1(page, rows, carYouapprove,name);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarYouapprovePO carYouapprove, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carYouapproveService.insert(carYouapprove);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarYouapprovePO cCarYouapprove, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carYouapproveService.update(cCarYouapprove);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarYouapprovePO cCarYouapprove, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carYouapproveService.updateAll(cCarYouapprove);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carYouapproveDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYouapprove:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carYouapproveService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carYouapproveService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carYouapprove_by_p1")
	@ResponseBody
	public EUDataGridResult searchCarYouapproveByCarYouapproveBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String name = (String) session.getAttribute("username");
		EUDataGridResult result = carYouapproveService.searchCarYouapproveByCarYouapproveBrand(page, rows, searchValue,name);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carYouapprove_by_p2")
	@ResponseBody
	public EUDataGridResult searchCarYouapproveByCarYouapproveCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String name = (String) session.getAttribute("username");
		EUDataGridResult result = carYouapproveService.searchCarYouapproveByCarYouapproveCarXH(page, rows, searchValue,name);
		return result;
	}
	
}