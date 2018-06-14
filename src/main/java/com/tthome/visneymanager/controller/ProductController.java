package com.tthome.visneymanager.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.tthome.visneymanager.entity.*;
import com.tthome.visneymanager.service.ProductService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public Map getAll(int page,int rows,String proName, String brandName, String proStyleName,String proTypeName,
                      String proSeriesName,String proTextureName,String proPositionName) {
        return productService.selectAll(page, rows,proName,brandName,proStyleName,proTypeName,proSeriesName,proTextureName,proPositionName);
    }



    @GetMapping("/selectProductById/{proId}")
    public Product selectProductById(@PathVariable("proId") int proId){
        return productService.selectProductById(proId);
    }
  @PostMapping("/addProduct")
    public int addProduct(String alt,Product product, HttpServletRequest req, @RequestParam("files") MultipartFile[] files){
            String proImgSrc=null;
            List<ProImg> proImgList=new ArrayList<>();
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
                    String url="http://192.168.100.250:8099/img/product_img/"+fileName;
                    //上传客户端对象
                    Client client=new Client();
                    WebResource resource = client.resource(url);
                    //文件上传到指定地址
                    resource.put(String.class,file.getBytes());
                    proImgSrc = url;
                    ProImg proImg=new ProImg();
                    proImg.setProImgSrc(proImgSrc);
                    proImg.setProImgAlt(alt);
                    proImgList.add(proImg);


                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return 0;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
            //第一张图是封面图
                   ProImg proImg=proImgList.get(0);
                   proImg.setProImgCover(1);
                   proImgList.set(0,proImg);
                   product.setProImgs(proImgList);
            int result =productService.addProduct(product);
            return result;

    }
    @PostMapping("/deleteProduct")
    public Map deleteProduct(int[] proIds,int[] pageViewsIds){
        return productService.deleteProduct(proIds,pageViewsIds);
    }
    @PostMapping("/updateProduct")
    public Map updateProduct(Product product){
        return productService.updateProduct(product);
    }

}
