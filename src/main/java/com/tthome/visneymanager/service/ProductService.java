package com.tthome.visneymanager.service;

import com.sun.javafx.collections.MappingChange;
import com.tthome.visneymanager.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/10 11:01
 */
public interface ProductService {
    /**
     * 查询全部商品
     *
     * @return
     */
    public Map selectAll(int page,int rows);

    public int addProduct(Product product);

    public Map updateProduct(Product product);

    public Map deleteProduct(int[] proIds);

    public Map selectAllLikeProduct(String proName,String brandName,String proCategoryName);
}
