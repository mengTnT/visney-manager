package com.tthome.visneymanager.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.tthome.visneymanager.entity.ProImg;
import com.tthome.visneymanager.service.ProImgService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author zcy
 * @date 2018-06-04 10:06
 */
@RestController
@RequestMapping("/proImg")
public class ProImgContrller {
    @Autowired
    private ProImgService proImgService;
    @PostMapping("/getAllProImg")
    public Map getAllProImg(int page ,int rows,int proId){

        return proImgService.getAllProImg(page, rows,proId);
    }
    @PostMapping("/addProImg")
    public int addProImg(ProImg proImg,@RequestParam("files") MultipartFile[] files) {
        String proImgSrc = null;
        //用formdata直接格式化form表单，会把空的图片input标签当做有内容，需要以下判断，防止添加错误
        if (files[0].isEmpty()) {
            return 0;
        } else {
            try {
                for (MultipartFile file : files) {
                    //生成文件名
                    String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) +
                            UUID.randomUUID().toString().replace("-", "") +
                            "." + FilenameUtils.getExtension(file.getOriginalFilename());
                    //生成上传的地址
                    String url = "http://192.168.100.250:8099/img/product_img/" + fileName;
                    //上传客户端对象
                    Client client = new Client();
                    WebResource resource = client.resource(url);
                    //文件上传到指定地址
                    resource.put(String.class, file.getBytes());
                    proImgSrc = url;

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return 0;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
            proImg.setProImgSrc(proImgSrc);


            return proImgService.addProImg(proImg);
        }
    }

    @PostMapping("/updateProImg")
    public int updateProImg(ProImg proImg,@RequestParam("files") MultipartFile[] files){
        String proImgSrc = null;
        //用formdata直接格式化form表单，会把空的图片input标签当做有内容，需要以下判断，防止添加错误
        if (files[0].isEmpty()) {
            return proImgService.updateProImg(proImg);
        } else {
            try {
                for (MultipartFile file : files) {
                    //生成文件名
                    String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) +
                            UUID.randomUUID().toString().replace("-", "") +
                            "." + FilenameUtils.getExtension(file.getOriginalFilename());
                    //生成上传的地址
                    String url = "http://192.168.100.250:8099/img/product_img/" + fileName;
                    //上传客户端对象
                    Client client = new Client();
                    WebResource resource = client.resource(url);
                    //文件上传到指定地址
                    resource.put(String.class, file.getBytes());
                    proImgSrc = url;

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return 0;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
            proImg.setProImgSrc(proImgSrc);


            return proImgService.updateProImg(proImg);
        }

    }
    @PostMapping("/deleteProImg")
    public int deleteProImg(int [] ids){
        return  proImgService.deleteProImg(ids);
    }
    @PostMapping("/deleteProImgbyProIds")
    public int  deleteProImgbyProId(int[] proIds){
        return proImgService.deleteProImgbyProId(proIds);
    }
}
