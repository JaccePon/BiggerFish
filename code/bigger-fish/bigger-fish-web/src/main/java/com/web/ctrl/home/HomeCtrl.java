package com.web.ctrl.home;

import org.springframework.stereotype.Controller;
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
	public String index() {
		return "index";
	}

}
