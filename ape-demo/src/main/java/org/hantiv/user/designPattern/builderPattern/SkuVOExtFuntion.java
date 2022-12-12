package org.hantiv.user.designPattern.builderPattern;

/**
 * @Author Zhikun Han
 * @Date Created in 16:23 2022/12/12
 * @Description:
 */
public interface SkuVOExtFuntion<T extends SkuVO> {
    void buildExtInfo(T skuVo, SkuDO skuDO);

}
