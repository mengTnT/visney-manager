package com.tthome.visneymanager.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.tthome.visneymanager.entity.Banner;
import com.tthome.visneymanager.service.BannerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author NBUG
 * @date 2018/6/8 15:53
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/selectAllByTpye/{bannerTypeId}")
    public List<Banner> selectAllByTpye(@PathVariable("bannerTypeId") int bannerTypeId) {

        return bannerService.selectAllByTpye(bannerTypeId);
    }
    @PostMapping("/getAll")
    public List<Banner> getAll() {
        return bannerService.getAll();
    }
    @PostMapping("/delete")
    public int delete(int[] ids) {
        return bannerService.delete(ids);
    }
    @PostMapping("/update")
    public int update(int bannerId) {
        return bannerService.update(bannerId);
    }
    @PostMapping("/add")
    public int add(Banner banner,@RequestParam("files") MultipartFile[] files) {
        String bannerImgSrc = null;
        if (files.length == 0) {
            return 0;
        }
        try {
            for (MultipartFile file : files) {
                //生成文件名
                String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) +
                        UUID.randomUUID().toString().replace("-", "") +
                        "." + FilenameUtils.getExtension(file.getOriginalFilename());
                //生成上传的地址
                String url="http://192.168.100.250:8099/img/banner_img/"+fileName;
                //上传客户端对象
                Client client=new Client();
                WebResource resource = client.resource(url);
                //文件上传到指定地址
                resource.put(String.class,file.getBytes());
                bannerImgSrc = url;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        banner.setBannerSrc(bannerImgSrc);
        return bannerService.add(banner);
    }

}
