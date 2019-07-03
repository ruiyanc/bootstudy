#SpringBoot
* 基于约定,大多默认
* 起步依赖,自动配置
    * <parent>:坐标版本控制
* @SpringBootApplication:声明springboot引导类
    * SpringApplication.run():运行引导类,run参数是引导类的字节码对象
* application.yml配置文件
    * 语法:key:value
* 获取配置文件的数据
    * @Value("${name}"):绑定字段
    * @ConfigurationProperties():绑定对象数据,需setget方法
* 整合mybatis
    * application.properties加入数据库信息
    * 别名扫描包:mybatis.type-aliases-package=rui.model
    * 加载mybatis映射文件:mybatis.mapper-locations=classpath:mapper/*Mapper.xml
* 整合Servlet
    * @ServletComponentScan:启动时扫描@WebServlet并实例化
* 文件上传
    * @RestController:该类下方法返回值会自动做json格式转换
* 整合Thymeleaf
    * 