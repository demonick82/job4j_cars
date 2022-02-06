package ru.job4j.cars.servlet;

import ru.job4j.cars.repository.PostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postId = req.getParameter("id");
        req.setAttribute("post", PostRepository.instOf().findPostById(Integer.parseInt(postId)));
        req.getRequestDispatcher("post.jsp").forward(req, resp);
    }
}
