package com.mfhcd.pass.gateway;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author litao
 */
//@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.mfhcd.pass.*"})
public class GatewayApplication {
//    /*跨域处理*/
//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
