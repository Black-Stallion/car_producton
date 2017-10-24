package org.hqu.production_ms.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarPublic;
import org.hqu.production_ms.domain.Department;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.CarRegisterService;
import org.hqu.production_ms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private CarRegisterService carRegisterService;
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/get/{departmentId}")
	@ResponseBody
	public Department getItemById(@PathVariable String departmentId) throws Exception{
		Department department = departmentService.get(departmentId);
		return department;
	}
	
	@RequestMapping("/getsf/{index}")
	@ResponseBody
	public Department getItemByIndex(@PathVariable String index) throws Exception{
		Department department = departmentService.getDep2(index);
		return department;
	}
	
	@RequestMapping("/get_data_first")
	@ResponseBody
	public List<Department> getDataFirst() throws Exception{
		//return departmentService.findByLevel(0);
		return departmentService.findByLevel(1);
	}
	
	@RequestMapping("/get_data_second/{fatherdep}")
	@ResponseBody
	public List<Department> getDataSecond(@PathVariable String fatherdep) throws Exception{
		return departmentService.findSecond(fatherdep);
	}
	@RequestMapping("/father_judge/{ids}")
	@ResponseBody
	public Map<String,Object> departmentfatherudge(@PathVariable String ids) throws Exception{
		List<Department> list = departmentService.findSecond(ids);
		Map<String,Object> map = new HashMap<String,Object>(); 
		if(list.size()>0){
			map.put("msg", "部门含有子部门，请先删除子部门，在来删除该部门!");
		}
		return map;
	}
	@RequestMapping("/get_data_third/{fatherdep}")
	@ResponseBody
	public List<Department> getDatathird(@PathVariable String fatherdep) throws Exception{
		return departmentService.findSecond(fatherdep);
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "department_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Department> getData() throws Exception{
		return departmentService.find();
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> departmentAddJudge() throws Exception{
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
			if(!subject.isPermitted("department:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "department_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> departmentEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("department:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "department_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Department department,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = departmentService.getList(page, rows, department);
		}else{
			int level =  (int) session.getAttribute("level");
			if(level==1){
			result = departmentService.getList1(page, rows, id);
			}else{
				result =departmentService.getLists(page, rows, id);
			}
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Department department, BindingResult bindingResult) throws Exception {
		CustomResult result;
		Calendar now = Calendar.getInstance();  
		int year =  now.get(Calendar.YEAR);  
		String month = now.get(Calendar.MONTH) + 1 + "";  
        int day =  now.get(Calendar.DAY_OF_MONTH);  
        int hour =  now.get(Calendar.HOUR_OF_DAY);  
        int minute = now.get(Calendar.MINUTE);  
        int second =  now.get(Calendar.SECOND); 
        int mi = now.get(Calendar.MILLISECOND);
        String did = "jn"+year+month+day+hour+minute+second+mi;
        department.setDepartmentId(did);
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			if(department.getLevel()==0){
				if(departmentService.getDep23(department.getDepartmentName()) != null){
					result = new CustomResult(0, "该部门已存在，请检查后重新填写！", null);
				}else{
					department.setFatherdep("0");
					result = departmentService.insert(department);
				}
			}else if(department.getLevel()==2){
				if(departmentService.getDep23(department.getDepartmentName()) != null){
					result = new CustomResult(0, "该部门已存在，请检查后重新填写！", null);
				}else{
				if(departmentService.getDep11(department.getFathername()) == null){
					result = new CustomResult(0, "该部门不存在或该部门级别与您所添加部门选择的级别相同或越级(为一级),故不能作为其上级，请检查后重新填写！", null);
				}else{
					department.setFatherdep(departmentService.getDep11(department.getFathername()).getDepartmentId());
					result = departmentService.insert(department);
				}
				}
			}else if(department.getLevel()==1){
//				if(departmentService.getDep23(department.getDepartmentName()) != null){
//					result = new CustomResult(0, "该部门已存在，请检查后重新填写！", null);
//				}else{
//				if(departmentService.getDep1(department.getFathername()) == null){
//					result = new CustomResult(0, "该部门不存在或该部门级别与您所添加部门选择的级别相同或太低，故不能作为其上级，请检查后重新填写！", null);
//				}else{
//					department.setFatherdep(departmentService.getDep1(department.getFathername()).getDepartmentId());
//					result = departmentService.insert(department);
//				}
//				}
				if(departmentService.getDep23(department.getDepartmentName()) != null){
					result = new CustomResult(0, "该部门已存在，请检查后重新填写！", null);
				}else{
					department.setFatherdep("0");
					result = departmentService.insert(department);
				}
			}
			else{
				result = new CustomResult(0, "操作有误，请刷新页面后，重新添加！", null);
			}
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid Department department, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return departmentService.update(department);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Department department, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{//选择一级
			if(department.getLevel()==0){
				if(departmentService.getDep23(department.getDepartmentName()) != null){
					result = new CustomResult(0, "该部门已存在，请检查后重新填写！", null);
				}else{
					department.setFatherdep("0");
					result = departmentService.updateAll(department);
				}
			}else if(department.getLevel()==2){//选择三级
				
				if(department.getFathername() == null && department.getFatherdep()!=null){//没进行级别的改动
					result = departmentService.updateAll(department);
				}else{//进行级别的改动了
					if(departmentService.getDep11(department.getFathername()) == null){
						result = new CustomResult(0, "该部门不存在或该部门级别与您所添加部门选择的级别相同或越级(为一级),故不能作为其上级，请检查后重新填写！", null);
					}else{
						department.setFatherdep(departmentService.getDep11(department.getFathername()).getDepartmentId());
						result = departmentService.updateAll(department);
					}
				}
				
			}
			else if(department.getLevel()==1){//选择二级，没有进行级别改动
				
//				if(department.getFathername() == null && department.getFatherdep()!=null){
//						result = departmentService.updateAll(department);
//				}else{//选择二级，进行级别改动
//					if(departmentService.getDep1(department.getFathername()) == null){
//						result = new CustomResult(0, "该部门不存在或该部门级别与您所添加部门选择的级别相同或太低，故不能作为其上级，请检查后重新填写！", null);
//					}else{
//						department.setFatherdep(departmentService.getDep1(department.getFathername()).getDepartmentId());
//						result = departmentService.updateAll(department);
//					}
//				}
				department.setFatherdep("0");
				result = departmentService.updateAll(department);
				
			}else{
				result = new CustomResult(0, "操作有误，请刷新页面后，重新修改！", null);
			}
		}
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid Department department, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return departmentService.updateNote(department);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> departmentDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("department:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = departmentService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = departmentService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_department_by_departmentId")
	@ResponseBody
	public EUDataGridResult searchDepartmentByDepartmentId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = departmentService.searchDepartmentByDepartmentId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_department_by_departmentName")
	@ResponseBody
	public EUDataGridResult searchDepartmentByDepartmentName(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = departmentService.searchDepartmentByDepartmentName(page, rows, searchValue);
		return result;
	}
	//搜索
		@RequestMapping("/dep")
		public String dep(ModelMap map) throws Exception{
			
			List<Department> result = departmentService.dep();
			List<CarPublic> resu = carRegisterService.findP();
			map.put("list", result);
			map.put("listc", resu);
			return "carPublic_list5";
		}
}
