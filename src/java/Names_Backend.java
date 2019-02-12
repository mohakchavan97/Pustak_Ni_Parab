/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohak Chavan
 */
public class Names_Backend extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = request.getRequestDispatcher("./Names.jsp");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Names_Backend</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Names_Backend at " + request.getContextPath() + "</h1>");

            String fname, lname, blkflt, strt, local, cont, sql;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pustak_ni_parab", "root", "");
                Statement st = con.createStatement();

                fname = request.getParameter("f_name").trim().toUpperCase();
                lname = request.getParameter("l_name").trim().toUpperCase();
                blkflt = request.getParameter("blk_flat").trim().toUpperCase();
                strt = request.getParameter("strt_name").trim().toUpperCase();
                local = request.getParameter("local_area").trim().toUpperCase();
                cont = request.getParameter("cont_no").trim().toUpperCase();

                sql = "INSERT INTO `names` (`First_Name`, `Last_Name`, `Block/Flat_No`, `Street_Name`, `Locality/Area`, `Contact_No`) VALUES ('" + fname + "', '" + lname + "', '" + blkflt + "', '" + strt + "', '" + local + "', '" + cont + "')";

                int i = st.executeUpdate(sql);
                if (i > 0) {
                    request.setAttribute("data", "Name Inserted");
                    rd.forward(request, response);
                }

            } catch (IOException | ClassNotFoundException | SQLException | ServletException ex) {
                out.println("Exception Caught");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
