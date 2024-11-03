package com.xwcom.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ author Administrator
 * @ date  2024/11/3
 * <p>
 * 创建javaweb项目，同时添加tomcat到项目中,这里的类都是来自于tomcat的servlet-api.jar包,
 * tomcat 中每个项目默认都会引入这个包
 * 重写 doGet方法，输出Hello, User!
 * <p>
 * <p>
 * 在服务中不能操作成员变量,因为成员变量是共享的,会有线程安全问题
 * 可以使用局部变量
 * <p>
 * load-on-startup: -1  启动时不会实例化，
 * 1-15 或者其他正整数, 启动时实例化该对象的顺序
 * 如果冲突 tomcat 会自动排序
 */

@WebServlet("/user")
public class User extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        String res = "no";
        if (null != username && username.equals("admin")) {
            res = "yes";
        }

        resp.getWriter().write(res);
    }
}
