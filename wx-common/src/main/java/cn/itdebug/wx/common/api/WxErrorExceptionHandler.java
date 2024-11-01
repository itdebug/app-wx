package cn.itdebug.wx.common.api;


import cn.itdebug.wx.common.error.WxErrorException;

/**
 * WxErrorException处理器.
 *
 * @author Daniel Qian
 */
public interface WxErrorExceptionHandler {

  void handle(WxErrorException e);

}
