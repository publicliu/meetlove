package net.lw.meetlove.web.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody  ModelMap logout(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session != null){
		    session.invalidate();
		}
		ModelMap map = new ModelMap();
		map.addAttribute("success", true);
		return map;
	}

}
