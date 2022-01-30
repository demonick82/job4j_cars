package ru.job4j.cars.servlet;

import ru.job4j.cars.model.User;
import ru.job4j.cars.store.HBmStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myPosts")
public class MyPostsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
            req.setAttribute("posts", HBmStore.instOf().findPostsForUser(user.getEmail()));
            req.getRequestDispatcher("myPosts.jsp").forward(req, resp);
    }
}
