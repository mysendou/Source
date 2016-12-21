package com.jeff.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PeeperServlet
 */
@WebServlet("/PeeperServlet")
public class PeeperServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Peeper</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Peeper!</h1>");

        try {
            List<String> allPeeps = PeeperServletContextListener.DATA_STORE.findAllPeeps();
            for (String peep : allPeeps) {
                out.println(peep);
                out.print("<br/><br/>");
            }
        } catch (Exception e) {
            throw new ServletException("Error listing peeps", e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
