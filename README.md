# Spring Boot Project

基于 Spring Boot 2.7 + Java 8 的后端项目模板

## 技术栈

- **Spring Boot**: 2.7.18
- **Java**: 1.8
- **Maven**: 构建工具
- **MyBatis Plus**: ORM 框架
- **MySQL**: 数据库
- **Redis**: 缓存
- **Knife4j**: API 文档

## 项目结构

```
src
├── main
│   ├── java
│   │   └── com.yourname.project
│   │       ├── ProjectApplication.java    # 启动类
│   │       ├── common                     # 通用类
│   │       ├── config                     # 配置类
│   │       ├── controller                 # 控制器
│   │       ├── entity                     # 实体类
│   │       ├── mapper                     # 数据访问层
│   │       └── service                    # 服务层
│   └── resources
│       ├── application.yml                # 配置文件
│       └── mapper                         # MyBatis XML
└── test                                   # 测试代码
```

## 快速开始

1. 配置数据库（修改 `application.yml`）
2. 启动项目：运行 `ProjectApplication.main()`
3. 访问 API 文档：http://localhost:8080/doc.html

## 接口说明

- 健康检查：`GET /health`
- API 文档：`/doc.html`
