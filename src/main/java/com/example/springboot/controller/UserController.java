package com.example.springboot.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Constants;
import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
//import javax.xml.transform.Result;
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
@RequestMapping("/user")
public class UserController {

        @Resource
        private UserService userService;





        //新增或者更新
        @PostMapping("/login")
//       @RequestBody将前端json转成后台java对象
        public Result login(@RequestBody UserDTO userDto)
        {//user变table.entityPath
//       hutool工具类中的方法
                String username = userDto.getUsername();
                String password = userDto.getPassword();
                if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
                        return Result.error(Constants.CODE_400,"参数错误");
                }
                UserDTO userDTO = userService.login(userDto);
                //成功返回，失败在方法中返回错误
                return Result.success(userDTO);
        }



        //新增或者更新
        @PostMapping("/register")
        public Result register(@RequestBody UserDTO userDTO) { //user变table.entityPath
                System.out.println("注册了");
                String username = userDTO.getUsername();
                String password = userDTO.getPassword();
//                String email = userDTO.getEmail();
                if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
                        return Result.error(Constants.CODE_400,"参数错误");
                }
                return Result.success(userService.register(userDTO));
        }

        //新增或者更新
        @PostMapping
        public Result save(@RequestBody User user) { //user变table.entityPath

                return Result.success(userService.saveOrUpdate(user));
        }


        //删除
        @DeleteMapping("/{id}")
        public Result delete(@PathVariable Integer id) {
                return Result.success(userService.removeById(id));
        }


        //查询所有
        @GetMapping
        public Result findAll() {    //User变entity
                return Result.success(userService.list());  //user变table.entityPath
                }

        //根据ID查询
        @GetMapping("/{id}")
        public Result findOne(@PathVariable Integer id) {
                return Result.success(userService.getById(id));
        }


        //根据username查询
        @GetMapping("/username/{username}")
        public Result findOne(@PathVariable String username) {
                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("username",username);
                return Result.success(userService.getOne(queryWrapper));
        }


        //分页查询
        @GetMapping("/page")
        public Result findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String username,
                                   @RequestParam(defaultValue = "") String email,
                                   @RequestParam(defaultValue = "") String address) {
                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByAsc("u_id");   //插入顺序查看
                if(!"".equals(username)) {           //"" like匹配不到
                        queryWrapper.like("username", username);   //sql语句
                }
                if(!"".equals(email)) {
                        queryWrapper.like("email", email);  //自动加and
                }
                if(!"".equals(address)) {
                        queryWrapper.like("address", address);
                }
                System.out.println("进入了===============================");
//              通过token在任何地方也能够获取
                User currentUser = TokenUtils.getCurrentUser();
                if(currentUser != null) {
                        System.out.println("获取当前用户信息==================" + currentUser.getNickname());
                }
                return Result.success(userService.page(new Page<>(pageNum, pageSize),queryWrapper));
        }





        @PostMapping("/del/batch")
        public Result deleteBatch(@RequestBody List<Integer> ids) {   //{}中的id和PathVariable对应 {1,2,3}
        //      return userMapper.deleteById(id);
                return Result.success(userService.removeBatchByIds(ids));  //MybaticsPlus框架
        }


}

