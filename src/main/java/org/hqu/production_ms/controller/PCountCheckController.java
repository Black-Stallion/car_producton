package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.ProcessCountCheck;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.PCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/p_count_check")
public class PCountCheckController {
	
	@Autowired
	private PCountCheckService pCountCheckService;
	
	/*
	 * @responsebody表示该方法的返回结果直接写入HTTP response body中。
	 * 一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径，
	 * 加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。
	 * 比如异步获取json数据，加上@responsebody后，会直接返回json数据。
	 * 
	 * GET模式下，这里使用了@PathVariable绑定输入参数，非常适合Restful风格。
	 * 因为隐藏了参数与路径的关系，可以提升网站的安全性，静态化页面，降低恶意攻击风险。
	 * POST模式下，使用@RequestBody绑定请求对象，Spring会帮你进行协议转换，将Json、Xml协议转换成你需要的对象。
	 * @ResponseBody可以标注任何对象，由Srping完成对象——协议的转换。
	 * 
	 * 一般是指定要response 的type 比如json 或 xml 。
	 * 可以直接用jackson或jaxb的包，然后就可以自动返回了，
	 * xml中也无需多的配置，就可以使用了
	 * 
	 */
	@RequestMapping("/get/{orderId}")
	@ResponseBody
	public COrder getItemById(@PathVariable String orderId) throws Exception{
		return null;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "p_count_check_list";
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "p_count_check_add";
	}
	
	//搜索
	@RequestMapping("/search_pCountCheck_by_pCountCheckId")
	@ResponseBody
	public EUDataGridResult searchpCountCheckBypCountCheckId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = pCountCheckService.searchPCountCheckByPCountCheckId(page, rows, searchValue);
		return result;
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> pCountCheckAddJudge() 
			throws Exception{
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
			if(!subject.isPermitted("pCountCheck:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "p_count_check_edit";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> pCountCheckEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("pCountCheck:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> pCountCheckDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("pCountCheck:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, ProcessCountCheck processCountCheck) 
			throws Exception{
		
		EUDataGridResult result = pCountCheckService.getList(page, rows, processCountCheck);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid ProcessCountCheck processCountCheck, BindingResult bindingResult)
			throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		result = pCountCheckService.insert(processCountCheck);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid ProcessCountCheck processCountCheck, BindingResult bindingResult)
			throws Exception {
		return null;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid ProcessCountCheck processCountCheck, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return pCountCheckService.updateAll(processCountCheck);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid ProcessCountCheck processCountCheck, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return pCountCheckService.updateNote(processCountCheck);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		return null;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		System.out.println(ids);
		CustomResult result = pCountCheckService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/change_status")
	@ResponseBody
	public CustomResult changeStatus(String[] ids) throws Exception{
		return null;
	}
}
