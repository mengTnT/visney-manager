package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.Banner;

import java.util.List;

/**
 * @author NBUG
 * @date 2018/6/8 15:45
 */
public interface BannerService {
    public List<Banner> selectAllByTpye(int bannerTypeId);
    public List<Banner>getAll();
    public int delete(int []ids);
    public int update(int bannerId);
    public int add(Banner banner);

}
