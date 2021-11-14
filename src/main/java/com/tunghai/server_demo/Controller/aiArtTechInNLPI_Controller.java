package com.tunghai.server_demo.Controller;

import com.tunghai.server_demo.Model.ArtWorkModel;
import com.tunghai.server_demo.Service.ArtWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class aiArtTechInNLPI_Controller {
    @Autowired    //注入Service的依賴
    ArtWorkService artWorkService;

    @RequestMapping("/AI_Art_Tech_MainPage")
    public String aI_Art_Tech_MainPage() {
        return "AI_Art_Tech_MainPage";
    }

    @RequestMapping("/Show_No.1_ArtWorks")
    public String Show_No1_ArtWorks(Model model) {
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        return "Show_No1_ArtWorks";
    }

    @RequestMapping("/Show_No.2_ArtWorks")
    public String Show_No2_ArtWorks(Model model) {
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        return "Show_No2_ArtWorks";
    }

    @RequestMapping("/Show_No.3_ArtWorks")
    public String Show_No3_ArtWorks(Model model) {
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        return "Show_No3_ArtWorks";
    }

    @RequestMapping("/Show_No.4_ArtWorks")
    public String Show_No4_ArtWorks(Model model) {
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        return "Show_No4_ArtWorks";
    }

    @RequestMapping("/Show_No.5_ArtWorks")
    public String Show_No5_ArtWorks(Model model) {
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        return "Show_No5_ArtWorks";
    }

    @RequestMapping("/Show_No.6_ArtWorks")
    public String Show_No6_ArtWorks(Model model) {
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        return "Show_No6_ArtWorks";
    }
}
