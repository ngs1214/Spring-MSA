package com.spring.msa.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomRouteFilter extends AbstractGatewayFilterFactory<CustomRouteFilter.Config> {

    public CustomRouteFilter() {
        super(Config.class); // Config 클래스를 필터와 연결
    }


    @Override
    public GatewayFilter apply(Config config) {
      return (exchange, chain) ->{

              if(config.isPre()){
                  System.out.println("PRE local filter" + config.getHeaderName() + ":" +config.getHeaderValue());
              }
              return chain.filter(exchange)
                      .then(Mono.fromRunnable(()->{
                          if (config.isPost()) {
                              System.out.println("POST local filter" + config.getHeaderName() + ":" +config.getHeaderValue());
                          }
                      }));

      };
    }

    // 필터 설정을 위한 Config 클래스

    public static class Config{
        private String headerName;
        private String headerValue;
        private boolean pre;
        private boolean post;

        public Config() {
        }

        public Config(String headerName, String headerValue, boolean pre, boolean post) {
            this.headerName = headerName;
            this.headerValue = headerValue;
            this.pre = pre;
            this.post = post;
        }

        public String getHeaderName() {
            return headerName;
        }

        public void setHeaderName(String headerName) {
            this.headerName = headerName;
        }

        public String getHeaderValue() {
            return headerValue;
        }

        public void setHeaderValue(String headerValue) {
            this.headerValue = headerValue;
        }

        public boolean isPre() {
            return pre;
        }

        public void setPre(boolean pre) {
            this.pre = pre;
        }

        public boolean isPost() {
            return post;
        }

        public void setPost(boolean post) {
            this.post = post;
        }
    }
}
