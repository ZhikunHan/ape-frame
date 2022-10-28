package org.hantiv.user.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.hantiv.user.interceptor.SqlBeautyInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Zhikun Han
 * @Date Created in 9:34 2022/8/14
 * @Description:
 */
@Configuration
public class MybatisConfiguration {

    @Bean
    @ConditionalOnProperty(name = {"sql.beauty.show"}, havingValue = "true",matchIfMissing = true)
    public SqlBeautyInterceptor sqlBeautyInterceptor(){
        return new SqlBeautyInterceptor();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
