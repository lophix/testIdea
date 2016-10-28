package main.pojo.enums;

import io.netty.util.AttributeKey;

import java.util.Map;

/**
 * @Authuor Administrator
 * @Create 2016-10-28-15:09
 */
public class ChannelAttrEnums {
    /**
     * channel的session 序号
     */
    public static final AttributeKey<String> CHANNEL_ATTR_SERIAL_ID = AttributeKey.valueOf("C_Y");
    /**
     *channel绑定的厂商识别码
     */
    public static final AttributeKey<VendorID> CHANNEL_ATTR_VENDOR_ID = AttributeKey.valueOf("C_D");

    /**
     * channel上绑定的电桩号码
     */
    public static final AttributeKey<String> CHANNEL_BIND_PILE_CODE = AttributeKey.valueOf("B_D");

    /**
     * API的通信报文
     */
    public static AttributeKey<Map<String, Object>> API_BEAN = AttributeKey.valueOf("API_BEAN");
    /**
     *桩绑定的属性信息
     * key : venderId；厂商识别码
     *       pileId ：电桩的编号
     *       channel:电桩的Channel信息
     *       channelSessionId：channel的唯一回话ID
     *
     */
    public static final AttributeKey<Map<String,Object>> CHANNEL_ATTR_MAP = AttributeKey.valueOf("CHANNEL_ATTR_MAP_ETF");
    /**
     * 盛宏电桩升级 attr
     */
    public static AttributeKey<Map<String, Object>> SHENGHONG_UPDATE_BEAN = AttributeKey.valueOf("SHENGHONG_UPDATE_BEAN");
}
