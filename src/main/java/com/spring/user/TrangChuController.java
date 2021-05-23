package com.spring.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DAO.ProductDAO;
import com.spring.entity.Image;
import com.spring.entity.Product;
import com.spring.service.ProductService;

@Controller
@RequestMapping("/user")
public class TrangChuController {	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public ModelAndView getHome() {
		ModelAndView mav = new ModelAndView("user/trang_chu");
		Product product = productDAO.getBestSell();
		Product bestSellProduct = productService.getProductAndImageService(product.getId());
		List<Image> listImage = bestSellProduct.getImages();
		
		mav.addObject("bestProduct", bestSellProduct);
		mav.addObject("bestSellImage", listImage.get(0));
		return mav;
	}
}
