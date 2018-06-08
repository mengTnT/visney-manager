package com.tthome.visneymanager.controller;


import com.tthome.visneymanager.entity.Article;
import com.tthome.visneymanager.entity.ArticleImg;
import com.tthome.visneymanager.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

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
                //获取原文件名,和毫秒数进行拼接
                String fileName = System.currentTimeMillis() + file.getOriginalFilename();
                //图片将要存储到本地的地址
                String destFileName = uploadPath + "/article" + File.separator + fileName;
                //创建一个file对象
                File destFile = new File(destFileName);
                if (!destFile.exists()) {
                    //创建文件夹
                    destFile.getParentFile().mkdirs();
                }
                //写入文件
                file.transferTo(destFile);
                System.out.println(fileName);
                System.out.println(destFileName);
                System.out.println("article" + File.separator + fileName);

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
                //获取原文件名,和毫秒数进行拼接
                String fileName = System.currentTimeMillis() + file.getOriginalFilename();
                //图片将要存储到本地的地址
                String destFileName = uploadPath + "/article" + File.separator + fileName;
                //创建一个file对象
                File destFile = new File(destFileName);
                if (!destFile.exists()) {
                    //文件夹不存在，就创建文件夹
                    destFile.getParentFile().mkdirs();
                }
                //写入文件
                file.transferTo(destFile);
                articleImgSrc = "http://192.168.100.250/visney/article" + File.separator + fileName;

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
                    //获取原文件名,和毫秒数进行拼接
                    String fileName = System.currentTimeMillis() + file.getOriginalFilename();
                    //图片将要存储到本地的地址
                    String destFileName = uploadPath + "/article" + File.separator + fileName;
                    //创建一个file对象
                    File destFile = new File(destFileName);
                    if (!destFile.exists()) {
                        //文件夹不存在，就创建文件夹
                        destFile.getParentFile().mkdirs();
                    }
                    //写入文件
                    file.transferTo(destFile);
                    articleImgSrc =  "http://192.168.100.250/visney/article" + File.separator + fileName;
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
