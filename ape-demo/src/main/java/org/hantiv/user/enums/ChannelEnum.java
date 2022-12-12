package org.hantiv.user.enums;

/**
 * @Author Zhikun Han
 * @Date Created in 19:34 2022/12/2
 * @Description:
 */
public enum ChannelEnum {

    DOU_YIN(0, "抖音渠道"),
    BILIBILI(1, "B站渠道");

    private int code;

    private String desc;

    ChannelEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code值获取渠道枚举
     */
    public static ChannelEnum getByCode(int codeVal) {
        for (ChannelEnum channelEnum : ChannelEnum.values()) {
            if (channelEnum.code == codeVal) {
                return channelEnum;
            }
        }
        return null;
    }

    /**
     * 根据code值获得desc
     */
    public static String getValueByCode(int code){
        ChannelEnum[] values = ChannelEnum.values();
        for (ChannelEnum channelEnum : values) {
            if (channelEnum.code == code){
                return channelEnum.desc;
            }
        }
        return null;
    }
}
