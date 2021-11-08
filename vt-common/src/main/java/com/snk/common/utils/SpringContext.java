package com.snk.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Slf4j
@Component
public class SpringContext implements ApplicationContextAware, DisposableBean {


    private static ApplicationContext applicationContext;


    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }


    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return (T) applicationContext.getBean(requiredType);
    }


    public static void clearHolder() {
        log.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
        applicationContext = null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        log.debug("注入ApplicationContext到SpringContextHolder:" + applicationContext);
        if (applicationContext != null) {
            log.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:" + com.snk.common.utils.SpringContext.applicationContext);
        }
        com.snk.common.utils.SpringContext.applicationContext = applicationContext;
    }

    public void destroy() throws Exception {
        clearHolder();
    }

    private static void assertContextInjected() {
        Assert.state((applicationContext != null), "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
    }
}
