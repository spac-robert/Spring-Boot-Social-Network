package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.robert.socialmediaspringboot.encoder.Encrypt;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.entity.enumeration.UserRole;
import ro.robert.socialmediaspringboot.repository.UserRepository;
import ro.robert.socialmediaspringboot.validator.UserValidator;
import ro.robert.socialmediaspringboot.validator.ValidationException;
import ro.robert.socialmediaspringboot.validator.Validator;

@Controller
public class SignUpController {
    private final UserRepository userRepository;
    private final Validator<User> userValidator;

    @Autowired
    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
        userValidator = new UserValidator();
    }

    @GetMapping("/register")
    public String index(Model model) {
        model.addAttribute("account", new User());
        return "SignUp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, params = "signup")
    public String signUp(@ModelAttribute("account") User user, Model m) {
        System.out.println(user);
        //TODO validate email, password,lastname,firstname
        //TODO find how to display error msg
        try {
            userValidator.validate(user);
        } catch (ValidationException e) {
            e.getStackTrace();
            System.out.println(e);
            m.addAttribute("errorMessage", "Last name can't be blank");
            return "redirect:/register";
        }
        user.setPassword(Encrypt.encrypt(user.getPassword()));
        user.setRole(UserRole.USER);
        userRepository.save(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, params = "login")
    public String back(@ModelAttribute("account") User user, Model model) {
        return "redirect:/login";
    }
}
