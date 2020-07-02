package cn.sucre.web.servlet;

import cn.sucre.domain.User;
import cn.sucre.service.UserService;
import cn.sucre.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();
        // 2.将list存入request中
        request.setAttribute("users",users);
        // 3.转发到list.jsp中
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
