package com.example.springboot.service.impl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.common.Constants;
import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.User;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 庆哥哥
 * @since 2022-02-13
 */
//灰色阴影表示未使用
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private static final Log LOG = Log.get();

    @Override
    public UserDTO login(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if(one != null) {
            BeanUtils.copyProperties(one,userDTO,"true");  //将one赋值给userDTO，从数据库查询用户信息返回one
            //设置token，必须是uid，唯一，getbyId验证搜id
            String token = TokenUtils.genToken(one.getUId().toString(), one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        }else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if(one == null) {
            one = new User();
            BeanUtils.copyProperties(userDTO,one,"true");  //将userDTO赋值给one，存到数据库
            save(one);
            System.out.println("成功存储用户");
        }else {
            throw new ServiceException(Constants.CODE_600,"用户已存在");
        }
        return one;
    }



    private User getUserInfo(UserDTO userDTO){
        //        对userDto进行校验
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        User one;
        try {
            //user表唯一数据用getOne
            one = getOne(queryWrapper);
        } catch (Exception e) {
//          e.printStackTrace();
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        return one;

    }
}
