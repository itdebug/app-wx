package cn.itdebug.wx.common.util;

public class XStreamMediaIdConverter extends XStreamCDataConverter {
  @Override
  public String toString(Object obj) {
    return "<MediaId>" + super.toString(obj) + "</MediaId>";
  }
}
