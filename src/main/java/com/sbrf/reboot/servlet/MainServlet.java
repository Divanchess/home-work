package com.sbrf.reboot.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    private AtomicInteger visitCounter = new AtomicInteger(0);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        // Avoid favicon.ico request
        printWriter.println("<link rel=\"icon\" href=\"data:,\">");
        if (username == null) {
            printWriter.println("Привет, Anonymous");
        } else {
            printWriter.println("Привет, " + username);
        }
        printWriter.println("Страница была посещена: " + visitCounter.addAndGet(1) + " раз");
        printWriter.close();
    }
}
