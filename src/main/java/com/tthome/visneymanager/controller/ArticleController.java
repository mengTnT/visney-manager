package com.tthome.visneymanager.controller;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.tthome.visneymanager.entity.Article;
import com.tthome.visneymanager.entity.ArticleImg;
import com.tthome.visneymanager.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author NBUG
 * @date 2018/5/14 9:26
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    //从yml配置中取出对应的图片上传路径
    @Value("${web.upload-path}")
    private String uploadPath;


    @GetMapping("/getArticleDetails/{articleId}")
    public Article getArticleDetails(@PathVariable("articleId") int articleId) {

        return articleService.getArticleDetails(articleId);
    }

    @RequestMapping("/getArticlesByCategory")
    public Map getArticles(int articleCategoryId, int page, int rows) {

        return articleService.getArticles(articleCategoryId, page, rows);
    }

    @RequestMapping("/getArticles")
    public Map getArticles(int page, int rows, String category, String editor, String title) {
        return articleService.getArticles(page, rows, category, editor, title);
    }

    @RequestMapping("/articleDelete")
    public int articleDelete(int[] articleIds, int[] pageViewsIds, int[] articleImgIds) {
        return articleService.articleDelete(articleIds, pageViewsIds, articleImgIds);

    }


    @PostMapping("/articleCover_img_upload")
    public String upload2(HttpServletRequest req, @RequestParam("files") MultipartFile[] files) {
        if (files.length == 0) {
            return "error";
        }
        try {
            for (MultipartFile file : files) {
                String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) +
                        UUID.randomUUID().toString().replace("-", "") +
                        "." + FilenameUtils.getExtension(file.getOriginalFilename());
                String url="http://192.168.100.250:8099/img/article_img/"+fileName;
                System.out.println(url);
                Client client=new Client();
                WebResource resource = client.resource(url);
                resource.put(String.class,file.getBytes());

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "ok";
    }

    @PostMapping("/articleAdd")
    public int articleAdd(String label1, String label2, Article article, HttpServletRequest req, @RequestParam("files") MultipartFile[] files) {
        String articleImgSrc = null;
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
                String url="http://192.168.100.250:8099/img/article_img/"+fileName;
                //上传客户端对象
                Client client=new Client();
                WebResource resource = client.resource(url);
                //文件上传到指定地址
                resource.put(String.class,file.getBytes());
                articleImgSrc = url;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        ArticleImg articleImg = article.getArticleImg();
        articleImg.setArticleImgSrc(articleImgSrc);
        int result = articleService.articleAdd(label1, label2, article);
        return result;

    }

    @PostMapping("/articleUpdate")
    public int articleUpdate(int labelID1, int labelID2,String label1, String label2, Article article, HttpServletRequest req, @RequestParam("files") MultipartFile[] files) {
        String articleImgSrc = null;
        //用户没有修改图片
        if (files.length == 0) {
            int result = articleService.articleUpdate(labelID1, labelID2,label1,label2, article);
            return result;
        }
        //修改了图片
        else {
            try {
                for (MultipartFile file : files) {
                    String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) +
                            UUID.randomUUID().toString().replace("-", "") +
                            "." + FilenameUtils.getExtension(file.getOriginalFilename());
                    String url="http://192.168.100.250:8099/img/article_img/"+fileName;
                    Client client=new Client();
                    WebResource resource = client.resource(url);
                    resource.put(String.class,file.getBytes());
                    articleImgSrc = url;
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return 0;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
            ArticleImg articleImg = article.getArticleImg();
            articleImg.setArticleImgSrc(articleImgSrc);
            int result = articleService.articleUpdate(labelID1, labelID2,label1,label2, article);
            return result;
        }
    }
}
