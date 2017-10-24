# car_producton
这是一个采用SSM(Spring/SpringMVC/Mybatis/shiro)+jQuery EasyUI架构的机动车信息管理系统。（数据库私信我：1135803637@qq.com）

## 项目技术架构(Spring+SpringMVC+Mybatis） ##
- Maven
- Spring（IOC DI AOP 声明式事务处理）
- SpringMVC（支持Restful风格）
- Hibernate Validator（参数校验）
- Mybatis（最少配置方案）
- jQuery EasyUI开发前端页面，利用jQuery文件上传插件实现拖拽上传的效果并对文件类型、大小、数量进行控制；利用search-box实现查找功能
- [Druid（数据源配置 sql防注入 sql性能监控)](http://wosyingjun.iteye.com/blog/2306139)
- 统一的异常处理
- JSP JSTL JavaScript
- shiro权限控制,结合ajax实现了异步认证与异步授权，同时实现了细粒度的权限动态分配（到按钮级别）
- kindeditor富文本编辑器，处理图片上传和富文本编辑<!--more-->
