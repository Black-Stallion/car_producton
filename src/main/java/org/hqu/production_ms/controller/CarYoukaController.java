package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarYou;
import org.hqu.production_ms.domain.CarYouka;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYoukaPO;
import org.hqu.production_ms.service.CarYouService;
import org.hqu.production_ms.service.CarYoukaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carYouka")
public class CarYoukaController {
	@Autowired
	private CarYoukaService carYoukaService;
	@Autowired
	private CarYouService carYouService;
	
	@RequestMapping("/get/{carYoukaId}")
	@ResponseBody
	public CarYouka getItemById(@PathVariable int technicalId) throws Exception{
		CarYouka carYouka = carYoukaService.get(technicalId);
		return carYouka;
	}
	@RequestMapping("/get_car/{carId}")
	@ResponseBody
	public CarYouka getFindByCarId(@PathVariable int carId) throws Exception{
		CarYouka carYouka = carYoukaService.findByCarId(carId);
		return carYouka;
	}
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarYouka> getData(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		 List<CarYouka> list = carYoukaService.find1(id);
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carYouka_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carYoukaAddJudge() throws Exception{
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
			if(!subject.isPermitted("carYouka:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carYouka_add";
	}
	@RequestMapping("/adds")
	public String adds() throws Exception{
		return "carYouka_adds";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carYoukaEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYouka:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carYouka_edit";
	}
	
//	@RequestMapping("/list/{d}")
//	@ResponseBody
//	public EUDataGridResult getList(Integer page, Integer rows, CarYouka carYouka,String string) throws Exception{
//		EUDataGridResult result = carYoukaService.getList(page, rows, carYouka,string);
//		return result;
//	}
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarYouka carYouka,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carYoukaService.getList1(page, rows, carYouka);
		}else{
		    result = carYoukaService.getList(page, rows, carYouka,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarYoukaPO carYouka, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carYoukaService.insert(carYouka);
			CarYou you = carYouService.get(carYouka.getYouId());
			you.setYouId(carYouka.getYouId());
			you.setBeiyong2(you.getBeiyong2().subtract(carYouka.getTotlyou()));
			carYouService.updateByYouId(you);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarYoukaPO cCarYouka, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carYoukaService.update(cCarYouka);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarYoukaPO cCarYouka, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			CarYouka y = carYoukaService.get(cCarYouka.getYoukaId());
			CarYou you = carYouService.get(cCarYouka.getYouId());
			you.setYouId(cCarYouka.getYouId());
			you.setBeiyong2(you.getBeiyong2().add(y.getTotlyou()).subtract(cCarYouka.getTotlyou()));
			carYouService.updateByYouId(you);
			result = carYoukaService.updateAll(cCarYouka);
		}
		return result;
	}
	@RequestMapping(value="/update_id")
	@ResponseBody
	private CustomResult updateById(@Valid CarYoukaPO carYouka, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carYoukaService.updateById(carYouka);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carYoukaDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYouka:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carYoukaService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carYoukaService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carYouka_by_carnum")
	@ResponseBody
	public EUDataGridResult searchCarYoukaByCarYoukaBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carYoukaService.searchCarYoukaByCarYoukaBrand(page, rows, searchValue);
		}else{
			result = carYoukaService.searchCarYoukaByCarYoukaBrand1(page, rows,id,searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carYouka_by_younum")
	@ResponseBody
	public EUDataGridResult searchCarYoukaByCarYoukaCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carYoukaService.searchCarYoukaByCarYoukaCarXH(page, rows, searchValue);
		}else{
			result = carYoukaService.searchCarYoukaByCarYoukaCarXH1(page, rows,id,searchValue);
		}
		return result;
	}
	
}
