package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.IntrPolicy;
import com.example.springboot.entity.User;
import com.example.springboot.service.IntrPolicyService;
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
@RequestMapping("/intr/policy")
public class IntrPolicyController {

        @Resource
        private IntrPolicyService intrPolicyService;

        //新增或者更新
        @PostMapping
        public Boolean save(@RequestBody IntrPolicy intrPolicy) { //user变table.entityPath
                return intrPolicyService.saveOrUpdate(intrPolicy);
        }


        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return intrPolicyService.removeById(id);
        }


        //查询所有
        @GetMapping
        public List<IntrPolicy> findAll() {    //User变entity
                return intrPolicyService.list();  //user变table.entityPath
                }

        //根据ID查询
        @GetMapping("/{id}")
        public IntrPolicy findOne(@PathVariable Integer id) {
                return intrPolicyService.getById(id);
        }


        //分页查询
        @GetMapping("/page")
        public Page<IntrPolicy> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
                QueryWrapper<IntrPolicy> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByAsc("ip_id");   //插入顺序查看
                return intrPolicyService.page(new Page<>(pageNum, pageSize),queryWrapper);
        }





        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {   //{}中的id和PathVariable对应 {1,2,3}
        //      return userMapper.deleteById(id);
                return intrPolicyService.removeBatchByIds(ids);  //MybaticsPlus框架
        }


}

