package com.mkcloud.pubservicegateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author lzz
 * @date 2020/2/2 - 15:08
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");

        // 判断jwt是否合法，没有jwt就跳转
        // 解析jwt增加参数
        // 唯一的biz_id 雪花算法
        // 响应头带上时间
        // 打印日志
        // 计算耗时

        if (token == null || token.isEmpty()) {
            ServerHttpResponse response = exchange.getResponse();

            Map<String, Object> responseData = Maps.newHashMap();
            responseData.put("code", 401);
            responseData.put("message", "非法请求");
            responseData.put("cause", "Token is empty");

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                byte[] data = objectMapper.writeValueAsBytes(responseData);


                //输出错误信息到页面

                DataBuffer buffer = response.bufferFactory().wrap(data);
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                response.getHeaders().add("Content-Type","application/json:charset=UTF-8");
                return response.writeWith(Mono.just(buffer));

            }catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return -21;
    }
}
