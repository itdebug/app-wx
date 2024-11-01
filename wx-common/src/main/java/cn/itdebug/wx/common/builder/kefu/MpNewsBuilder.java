package cn.itdebug.wx.common.builder.kefu;

import cn.itdebug.wx.common.api.WxConsts;
import cn.itdebug.wx.common.bean.kefu.WxMpKefuMessage;

/**
 * 图文消息builder
 * <pre>
 * 用法:
 * WxMpKefuMessage m = WxMpKefuMessage.NEWS().mediaId("xxxxx").toUser(...).build();
 * </pre>
 *
 * @author Binary Wang
 */
public final class MpNewsBuilder extends BaseBuilder<MpNewsBuilder> {
  private String mediaId;

  public MpNewsBuilder() {
    this.msgType = WxConsts.KefuMsgType.MPNEWS;
  }

  public MpNewsBuilder mediaId(String mediaId) {
    this.mediaId = mediaId;
    return this;
  }

  @Override
  public WxMpKefuMessage build() {
    WxMpKefuMessage m = super.build();
    m.setMpNewsMediaId(this.mediaId);
    return m;
  }
}
