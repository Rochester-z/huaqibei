package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.Concept;
import com.example.springboot.service.ConceptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 庆哥哥
 * @since 2022-02-13
 */
@RestController
@RequestMapping("/intr/concept")
public class ConceptController {

//      shift+f6全选改名
        @Resource
        private ConceptService conceptService;

        //新增或者更新
        @PostMapping
        public Boolean save(@RequestBody Concept concept) { //user变table.entityPath
                return conceptService.saveOrUpdate(concept);
        }


        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return conceptService.removeById(id);
        }


        //查询所有
        @GetMapping
        public List<Concept> findAll() {    //User变entity
                return conceptService.list();  //user变table.entityPath
                }

        //根据ID查询
        @GetMapping("/{id}")
        public Concept findOne(@PathVariable Integer id) {
                return conceptService.getById(id);
        }


        //分页查询
        @GetMapping("/page")
        public Page<Concept> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
                QueryWrapper<Concept> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByAsc("c_id");   //插入顺序查看
                return conceptService.page(new Page<>(pageNum, pageSize),queryWrapper);
        }





        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {   //{}中的id和PathVariable对应 {1,2,3}
        //      return userMapper.deleteById(id);
                return conceptService.removeBatchByIds(ids);  //MybaticsPlus框架
        }


}

