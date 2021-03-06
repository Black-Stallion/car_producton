package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.Shigu;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.ShiguPO;
import org.hqu.production_ms.service.ShiguService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shigu")
public class ShiguController {

	@Autowired
	private ShiguService shiguService;
	
	@RequestMapping("/get/{driveCheckId}")
	@ResponseBody
	public Shigu getItemById(@PathVariable int driveCheckId) throws Exception{
		Shigu shigu = shiguService.get(driveCheckId);
		return shigu;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Shigu> getData() throws Exception{
		 List<Shigu> list = shiguService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "shigu_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> ShiguAddJudge() throws Exception{
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
			if(!subject.isPermitted("shigu:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "shigu_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> ShiguEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("shigu:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "shigu_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, Shigu shigu,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = shiguService.getList(page, rows, shigu);
		}else{
			result = shiguService.getList1(page, rows, shigu,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid ShiguPO shigu, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = shiguService.insert(shigu);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid ShiguPO shigu, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return shiguService.update(shigu);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid ShiguPO shigu, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return shiguService.updateAll(shigu);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> ShiguDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("shigu:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = shiguService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = shiguService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_Shigu_by_code")
	@ResponseBody
	public EUDataGridResult searchShiguBycode(Integer page, Integer rows, int code) 
			throws Exception{
		EUDataGridResult result = shiguService.searchShiguBycode(page, rows, code);
		return result;
	}
	
	//搜索
	@RequestMapping("/findShigu/{carnumber}")
	@ResponseBody
	public EUDataGridResult searchShiguBycarnum(@PathVariable String carnumber,Integer page, Integer rows) 
			throws Exception{
		EUDataGridResult result = shiguService.searchShiguBycarnum(page, rows, carnumber);
		return result;
	}
	
}
