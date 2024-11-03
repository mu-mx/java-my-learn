# tomcat 教程

    安装之后配置path
    tomcat的配置文件
    编码改为GBK
    tomcat的目录结构

    idea也要配置,加入 tomcat 
    
    application server 选择 tomcat

    web-inf lib存放jar包

    注解代替了xml配置
    @WebServlet("/hello")

# 三层架构

    pojo
    定义数据库的对象,使用 lombok
    @data
    @AllArgsConstructor
    @NoArgsConstructor
    

    dao
    数据库操作对象接口
    impl
    实现类

    service
    服务接口
    impl
    服务接口的实现类


    web - controller
    控制器对象

# 开始处理请求

    baseServlet 反射的工具类

    通过反射调用方法, 找到/ss/{name}方法名字,处理每个请求


    baseDao 通用的处理数据库的方法,里面有增删改查的方法,每个dao都继承这个类



    util/DBUtil 数据库连接工具类,读取配置文件,获取连接,关闭连接

# 场景处理

### session 保存用户信息

    session
        在登录完成之后,将用户信息保存到session中,
        在每个页面中,都可以通过session获取用户信息
        具体代码

    // HttpSession session = req.getSession();
    // session.setAttribute("user", user);

    应用场景
        1. 用户登录
        2. 用户权限

### cookie 保存用户信息

    cookie
        在登录完成之后,将用户信息保存到cookie中,
        在每个页面中,都可以通过cookie获取用户信息,可以做到验证用户是否登录
        具体代码

    // Cookie cookie = new Cookie("user", user.toString());
    // cookie.setMaxAge(60 * 60 * 24 * 7);
    // resp.addCookie(cookie);

    应用场景
        1. 记住密码
        2. 自动登录

### filter 过滤器

    filter
        过滤器,可以在请求到达servlet之前,对请求进行处理
        具体代码

    // @WebFilter("/*")
    // public class EncodingFilter implements Filter {
    //     @Override
    //     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    //         request.setCharacterEncoding("utf-8");
    //         response.setCharacterEncoding("utf-8");
    //         chain.doFilter(request, response);
    //     }
    // }

    应用场景
        1. 编码过滤
        2. 登录验证
        3. 权限验证

### listener 监听器

    listener
        监听器,可以监听到请求的创建和销毁
        具体代码

    // @WebListener
    // public class MyListener implements ServletContextListener {
    //     @Override
    //     public void contextInitialized(ServletContextEvent sce) {
    //         System.out.println("contextInitialized");
    //     }
    //     @Override
    //     public void contextDestroyed(ServletContextEvent sce) {
    //         System.out.println("contextDestroyed");
    //     }
    // }
    
    应用场景
        1. 在项目启动的时候,初始化一些数据
            // 初始化ioc容器, beanFactory , 这个是要从配置文件中读取的配置对象
            BeanFactory beanFactory = new ClassPathXmlApplicationContext();

            ServletContext servletContext = sce.getServletContext();
        
            servletContext.setAttribute("beanFactory", beanFactory);
            
        2. 在项目销毁的时候,释放一些资源

### 事务管理

    事务管理
        事务管理,可以在多个数据库操作中,保证数据的一致性
        具体代码

    一般来说,在service层中,使用事务管理,少用try catch 会吃掉错误不会向上跑出
    
    // 保存连接,保证一个线程中只有一个连接,通过线程来控制事务流
    ThreadLocal threadLocal = new ThreadLocal(); 
    Connection conn = threadLocal.get();
    if (conn == null) {
        // 获取数据库连接,一般是用来控制批量操作
        conn = DBUtil.getConnection();
        threadLocal.set(conn);
    }
    conn.setAutoCommit(false);
    


    // try {
    //     conn.setAutoCommit(false);
    //     // 事务操作
    //     conn.commit();
    // } catch (SQLException e) {
    //     conn.rollback();
    // } finally {
    //     conn.setAutoCommit(true);
    // }

    应用场景
    1. 多个数据库操作
        例子
        1. 一个用户注册,需要在用户表和用户信息表中插入数据, 保证数据的一致性
            // UserDAO userDAO = new UserDAO();            
            // userDAO.add(user);
            // userInfoDAO.add(userInfo);
            // 事务管理
            // conn.commit();
    2. 保证数据的一致性

