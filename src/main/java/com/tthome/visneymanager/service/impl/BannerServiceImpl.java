package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.BannerDao;
import com.tthome.visneymanager.entity.Banner;
import com.tthome.visneymanager.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NBUG
 * @date 2018/6/8 15:45
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public List<Banner> selectAllByTpye(int bannerTypeId) {
        return bannerDao.selectAllByTpye(bannerTypeId);
    }

    @Override
    public List<Banner> getAll() {
        return bannerDao.getAll();
    }

    @Override
    public int delete(int[] ids) {
        return bannerDao.delete(ids);
    }

    @Override
    public int update(int bannerId) {
        return bannerDao.update(bannerId);
    }

    @Override
    public int add(Banner banner) {
        return bannerDao.add(banner);
    }
}
