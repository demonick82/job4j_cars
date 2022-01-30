package ru.job4j.cars.servlet;

import ru.job4j.cars.store.HBmStore;
import ru.job4j.cars.store.Store;

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
        Store store = HBmStore.instOf();
        req.setAttribute("posts", store.findAllPosts());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
