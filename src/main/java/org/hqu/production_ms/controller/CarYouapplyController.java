package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarYouapply;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYouapplyPO;
import org.hqu.production_ms.service.CarYouapplyService;
import org.hqu.production_ms.util.FileUtil;
import org.hqu.production_ms.util.Image_fileUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/carYouapply")
public class CarYouapplyController {
	@Autowired
	private CarYouapplyService carYouapplyService;
	
	@RequestMapping("/get/{carYouapplyId}")
	@ResponseBody
	public CarYouapply getItemById(@PathVariable int ApplyId) throws Exception{
		CarYouapply carYouapply = carYouapplyService.get(ApplyId);
		return carYouapply;
	}
		
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarYouapply> getData(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		List<CarYouapply> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			list = carYouapplyService.find();
		}else{
			list = carYouapplyService.find1(id);
		}
		 
		return list;
	}
	
	@RequestMapping("/get_find")
	@ResponseBody
	public List<CarYouapply> find1(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		 List<CarYouapply> list = carYouapplyService.find1(id);
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carYouapply_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carYouapplyAddJudge() throws Exception{
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
			if(!subject.isPermitted("carYouapply:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carYouapply_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carYouapplyEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYouapply:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carYouapply_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarYouapply carYouapply,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carYouapplyService.getList(page, rows, carYouapply);
		}else{
			result = carYouapplyService.getList1(page, rows, carYouapply,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarYouapplyPO carYouapply, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carYouapplyService.insert(carYouapply);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarYouapplyPO cCarYouapply, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carYouapplyService.update(cCarYouapply);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarYouapplyPO cCarYouapply, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		System.out.println(cCarYouapply.toString());
		return carYouapplyService.updateAll(cCarYouapply);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carYouapplyDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYouapply:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carYouapplyService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		for (int i : ids) {
			CarYouapply apply = carYouapplyService.get(i);
			String fileName = apply.getFolds();
			if(fileName != null){
				fileName = fileName.substring(fileName.lastIndexOf("/")+1);
				fileName = new Image_fileUtile().fileName()+fileName;
				FileUtil.deleteFile(fileName);
			}
		}
		CustomResult result = carYouapplyService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carYouapply_by_y1")
	@ResponseBody
	public EUDataGridResult searchCarYouapplyByCarYouapplyBrand(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carYouapplyService.searchCarYouapplyByCarYouapplyBrand(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carYouapply_by_y2")
	@ResponseBody
	public EUDataGridResult searchCarYouapplyByCarYouapplyCarXH(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carYouapplyService.searchCarYouapplyByCarYouapplyCarXH(page, rows, searchValue);
		return result;
	}
	
}
