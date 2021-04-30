package com.study.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
 
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Form 데이터 전달받아 사용하기";
	}
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest httpServletRequest,Model model) {
		String id = httpServletRequest.getParameter("id");
		String name = httpServletRequest.getParameter("name");
		
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2(@RequestParam("id") String id,
						@RequestParam("name") String name,
						Model model)
	{
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		return "test2";
	}
	
	@RequestMapping("/test3")
	public String test3(Member member, Model model)
	{
		//파라미터와 알치하는 빈을 만들어서 사용할수 있다. 
		//View 페이지에서 model을 사용하지 않고 member를 사용한다
		return "test3";
	}
	
	//패스 자체에 변수를 넣을수도 있다.
	@RequestMapping("/test4/{studentId}/{name}")
	public String getStudnet(@PathVariable String studentId,
							@PathVariable String name,
							Model model)
	{
		model.addAttribute("id",studentId);
		model.addAttribute("name",name);
		return "test4";
}	




}






