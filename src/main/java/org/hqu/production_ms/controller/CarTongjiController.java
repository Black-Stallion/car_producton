package org.hqu.production_ms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hqu.production_ms.domain.CarMoney;
import org.hqu.production_ms.domain.CarPublic;
import org.hqu.production_ms.domain.CarSend;
import org.hqu.production_ms.domain.CarWD;
import org.hqu.production_ms.domain.CarWE;
import org.hqu.production_ms.domain.CarYidong;
import org.hqu.production_ms.service.CarTongjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carTongji")
public class CarTongjiController {
	@Autowired
	private CarTongjiService ctService;
	@RequestMapping("/find1")
	public String find1() throws Exception{
		return "carTongji";                                                                                                                                                                                                                                                                                                 
	}
	@RequestMapping("/find2")
	public String find2() throws Exception{
		return "carYidongTongji";                                                                                                                                                                                                                                                                                                 
	}
	@RequestMapping("/find3")
	public String find3() throws Exception{
		return "carLiCheng";                                                                                                                                                                                                                                                                                                 
	}
	@RequestMapping("/cardepnums")
	@ResponseBody
	public List<CarPublic> findcardepnums() throws Exception{
		List<CarPublic> list = ctService.findDep();
		return list;
	}
	
	@RequestMapping("/carTypenums")
	@ResponseBody
	public List<CarPublic> findcarTypenums() throws Exception{
		List<CarPublic> list = ctService.findType();
		return list;
	}
	
	@RequestMapping("/carUsenaturenums")
	@ResponseBody
	public List<CarPublic> findcarUsenaturenums() throws Exception{
		List<CarPublic> list = ctService.findUsenature();
		return list;
	}
	
	@RequestMapping("/carYidongnums")
	@ResponseBody
	public List<CarYidong> findcarYidongnums() throws Exception{
		List<CarYidong> list = ctService.findYidong();
		return list;
	}
	@RequestMapping("/carMoneynums")
	@ResponseBody
	public List<CarMoney> findcaMoneynums(HttpServletRequest request) throws Exception{
		String id1 =request.getParameter("year");
		String id2 =request.getParameter("month");
		List<CarMoney> list = ctService.findMoney(id1, id2);
		return list;
	}
	
	@RequestMapping("/carFXnums")
	@ResponseBody
	public List<CarMoney> findcaFXnums(HttpServletRequest request) throws Exception{
		String id1 =request.getParameter("year");
		List<CarMoney> list = ctService.findFX(id1);
		return list;
	}
	
	@RequestMapping("/carLCnums")
	@ResponseBody
	public List<CarMoney> findcaLCnums(HttpServletRequest request) throws Exception{
		String id1 =request.getParameter("year");
		List<CarMoney> list = ctService.findFX(id1);
		return list;
	}
	@RequestMapping("/carDepnums")
	@ResponseBody
	public List<CarSend> findDepnums(HttpServletRequest request) throws Exception{
		String id1 =request.getParameter("year");
		String id2 =request.getParameter("month");
		List<CarSend> list = ctService.findDepnums(id1, id2);
		return list;
	}
	@RequestMapping("/carCarnums")
	@ResponseBody
	public List<CarWE> findCarnums(HttpServletRequest request,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		String id1 =request.getParameter("year");
		List<CarWE> list1 = ctService.findCarnums(id, id1);
		return list1;
	}
	@RequestMapping("/carCarnums2")
	@ResponseBody
	public List<CarWE> findCarnums2(HttpServletRequest request) throws Exception{
		String id = request.getParameter("departmentId");
		String id1 =request.getParameter("year");
		List<CarWE> list = ctService.findCarnums(id, id1);
		return list;
	}
	@RequestMapping("/carCarnums3")
	@ResponseBody
	public List<CarWE> findCarnums3(HttpServletRequest request,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		String id1 =request.getParameter("year");
		List<CarWE> list = ctService.findCarnums(id, id1);
		return list;
	}
	@RequestMapping("/carDrivernums")
	@ResponseBody
	public List<CarWD> findDrivernums(HttpServletRequest request,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		String id1 =request.getParameter("year");
		List<CarWD> list = ctService.findDrivernums(id, id1);
		return list;
	}
	@RequestMapping("/carDrivernums2")
	@ResponseBody
	public List<CarWD> findDrivernums2(HttpServletRequest request) throws Exception{
		String id = request.getParameter("departmentId");
		String id1 =request.getParameter("year");
		List<CarWD> list = ctService.findDrivernums(id, id1);
		return list;
	}
	@RequestMapping("/carDrivernums3")
	@ResponseBody
	public List<CarWD> findDrivernums3(HttpServletRequest request,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		String id1 =request.getParameter("year");
		List<CarWD> list = ctService.findDrivernums(id, id1);
		return list;
	}
}
