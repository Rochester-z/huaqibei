package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.IntrPolicy;
import com.example.springboot.entity.News;
import com.example.springboot.mapper.IntrPolicyMapper;
import com.example.springboot.mapper.NewsMapper;
import com.example.springboot.service.IntrPolicyService;
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
public class IntrPolicyServiceImpl extends ServiceImpl<IntrPolicyMapper, IntrPolicy> implements IntrPolicyService {

}
