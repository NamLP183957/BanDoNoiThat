package com.spring.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DAO.ProductDAO;

@Controller
public class HomeController {

	@Autowired
	private ProductDAO productDao;
	
	@RequestMapping(value = "/home")
	public ModelAndView getHomepage() {
		ModelAndView mav = new ModelAndView("admin/home");
		Long numberProduct = productDao.getNumberProduct("all");
		
		mav.addObject("numberProduct", numberProduct);
		return mav;
	}
}
