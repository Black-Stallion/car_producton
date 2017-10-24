package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarFold;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarFoldPO;
import org.hqu.production_ms.service.CarFoldService;
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
@RequestMapping("/carFold")
public class CarFoldController {
	@Autowired
	private CarFoldService carFoldService;
	
	@RequestMapping("/get/{carFoldId}")
	@ResponseBody
	public CarFold getItemById(@PathVariable int ApplyId) throws Exception{
		CarFold carFold = carFoldService.get(ApplyId);
		return carFold;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarFold> getData(HttpSession session) throws Exception{
		List<CarFold> list = carFoldService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carFold_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carFoldAddJudge(HttpSession session) throws Exception{
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
			if(!subject.isPermitted("carFold:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}if(subject.isPermitted("fold:jufa")){
			session.setAttribute("jufa","局发");
		}if(subject.isPermitted("fold:duanfa")){
			session.setAttribute("duanfa","段发");
		}if(subject.isPermitted("fold:chejian")){
			session.setAttribute("chejian","车间发");
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carFold_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carFoldEditJudge(HttpSession session) throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carFold:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		if(subject.isPermitted("fold:jufa")){
			session.setAttribute("jufa","局发");
		}if(subject.isPermitted("fold:duanfa")){
			session.setAttribute("duanfa","段发");
		}if(subject.isPermitted("fold:chejian")){
			session.setAttribute("chejian","车间发");
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carFold_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarFold carFold,HttpSession session) throws Exception{
		EUDataGridResult result =null;
		String id = (String) session.getAttribute("departmentId");
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result  = carFoldService.getList(page, rows, carFold);
		}else{
			result  = carFoldService.getList1(page, rows, carFold,id);
		}
		return result;
	}
	
	@RequestMapping("/list1")
	@ResponseBody
	public EUDataGridResult getList1(Integer page, Integer rows, CarFold carFold,HttpSession session) throws Exception{
		EUDataGridResult result =null;
		String id = (String) session.getAttribute("departmentId");
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result  = carFoldService.getList(page, rows, carFold);
		}else{
			result  = carFoldService.getList1(page, rows, carFold,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarFoldPO carFold, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carFoldService.insert(carFold);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarFoldPO cCarFold, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carFoldService.update(cCarFold);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarFoldPO cCarFold, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carFoldService.updateAll(cCarFold);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carFoldDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carFold:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carFoldService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		for (int i : ids) {
			CarFold fold = carFoldService.get(i);
			String fileName = fold.getFold();
			if(fileName != null){
				fileName = fileName.substring(fileName.lastIndexOf("/")+1);
				fileName = new Image_fileUtile().fileName()+fileName;
				FileUtil.deleteFile(fileName);
			}
		}
		CustomResult result = carFoldService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carFold_by_f1")
	@ResponseBody
	public EUDataGridResult searchCarFoldByCarFoldBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		EUDataGridResult result =null;
		String id = (String) session.getAttribute("departmentId");
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carFoldService.searchCarFoldByCarFoldBrand(page, rows, searchValue);
		}else{
			result = carFoldService.searchCarFoldByCarFoldBrand1(page, rows, id,searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carFold_by_f2")
	@ResponseBody
	public EUDataGridResult searchCarFoldByCarFoldCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		EUDataGridResult result =null;
		String id = (String) session.getAttribute("departmentId");
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carFoldService.searchCarFoldByCarFoldCarXH(page, rows, searchValue);
		}else{
			result = carFoldService.searchCarFoldByCarFoldCarXH1(page, rows,id, searchValue);
		}
		return result;
	}
	
	
	}