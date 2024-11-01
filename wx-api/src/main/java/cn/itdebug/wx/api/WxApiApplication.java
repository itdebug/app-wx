package cn.itdebug.wx.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author Eric.lu
 * @url https://itdebug.cn/
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "cn.itdebug.wx.common",
        "cn.itdebug.wx.api",
})
public class WxApiApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(WxApiApplication.class, args);
    }
}
