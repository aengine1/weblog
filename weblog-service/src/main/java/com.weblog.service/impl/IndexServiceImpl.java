package com.weblog.service.impl;

import com.weblog.dao.UserMapper;
import com.weblog.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "indexService")
public class IndexServiceImpl implements IIndexService {

    @Autowired
    private UserMapper userDao;

    /*
      页面访问测试
     */
    @Override
    public String Hello() {
        return "后台say:'hello'"+userDao.selectByPrimaryKey(1).getUserName();
    }

}
