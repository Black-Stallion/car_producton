package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarBS;
import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.CarSend;
import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.authority.SysUserRole;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.service.CarBSService;
import org.hqu.production_ms.service.CarRegisterService;
import org.hqu.production_ms.service.CarSendService;
import org.hqu.production_ms.service.SysService;
import org.hqu.production_ms.service.SysUserRoleService;
import org.hqu.production_ms.util.EcondMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

 /**
  * created on 2016年9月6日 
  *
  * 登陆和退出
  *
  * @author  megagao
  * @version  0.0.1
  */
@Controller
public class LoginController {
	
	@Autowired
	private SysService sysService;
	@Autowired
	private CarRegisterService carRegisterService;
	@Autowired
	private CarBSService carBsService;
	@Autowired
	private SysUserRoleService surService;
	@Autowired
	private CarSendService sendService;
	//用户登陆提交方法
	/**
	 * 
	 * <p>Title: login</p>
	 * <p>Description: </p>
	 * @param session
	 * @param randomcode 输入的验证码
	 * @param usercode 用户账号
	 * @param password 用户密码 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public @ResponseBody Map<String,Object> login(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception{
		
		Map<String,Object> map = new HashMap<String,Object>();  
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//调用service校验用户账号和密码的正确性
		ActiveUser activeUser = sysService.authenticat(username, password);
		if(activeUser!=null){
			//如果service校验通过，将用户身份记录到session
			session.setAttribute("activeUser", activeUser);
			//重定向到商品查询页面
			map.put("msg", "success");
		}else{
			map.put("msg", "用户名或密码错误！");
		}
		return map; 
	}
	
	/**
	 * shiro ajax登录 
	 */
	@RequestMapping(value = "/ajaxLogin")
	public @ResponseBody Map<String,Object> ajaxLogin(@RequestParam String username, @RequestParam String password,
			@RequestParam(required=false) String randomcode, HttpSession session) throws Exception{
	    
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		Subject currentUser = SecurityUtils.getSubject();
	    if (!currentUser.isAuthenticated()) {
	    	String password1 = new EcondMD5().EncoderByMd5(password);
	    	UsernamePasswordToken token = new UsernamePasswordToken(username, password1);
	         
	        try{
	            currentUser.login(token);
	            ActiveUser activeUser = sysService.authenticat(username, password1);
	            if(activeUser != null){
	    		SysUser user=sysService.getSysUserById(activeUser.getUserid());
	    		SysUserRole sur = surService.findRoleID(activeUser.getUserid());
	    		if(user !=null && sur!=null){
	    			session.setAttribute("departmentId", user.getDepartment().getDepartmentId());
		    		session.setAttribute("roleId", sur.getSysRoleId());
		    		session.setAttribute("leve", user.getLeve());
		    		session.setAttribute("departmentname", user.getDepartment().getDepartmentName());
		    		session.setAttribute("level", user.getDepartment().getLevel());
		    		session.setAttribute("username", user.getUsername());
//		    		if(user.getDepartment().getFatherdep()!="0" &&(user.getDepartment().getFatherdep()!=null)){
//		    			Department fathername = departmentService.getDep2(user.getDepartment().getFatherdep());
//		    			if(fathername != null){
//		    				session.setAttribute("fathername", fathername.getDepartmentName());
//		    				session.setAttribute("departmentNames1", user.getDepartment().getDepartmentName());
//		    				List<CarPublic> list = null;
//		    				if(2 == user.getLeve()){
//		    					list = carRegisterService.findP11();
//		    				}else{
//		    					list = carRegisterService.findP2(user.getDepartment().getDepartmentId());
//		    				}
//		    				session.setAttribute("lists",list);
//		    			}else{
//		    				session.setAttribute("fathername", user.getDepartment().getDepartmentName());
//		    				List<CarPublic> list = null;
//		    				if(2 == user.getLeve()){
//		    					list = carRegisterService.findP11();
//		    				}else{
//		    					list = carRegisterService.findP2(user.getDepartment().getDepartmentId());
//		    				}
//		    				session.setAttribute("lists",list);
//		    			}
//		    		}
//		    		else{
//		    			map.put("msg", "异常");
		    				List<CarBS> listb = null;
		    				List<CarRegister> list = null;
		    				List<CarSend> listc = null;
		    				if(2 == user.getLeve()){
		    					list = carRegisterService.findP11();
		    					listb = carBsService.finds();
		    					listc = sendService.findStat();
		    				}else{
		    					list = carRegisterService.findP2(user.getDepartment().getDepartmentId());
		    					listb = carBsService.finds1(user.getDepartment().getDepartmentId());
		    					listc = sendService.findStat1(user.getDepartment().getDepartmentId());
		    				}
		    				if(listc== null){
		    					for (CarRegister carRegister : list) {
										 carRegister.setStat("未使用");
								}
		    				}else{
		    					for (CarRegister carRegister : list) {
			    					for (CarSend carSend : listc) {
										if(carRegister.getCarId()==carSend.getCarId()){
											carRegister.setStat("使用中");
										}else{
											carRegister.setStat("未使用");
										}
									}
								}
		    				}
		    				
		    				session.setAttribute("lists",list);
		    				session.setAttribute("listb",listb);
		    				//session.setAttribute("listc",listc);
	    		}else{
	    			map.put("msg", "异常");
	    		}}else{
	    			map.put("msg", "异常");
	    		}
	    		
	        }catch(UnknownAccountException ex){
	        	map.put("msg", "account_error");
	        }catch(IncorrectCredentialsException ex){
	        	map.put("msg", "password_error");
	        }catch(AuthenticationException ex){
	        	map.put("msg", "authentication_error");
	        }
	    }
	    //返回json数据
	    return map;
	}
	
	//登陆提交地址，和applicationContext-shiro.xml中配置的loginurl一致
	/*@RequestMapping("/login")
	public String login(HttpServletRequest request) throws Exception{
		
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				throw new CustomException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				throw new CustomException("用户名/密码错误");
			} else if("randomCodeError".equals(exceptionClassName)){
				throw new CustomException("验证码错误 ");
			}else {
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败还到login页面
		return "login";
	}*/
	
/*	//用户退出
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		
		//session失效
		session.invalidate();
		//重定向到商品查询页面
		return "redirect:/first.action";
		
	}*/
}
