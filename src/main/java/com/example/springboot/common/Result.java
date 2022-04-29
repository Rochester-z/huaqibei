package com.example.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
接口统一返回包装类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {



    private String code;
    private String msg;  //返回错误信息
    private Object data;


//  返回成功无数据
    public static Result success(){
        return new Result(Constants.CODE_200, "", null);
    }
    //  返回成功有数据
    public static Result success(Object data){
        return new Result(Constants.CODE_200, "", data);
    }

    public static Result error(String code, String msg){
        return new Result(code, msg, null);
    }


    public static Result error(){
        return new Result(Constants.CODE_500,"系统错误",null);
    }






}
