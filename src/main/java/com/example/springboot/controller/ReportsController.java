package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.Reports;
import com.example.springboot.entity.User;
import com.example.springboot.service.ReportsService;
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
@RequestMapping("/home/reports")
public class ReportsController {

        @Resource
        private ReportsService reportsService;

        //新增或者更新
        @PostMapping
        public Boolean save(@RequestBody Reports reports) { //user变table.entityPath
                return reportsService.saveOrUpdate(reports);
        }


        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return reportsService.removeById(id);
        }


        //查询所有
        @GetMapping
        public List<Reports> findAll() {    //User变entity
                return reportsService.list();  //user变table.entityPath
                }

        //根据ID查询
        @GetMapping("/{id}")
        public Reports findOne(@PathVariable Integer id) { //对象即json对象
                return reportsService.getById(id);
        }


        //分页查询
        @GetMapping("/page")
        public Page<Reports> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
                QueryWrapper<Reports> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByAsc("r_id");   //插入顺序查看
//                封装好的属性里面嵌套了方法
                return reportsService.page(new Page<>(pageNum, pageSize),queryWrapper);
        }





        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {   //{}中的id和PathVariable对应 {1,2,3}
        //      return userMapper.deleteById(id);
                return reportsService.removeBatchByIds(ids);  //MybaticsPlus框架
        }


}

