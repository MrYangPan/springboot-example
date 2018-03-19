package com.example.demo.service.impl;

import com.example.demo.exception.TipException;
import com.example.demo.mapper.UserVoMapper;
import com.example.demo.model.UserVo;
import com.example.demo.model.UserVoExample;
import com.example.demo.service.IUserService;
import com.example.demo.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/3/15.
 */
@Service
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserVoMapper userDao;


    /**
     * 保存用户数据
     *
     * @param userVo 用户数据
     * @return 主键
     */
    @Override
    public Integer insertUser(UserVo userVo) {
        Integer uid = null;
        if (StringUtils.isNotBlank(userVo.getUsername()) && StringUtils.isNotBlank(userVo.getEmail())) {
//            用户密码加密
            String encodePwd = TaleUtils.MD5encode(userVo.getUsername() + userVo.getPassword());
            userVo.setPassword(encodePwd);
            userDao.insertSelective(userVo);
        }
        return userVo.getUid();
    }

    /**
     * 通过uid查找对象
     *
     * @param uid
     * @return
     */
    @Override
    public UserVo queryUserById(Integer uid) {
        UserVo userVo = null;
        if (uid != null) {
            userVo = userDao.selectByPrimaryKey(uid);
        }
        return userVo;
    }

    /**
     * 用戶登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserVo login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new TipException("用户名和密码不能为空");
        }
        UserVoExample example = new UserVoExample();
        UserVoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        long count = userDao.countByExample(example);
        if (count < 1) {
            throw new TipException("不存在该用户");
        }
        String pwd = TaleUtils.MD5encode(username + password);
        criteria.andPasswordEqualTo(pwd);
        List<UserVo> userVos = userDao.selectByExample(example);
        if (userVos.size() != 1) {
            throw new TipException("用户名或密码错误");
        }
        return userVos.get(0);
    }

    /**
     * 根据主键更新user对象
     *
     * @param userVo
     * @return
     */
    @Override
    @Transactional
    public void updateByUid(UserVo userVo) {
        if (null == userVo || null == userVo.getUid()) {
            throw new TipException("userVo is null");
        }
        int i = userDao.updateByPrimaryKeySelective(userVo);
        if (i != 1) {
            throw new TipException("update user by uid and retrun is not one");
        }
    }
}
