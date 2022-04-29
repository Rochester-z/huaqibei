package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.ForeignNews;
import com.example.springboot.mapper.ForeignNewsMapper;
import com.example.springboot.service.ForeignNewsService;
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
public class ForeignNewsServiceImpl extends ServiceImpl<ForeignNewsMapper, ForeignNews> implements ForeignNewsService {

}
