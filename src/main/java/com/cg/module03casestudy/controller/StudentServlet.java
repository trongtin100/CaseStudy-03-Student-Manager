package com.cg.module03casestudy.controller;

import com.cg.module03casestudy.model.Student;
import com.cg.module03casestudy.service.StudentService;
import com.cg.module03casestudy.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentServlet",
        urlPatterns = {"/","/students", "/student/add","/student/details",
                "/student/edit", "/student/remove"})
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentService studentService = null;

    @Override
    public void init() throws ServletException {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "/":
            case "/students":
                req.setAttribute("students", studentService.findAll());
                req.getRequestDispatcher("/WEB-INF/view/student/index.jsp").forward(req, resp);
                break;

            case "/student/add":
                req.getRequestDispatcher("/WEB-INF/view/student/add.jsp").forward(req, resp);
                break;
            case "/student/details":
                int detailId = Integer.parseInt(req.getParameter("stuID"));
                req.setAttribute("students", studentService.findById(detailId));
                req.getRequestDispatcher("/WEB-INF/view/student/detail.jsp").forward(req, resp);
                break;
            case "/student/edit":
                req.setAttribute("students", studentService.findAll());
                int editId = Integer.parseInt(req.getParameter("stuID"));
                req.setAttribute("students", studentService.findById(editId));
                req.getRequestDispatcher("/WEB-INF/view/student/edit.jsp").forward(req, resp);
                break;
            case "/student/remove":
                int removeId = Integer.parseInt(req.getParameter("stuID"));
                studentService.remove(removeId);
                resp.sendRedirect(req.getContextPath()+"/students");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        String stuIDStr = req.getParameter("stuID");
        Integer stuID = (stuIDStr != null) ? Integer.parseInt(stuIDStr) : null;
        String namestu = req.getParameter("namestu");
        String dateofbirth= req.getParameter("dateofbirth");
        String email    = req.getParameter("email");
        String address  = req.getParameter("address");

        Student student = new Student(stuID, namestu, dateofbirth, email,address);

        switch (action) {
            case "/student/add":
                studentService.save(student);
                resp.sendRedirect(req.getContextPath() + "/students");
                break;
            case "/student/edit":
                student.setStuID(stuID);
                studentService.update(stuID, student);
                resp.sendRedirect(req.getContextPath() + "/students");
                break;

        }
    }
}
