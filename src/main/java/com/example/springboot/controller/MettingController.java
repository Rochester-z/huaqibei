package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.Metting;
import com.example.springboot.entity.User;
import com.example.springboot.service.MettingService;
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
@RequestMapping("/home/meeting")
public class MettingController {

        @Resource
        private MettingService mettingService;

        //新增或者更新
        @PostMapping
        public Boolean save(@RequestBody Metting metting) { //user变table.entityPath
                return mettingService.saveOrUpdate(metting);
        }


        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return mettingService.removeById(id);
        }


        //查询所有
        @GetMapping
        public List<Metting> findAll() {    //User变entity
                return mettingService.list();  //user变table.entityPath
                }

        //根据ID查询
        @GetMapping("/{id}")
        public Metting findOne(@PathVariable Integer id) {
                return mettingService.getById(id);
        }


        //分页查询
        @GetMapping("/page")
        public Page<Metting> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
                QueryWrapper<Metting> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByAsc("m_id");   //插入顺序查看
                return mettingService.page(new Page<>(pageNum, pageSize),queryWrapper);
        }





        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {   //{}中的id和PathVariable对应 {1,2,3}
        //      return userMapper.deleteById(id);
                return mettingService.removeBatchByIds(ids);  //MybaticsPlus框架
        }


}

