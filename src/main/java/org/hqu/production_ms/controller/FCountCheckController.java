package org.hqu.production_ms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.FinalCountCheck;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.FCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/f_count_check")
public class FCountCheckController {
	
	@Autowired
	private FCountCheckService fCountCheckService;
	
	@InitBinder
    public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
                dateFormat, true));
    }
	
	@RequestMapping("/get/{finalCountCheckId}")
	@ResponseBody
	public FinalCountCheck getItemById(@PathVariable String finalCountCheckId) throws Exception{
		FinalCountCheck finalCountCheck = fCountCheckService.get(finalCountCheckId);
		return finalCountCheck;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "f_count_check_list";
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "f_count_check_add";
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> fCountCheckAddJudge() throws Exception{
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
			if(!subject.isPermitted("fCountCheck:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "f_count_check_edit";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> fCountCheckEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("fCountCheck:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, FinalCountCheck finalCountCheck) 
			throws Exception{
		EUDataGridResult result = fCountCheckService.getList(page, rows, finalCountCheck);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid FinalCountCheck finalCountCheck, BindingResult bindingResult)
			throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(fCountCheckService.get(finalCountCheck.getfCountCheckId()) != null){
			result = new CustomResult(0, "该成品计数质检编号已经存在，请更换！", null);
		}else{
			result =  fCountCheckService.insert(finalCountCheck);
		}
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid FinalCountCheck finalCountCheck, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return fCountCheckService.updateAll(finalCountCheck);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid FinalCountCheck finalCountCheck, BindingResult bindingResult) 
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return fCountCheckService.updateNote(finalCountCheck);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> fCountCheckDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("fCountCheck:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = fCountCheckService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_fCountCheck_by_fCountCheckId")
	@ResponseBody
	public EUDataGridResult searchFCountCheckByFCountCheckId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = fCountCheckService.searchFCountCheckByFCountCheckId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_fCountCheck_by_orderId")
	@ResponseBody
	public EUDataGridResult searchFCountCheckByOrderId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = fCountCheckService.searchFCountCheckByOrderId(page, rows, searchValue);
		return result;
	}
}
