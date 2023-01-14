package com.example.mytestservlet;

import java.io.*;

import com.example.mytestservlet.model.User;
import com.example.mytestservlet.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;

@WebServlet(urlPatterns = "/users")
public class MyServlet extends HttpServlet {

    private final ObjectMapper mapper = new ObjectMapper();

    private final UserService userService = new UserService();

    //create
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        var is = req.getInputStream();
        User user = mapper.readValue(is, User.class);
        userService.createNewUser(user);
        var os = resp.getOutputStream();
        mapper.writeValue(os,user);
        }

    //read
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        Long id= Long.valueOf(req.getParameter("id"));
        User user = userService.getUserById(id );

        if (user == null){
            resp.setStatus(404);
            return;
        }

        var os=resp.getOutputStream();
        mapper.writeValue(os,user);
    }

    //update
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id= Long.valueOf(req.getParameter("id"));
        String company=req.getParameter("company");
        User user = userService.getUserById(id);
        user.setCompany(company);
        var os=resp.getOutputStream();
        mapper.writeValue(os,user);
    }

    //delete
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id= Long.valueOf(req.getParameter("id"));

        userService.deleteUser(id);

        var os=resp.getOutputStream();
        mapper.writeValue(os,"user by id "+ id+" has been deleted");
    }

    public void destroy() {
    }
}
