package cn.itdebug.wx.common.bean.result;

import cn.itdebug.wx.common.util.json.WxGsonBuilder;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author Daniel Qian
 */
@Data
public class WxMediaUploadResult implements Serializable {
  private static final long serialVersionUID = 330834334738622341L;

  private String url;
  private String type;
  private String mediaId;
  private String thumbMediaId;
  private long createdAt;

  public static WxMediaUploadResult fromJson(String json) {
    return WxGsonBuilder.create().fromJson(json, WxMediaUploadResult.class);
  }

  @Override
  public String toString() {
    return WxGsonBuilder.create().toJson(this);
  }

}
