package cn.itdebug.wx.common.util;

public class XStreamReplaceNameConverter extends XStreamCDataConverter {
  @Override
  public String toString(Object obj) {
    return "<ReplaceName>" + super.toString(obj) + "</ReplaceName>";
  }
}
