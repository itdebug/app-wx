package cn.itdebug.wx.common.bean.material;

import cn.itdebug.wx.common.util.json.WxMpGsonBuilder;
import lombok.Data;

import java.io.Serializable;

@Data
public class WxMpMaterialArticleUpdate implements Serializable {
  private static final long serialVersionUID = -7611963949517780270L;

  private String mediaId;
  private int index;
  private WxMpNewsArticle articles;

  public String toJson() {
    return WxMpGsonBuilder.create().toJson(this);
  }
}
