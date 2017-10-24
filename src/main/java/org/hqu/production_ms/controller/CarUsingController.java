package org.hqu.production_ms.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarUsing;

import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarUsingPO;
import org.hqu.production_ms.service.CarUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carUsing")
public class CarUsingController {
	@Autowired
	private CarUsingService carUsingService;
	
	@RequestMapping("/get/{usingId}")
	@ResponseBody
	public CarUsing getItemById(@PathVariable int usingId) throws Exception{
		CarUsing CarUsing = carUsingService.get(usingId);
		return CarUsing;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarUsing> getData() throws Exception{
		 List<CarUsing> list = carUsingService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carUsing_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> CarUsingAddJudge() throws Exception{
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
			if(!subject.isPermitted("carUsing:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carUsing_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> CarUsingEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carUsing:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carUsing_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarUsing CarUsing,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carUsingService.getList(page, rows, CarUsing);
		}else{
			result = carUsingService.getList1(page, rows, CarUsing,id);
		}
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarUsingPO CarUsing, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			double ranyou = Integer.parseInt(CarUsing.getMonthry());
			double km = Integer.parseInt(CarUsing.getMonthkm());
			double hh = ranyou/(km/100);
			DecimalFormat df = new DecimalFormat("#.00"); 
			String  haoyou = df.format(hh);
			CarUsing.setHaoyou(haoyou);
			result = carUsingService.insert(CarUsing);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarUsingPO carUsing, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carUsingService.update(carUsing);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarUsingPO carUsing, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		double ranyou = Integer.parseInt(carUsing.getMonthry());
		double km = Integer.parseInt(carUsing.getMonthkm());
		double hh = ranyou/(km/100);
		DecimalFormat df = new DecimalFormat("#.00"); 
		String  haoyou = df.format(hh);;
		carUsing.setHaoyou(haoyou);
		return carUsingService.updateAll(carUsing);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> CarUsingDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carUsing:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carUsingService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carUsingService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carUsing_by_carid")
	@ResponseBody
	public EUDataGridResult searchCarUsingByCarUsingYear(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carUsingService.searchCarUsingByCarUsing1(page, rows, searchValue);
		}else{
			result = carUsingService.searchCarUsingByCarUsing1s(page, rows,id, searchValue);
		}
		return result;
	}
	@RequestMapping("/search_carUsing_by_depname")
	@ResponseBody
	public EUDataGridResult searchCarUsingByCarUsingdep(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carUsingService.searchCarUsingByCarUsing2(page, rows, searchValue);
		}else{
			result = carUsingService.searchCarUsingByCarUsing2s(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/findUsing/{carId}")
	@ResponseBody
	public EUDataGridResult searchCarUsingByCarUsingCarId(@PathVariable int carId,Integer page, Integer rows) 
			throws Exception{
		EUDataGridResult result = carUsingService.searchCarUsingByCarUsingCarId(page, rows, carId);
		return result;
	}
	
	
		
}
