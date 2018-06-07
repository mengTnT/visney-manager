package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.Article;
import com.tthome.visneymanager.entity.ArticleImg;
import com.tthome.visneymanager.entity.ProImg;
import com.tthome.visneymanager.entity.Product;
import com.tthome.visneymanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/10 11:05
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    //从yml配置中取出对应的图片上传路径
    @Value("${web.upload-path}")
    private String uploadPath;

    @Autowired
    private ProductService productService;

    @RequestMapping("/getAll")
    public Map getAll(int page,int rows) {
        return productService.selectAll(page, rows);
    }

    public int addProduct(Product product){ return productService.addProduct(product);}



    @PostMapping("/productImgAdd")
    public int productImgAdd(Product product, HttpServletRequest req, @RequestParam("files") MultipartFile[] files){
        String proImgSrc=null;
        List<ProImg> proImgList=new ArrayList<>();
        if (files.length == 0) {
            return 0;
        }
        try {
            for (MultipartFile file : files) {
                //获取原文件名,和毫秒数进行拼接
                String fileName = System.currentTimeMillis() + file.getOriginalFilename();
                //图片将要存储到本地的地址
                String destFileName = uploadPath + "/product" + File.separator + fileName;
                //创建一个file对象
                File destFile = new File(destFileName);
                if (!destFile.exists()){
                    //文件夹不存在，就创建文件夹
                    destFile.getParentFile().mkdirs();
                }
                //写入文件
                file.transferTo(destFile);
                //
                proImgSrc="192.168.100.250/visney"+"product" + File.separator + fileName;
                //得到每个ProImg对象的图片地址 把对象放入list集合
                ProImg proImg=new ProImg();
                proImg.setProImgSrc(proImgSrc);
                proImgList.add(proImg);
                System.out.println(fileName);
                System.out.println(destFileName);
                System.out.println(proImg);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        product.setProImgs(proImgList);
        int result =productService.addProduct(product);
        return result;

    }
}
