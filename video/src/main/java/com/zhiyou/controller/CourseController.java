package com.zhiyou.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Course;
import com.zhiyou.service.CourseService;

@Controller
 
public class CourseController {

	@Resource
	CourseService service;
	
	@RequestMapping("show")
       public String show (int page,int num,HttpServletRequest req ,HttpServletResponse res) {
		
		req.setAttribute("list", service.selectAll(page,num));
		
		return "show";
		
	}
	
	@RequestMapping("add")
       public String add(Course course,HttpServletRequest req, HttpServletResponse res) {
   		
   		service.add(course);
   		
   		return "redirect:show";	
   		
   	}
	
	@RequestMapping("update")
	  public String update(Course course,HttpServletRequest req, HttpServletResponse res) {
		
		service.update(course);
		
		return "redirect:show";
	
	}
		
	 @RequestMapping("delete")
	  public String delete(int id, HttpServletRequest req, HttpServletResponse res) {
		 
		 service.delete(id);
		 
		 return "redirect:show";
		 
	 }
		
	@RequestMapping("deletes")
	 public String deletes(int [] ids , HttpServletRequest req, HttpServletResponse res) {
		
		service.deletes(ids);;
		
		return "redirect:show";
		
	}
	
	
	@RequestMapping("selectById")
	  public String selectById(int id , HttpServletRequest req, HttpServletResponse res) {
		
		service.selectById(id);
		
		return "update";
		
	}
		
		
	}
		

