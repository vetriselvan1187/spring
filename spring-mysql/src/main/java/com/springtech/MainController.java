package com.springtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/add")
	public @ResponseBody String addNewUser(@RequestParam("name") String name, @RequestParam("email") String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		return "saved";
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
