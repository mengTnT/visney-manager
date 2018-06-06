package com.tthome.visneymanager;

import com.tthome.visneymanager.dao.PageViewsDao;
import com.tthome.visneymanager.entity.PageViews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisneyManagerApplicationTests {
    @Autowired
    PageViewsDao pageViewsDao;

    @Test
    public void contextLoads() {
        PageViews pageViews=new PageViews();
        int add = pageViewsDao.pageViewsAdd(pageViews);

        System.out.println(add);
        System.out.println(pageViews.getPageViewsId());

    }

}
