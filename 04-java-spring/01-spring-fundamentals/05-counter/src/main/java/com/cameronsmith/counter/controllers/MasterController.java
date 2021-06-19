package com.cameronsmith.counter.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MasterController {
	private Integer currentCount;
	
	public Integer getCount(HttpSession session){
        if(session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
         return currentCount = (Integer) session.getAttribute("count");
    }
	
	public void setCount(HttpSession session, Integer currentCount) {
		session.setAttribute("count", currentCount);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpSession session) {
		Integer count = getCount(session);
		count +=1;
		setCount(session, count);
		return "index.jsp";
	}
	
	@RequestMapping(value="/counter", method=RequestMethod.GET)
	public String count(HttpSession session, Model viewModel){
		currentCount= (Integer) session.getAttribute("count");
        viewModel.addAttribute("count", currentCount);
        return "counter.jsp";
    }
	@RequestMapping(value="/reset", method=RequestMethod.GET)
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/counter";
	}
	@RequestMapping(value="/twice", method=RequestMethod.GET)
	public String index2(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count +=2;
		setCount(session, count);
		return "index.jsp";
	}
}
