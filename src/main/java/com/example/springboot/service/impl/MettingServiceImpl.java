package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.Metting;
import com.example.springboot.entity.News;
import com.example.springboot.mapper.MettingMapper;
import com.example.springboot.mapper.NewsMapper;
import com.example.springboot.service.MettingService;
import com.example.springboot.service.NewsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 庆哥哥
 * @since 2022-02-13
 */
@Service
public class MettingServiceImpl extends ServiceImpl<MettingMapper, Metting> implements MettingService {

}
