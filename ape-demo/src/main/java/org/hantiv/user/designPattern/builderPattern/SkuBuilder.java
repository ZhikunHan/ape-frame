package org.hantiv.user.designPattern.builderPattern;

/**
 * @Author Zhikun Han
 * @Date Created in 16:19 2022/12/12
 * @Description:
 */
public class SkuBuilder<T extends SkuVO> {

    private SkuDO skuDO;

    private Boolean needCoupon;

    private SkuVOFuntion<T> skuVOFuntion;

    private SkuVOExtFuntion<T> skuVOExtFuntion;

    public static <T extends SkuVO> SkuBuilder<T> create(){
        return new SkuBuilder<T>();
    }

    public SkuBuilder<T> skuDO(SkuDO skuDO){
        this.skuDO = skuDO;
        return this;
    }

    public SkuBuilder<T> needCoupon(Boolean needCoupon){
        this.needCoupon = needCoupon;
        return this;
    }

    public SkuBuilder<T> skuVOFuntion(SkuVOFuntion<T> skuVOFuntion){
        this.skuVOFuntion = skuVOFuntion;
        return this;
    }

    public SkuBuilder<T> skuVOExtFuntion(SkuVOExtFuntion<T> skuVOExtFuntion){
        this.skuVOExtFuntion = skuVOExtFuntion;
        return this;
    }

    public T build(){
        T skuVo = this.skuVOFuntion.newInstance();
        skuVo.setSkuId(skuDO.getSkuId());
        skuVo.setSkuName(skuDO.getSkuName());
        if (needCoupon){
            skuVo.setCouponText("");
        }
        if (this.skuVOExtFuntion!=null){
            this.skuVOExtFuntion.buildExtInfo(skuVo, skuDO);
        }
        return skuVo;
    }
}
