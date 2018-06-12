package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.Banner;

import java.util.List;

public interface BannerDao {
    List<Banner> selectAllByTpye(int bannerTypeId);
    public List<Banner>getAll();
    public int delete(int []ids);
    public int update(int bannerId);
    public int add(Banner banner);

}