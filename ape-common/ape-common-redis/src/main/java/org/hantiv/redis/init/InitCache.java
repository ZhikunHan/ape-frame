package org.hantiv.redis.init;

import org.hantiv.redis.util.SpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author Zhikun Han
 * @Date Created in 22:33 2022/10/28
 * @Description:
 */
@Component
public class InitCache implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //需要知道那些缓存需要进行预热
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        Map<String, AbstractCache> beanMap = applicationContext.getBeansOfType(AbstractCache.class);
        //调用init方法
        if (beanMap.isEmpty()){
            return;
        }
        for (Map.Entry<String, AbstractCache> entry : beanMap.entrySet()){
            AbstractCache abstractCache = (AbstractCache) SpringContextUtil.getBean(entry.getValue().getClass());
            abstractCache.initCache();
        }
    }
}
