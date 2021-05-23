package com.spring.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.Tuple;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DAO.ProductDAO;
import com.spring.entity.Image;
import com.spring.entity.Product;
import com.spring.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/product")
	public ModelAndView product(@RequestParam("type") String type) {
		ModelAndView mav = new ModelAndView("admin/product");
		List<Product> listProduct = productDAO.getProduct(type);
		mav.addObject("listProduct", listProduct);
		mav.addObject("type", type);
		return mav;
	}

	@RequestMapping(value = "/addProduct")
	public ModelAndView addProduct(@RequestParam("type") String type) {
		ModelAndView mav = new ModelAndView("admin/add_product");
		mav.addObject("type", type);
		return mav;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView saveProduct(@RequestParam("images") MultipartFile files[], @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") Long price,
			@RequestParam("number") Long numberInWare, @RequestParam("style") String style,
			@RequestParam("type") String type) throws IOException {
		ModelAndView mav = new ModelAndView("admin/product");
		Long numberOfSell = (long) 0;
		
		List<Image> listImage = new ArrayList<Image>();
		Product product = new Product(name, description, type, price, numberInWare, numberOfSell, style, listImage);
		
		for (MultipartFile file : files) {
			Image image = new Image();
			image.setContent(file.getBytes());
			product.addImage(image);
		}
		
		
		productDAO.saveProduct(product);
		
		List<Product> listProduct = productDAO.getProduct(type);
		mav.addObject("listProduct", listProduct);
		return mav;
	}
	
	@RequestMapping(value = "/productDetail")
	public ModelAndView getProductDetail(@RequestParam("id")int id, HttpServletResponse respone) {
		ModelAndView mav = new ModelAndView("product/product_detail");
		Product product = productService.getProductAndImageService(id);
		
		List<Image> listImage = product.getImages();
		Image image = listImage.get(0);
		
		mav.addObject("mainImage", image);
		mav.addObject("product", product);
		mav.addObject("listImage", listImage);
		return mav;
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public ModelAndView updateProduct(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") Long price,
			@RequestParam("number") Long numberInWare, @RequestParam("style") String style) {

		ModelAndView mav = new ModelAndView("product/product_detail");
		boolean updateState = productDAO.updateProduct(id, name, description, price, numberInWare, style);
		if (updateState == true) {
			mav.addObject("updateStatus", "Update Successfull!");
		} else {
			mav.addObject("updateStatus", "Update Failed!");
		}

		Product product = productService.getProductAndImageService(id);

		List<Image> listImage = product.getImages();
		Image image = listImage.get(0);

		mav.addObject("mainImage", image);
		mav.addObject("product", product);
		mav.addObject("listImage", listImage);
		return mav;
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@RequestParam("id")int id, @RequestParam("type")String type) {
		ModelAndView mav = new ModelAndView("admin/product");
		productDAO.deleteProduct(id);
		List<Product> listProduct = productDAO.getProduct(type);
		mav.addObject("listProduct", listProduct);
		mav.addObject("type", type);
		return mav;
	}
	
	@PostMapping(value = "/addImage")
	public ModelAndView addImage(@RequestParam("id")int id, @RequestParam("image")MultipartFile file) throws IOException {
		ModelAndView mav = new ModelAndView("product/product_detail");
		Image addImage = new Image();
		addImage.setContent(file.getBytes());
		addImage.setBase64Image(Base64.getEncoder().encodeToString(file.getBytes()));
		productDAO.addImage(id, addImage);
		
		Product product = productService.getProductAndImageService(id);
		
		List<Image> listImage = product.getImages();
		Image image = listImage.get(0);
		
		mav.addObject("mainImage", image);
		mav.addObject("product", product);
		mav.addObject("listImage", listImage);
		
		return mav;
	}
}
