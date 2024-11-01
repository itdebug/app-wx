package cn.itdebug.wx.api.controller;

import cn.itdebug.wx.common.WxMpXmlOutMessage;
import cn.itdebug.wx.common.api.WxMpMessageRouter;
import cn.itdebug.wx.common.message.WxMpXmlMessage;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @创建人 Eric.Lu
 * @创建时间 2024/1/3
 * @描述
 */
@Slf4j
@RestController
@RequestMapping("/portal/{appid}")
public class PortalApi {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final WxMpMessageRouter messageRouter;

	public PortalApi(WxMpMessageRouter messageRouter) {
		this.messageRouter = messageRouter;
	}

	@GetMapping(produces = "text/plain;charset=utf-8")
	@ApiOperation(value = "微信服务器的认证消息",notes = "公众号接入开发模式时腾讯调用此接口")
	public String authGet(@PathVariable String appid,
						  @RequestParam(name = "signature", required = false) String signature,
						  @RequestParam(name = "timestamp", required = false) String timestamp,
						  @RequestParam(name = "nonce", required = false) String nonce,
						  @RequestParam(name = "echostr", required = false) String echostr) {

		log.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature,
				timestamp, nonce, echostr);
		return echostr;
	}

	@PostMapping(produces = "application/xml; charset=UTF-8")
	@ApiOperation(value = "微信各类消息",notes = "公众号接入开发模式后才有效")
	public String post(@PathVariable String appid,
					   @RequestBody String requestBody,
					   @RequestParam("signature") String signature,
					   @RequestParam("timestamp") String timestamp,
					   @RequestParam("nonce") String nonce,
					   @RequestParam("openid") String openid,
					   @RequestParam(name = "encrypt_type", required = false) String encType,
					   @RequestParam(name = "msg_signature", required = false) String msgSignature) {
		log.info("\n接收微信请求：[openid=[{}], [signature=[{}], encType=[{}], msgSignature=[{}],"
						+ " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
				openid, signature, encType, msgSignature, timestamp, nonce, requestBody);

		String out = null;
		if (encType == null) {
			// 明文传输的消息
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
			WxMpXmlOutMessage outMessage = this.route(appid,inMessage);
			if (outMessage == null) {
				return "";
			}

			out = outMessage.toXml();
		}
		log.debug("\n组装回复信息：{}", "out");
		return out;
	}

	private WxMpXmlOutMessage route(String appid,WxMpXmlMessage message) {
		try {
			return this.messageRouter.route(appid,message);
		} catch (Exception e) {
			logger.error("路由消息时出现异常！", e);
		}
		return null;
	}
}
