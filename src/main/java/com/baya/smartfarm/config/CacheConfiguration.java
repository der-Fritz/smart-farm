package com.baya.smartfarm.config;//package com.cbsolutions.smartfarmer.config;
//
//import com.github.benmanes.caffeine.cache.Caffeine;
//import com.github.benmanes.caffeine.cache.Ticker;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.caffeine.CaffeineCache;
//import org.springframework.cache.support.SimpleCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//
//@Configuration
//@EnableCaching
//@ConfigurationProperties(prefix = "caching")
//@Slf4j
//@Getter
//@Setter
//public class CacheConfiguration {
//
//    private Map<String, CacheSpec> specs = new HashMap<>();
//
//    @Bean
//    public CacheManager cacheManager(Ticker ticker) {
//
//        final SimpleCacheManager manager = new SimpleCacheManager();
//        List<CaffeineCache> caches = specs.entrySet()
//                .stream()
//                .map(entry -> buildCache(entry.getKey(), ticker, entry.getValue()))
//                .collect(Collectors.toList());
//        manager.setCaches(caches);
//        return manager;
//    }
//
//    private CaffeineCache buildCache(String name, Ticker ticker, CacheSpec cacheSpec) {
//
//        log.info("Cache {} specified timeout of {} minutes, maximum size of {}", name, cacheSpec.getTimeout(),
//                cacheSpec.getMax());
//        return new CaffeineCache(name, Caffeine.newBuilder()
//                .expireAfterWrite(cacheSpec.getTimeout(), TimeUnit.MINUTES)
//                .maximumSize(cacheSpec.getMax())
//                .ticker(ticker)
//                .build());
//    }
//
//    @Bean
//    public Ticker ticker() {
//        return Ticker.systemTicker();
//    }
//
//    @Data
//    public static class CacheSpec {
//
//        private Integer timeout;
//        private Integer max = 1000;
//    }
//}
