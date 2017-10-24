package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarDriver;
import org.hqu.production_ms.domain.Department;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarDriverPO;
import org.hqu.production_ms.service.CarDriverService;
import org.hqu.production_ms.service.DepartmentService;
import org.hqu.production_ms.util.FileUtil;
import org.hqu.production_ms.util.Image_fileUtile;
import org.hqu.production_ms.util.uploadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carDriver")
public class CarDriverController {
	@Autowired
	private CarDriverService carDriverService;
	@Autowired
	private DepartmentService dService;
	
	@RequestMapping("/get/{driveId}")
	@ResponseBody
	public CarDriver getItemById(@PathVariable int driveId) throws Exception{
		CarDriver carDriver = carDriverService.get(driveId);
		return carDriver;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarDriver> getData(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		List<CarDriver> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
		 list = carDriverService.gets();
		}else{
		list = carDriverService.gets1(id);
		}
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carDriver_list";                                                                                                                                                                                                                                                                                                 
	}
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public CustomResult download(@Valid String upload) throws Exception{
		CustomResult result = null;
		uploadExcel x = new uploadExcel();
		List<CarDriverPO> list1 = x.loadScoreInfo(new Image_fileUtile().uploadName()+upload);
		for (CarDriverPO carDriver : list1) {
			if(carDriver.getDepartmentName() != null && !carDriver.getDepartmentName().equals("")){
				Department dep = dService.getDep23(carDriver.getDepartmentName());
				if(dep != null){
					String id = dep.getDepartmentId();
					carDriver.setDepartmentId(id);
					result = carDriverService.insert(carDriver);
				}
				else{
					FileUtil.deleteFile(new Image_fileUtile().uploadName()+upload);
					return CustomResult.build(201,"该系统部门内没有找到名称为  "+carDriver.getDepartmentName()+" 的部门，导致该部门以下的司机信息导入失败，请检查后重新导入！");
				}
			}else{
				FileUtil.deleteFile(new Image_fileUtile().uploadName()+upload);
				return CustomResult.build(201,"您的Excel文档内部门名称有为空的，导致空部门以下的信息导入失败，请检查后重新导入！");
			}
		}
		FileUtil.deleteFile(new Image_fileUtile().uploadName()+upload);
		return result;
	}
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carDriverAddJudge() throws Exception{
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
			if(!subject.isPermitted("carDriver:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carDriver_add";
	}
	@RequestMapping("/upload1")
	public String upload() throws Exception{
		return "carDriver_upload";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carDriverEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carDriver:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carDriver_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarDriver carDriver,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carDriverService.getList(page, rows, carDriver);
		}else{
			result = carDriverService.getList1(page, rows, carDriver,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarDriverPO carDriver, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carDriverService.insert(carDriver);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarDriverPO cCarDriver, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carDriverService.update(cCarDriver);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarDriverPO cCarDriver, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carDriverService.updateAll(cCarDriver);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carDriverDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carDriver:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carDriverService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carDriverService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carDriver_by_dd1")
	@ResponseBody
	public EUDataGridResult searchCarDriverByCarDriverBrand(Integer page, Integer rows,  String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carDriverService.searchCarDriverByCarDriverName(page, rows, searchValue);
		}else{
			result = carDriverService.searchCarDriverByCarDriverName1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carDriver_by_dd2")
	@ResponseBody
	public EUDataGridResult searchCarDriverByCarDriverNum(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			 result = carDriverService.searchCarDriverByCarDrivernum(page, rows, searchValue);
			 }else{
				 result = carDriverService.searchCarDriverByCarDrivernum1(page, rows,id, searchValue);
			 }
		return result;
	}
	
	
}
