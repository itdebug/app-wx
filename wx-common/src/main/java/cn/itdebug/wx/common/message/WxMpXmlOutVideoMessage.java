package cn.itdebug.wx.common.message;

import cn.itdebug.wx.common.WxMpXmlOutMessage;
import cn.itdebug.wx.common.api.WxConsts;
import cn.itdebug.wx.common.util.XStreamCDataConverter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@XStreamAlias("xml")
@JacksonXmlRootElement(localName = "xml")
@EqualsAndHashCode(callSuper = true)
public class WxMpXmlOutVideoMessage extends WxMpXmlOutMessage {
  private static final long serialVersionUID = 1745902309380113978L;

  @XStreamAlias("Video")
  @JacksonXmlProperty(localName = "Video")
  protected final Video video = new Video();

  public WxMpXmlOutVideoMessage() {
    this.msgType = WxConsts.XmlMsgType.VIDEO;
  }

  @Data
  @XStreamAlias("Video")
  @JacksonXmlRootElement(localName = "Video")
  public static class Video implements Serializable {
    private static final long serialVersionUID = -6445448977569651183L;

    @XStreamAlias("MediaId")
    @XStreamConverter(value = XStreamCDataConverter.class)
    @JacksonXmlProperty(localName = "MediaId")
    @JacksonXmlCData
    private String mediaId;

    @XStreamAlias("Title")
    @XStreamConverter(value = XStreamCDataConverter.class)
    @JacksonXmlProperty(localName = "Title")
    @JacksonXmlCData
    private String title;

    @XStreamAlias("Description")
    @XStreamConverter(value = XStreamCDataConverter.class)
    @JacksonXmlProperty(localName = "Description")
    @JacksonXmlCData
    private String description;

  }

  public String getMediaId() {
    return this.video.mediaId;
  }

  public void setMediaId(String mediaId) {
    this.video.mediaId = mediaId;
  }

  public String getTitle() {
    return this.video.title;
  }

  public void setTitle(String title) {
    this.video.title = title;
  }

  public String getDescription() {
    return this.video.description;
  }

  public void setDescription(String description) {
    this.video.description = description;
  }
}
