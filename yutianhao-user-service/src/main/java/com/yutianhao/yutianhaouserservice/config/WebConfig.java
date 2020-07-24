package com.yutianhao.yutianhaouserservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web相关配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(WebConfig.class);
    /**
     * 自定义资源配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        logger.info("静态资源配置信息-------------------------------");
        registry.addResourceHandler("/imgs/**")
                .addResourceLocations("file:E:/upload/boot/");
    }
}
