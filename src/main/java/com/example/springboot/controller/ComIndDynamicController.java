package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.ComIndDynamic;
import com.example.springboot.entity.User;
import com.example.springboot.service.ComIndDynamicService;
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
@RequestMapping("/intr/ind_dynamic")
public class ComIndDynamicController {

        @Resource
        private ComIndDynamicService comIndDynamicService;

        //新增或者更新
        @PostMapping
        public Boolean save(@RequestBody ComIndDynamic comIndDynamic) { //user变table.entityPath
                return comIndDynamicService.saveOrUpdate(comIndDynamic);
        }


        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return comIndDynamicService.removeById(id);
        }


        //查询所有
        @GetMapping
        public List<ComIndDynamic> findAll() {    //User变entity
                return comIndDynamicService.list();  //user变table.entityPath
                }

        //根据ID查询
        @GetMapping("/{id}")
        public ComIndDynamic findOne(@PathVariable Integer id) {
                return comIndDynamicService.getById(id);
        }


        //分页查询
        @GetMapping("/page")
        public Page<ComIndDynamic> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
                QueryWrapper<ComIndDynamic> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByAsc("ci_id");   //插入顺序查看
                return comIndDynamicService.page(new Page<>(pageNum, pageSize),queryWrapper);
        }





        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {   //{}中的id和PathVariable对应 {1,2,3}
        //      return userMapper.deleteById(id);
                return comIndDynamicService.removeBatchByIds(ids);  //MybaticsPlus框架
        }


}

