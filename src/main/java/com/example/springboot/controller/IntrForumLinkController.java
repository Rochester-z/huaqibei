package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.IntrForumLink;
import com.example.springboot.entity.User;
import com.example.springboot.service.IntrForumLinkService;
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
@RequestMapping("/intr/forum_link")
public class IntrForumLinkController {

        @Resource
        private IntrForumLinkService intrForumLinkService;

        //新增或者更新
        @PostMapping
        public Boolean save(@RequestBody IntrForumLink intrForumLink) { //user变table.entityPath
                return intrForumLinkService.saveOrUpdate(intrForumLink);
        }


        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return intrForumLinkService.removeById(id);
        }


        //查询所有
        @GetMapping
        public List<IntrForumLink> findAll() {    //User变entity
                return intrForumLinkService.list();  //user变table.entityPath
                }

        //根据ID查询
        @GetMapping("/{id}")
        public IntrForumLink findOne(@PathVariable Integer id) {
                return intrForumLinkService.getById(id);
        }


        //分页查询
        @GetMapping("/page")
        public Page<IntrForumLink> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
                QueryWrapper<IntrForumLink> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByAsc("if_id");   //插入顺序查看
                return intrForumLinkService.page(new Page<>(pageNum, pageSize),queryWrapper);
        }





        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {   //{}中的id和PathVariable对应 {1,2,3}
        //      return userMapper.deleteById(id);
                return intrForumLinkService.removeBatchByIds(ids);  //MybaticsPlus框架
        }


}

