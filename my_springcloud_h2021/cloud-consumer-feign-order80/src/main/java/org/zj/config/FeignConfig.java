package org.zj.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiezhou
 * @CalssName: FeignConfig
 * @Package org.zj.config
 * @Description: 配置
 * @date 2021/7/5/10:31
 */
@Configuration
public class FeignConfig {


    /**
     * 配置日志bean
     *
     *
     * 日志级别
     *
     * NONE：默认的，不显示任何日志;
     * BASIC：仅记录请求方法、URL、响应状态码及执行时间;
     * HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息;
     * FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
