package com.example.Cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.pojo.Person;
import com.example.repo.mRepo;

@RestController
@RequestMapping("/insertService")
//@DependsOn("mRepo")
public class InsertCont {
	
	@Autowired
	public mRepo repo;
	
	@RequestMapping("/hi")
	public void  hi() {
		System.out.println("Hello");
	}
	
	@RequestMapping("/addPerson")
	public String enter(
			@RequestParam("id") Integer id,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("pwd") String pwd)
	{
		System.out.println("email  :"+email);
		/*repo.save(p);
		return "Person inserted" ;*/
		return "Abc";
	}
	
	//@RequestMapping("/enter/")
	public ModelAndView enter() {
		System.out.println("Insert service  method");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("entry.html");
		return mv;
	}
}