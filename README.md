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

## 项目功能 ##
- 基本信息管理，油卡管理，用车管理，车辆异动管理，车辆维护管理，车辆运行管理，驾驶员管理，安全管理，车辆维保管理，报表图形统计管理，数据字典管理，系统管理，提醒功能管理等13个功能模块。
- 该项目有一般的审批流程，能进行图片，文件的上传和下载，可以进行报表打印和导出。权限实现了细粒度的权限动态分配
