package ru.job4j.cars.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.cars.model.Photo;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.store.HBmStore;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@WebServlet("/uploadPhoto")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        Photo photo = null;
        Post post = HBmStore.instOf().findPostById(id);
        try {
            List<FileItem> items = upload.parseRequest(req);
            String path = "C:/imagesCar" + File.separator + req.getParameter("id");
            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdir();
            }
            for (FileItem item : items) {
                System.out.println(item);
                if (!item.isFormField()) {
                    File file = new File(folder + File.separator + item.getName());
                    photo = Photo.of("", file.toString().replace("\\", "/"), true);
                    System.out.println(photo);
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        out.write(item.getInputStream().readAllBytes());
                    }
                }
            }
            HBmStore.instOf().deleteAllNotExistPhotos(post);
            HBmStore.instOf().addPhoto(post, photo);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/myPosts");

    }
}