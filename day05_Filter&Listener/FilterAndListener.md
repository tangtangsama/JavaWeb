## Filter 过滤器
1. 过滤器：当客户端访问服务器资源时，过滤器可以将请求拦截下来，并完成一些特殊的功能。
    + 一般用于完成一些通用的功能：登录验证，设置编码，敏感字符过滤等。
2. 使用步骤：创建Filter类，复写其中的三个方法，使用注解设置拦截路径和拦截方式。
3. 过滤器执行流程：执行过滤器-执行放行后的资源-之后放行代码下的其他代码。
4. 过滤器生命周期：
    + init:在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次，用于加载资源。
    + doFilter:每一次请求被拦截资源时，会执行。执行多次。
    + destroy:在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法，只执行一次，用于释放资源。
5. 拦截路径注解配置：
    + 设置dispatcherTypes属性  
        REQUEST：默认值。浏览器直接请求资源时进行过滤  
        FORWARD：转发访问资源时进行过滤  
        INCLUDE：包含访问资源  
        ERROR：错误跳转资源  
        ASYNC：异步访问资源
6.  过滤器链(配置多个过滤器)
   	+ 执行顺序：如果有两个过滤器：过滤器1和过滤器2
   	    1. 过滤器1
   	    2. 过滤器2
   		3. 资源执行
   		4. 过滤器2
   		5. 过滤器1 
   
   	+ 过滤器先后顺序问题：
   	    1. 注解中配置：按照类名的字符串比较规则比较，值小的先执行
   		    + 如： AFilter 和 BFilter，AFilter就先执行了。
   		2. web.xml配置： <filter-mapping>谁定义在上边，谁先执行。
   		
   		
 ## Listener 监听器
 1. 时间监听机制
    + 事件：一件事情
    + 事件源 ：事件发生的地方
    + 监听器 ：一个对象
    + 注册监听：将事件、事件源、监听器绑定在一起。 当事件源上发生某个事件后，执行监听器代码.
 2. 使用步骤
    + 新建listener类
    + 注解配置@WebListener()
    + void contextDestroyed(ServletContextEvent sce) ：ServletContext对象被销毁之前会调用该方法
    + void contextInitialized(ServletContextEvent sce) ：ServletContext对象创建后会调用该方法