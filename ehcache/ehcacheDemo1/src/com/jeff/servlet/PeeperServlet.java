package com.jeff.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jeff.listener.PeeperServletContextListener;

/**
 * Servlet implementation class PeeperServlet
 */
@WebServlet("/PeeperServlet")
public class PeeperServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PeeperServlet.class);

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Do post method");
        String peepText = request.getParameter("peep");

        try {

          PeeperServletContextListener.DATA_STORE.addPeep(peepText);
          response.sendRedirect("peep");

        } catch (Exception e) {
          throw new ServletException("Error saving peep", e);
        }
    }

}
