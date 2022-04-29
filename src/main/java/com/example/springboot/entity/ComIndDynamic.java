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
@TableName("com_ind_dynamic")
@ApiModel(value = "公司行业动态", description = "")
public class ComIndDynamic implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "ci_id", type = IdType.AUTO)
      private Integer ciId;

      @ApiModelProperty("标题")
      private String title;

      @ApiModelProperty("时间")
      private String time;

      @ApiModelProperty("概述")
      private String summary;

      @ApiModelProperty("来源")
      private String source;

      @ApiModelProperty("链接")
      private String link;

      @ApiModelProperty("图片")
      private String img;

}
