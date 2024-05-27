package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.UserForm;

import services.UserService;

@Controller
public class PageController {
  
 @Autowired
  private UserService userService;
  // local
  @RequestMapping("/home")
  public String home(Model model) {
    model.addAttribute("name", "Substring Technologies");
    model.addAttribute("youtubeChannel", "Learn Code With Durgesh");
    model.addAttribute("githubRepo", "https://github.com/learncodewithdurgesh/");
    System.out.println("Home Page");
    return "home";
  }

  @RequestMapping("/about")
  public String about() {
    System.out.println("About page");
    return "about";
  }

  @RequestMapping("/services")
  public String service() {
    System.out.println("Service page");
    return "service";
  }

  @RequestMapping("/contact")
  public String contact() {
    System.out.println("welcome Contact page");
    return "contact";
  }

  @RequestMapping("/login")
  public String login() {
    System.out.println("welcome Login page");
    return "login";
  }

  @RequestMapping("/register")
  public String SignUp(Model model) {
    System.out.println("welcome Login page");
    UserForm userForm = new UserForm();
    model.addAttribute("userForm", userForm);
    return "register";
  }

  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String processRegister(@ModelAttribute UserForm userForm) {
    System.out.println(userForm);

    return "redirect:/register";
  }
}
