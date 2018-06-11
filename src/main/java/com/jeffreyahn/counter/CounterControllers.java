package com.jeffreyahn.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterControllers {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			int count = (int) session.getAttribute("count");
			session.setAttribute("count", count+=1);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		if(session.getAttribute("count") == null) {
			model.addAttribute("count", 0);
			return "counter.jsp";
		} else {
			int count = (int) session.getAttribute("count");
			model.addAttribute("count", count);
			return "counter.jsp";
		}
	}
	@RequestMapping("/reset")
	public String reset(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:/counter";
	}
}
