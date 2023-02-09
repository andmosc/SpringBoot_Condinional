package ru.andmosc.conditionalapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.andmosc.conditionalapp.profiles.SystemProfile;

@RestController
@RequestMapping()
public class ProfileController {
    private final SystemProfile profile;

    public ProfileController(SystemProfile systemProfile) {
        this.profile = systemProfile;
    }

    @GetMapping("/profile")
    public String getProfile() {
        return profile.getProfile();
    }


}
