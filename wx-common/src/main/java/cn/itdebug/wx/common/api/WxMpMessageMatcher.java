package cn.itdebug.wx.common.api;


import cn.itdebug.wx.common.message.WxMpXmlMessage;

/**
 * 消息匹配器，用在消息路由的时候
 */
public interface WxMpMessageMatcher {

    /**
     * 消息是否匹配某种模式
     *
     * @param message the message
     * @return the boolean
     */
    boolean match(WxMpXmlMessage message);

}
