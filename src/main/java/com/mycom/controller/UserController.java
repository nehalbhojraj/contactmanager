package com.mycom.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.alert.Message;
import com.mycom.entities.Contact;
import com.mycom.entities.User;
import com.mycom.repo.ContactRepo;
import com.mycom.repo.UserRepository;

@Controller
@RequestMapping(value ="/myuser")
public class UserController {
   
	@Autowired
  private UserRepository repository;
  
	@Autowired
 	private ContactRepo   contactRepo;  
	  

	
	 @RequestMapping(value = "/index")
	 public String dashbord(Model model,Principal principal) 
	 {

		 String username=principal.getName();
		 System.out.println(username);
		 
		  return "Inside/dashboard";
	}

	 @RequestMapping(value = "/contact")
	 public String contactform(Model model) {
		
		 model.addAttribute("tittl", "contact add");
         model.addAttribute("contact", new Contact());
     return "Inside/contactform";
	}


	 @PostMapping(value = "/visitor")
	 public String profile(@ModelAttribute Contact contact,
			               Principal principal ,HttpSession session) {
		
		 String name=principal.getName(); 
		 User user=repository.getUserByUserName(name); 
		
		 contact.setUser(user);
		 user.getContacts().add(contact);

		 contact.setImage("default.jpg");
		
	     this.repository.save(user);
		 session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
			
         System.out.println(contact);  
		 
	return "Inside/contactform";
	}
	 
	 
	 @GetMapping(value = "/showcontact")
	 public String showcontact(Model model, Principal principal) {
         
		  String userName=principal.getName();
   		 User user=this.repository.getUserByUserName(userName);
		  
         List<Contact> contacts	=this.contactRepo.findContactsByUser(user.getId());
		 
         model.addAttribute("contacts", contacts);
		return "Inside/showcontact";
	}
	 
	 
	 @RequestMapping(value = "/profile{cId}")
	 public String profile(@PathVariable("cId") Integer cId,  Model model) {
	   
		       Optional<Contact> optionalcontact=this.contactRepo.findById(cId); 
	                          Contact contact=optionalcontact.get();
		       model.addAttribute("contact", contact);
		 return "Inside/profile";
	}

	 @PutMapping(value = "/edit")
	 public String editcontact(Model model) {
		 
		
		 return "Inside/profile";
	}

	 @DeleteMapping(value = "/delete{cId}")
	 public String deletecontact(@PathVariable("cId") Integer cId, Model model) {
		 this.contactRepo.deleteById(cId);
		
		 return "Inside/showcontact";
	}

	 	 


}

