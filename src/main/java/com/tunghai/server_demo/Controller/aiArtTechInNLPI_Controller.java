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
    public String Show_No2_ArtWorks(@RequestParam(value="page", required = false) Integer page, Model model) {
        if(page == null){
            page = 1;
        }
        String createDate = pageToDate(page);
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        model.addAttribute("createDate", createDate);
        return "Show_No2_ArtWorks";
    }

    @RequestMapping("/Show_No.3_ArtWorks")
    public String Show_No3_ArtWorks(@RequestParam(value="page", required = false) Integer page, Model model) {

        if(page == null){
            page = 1;
        }
        String createDate = pageToDate(page);
        Iterable<ArtWorkModel> artWorkList = artWorkService.getArtWorkModels();
        model.addAttribute("artWorkList", artWorkList);
        model.addAttribute("createDate", createDate);
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

    private String pageToDate(Integer page){
        String createDate =  "createDate";
        switch(page) {
            case 1:
                createDate = "2021-11-17";
                break;
            case 2:
                createDate = "2021-11-18";
                break;
            case 3:
                createDate = "2021-11-19";
                break;
            case 4:
                createDate = "2021-11-20";
                break;
            case 5:
                createDate = "2021-11-21";
                break;
            case 6:
                createDate = "2021-11-23";
                break;
            case 7:
                createDate = "2021-11-24";
                break;
            case 8:
                createDate = "2021-11-25";
                break;
            default:
                System.out.println("Page to Date ERROR");
        }
        return createDate;
    }
}
