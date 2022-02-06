package ru.job4j.cars.servlet;

import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        User tmpUser = UserRepository.instOf().findUserByEmail(email);
        if (tmpUser == null) {
            User user = User.of(name, email, phone, password);
            UserRepository.instOf().saveUser(user);
            HttpSession sc = req.getSession();
            sc.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/index");
        } else {
            req.setAttribute("error", "Пользователь с таким email уже существует");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
