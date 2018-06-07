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

    @Override
    public Map selectAll(int page,int rows,String proName, String brandName, String proStyleName,String proTypeName,
                         String proSeriesName,String proTextureName,String proPositionName) {
        Map map = new HashMap();
        int total = productDao.getTotal();
        PageHelper.startPage(page, rows);
        List<Product> products = productDao.selectAll(proName,brandName,proStyleName,proTypeName,proSeriesName,proTextureName,proPositionName);
        map.put("total", total);
        map.put("rows", products);
        return map;
    }

    @Override
    public int addProduct(Product product) {
       /* 风格 类型 系列 材质
          品牌 型号 尺寸 图片*/
        //添加品牌id
//先添加尺寸Size 在获取ID
        Size size=new Size();
        int addsize=sizeDao.addSize(size);
        int sizeId=size.getSizeId();
//先添加型号 在获取ID
        ModleCode modleCode=new ModleCode();
        int addModleCode = modleCodeDao.addModleCode(modleCode);
        int modleCodeId=modleCode.getModelCodeId();

        product.setSize(size);
        product.setModleCode(modleCode);

//先添加产品Id
        int addProduct = productDao.addProduct(product);
        Integer proId=product.getProId();

        // 根据产品ID 添加图片
        ProImg proImg=new ProImg();
        proImg.setProId(proId);
        int addProImg = proImgDao.addProImg(proImg);
        if(addsize==1&&addModleCode==1&&addProImg==1&&addProduct==1){
            return 1;
        }else{
           return 0;
        }

    }

    @Override
    public Map updateProduct(Product product) {
        return null;
    }

    @Override
    public Map deleteProduct(int[] proIds) {
        return null;
    }

}


