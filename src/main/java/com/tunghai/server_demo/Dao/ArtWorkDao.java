package com.tunghai.server_demo.Dao;

import com.tunghai.server_demo.Model.ArtWorkModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtWorkDao extends CrudRepository<ArtWorkModel, Integer>{
    ArtWorkModel findALLByFilePath(String filePath);
}
