package com.sbrf.reboot.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ask")
public class MainServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            visitCounter = 1;
        } else {
            visitCounter++;
        }
        session.setAttribute("visitCounter", visitCounter);
        String username = request.getParameter("name");
        response.setContentType("txt/html");
        PrintWriter printWriter = response.getWriter();
        if (username == null) {
            printWriter.write("Привет, Anonymous");
        } else {
            printWriter.write("Привет, " + username);
        }
        printWriter.write("Страница была посещена: " + visitCounter + " раз");
        printWriter.close();
    }
}
