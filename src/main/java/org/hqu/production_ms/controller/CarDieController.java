package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarDie;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarDiePO;
import org.hqu.production_ms.service.CarDieService;
import org.hqu.production_ms.service.CarRegisterService;
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
@RequestMapping("/carDie")
public class CarDieController {
	@Autowired
	private CarDieService carDieService;
	@Autowired
	private CarRegisterService carRegisterService;
	@RequestMapping("/get/{carDieId}")
	@ResponseBody
	public CarDie getItemById(@PathVariable int technicalId) throws Exception{
		CarDie carDie = carDieService.get(technicalId);
		return carDie;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarDie> getData() throws Exception{
		 List<CarDie> list = carDieService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carDie_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carDieAddJudge() throws Exception{
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
			if(!subject.isPermitted("carDie:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carDie_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carDieEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carDie:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carDie_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarDie carDie,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carDieService.getList(page, rows, carDie);
		}else{
			result = carDieService.getList1(page, rows, carDie,id);
			}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarDiePO carDie, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			String carId = carDie.getNewnum();
			String depid = carDie.getDepartmentId();
			boolean re = carRegisterService.updateDepByIds(depid, carId);
			if(re == true){
			result = carDieService.insert(carDie);
			}else{
				return CustomResult.build(201,"新增车辆报废信息失败，请刷新一下网页后重新填写！");
			}
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarDiePO cCarDie, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carDieService.update(cCarDie);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarDiePO cCarDie, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		String carId = cCarDie.getNewnum();
		String depid = cCarDie.getDepartmentId();
		boolean re = carRegisterService.updateDepByIds(depid, carId);
		if(re == true){
		return carDieService.updateAll(cCarDie);
		}else{
			return CustomResult.build(201,"修改车辆报废信息失败，请刷新一下网页后重新填写！");
		}
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carDieDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carDie:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carDieService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		for (int i : ids) {
			CarDie fold = carDieService.get(i);
			String fileName = fold.getNotes();
			if(fileName != null){
				fileName = fileName.substring(fileName.lastIndexOf("/")+1);
				fileName = new Image_fileUtile().fileName()+fileName;
				FileUtil.deleteFile(fileName);
			}
		}
		CustomResult result = carDieService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carDie_by_d1")
	@ResponseBody
	public EUDataGridResult searchCarDieByCarDieBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		//String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carDieService.searchCarDieByCarDieBrand(page, rows, searchValue);
		}else{
			result = carDieService.searchCarDieByCarDieBrand(page, rows, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carDie_by_d2")
	@ResponseBody
	public EUDataGridResult searchCarDieByCarDieCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		//String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carDieService.searchCarDieByCarDieCarXH(page, rows, searchValue);
		}else{
			result = carDieService.searchCarDieByCarDieCarXH(page, rows, searchValue);		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carDie_by_checknums")
	@ResponseBody
	public EUDataGridResult searchCarDieByDepartmentCheckNums(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carDieService.searchCarDieByCheckNums(page, rows, searchValue);
		return result;
	}
}
