package com.tthome.visneymanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.tthome.visneymanager.dao.*;
import com.tthome.visneymanager.entity.*;
import com.tthome.visneymanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/10 11:02
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProImgDao proImgDao;
    @Autowired
    private SizeDao sizeDao;
    @Autowired
    private ModleCodeDao modleCodeDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private PageViewsDao pageViewsDao;
    @Override
    public Map selectAll(int page,int rows,String proName, String brandName, String proStyleName, String proTypeName, String proSeriesName, String proTextureName, String proPositionName) {
        Map map = new HashMap();
        int total = productDao.getTotal(proName,brandName,proStyleName,proTypeName,proSeriesName,proTextureName,proPositionName);
        PageHelper.startPage(page, rows);
        List<Product> products = productDao.selectAll(proName,brandName,proStyleName,proTypeName,proSeriesName,proTextureName,proPositionName);
        map.put("total", total);
        map.put("rows", products);
        return map;
    }

    @Override
    public int addProduct(Product product) {
       /* 风格 类型 系列 材质
          品牌 型号 尺寸 图片
          浏览量*/
//添加浏览量Id
        PageViews pageViews=new PageViews();
        int pageViewsAdd = pageViewsDao.pageViewsAdd(pageViews);
        product.setPageViews(pageViews);
/*
//先添加尺寸Size 在获取ID
        Size size=new Size();
        int addsize=sizeDao.addSize(size);
        int sizeId=size.getSizeId();
//先添加型号 在获取ID
        ModleCode modleCode=new ModleCode();
        int addModleCode = modleCodeDao.addModleCode(modleCode);
        int modleCodeId=modleCode.getModelCodeId();
//添加品牌
        Brand brand=new Brand();
        int addBrand=brandDao.addBrand(brand);

        product.setPageViews(pageViews);
        product.setSize(size);
        product.setModleCode(modleCode);
        product.setBrand(brand);
*/
//先添加产品Id


        int addProduct = productDao.addProduct(product);
        Integer proId=product.getProId();

        // 根据产品ID 添加图片
        List<ProImg> proImgs = product.getProImgs();
        ProImg proImg=null;
        int addProImg=0;
        int count=0;
        for(int i=0;i<proImgs.size();i++){
           proImg=proImgs.get(i);
           proImg.setProId(proId);
           addProImg = proImgDao.addProImg(proImg);
           if(addProImg==1){
                 count++;
           }
        }
        if(count==proImgs.size()&&addProduct==1&&pageViewsAdd==1){
            return 1;
        }else{
           return 0;
        }

    }
    @Override
    public Map  deleteProduct(int[] proIds, int[] pageViewsIds) {
        Map map = new HashMap();
        //先删除图片 和浏览量  再删除其他的
        int i = proImgDao.deleteProImgbyProId(proIds);
        int i1 = pageViewsDao.pageViewsDelete(pageViewsIds);
        int i2 = productDao.deleteProduct(proIds);
        if(i!=0&&i1!=0&&i2!=0){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }

    @Override
    public Map updateProduct(Product product) {
        Map map = new HashMap();
        int i = productDao.updateProduct(product);
        if(i==1){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }




    @Override
   public Product selectProductById(int proId) {
        return productDao.selectProductById(proId);
    }
}


