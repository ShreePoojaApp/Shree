package com.shreepooja.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import org.bson.types.ObjectId;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    static {
        SpringDocUtils.getConfig().replaceWithSchema(ObjectId.class, new StringSchema());
    }
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Shree Pooja App")
                .version("1.0")
                .description("This is our new venture for connecting priests with devotees.");
        return new OpenAPI().info(info);
    }
}
