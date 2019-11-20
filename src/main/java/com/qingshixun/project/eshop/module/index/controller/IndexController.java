package com.qingshixun.project.eshop.module.index.controller;

import com.qingshixun.project.eshop.dto.MemberDTO;
import com.qingshixun.project.eshop.dto.ProductDTO;
import com.qingshixun.project.eshop.module.advertisement.service.AdvertisementServiceImpl;
import com.qingshixun.project.eshop.module.cart.service.CartItemServiceImpl;
import com.qingshixun.project.eshop.module.product.service.ProductCategoryServiceImpl;
import com.qingshixun.project.eshop.module.product.service.ProductServiceImpl;
import com.qingshixun.project.eshop.web.BaseController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController extends BaseController {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Autowired
    private AdvertisementServiceImpl advertisementService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CartItemServiceImpl cartItemService;

    @RequestMapping(value = {"/front/index", ""})
    public String index(Model model) {
        MemberDTO member = getCurrentUser();
       
        model.addAttribute("productCategories", productCategoryService.getProductCategories());
        model.addAttribute("advertisements", advertisementService.getAdvertisements());
        model.addAttribute("hotProducts", productService.getHotProducts());
        model.addAttribute("newProducts", productService.getNewProducts());
        model.addAttribute("bestProducts", productService.getBestProducts());
        model.addAttribute("totalCartCount", cartItemService.getTotalCartCount(member, getSession()));
        // 当前登录用户数据保存到session中
        setSessionAttribute("member", member);

        return "/index";
    }

    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping("/front/register")
    public String register(Model model) {
        model.addAttribute("member", new MemberDTO());
        return "/register";
    }

    /**
     * 登录页面
     *     
     * @return
     */
    @RequestMapping("/front/login")
    public String login() {
        return "/login";
    }
    
    @RequestMapping("sach")
    public  String info( @RequestParam String name,Model model) {
    	
    	System.out.println(name);
		List<ProductDTO>product=productCategoryService.select(name);
    	if (product.size()==1) {
    		model.addAttribute("product", product.get(0));
    		return"/product/main";	
		}else if(product.size()==0) {
			model.addAttribute("mages", "暂无商品信息");
			return "/prompt";
		}
    	
		return name; 
    }
    
    
    
}
