package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.ForeignNews;
import com.example.springboot.entity.User;
import com.example.springboot.service.ForeignNewsService;
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
@RequestMapping("/home/foreign_news")
public class ForeignNewsController {

        @Resource
        private ForeignNewsService foreignNewsService;

        //新增或者更新
        @PostMapping
        public Boolean save(@RequestBody ForeignNews foreignNews) { //user变table.entityPath
                return foreignNewsService.saveOrUpdate(foreignNews);
        }


        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return foreignNewsService.removeById(id);
        }


        //查询所有
        @GetMapping
        public List<ForeignNews> findAll() {    //User变entity
                return foreignNewsService.list();  //user变table.entityPath
                }

        //根据ID查询
        @GetMapping("/{id}")
        public ForeignNews findOne(@PathVariable Integer id) {
                return foreignNewsService.getById(id);
        }


        //分页查询
        @GetMapping("/page")
        public Page<ForeignNews> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
                QueryWrapper<ForeignNews> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByAsc("fn_id");   //插入顺序查看
                return foreignNewsService.page(new Page<>(pageNum, pageSize),queryWrapper);
        }





        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {   //{}中的id和PathVariable对应 {1,2,3}
        //      return userMapper.deleteById(id);
                return foreignNewsService.removeBatchByIds(ids);  //MybaticsPlus框架
        }


}

