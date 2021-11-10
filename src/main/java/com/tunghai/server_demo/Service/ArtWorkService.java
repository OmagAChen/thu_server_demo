package com.tunghai.server_demo.Service;

import com.tunghai.server_demo.Dao.ArtWorkDao;
import com.tunghai.server_demo.Model.ArtWorkModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class ArtWorkService {
    @Autowired    //注入依賴
    ArtWorkDao artWorkDao;//取得物件


    public Iterable<ArtWorkModel> getArtWorkModels(){
        return artWorkDao.findAll();
    }

    public Iterable<ArtWorkModel> createArtWorkModel(MultipartFile file, ArtWorkModel artWorkModel) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        String date = df.format(new Date());
        if(file.isEmpty()){
            System.out.println(date +  "  USER EVENT --- upload_file_fail :  The file is empty ");
        }else {
            artWorkModel.setCreateDate(date);
            uploadArtWorkAndSave( file, artWorkModel);
            artWorkModel.setFilePath(getFilePath(artWorkModel.getAuthor()+"_"+artWorkModel.getCreateDate()+"_"+file.getOriginalFilename()));
            artWorkDao.save(artWorkModel);
        }
        return getArtWorkModels();

    }

    public ArtWorkModel getArtWorkModelByFilePath(String filePath){
        return artWorkDao.findALLByFilePath(filePath);
    }

    private String getFilePath(String fileName){
        return "/serverUploadTestLocation/" + fileName;
    }

    private void uploadArtWorkAndSave(MultipartFile file, ArtWorkModel artWorkModel) {

        //上傳檔案的位置
        String uploadFilePath = "D:/Server/serverUploadTestLocation/";
        //備份資料夾位置
        String backUpFilePath = "D:/backUpFile/";

        try{
            byte[] bytes = file.getBytes();

            //上傳用檔案
            Files.write(
                    createArtWorkName(
                            uploadFilePath,
                            artWorkModel.getAuthor(),
                            artWorkModel.getCreateDate(),
                            file.getOriginalFilename()),
                    bytes);
            System.out.println( artWorkModel.getCreateDate() +  "  USER EVENT --- upload_file_success : " + uploadFilePath + file.getOriginalFilename());
            //備份用
            Files.write(
                    createArtWorkName(
                            backUpFilePath,
                            artWorkModel.getAuthor(),
                            artWorkModel.getCreateDate(),
                            file.getOriginalFilename()),
                    bytes);
            System.out.println( artWorkModel.getCreateDate() +  "  USER EVENT --- backUp_file_success : " + backUpFilePath + file.getOriginalFilename());
        } catch (IOException e) {
            System.out.println( artWorkModel.getCreateDate() +  "  USER EVENT --- upload_file_fail :  Try catch run out ");
            e.printStackTrace();
        }
    }

    private Path createArtWorkName(String path, String author, String createDate, String fileName){
        String newName = author + "_" + createDate + "_";
        File file =new File(path);
        //如果資料夾不存在則建立
        if(!file.exists() && !file.isDirectory()){
            System.out.println(path + "//不存在");
            file.mkdirs();
        } else {
            System.out.println(path + "//目錄存在");
        }

        return Paths.get(path + newName + fileName);
    }

}
