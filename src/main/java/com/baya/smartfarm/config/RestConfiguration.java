package com.baya.smartfarm.config;//package com.cbsolutions.smartfarmer.config;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//@RequiredArgsConstructor
//public class RestConfiguration {
//
//    private final HttpClientConfig httpClientConfig;
//
//    @Value("${sms.endpoint.user}")
//    private String smsApiUser;
//    @Value("${sms.endpoint.password}")
//    private String smsPassword;
//    public static final String SMS_REST_TEMPLATE = "SMS_REST_TEMPLATE";
//
//
//    @Bean(name = SMS_REST_TEMPLATE)
//    public RestTemplate smsRestTemplate(RestTemplateBuilder restTemplateBuilder) {
//        return restTemplateBuilder
//                .defaultHeader("Source-Type", "WEB")
//                .defaultHeader("Source-Name", "VDF")
//                .defaultHeader("Application-Token", smsPassword)
//                .basicAuthentication(smsApiUser, smsPassword)
//                .setConnectTimeout(httpClientConfig.connectTimeout)
//                .setReadTimeout(httpClientConfig.getReadTimeout())
//                .build();
//    }
//
//
//}
