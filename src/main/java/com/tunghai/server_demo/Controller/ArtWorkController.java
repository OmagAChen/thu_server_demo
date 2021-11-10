package com.tunghai.server_demo.Controller;

import com.tunghai.server_demo.Model.ArtWorkModel;
import com.tunghai.server_demo.Service.ArtWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ArtWorkController {
    @Autowired    //注入Service的依賴
    ArtWorkService artWorkService;

    @RequestMapping("/AI_Art_Tech_MainPage")
    public String aI_Art_Tech_MainPage() {
        return "AI_Art_Tech_MainPage";
    }

    @RequestMapping("/Show_No.2_ArtWorks")
    public String Show_No2_ArtWorks(Model model) {
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        return "Show_No2_ArtWorks";
    }

    @GetMapping("/showArtWork")
    public String showArtWork(@RequestParam(value="filePath") String filePath, Model model) {
        ArtWorkModel artWorkModel = artWorkService.getArtWorkModelByFilePath(filePath);
        model.addAttribute("artWorkModel", artWorkModel);
        return "showArtWork";
    }

    @GetMapping("/showArtWorkNoShare")
    public String showArtWorkNoShare(@RequestParam(value="filePath") String filePath, Model model) {
        ArtWorkModel artWorkModel = artWorkService.getArtWorkModelByFilePath(filePath);
        model.addAttribute("artWorkModel", artWorkModel);
        return "showArtWorkNoShare";
    }

    @GetMapping("/showArtWorkAndShare")
    public String showArtWorkAndShare(@RequestParam(value="filePath") String filePath, Model model) {
        ArtWorkModel artWorkModel = artWorkService.getArtWorkModelByFilePath(filePath);
        model.addAttribute("artWorkModel", artWorkModel);
        return "showArtWorkAndShare";
    }

    @GetMapping("/showArtWorks")
    public String showArtWorks(Model model) {
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        return "showArtWorks";
    }

    @GetMapping("/editArtWork")
    public String getArtWorkList(Model model) {
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        ArtWorkModel emptyArtWorkModel = new ArtWorkModel();
        model.addAttribute("artWorkObject", emptyArtWorkModel);
        return "editArtWork";
    }
    @PostMapping("/editArtWork")
    public String createArtWork(@RequestParam("file") MultipartFile file, @ModelAttribute ArtWorkModel artWorkModel, Model model) {
        Iterable<ArtWorkModel> allArtWorkList = artWorkService.createArtWorkModel(file,artWorkModel);
        //回傳更新過後的作品列表
        model.addAttribute("artWorkList", allArtWorkList);
        ArtWorkModel emptyArtWorkModel = new ArtWorkModel();
        model.addAttribute("artWorkObject", emptyArtWorkModel);
        return "redirect:/editArtWork";
    }

}
