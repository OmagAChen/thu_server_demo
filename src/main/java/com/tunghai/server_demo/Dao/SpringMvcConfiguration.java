package com.tunghai.server_demo.Dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * @Description: 對檔案的路徑進行配置,建立一個虛擬路徑/Path/** ，即只要在<img src="/Path/picName.jpg" />便可以直接引用圖片
         *這是圖片的物理路徑 "file:/+本地圖片的地址"
         * @Date： Create in 14:08 2017/12/20
         */
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image/");
        registry.addResourceHandler("/serverUploadTestLocation/**").addResourceLocations("file:/D:/Server/serverUploadTestLocation/");
        super.addResourceHandlers(registry);
    }
}


