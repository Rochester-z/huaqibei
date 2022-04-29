package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.News;
import com.example.springboot.entity.User;
import com.example.springboot.service.NewsService;
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
@RequestMapping("/home/news")
public class NewsController {

        @Resource
        private NewsService newsService;

        //新增或者更新
        @PostMapping
        public Boolean save(@RequestBody News news) { //user变table.entityPath
                return newsService.saveOrUpdate(news);
        }


        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return newsService.removeById(id);
        }


        //查询所有
        @GetMapping
        public List<News> findAll() {    //User变entity
                System.out.println("进入了");
                return newsService.list();  //user变table.entityPath
                }

        //根据ID查询
        @GetMapping("/{id}")
        public News findOne(@PathVariable Integer id) {
                return newsService.getById(id);
        }


        //分页查询
        @GetMapping("/page")
        public Page<News> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
                QueryWrapper<News> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByAsc("n_id");   //插入顺序查看
                return newsService.page(new Page<>(pageNum, pageSize),queryWrapper);
        }






        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {   //{}中的id和PathVariable对应 {1,2,3}
        //      return userMapper.deleteById(id);
                return newsService.removeBatchByIds(ids);  //MybaticsPlus框架
        }


}

