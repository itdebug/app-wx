package cn.itdebug.wx.common.bean.result;

import cn.itdebug.wx.common.util.json.WxMpGsonBuilder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 关注者列表
 *
 * @author chanjarster
 */
@Data
public class WxMpUserList implements Serializable {
  private static final long serialVersionUID = 1389073042674901032L;

  protected long total = -1;
  protected int count = -1;
  protected List<String> openids = new ArrayList<>();
  protected String nextOpenid;

  public static WxMpUserList fromJson(String json) {
    return WxMpGsonBuilder.create().fromJson(json, WxMpUserList.class);
  }

  @Override
  public String toString() {
    return WxMpGsonBuilder.create().toJson(this);
  }
}
