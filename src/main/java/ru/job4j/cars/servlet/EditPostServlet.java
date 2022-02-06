package ru.job4j.cars.servlet;

import ru.job4j.cars.model.*;
import ru.job4j.cars.repository.CarBodyRepository;
import ru.job4j.cars.repository.ModelRepository;
import ru.job4j.cars.repository.PostRepository;
import ru.job4j.cars.repository.TransmissionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editPost")
public class EditPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String postId = req.getParameter("id");
        req.setAttribute("post", PostRepository.instOf().findPostById(Integer.parseInt(postId)));
        req.getRequestDispatcher("editPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        req.setCharacterEncoding("UTF-8");
        int markId = Integer.parseInt(req.getParameter("mark"));
        int modelId = Integer.parseInt(req.getParameter("model"));
        int year = Integer.parseInt(req.getParameter("year"));
        long mileage = Long.parseLong(req.getParameter("mileage"));
        String color = req.getParameter("color");
        int carBodyId = Integer.parseInt(req.getParameter("carBody"));
        int transmissionId = Integer.parseInt(req.getParameter("transmission"));
        long price = Long.parseLong(req.getParameter("price"));
        boolean isSale = (req.getParameter("isSale")) != null;
        String desc = req.getParameter("desc");
        String driveUnit = req.getParameter("driveUnit");
        Model model = ModelRepository.instOf().findModelForId(markId, modelId);
        Transmission transmission = TransmissionRepository.instOf().findTransmissionForId(transmissionId);
        CarBoby carBoby = CarBodyRepository.instOf().findCarBodyForId(carBodyId);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        Post post = PostRepository.instOf().findPostById(Integer.parseInt(req.getParameter("id")));

        post.setPrice(price);
        post.setProductionYear(year);
        post.setMileage(mileage);
        post.setColor(color);
        post.setDriveUnit(driveUnit);
        post.setDescription(desc);
        post.setModel(model);
        post.setCarBoby(carBoby);
        post.setTransmission(transmission);
        post.setUser(user);
        post.setSale(isSale);
        PostRepository.instOf().updatePost(post);

        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
