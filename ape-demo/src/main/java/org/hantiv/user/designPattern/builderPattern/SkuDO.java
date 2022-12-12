package org.hantiv.user.designPattern.builderPattern;

import lombok.Data;

/**
 * @Author Zhikun Han
 * @Date Created in 16:14 2022/12/12
 * @Description:
 */
@Data
public class SkuDO {

    private Long skuId;

    private String skuName;

    // 促销id
    private Long promotionId;

    // 优惠劵id
    private Long couponId;
}
