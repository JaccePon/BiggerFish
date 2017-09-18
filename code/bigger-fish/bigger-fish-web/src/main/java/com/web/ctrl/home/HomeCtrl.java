package com.web.ctrl.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统主页控制类
 * 
 *
 * <p>
 * 
 * @author huanghuapeng 2017年9月18日
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/")
public class HomeCtrl {

	/**
	 * 跳转到系统主页
	 * 
	 * @return String
	 */
	@RequestMapping("/")
	public String index(ModelMap map) {
		
		List<String> devs = new ArrayList<String>();
		devs.add("JaccePon");
		devs.add("3306");
		
		map.put("list", devs);
		
		return "index";
	}

}
