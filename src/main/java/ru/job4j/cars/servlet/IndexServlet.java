package ru.job4j.cars.servlet;

import ru.job4j.cars.repository.PostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("posts", PostRepository.instOf().findAllPosts());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
