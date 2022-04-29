package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.Concept;
import com.example.springboot.mapper.ConceptMapper;
import com.example.springboot.service.ConceptService;
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
public class ConceptServiceImpl extends ServiceImpl<ConceptMapper, Concept> implements ConceptService {

}
