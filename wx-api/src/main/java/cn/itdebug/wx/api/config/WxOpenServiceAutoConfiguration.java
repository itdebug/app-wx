package cn.itdebug.wx.api.config;

import cn.itdebug.wx.common.api.WxMpMessageRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @创建人 Eric.Lu
 * @创建时间 2024/1/5
 * @描述
 */
@Configuration
public class WxOpenServiceAutoConfiguration {

	@Bean
	public WxMpMessageRouter wxMpMessageRouter() {
		return new WxMpMessageRouter();
	}

}
