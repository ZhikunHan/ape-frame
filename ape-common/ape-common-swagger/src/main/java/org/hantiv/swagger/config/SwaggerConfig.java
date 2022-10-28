package org.hantiv.swagger.config;

import org.hantiv.swagger.bean.SwaggerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Zhikun Han
 * @Date Created in 21:11 2022/10/28
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private SwaggerInfo swaggerInfo;

    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(swaggerInfo.getTitle())
                .contact(new Contact(swaggerInfo.getContactName(), swaggerInfo.getContactUrl(), swaggerInfo.getEmail()))
                .version(swaggerInfo.getVersion())
                .description(swaggerInfo.getDescription())
                .build();
    }

}
