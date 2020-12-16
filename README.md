# Gateway

---

[TOC]

---

## 说明

Gateway 是 PaaS 的网关。

Gateway 基于 Spring Cloud Gateway 。

---

## 服务和配置

Gateway 同 PaaS 层的其他微服务一样，注册到 Nacos Server，同时可以使用全局路由和服务名称来自动路由到对应的微服务中。

在 `bootstrap.properties` 文件中配置 nacos config 地址和参数，

在 nacos 配置中心配置服务注册地址和参数

在配置中添加 gateway 相关的功能参数

```properties
# 使用自动发现服务并路由
spring.cloud.gateway.discovery.locator.enabled=true
spring.cloud.gateway.discovery.locator.lowerCaseServiceId=true
# 暴露端点
management.endpoint.gateway.enabled=true
management.endpoints.web.exposure.include=gateway
# 放开跨域
spring.cloud.gateway.globalcors.corsConfigurations.[/**].allowedOrigins=*
spring.cloud.gateway.globalcors.corsConfigurations.[/**].allowedMethods=*
spring.cloud.gateway.globalcors.corsConfigurations.[/**].allowedHeaders=*
```

---

## 调用说明

gateway 网关使用了 spring cloud gateway 官方推荐和提供的 “服务自动路由” 功能。
gateway 和其他微服务一样，注册到 nacos 。
所有 PaaS 外部的请求，经过网关，再到 PaaS 内部的微服务。

使用举例：
原本有一个服务A，HostName(host+port) 为 xxxx ，服务名称为 service-a ，提供一个 uri 为 /api/user/1 的 rest 服务
请求地址原本是：
`http://xxxx/api/user/1`

现在有一个网关G，HostName(host+port) 为 yyyy，那么
PaaS 外部经过网关请求以上服务，请求地址变为：
`http://yyyy/service-a/api/user/1`

区别就是，请求地址的 host 要使用网关的 host，在其后加入一个被调用服务的 服务名称 作为第一级路径，再之后，就是微服务的 rest 资源路径。

---

## 请求验证

经过网关的请求有以下几层验证

### Request Time

Request Header 中应当存放一组键值：

请求的时间，yyyyMMddHHmmss

Time=20190420122000

### Request Sign

Sing=xxxxxx

签名算法：

### Authentication

// TODO

---

## 全局过滤器

### pre

-100 Breaker 熔断过滤器

-90 RequestTime 请求时间

-80 RequestSign 请求签名

-70 CacheRequestBody 缓存 request body

-60 VerifyRequestSign 校验请求签名

-50 TracingId 调用链 ID

-40 Authentication 认证鉴权

-20 RequestBody 修改 request body

-10 RequestLog 记录 request log

0 route

### post

10 ResponseLog 记录 response body

20 ResponseBody 修改 response body

30 SignatureResponse 加签

40 CacheResponseBody 缓存 response body

---

## Reference

[spring-cloud-gateway](https://spring.io/projects/spring-cloud-gateway)
