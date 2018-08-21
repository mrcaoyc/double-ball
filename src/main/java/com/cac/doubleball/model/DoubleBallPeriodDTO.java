package com.cac.doubleball.model;

import lombok.Builder;
import lombok.Data;

/**
 * 双色球一期的数据
 *
 * @author CaoYongCheng
 */
@Data
@Builder
public class DoubleBallPeriodDTO {
    private Integer periodId;

    private DoubleBallGroupDTO doubleBallGroup;
}
