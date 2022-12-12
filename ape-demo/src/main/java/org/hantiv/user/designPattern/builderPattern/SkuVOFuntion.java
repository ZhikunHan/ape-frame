package org.hantiv.user.designPattern.builderPattern;

/**
 * @Author Zhikun Han
 * @Date Created in 16:23 2022/12/12
 * @Description:
 */
public interface SkuVOFuntion<T extends SkuVO> {
    T newInstance();
}
