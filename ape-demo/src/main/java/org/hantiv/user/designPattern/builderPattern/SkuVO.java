package org.hantiv.user.designPattern.builderPattern;

import lombok.Data;

/**
 * @Author Zhikun Han
 * @Date Created in 16:17 2022/12/12
 * @Description:
 */
@Data
public class SkuVO {
    private Long skuId;

    private String skuName;

    private String promotionText;

    private String couponText;
}
