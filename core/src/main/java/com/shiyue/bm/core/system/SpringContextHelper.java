package com.shiyue.bm.core.system;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <br/>
 * Created on 16/11/11.
 *
 * @auther lishenghao01
 */
@Component
public class SpringContextHelper implements ApplicationContextAware {

    private static ApplicationContext context;


    // 提供一个接口，获取容器中的Bean实例，根据名称获取
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        this.context = context;

    }

}