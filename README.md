# xiaoshuai

# Springboot学习笔记
## 登陆git获取用户信息
##配置分离
  使用配置文件设置参数：在properties文件或者yum文件中使用key=value的形式存储值
  获取参数：使用@Value("${key}") 来给属性注入
    注意：key必须要与变量名称一致否则启动报错
##细说session和cookie
##spring boot 整合mybatis
注意配置数据源有个坑
datasource下面是username，不是data-username
1、@Mapper注解 在mapper接口使用该注解
   方法中就能使用@insert 等增删改查对应的注解
2、@Results






  