package com.example.mCont;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Gateway;
import com.example.mService.service;
import com.example.pojo.Person;
import com.example.repo.mRepo;

@RestController
@RequestMapping("/app")
public class PersonController {
	
	@Autowired
	public Person person;
	@Autowired
	public service mservice;
	@Autowired
	public  mRepo repo;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Function hit");
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
			/*System.out.println("Going to call edit Service");
			mservice.insertperson();*/
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
	
	@RequestMapping("/delPerson")
	public ModelAndView delperson(@RequestParam("id") String id) {
		Gateway.log.debug("----In Api delete person");
		ModelAndView mv = new ModelAndView();
		String res = mservice.delPerson(Integer.parseInt(id));
		mv.addObject("msg",res);
		System.out.println("Delete res:"+res);
		mv.setViewName("result.html");
		return mv;
	}
	
	@RequestMapping("existingperson")
	public ModelAndView getperson(@PathVariable("id") Integer id) {
		ModelAndView mv= new ModelAndView();
		String u = mservice.fetchPerson(id);
		System.out.println("person--"+u);
		mv.addObject("person",u);
		mv.setViewName("updateperson");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam("personId") String id,
			@RequestParam("nm") String name,
			@RequestParam("e-add") String mail,
			@RequestParam("pwd") String pwd) {
		Gateway.log.debug("----In update person");
		ModelAndView mv = new ModelAndView();
		person.setId(Integer.parseInt(id));
		person.setName(name);
		person.setEmail(mail);
		person.setPwd(pwd);
		String res = mservice.updatePerson(person);
		System.out.println("Update result:"+res);
		mv.addObject("msg",res);
		mv.setViewName("result.html");
		return mv;
	}
	
	@RequestMapping("/insert")
	public ModelAndView enter(@RequestParam("id") String id,
			@RequestParam("nm") String name,
			@RequestParam("e-add")String mail,
			@RequestParam("pwd") String pwd) {
		Gateway.log.debug("----In Inter service");
		ModelAndView mv = new ModelAndView();
		person.setId(Integer.parseInt(id));
		person.setName(name);
		person.setEmail(mail);
		person.setPwd(pwd);
		System.out.println("Call the Service");
		String res = mservice.insertPerson(person);
		System.out.println("Insert result"+res);
		/*try{
			repo.save(person);
		}catch(Exception e){
			e.printStackTrace();	
		}*/
		mv.addObject("msg","Inserted");
		mv.setViewName("result.html");
		return mv;
	}
	
	/*@RequestMapping("/insertperson")
	public ModelAndView enter(@RequestParam("id") String id,
			@RequestParam("nm") String name,
			@RequestParam("e-add")String mail,
			@RequestParam("pwd") String pwd) {
		Gateway.log.debug("----In Inter service");
		ModelAndView mv = new ModelAndView();
		person.setId(Integer.parseInt(id));
		person.setName(name);
		person.setEmail(mail);
		person.setPwd(pwd);
		System.out.println("Call the Service");
		String res = mservice.insertperson(person);
		mv.addObject("msg",res);
		mv.setViewName("result.html");
		return mv;
	}*/
	
	@RequestMapping("/list")
	public ModelAndView fetchperson(@RequestParam("id") String id) {
		Gateway.log.debug("----In fetch person");
		ModelAndView mv = new ModelAndView();
		String u  = mservice.fetchPerson(Integer.parseInt(id));
		System.out.println("Fetch person:"+u);
		mv.addObject("msg",u);
		mv.setViewName("result.html");
		return mv;
	}
}
