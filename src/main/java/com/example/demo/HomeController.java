package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	    @RequestMapping("/")
	    public String home() {
	        return "Home";
	    }
	    
	    @RequestMapping("creation")
	    public String creation() {
	        return "creation";
	    }
	    
	    @RequestMapping("mentions")
	    public String mentions() {
	        return "mentions";
	    }
	    

}
