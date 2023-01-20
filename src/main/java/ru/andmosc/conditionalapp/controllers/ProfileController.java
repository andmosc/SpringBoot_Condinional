package ru.andmosc.conditionalapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.andmosc.conditionalapp.profiles.SystemProfile;
@Controller
@RequestMapping("/")
public class ProfileController {
    private final SystemProfile profile;

    public ProfileController(SystemProfile systemProfile) {
        this.profile = systemProfile;
    }
@GetMapping("profile")
    public String getProfile(Model model) {
        model.addAttribute("profile",profile.getProfile());
        return "profile";
    }
}
