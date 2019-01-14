package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	
	@RequestMapping("/carEmployee")
	public String showForm() {
		return "carEmployee-form";
	}
	
	
	@RequestMapping("/cars")
	public String carsForm() {
		return "cars-form";
	}
	
	@RequestMapping("/clients")
	public String clientsForm() {
		return "clients-form";
	}
	
	@RequestMapping("/transactions")
	public String transactionsForm() {
		return "transactions-form";
	}
	
	@RequestMapping("/accounts")
	public String accountsForm() {
		return "accounts-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	// new a controller method to read form data and
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		
		// read the request parameter from the HTML form
		String theName=request.getParameter("studentName");
		// convert the data to all caps
		theName=theName.toUpperCase();
		// create the message
		String result="Yo! "+theName;
		// add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	
	// new a controller method to read form data and
		// add data to the model
		@RequestMapping("/processFormVersionThree")
		public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
						
			// convert the data to all caps
			theName=theName.toUpperCase();
			// create the message
			String result="Hey My Friend from v3! "+theName;
			// add message to the model
			model.addAttribute("message",result);
			
			return "helloworld";
		}
	
}
