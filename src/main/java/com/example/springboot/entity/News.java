package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("home_news")
@ApiModel(value = "News对象", description = "")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "n_id", type = IdType.AUTO)
      private Integer nId;

      @ApiModelProperty("标题")
      private String title;

      @ApiModelProperty("时间")
      private String time;

      @ApiModelProperty("概述")
      private String summary;

      @ApiModelProperty("来源")
      private String author;

      @ApiModelProperty("链接")
      private String link;

      @ApiModelProperty("图片")
      private String img;


}
