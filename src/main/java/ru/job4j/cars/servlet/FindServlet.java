package ru.job4j.cars.servlet;

import ru.job4j.cars.repository.PostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findPosts")

public class FindServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        int markId = Integer.parseInt(req.getParameter("mark"));

        long startPrice = Long.parseLong(req.getParameter("priceStart"));
        long endPrice = Long.parseLong(req.getParameter("priceFinish"));

        int startYear = Integer.parseInt(req.getParameter("yearStart"));
        int endYear = Integer.parseInt(req.getParameter("yearFinish"));

        int carBodyId = Integer.parseInt(req.getParameter("carBody"));
        int transmissionId = Integer.parseInt(req.getParameter("transmission"));

        boolean withPhoto = req.getParameter("withPhoto") != null;
        String driveUnit = req.getParameter("driveUnit");

        req.setAttribute("posts", PostRepository.instOf().findPosts(markId, startPrice, endPrice, startYear,
                endYear, carBodyId, transmissionId, driveUnit, withPhoto));

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
