package org.hantiv.user.designPattern.filterPattern;

import org.hantiv.user.enums.ChannelEnum;

/**
 * @Author Zhikun Han
 * @Date Created in 16:41 2022/12/12
 * @Description:
 */
public enum ArticleFilterEnum {

    WORD_COUNT(0, "过滤器");

    private int code;
    private String desc;

    ArticleFilterEnum(int code, String desc){
        this.code= code;
        this.desc=desc;
    }

    /**
     * 根据code值获取枚举
     */
    public static ArticleFilterEnum getByCode(int codeVal) {
        for (ArticleFilterEnum articleFilterEnum : ArticleFilterEnum.values()) {
            if (articleFilterEnum.code == codeVal) {
                return articleFilterEnum;
            }
        }
        return null;
    }

    /**
     * 根据code值获得desc
     */
    public static String getValueByCode(int code){
        ArticleFilterEnum[] values = ArticleFilterEnum.values();
        for (ArticleFilterEnum articleFilterEnum : values) {
            if (articleFilterEnum.code == code){
                return articleFilterEnum.desc;
            }
        }
        return null;
    }

}
