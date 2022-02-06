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

@WebServlet("/createPost")
public class CreatePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("createPost.jsp").forward(req, resp);
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
        String desc = req.getParameter("desc");
        String driveUnit = req.getParameter("driveUnit");

        Model model = ModelRepository.instOf().findModelForId(markId, modelId);
        Transmission transmission = TransmissionRepository.instOf().findTransmissionForId(transmissionId);
        CarBoby carBoby = CarBodyRepository.instOf().findCarBodyForId(carBodyId);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Post post = Post.of(price, year, mileage, color, driveUnit, desc, false, model, carBoby, transmission, user);
        Photo photo = Photo.of("noPhoto", "C:/imagesCar/no_photo.jpg", false);
        PostRepository.instOf().addPost(post, photo);
        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
