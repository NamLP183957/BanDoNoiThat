package com.spring.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.Image;
import com.spring.entity.Product;
import com.spring.entity.User;
import com.spring.service.ProductService;

@Controller
@RequestMapping(value = "/user")
public class DetailProductController {
	@Autowired
	User user;

	@Autowired 
	ProductService productService;
	
	@RequestMapping(value = "/ChiTiet")
	public ModelAndView getDetailProduct(@RequestParam("id")int id) {
		ModelAndView mav = new ModelAndView("user/chi_tiet");
		Product product = productService.getProductAndImageService(id);
		List<Image> listImage = product.getImages();
		
		
		mav.addObject("product", product);
		mav.addObject("listImage", listImage);
		mav.addObject("mainImage", listImage.get(0));
		return mav;
	}
	
	@RequestMapping(value = "/DatHang")
	public ModelAndView getOrder() {
		ModelAndView mav = new ModelAndView();
		if (user.equals(null)) {
			mav.setViewName("user/login");
		} else {
			mav.setViewName("user/dat_hang");
			mav.addObject("")
		}
		
		return mav;
	}
}
