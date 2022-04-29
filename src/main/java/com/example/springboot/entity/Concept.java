package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *新闻资讯
 * @author 庆哥哥
 * @since 2022-02-13
 */
@Getter
@Setter
@TableName("intr_concept")
@ApiModel(value = "概念对象", description = "")
public class Concept implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "c_id", type = IdType.AUTO)
      private Integer cId;


      @ApiModelProperty("概述")
      private String content;

      @ApiModelProperty("来源")
      private String source;

      @ApiModelProperty("图片")
      private String img;

}
