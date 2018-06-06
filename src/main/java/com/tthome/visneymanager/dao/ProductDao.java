package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> selectAll();

    public int getTotal();

    public int addProduct(Product product);

    public int updateProduct(Product product);

    public int deleteProduct(int[] proIds);
}