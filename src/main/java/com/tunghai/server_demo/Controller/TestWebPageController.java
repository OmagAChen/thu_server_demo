package com.tunghai.server_demo.Controller;

import com.tunghai.server_demo.Model.ArtWorkModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestWebPageController {
    @GetMapping("/testWebPage")
    public String testWebPage() {
        return "index";
    }
}
