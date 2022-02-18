package com.mycom.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.alert.Message;
import com.mycom.entities.Contact;
import com.mycom.entities.User;
import com.mycom.repo.UserRepository;

@Controller
public class HomeController {
	@Autowired
	private BCryptPasswordEncoder PasswordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	           @GetMapping("/home")
	           public String home(Model model) {
		
		          model.addAttribute("title", "Home-SCM");
	                   	return "home";
	          }
	
	           
	           
                @GetMapping("/signup")
             	public String signup(Model model) {
		
	            	        model.addAttribute("title", "SignUp-SCM");
	                          	return "signup";
	          }
	
	
   //registration form
                @RequestMapping(value = "/action" , method = RequestMethod.POST)
     	        public String register(@Valid @ModelAttribute("user")
     	                      User user, BindingResult result, Model model, HttpSession session) {
             
        	 try { 
        		 
        	       if (result.hasErrors())  
      	         {         System.out.println("haserror");
      		              return "signup";
      	                }
      	 
        	 
        	user.setRole("ROLE_USER");
        	user.setEnabled(true);
        	user.setImage("nehal.png");
            user.setPassword(PasswordEncoder.encode(user.getPassword()));    	 
        	 
     		User result1=this.repository.save(user);
     		model.addAttribute("user",new User());
     		 
     		System.out.println(result1);
     		 session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
 			
     		 return "signup";
     		
			 } catch (Exception e) {
				e.printStackTrace();
                model.addAttribute("user", user);
                session.setAttribute("message", new Message("Something went Wrong"+e.getMessage(), "alert-error"));
			
			}return "signup";
     	}
     	
          
                
                 @GetMapping("/signin")
	              public String login() {
        	 
                  return "login";        	 
            }
         

               
}
