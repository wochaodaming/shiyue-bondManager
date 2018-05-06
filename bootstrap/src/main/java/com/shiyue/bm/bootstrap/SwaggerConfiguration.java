package com.shiyue.bm.bootstrap;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * <br/>
 * Created on 17/2/17.
 *
 * @auther lishenghao01
 */
@Configuration
@EnableSwagger2
@EnableAdminServer
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {
    /**
     * PS:解决spring-boot admin与swagger在web注册上的冲突。
     * SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
     * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试）
     * 重写该方法需要 extends WebMvcConfigurerAdapter
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了
     * （访问页面就可以看到效果了）
     */
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("o-v1")
                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/") // base，最终调用接口后会和paths拼接在一起
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.baidu.ark.sche"))
                .paths(or(regex("/.*"))) // 过滤的接口
                .build()
                .apiInfo(testApiInfo());
    }

    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("root")
                .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.baidu.ark.sch"))
                .paths(or(regex("/op/.*"))) // 过滤的接口
                .build()
                .apiInfo(demoApiInfo());
    }

    private ApiInfo testApiInfo() {
        Contact contact = new Contact("李胜浩", "", "lishenghao01@baidu.com");
        ApiInfo apiInfo = new ApiInfo("Ark调度平台", // 大标题
                "AS的Rest接口", // 小标题
                "2.0", // 版本
                "NO terms of service",
                contact, // 作者
                "百度运维开发者中心", // 链接显示文字
                "http://saas.baidu.com", // 网站链接
                new ArrayList<>()
        );

        return apiInfo;
    }

    private ApiInfo demoApiInfo() {
        Contact contact = new Contact("李胜浩", "", "lishenghao01@baidu.com");
        ApiInfo apiInfo = new ApiInfo("Ark调度平台", // 大标题
                "AS的Rest接口", // 小标题
                "2.0", // 版本
                "NO terms of service",
                contact, // 作者
                "百度运维开发者中心", // 链接显示文字
                "http://saas.baidu.com", // 网站链接
                new ArrayList<>()
        );

        return apiInfo;
    }
}
