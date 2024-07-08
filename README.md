# My-RPC-Framework

## 简介

My-RPC-Framework 是一个基于 Java 的 RPC 框架，使用 Netty 进行通信，支持多种序列化方式和注册中心，集成 Spring Boot 实现自动注册和消费服务。

## 技术栈

- Java
- Netty
- Zookeeper
- Nacos
- Spring Boot

## 技术点

1. 实现基于 Netty 和 Socket 两种方式的通信
2. 自定义 RPC 通信协议，自定义编解码器，实现 JDK、JSON、Kryo、Protostuff 和 Hessian 五种序列化方式
3. 实现 Netty 心跳机制，保持连接，重用 Channel
4. 实现 Nacos、Zookeeper 两种注册中心
5. 集成 Spring Boot 实现通过注解自动注册、消费服务
6. TODO：压测

## 功能特性

- 多种通信方式：支持 Netty 和传统 Socket 通信
- 多种序列化方式：提供 JDK、JSON、Kryo、Protostuff 和 Hessian 序列化方式
- 心跳机制：通过 Netty 实现心跳检测，保持连接稳定
- 注册中心：支持 Nacos 和 Zookeeper 作为服务注册中心
- Spring Boot 集成：通过注解实现服务的自动注册和消费

## 安装和使用

### 前置条件

- JDK 1.8+
- Maven 3.6+
- Zookeeper（如使用 Zookeeper 作为注册中心）
- Nacos（如使用 Nacos 作为注册中心）
