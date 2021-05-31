package com.example.mContoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Gateway;
import com.example.pojo.User;

@RestController
@RequestMapping("/cont")
public class UserController {
	
	@Autowired
	public User user;
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView h() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");
		return mv;
	}
	
	
	@RequestMapping("/contactUs")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contactUs.html");
		return mv;
	}
	
	@RequestMapping("/action")
	public ModelAndView action() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("action.html");
		return mv;
	}
	
	@RequestMapping("/mOpt")
	public ModelAndView opt(@RequestParam("optSel") String opt) {
		Gateway.log.debug("----In mOPt option");
		System.out.println("Opt:"+opt);
		ModelAndView mv = new ModelAndView();
		if(opt.equals("ed")){
			mv.setViewName("entry.html");
		}else if (opt.equals("fh")){
			mv.setViewName("fetch.html");
		}else if (opt.equals("del")){
			mv.setViewName("del.html");
		}else if (opt.equals("up")){
			mv.setViewName("update.html");	
		}else {
			System.out.println("This opertation is not supported");
		}
		return mv;	
	}
	
	@RequestMapping("/delUser")
	public ModelAndView delUser(@RequestParam("id") String id) {
		Gateway.log.debug("----In delete User");
		ModelAndView mv = new ModelAndView();
		return null;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam("id") String id,
			@RequestParam("nm") String name,@RequestParam("ead")
	String mail,@RequestParam("pwd") String pwd) {
		Gateway.log.debug("----In update User");
		ModelAndView mv = new ModelAndView();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setEmail(mail);
		user.setPwd(pwd);
		return mv;
	}
	
	@RequestMapping("/detail")
	public ModelAndView enter(@RequestParam("id") String id,
			@RequestParam("nm") String name,@RequestParam("ead")
	String mail,@RequestParam("pwd") String pwd) {
		Gateway.log.debug("----In enter User");
		ModelAndView mv = new ModelAndView();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setEmail(mail);
		user.setPwd(pwd);
		return mv;
	}
	
	@RequestMapping("/fetchUser")
	public ModelAndView fetchUser() {
		Gateway.log.debug("----In fetch User");
		ModelAndView mv = new ModelAndView();
		//List<User> mlist = ;
		return mv;
	}
	
}
