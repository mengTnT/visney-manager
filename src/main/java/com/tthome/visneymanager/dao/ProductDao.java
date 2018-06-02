package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> selectAll();

    public int getTotal();



}