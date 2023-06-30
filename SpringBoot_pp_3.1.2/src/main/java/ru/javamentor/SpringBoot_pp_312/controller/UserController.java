package ru.javamentor.SpringBoot_pp_312.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.SpringBoot_pp_312.model.User;
import ru.javamentor.SpringBoot_pp_312.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
	private UserService userService;

//	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping({""})
	public String getAllUser(Model users) {
		users.addAttribute("users", userService.getAllUser());
		return "all";
	}

	@GetMapping("/saveget")
	public String saveUserGet(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping("/savepost")
	public String saveUserPost(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}

	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return "redirect:/users";
	}

	@GetMapping("/usereditorget/{id}")
	public String userEditorGet(Model user, @PathVariable("id") Long id) {
		user.addAttribute("user", userService.getUserById(id));
		return "edit";
	}

	@PatchMapping("/{id}")
	public String userEditorPatch(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
		userService.userEditor(user, id);
		return "redirect:/users";
	}
}