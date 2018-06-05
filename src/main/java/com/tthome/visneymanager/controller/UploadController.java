package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.ProImg;
import com.tthome.visneymanager.service.ProImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author zcy
 * @date 2018-06-05 11:18
 */
@RestController
@RequestMapping
public class UploadController {
    @Autowired
    private ProImgService proImgService;
    @PostMapping("/")
    public Map  addUpload(Map map, ProImg proImg, MultipartFile uploadFile, HttpServletRequest request) throws IOException {

        //获取上传文件的名字
        String fileName = uploadFile.getOriginalFilename();

        //得到新的文件名，（名字与UUID联用，防止文件名重名（覆盖））-----------方法二
        fileName=UUID.randomUUID().toString().replace("-", "")+"_"+fileName;

        //直接把文件上传到服务器
        String pathname = "D:\\picture";

        File tomcatPath = new File(pathname+"\\image");

        //创建文件的目录
        if(!tomcatPath.exists()){
            tomcatPath.mkdirs();
        }
        if(!uploadFile.isEmpty()){
            uploadFile.transferTo(new File(pathname+"\\image\\"+fileName));
        }

        return proImgService.addProImg(proImg);
    }
}
