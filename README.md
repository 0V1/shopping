# shopping
购物网站demo 
（持续补充...）QQ908247035

环境说明：
64位：eclipse-mars，jdk1.7.0_75，tomcat-7.0.69，mysql5.6.24，SQLyog，chrome，redis3.2.1
技术说明：
ssm+maven+redis
项目说明：
1.shopping-parent是一个pom项目是所有项目的父目录，聚合子项目和一些jar配置
2.shopping-common是一个jar项目，将会包含一些常用工具类和一些公共的文件
3.shopping-manager是一个pom项目是后台管理的各个项目的父目录集成于shopping-parent，聚合后台管理
4.shopping-portal是一个pom项目是前台管理系统 pc端/android端/ios端/微商城
技术点
1.异步树形结构菜单 easyUI的树结构+ajax异步请求
2.图片上传ftp 使用到ftp专门存放图片，分布式部署时前台页面访问图片时候直接就访问ftp路径，避免了多个容器之间额资源不共享的问题。
3.helper分页插件 仅适用mybatis。
4.json模板 管理复杂的商品和规格关系时自定义商品类目使用的规格模板，生成json模板，引用的时候预留一个隐藏位来根据选择的模板异步加载规格参数，这样在数据库中存入的数据很简洁，查询的时候可以避免复杂的表关联
