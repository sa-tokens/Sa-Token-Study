# satoken-Dismantling

## 介绍
尝试分析sa-token框架中用到的技术
1. 按顺序打开目录
2. 阅读说明文件
3. 阅读子文件夹内maven项目源码

## sa-token 鉴权触发方式
- 调用方法后
- 配置注解拦截并检测到注解后
- 配置路由拦截并检测到路由匹配后

## sa-token 鉴权过程
1. 从请求中的各种方式内尝试获取token
2. 根据token获取对应用户id等唯一信息
3. 根据用户id判断当前用户是否拥有此权限或角色
4. 通过则放行, 否则抛出异常

## sa-token 绑定用户数据
查看sa-token数据缓存的dao接口, 里面最主要的数据存储方法是set(String key, String value, long timeout)

每个用户都有唯一的登录id, key可以用它来作为键, 从而保存此用户的SaSession对象

---

问: 等等, 如果是多用户体系不就重复了吗?

答: 那就把不同账号体系的类型标识加到id前面, 这样就算id重复了, 类型也不会重复

---

问: 那就只能存储一个session了, 如果每个用户需要自定义自己的配置怎么办?

答: 也是, 那就再加一个前缀, 标识这个是session, 这个是tokenName, 这个是token最后操作时间等等

---

具体有哪些数据存储的键, 进入sa-token-core模块下, cn.dev33.satoken.stp包下, StpLogic类内, 全文搜索关键词: 返回相应key

