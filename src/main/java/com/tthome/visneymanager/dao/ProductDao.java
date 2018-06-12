package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.Brand;
import com.tthome.visneymanager.entity.ModleCode;
import com.tthome.visneymanager.entity.Product;
import com.tthome.visneymanager.entity.Size;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    public List<Product> selectAll(@Param("proName")String proName,@Param("brandName")String brandName,@Param("proStyleName")String proStyleName,
    @Param("proTypeName")String proTypeName, @Param("proSeriesName")String proSeriesName, @Param("proTextureName")String proTextureName,
    @Param("proPositionName")String proPositionName);

    public int getTotal();

    public int addProduct(Product product);

    public Product selectProductById(int proId);

    public int updateProduct(Product product);

    public int deleteProduct(int[] proIds);

}