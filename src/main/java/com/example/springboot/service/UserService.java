package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 庆哥哥
 * @since 2022-02-13
 */
public interface UserService extends IService<User> {
    UserDTO login(UserDTO userDto);

    User register(UserDTO userDTO);
}
