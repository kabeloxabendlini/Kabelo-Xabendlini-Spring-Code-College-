package webapp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI tacoCloudOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Taco Cloud API")
                        .description("A simple demo API for creating and browsing tacos, "
                                + "documented and testable through Swagger UI.")
                        .version("v1.0"));
    }
}
