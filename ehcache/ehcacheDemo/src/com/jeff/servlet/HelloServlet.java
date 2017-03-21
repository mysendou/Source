package com.jeff.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jeff.listener.PeeperServletContextListener;

public class HelloServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = -7420497072832220829L;
    private static final Logger LOGGER = Logger.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("log = do get method");
        System.out.println("do get method");
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
            LOGGER.error("Error listing peeps", e);
            throw new ServletException("Error listing peeps", e);
        }

        out.println("<form name=\"htmlform\" method=\"post\" action=\"peep\">");

        out.println("Enter your peep: <input type=\"text\" name=\"peep\" maxlength=\"142\" size=\"30\"/>");

        out.println("<input type=\"submit\" value=\"Peep!\"/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Do post method");
        String peepText = req.getParameter("peep");

        try {

          PeeperServletContextListener.DATA_STORE.addPeep(peepText);
          resp.sendRedirect("peep");

        } catch (Exception e) {
          throw new ServletException("Error saving peep", e);
        }
    }
}
