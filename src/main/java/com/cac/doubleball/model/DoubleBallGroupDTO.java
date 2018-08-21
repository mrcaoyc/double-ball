package com.cac.doubleball.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 双色球组
 *
 * @author CaoYongCheng
 */
@Data
@Builder
public class DoubleBallGroupDTO {

    @JsonIgnore
    public static Integer BALL_COUNT=7;

    @ApiModelProperty("1号球")
    private Byte first;

    @ApiModelProperty("2号球")
    private Byte second;

    @ApiModelProperty("3号球")
    private Byte third;

    @ApiModelProperty("4号球")
    private Byte fourth;

    @ApiModelProperty("5号球")
    private Byte fifth;

    @ApiModelProperty("6号球")
    private Byte sixth;

    @ApiModelProperty("7号球")
    private Byte seventh;
}
