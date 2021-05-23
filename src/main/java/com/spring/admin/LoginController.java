package com.spring.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DAO.AdminDAO;
import com.spring.DAO.ProductDAO;

@Controller
public class LoginController {
	
	//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath://spring-hibernate-config.xml");
	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	private ProductDAO productDao;
	
	@RequestMapping(value = {"/", "/login"})
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("admin/login");
		mav.addObject("status", false);
		return mav;
	}
	
	@RequestMapping(value = "/authenciate")
	public ModelAndView authenciate(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String passOfUsername = adminDAO.getAdmin(username);
		
		if(password.equals(passOfUsername)) {
			mav.setViewName("admin/home");
			Long numberProduct = productDao.getNumberProduct("all");
			mav.addObject("numberProduct", numberProduct);
			mav.addObject("status", true);
		}
		else {
			mav.setViewName("admin/login");
			mav.addObject("status", false);
		}
		return mav;
	}
}
