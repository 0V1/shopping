# shopping
购物网站demo 
（持续补充...）QQ908247035

环境说明：
64位：eclipse-mars，jdk1.7.0_75，tomcat-7.0.69，mysql5.6.24，SQLyog，chrome，redis3.2.1，maven3.2.5
技术说明：
ssm+maven+redis+mysql
项目说明：
1.shopping-parent是一个pom项目是所有项目的父目录，聚合子项目和一些jar配置
2.shopping-common是一个jar项目，将会包含一些常用工具类和一些公共的文件
3.shopping-manager是一个pom项目是后台管理的各个项目的父目录集成于shopping-parent，聚合后台管理
4.shopping-portal是一个war项目是前台管理系统 pc端/android端/ios端/微商城
5.shopping-rest是一个war项目是服务层系统 主要处理portal系统访问过来的请求，以json形式交互
6.shopping-sso是一个war项目是单点登录系统 主要为各个系统提供统一的token，以达到一处登录多处使用。
技术点
1.异步树形结构菜单 easyUI的树结构+ajax异步请求
2.图片上传ftp 使用到ftp专门存放图片，分布式部署时前台页面访问图片时候直接就访问ftp路径，避免了多个容器之间额资源不共享的问题。
3.helper分页插件 仅适用mybatis。
4.json模板 管理复杂的商品和规格关系时自定义商品类目使用的规格模板，生成json模板，引用的时候预留一个隐藏位来根据选择的模板异步加载规格参数，这样在数据库中存入的数据很简洁，查询的时候可以避免复杂的表关联
5.jsonp 跨域请求，不在同一域名和端口的请求，以请求其他系统的js代码片段形式访问，响应的时候以返回js代码片段中包含json数据的形式，返回后会立刻执行该js，所以就可以间接的请求道json数据并加载
6.httpClient 模拟浏览器的各种请求（get/post..），portal以httpClient的形式请求rest加载json数据有利于seo优化，页面都是动态加载。
7.redis 作为缓存，使用注解方式，增加到manager-web和rest系统中，可以组成集群缓存，test中已测试。
8.单点登录 提供一个专门服务登录的系统，客户登录后将生成安全令牌，安全令牌将放入redis中设置有效时间（还会提供一个方法使用一次刷新一次有效时间），返回的token将放入cookie中，然后cookie共享，达到单点登录的效果。
