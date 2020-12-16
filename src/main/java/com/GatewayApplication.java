package com;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import com.alibaba.cloud.nacos.ribbon.NacosRibbonClientConfiguration;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.cloud.gateway.filter.RouteToRequestUrlFilter;
//import org.springframework.context.annotation;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/**
 * @author litao
 */
//@EnableCaching
@EnableDiscoveryClient
//@SpringBootApplication(scanBasePackages = {"com.*"},scanBasePackageClasses = com.netflix.client.config.IClientConfig.class)
//@SpringBootApplication(scanBasePackages={"com.netflix.client.config.IClientConfig"})
//@RibbonClients(defaultConfiguration = NacosRibbonClientConfiguration.class)
@SpringBootApplication(scanBasePackages = {"com.*"})
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
    @Bean
    IClientConfig iClientConfig() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.setClientName("myapp");
        return config;
    }
}
