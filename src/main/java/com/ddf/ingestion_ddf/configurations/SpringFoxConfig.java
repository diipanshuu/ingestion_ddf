//package com.ddf.ingestion_ddf.configurations;
//
//import javax.servlet.ServletContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.paths.RelativePathProvider;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.time.LocalDate;
//import java.util.Date;
//
//@Configuration
//public class SpringFoxConfig {
//
//    private ServletContext servletContext;
//
//    public SpringFoxConfig(ServletContext servletContext) {
//        this.servletContext = servletContext;
//    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .host("localhost")
//                .directModelSubstitute(LocalDate.class, Date.class)
//                .pathProvider(new RelativePathProvider(servletContext))
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//}
