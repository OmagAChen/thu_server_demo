package com.tunghai.server_demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamFrontPageController {

    @GetMapping("/indexWebPage")
    public String indexWebPage() {
        return "TeamFrontPage";
    }

    @GetMapping("/aiArtTechInNLPI")
    public String aiArtTechInNLPI() {
        return "aiArtTechInNLPI";
    }

}
