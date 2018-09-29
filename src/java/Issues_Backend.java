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
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohak Chavan
 */
public class Issues_Backend extends HttpServlet {

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

        RequestDispatcher rd = request.getRequestDispatcher("./Issues.jsp");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Issues_Background</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Issues_Background at " + request.getContextPath() + "</h1>");

            String book_name, auth_pub, iss_name, iss_add, iss_date, test, sql = null, iss_cont;
            int price = 0;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pustak_ni_parab", "root", "");
                Statement st = con.createStatement();

                out.println("Getting Parameters\n");

                //Enumeration<String> e = request.getParameterNames();
                /*while (e.hasMoreElements()) {
                    out.println("<br/>" + e.nextElement() + "<br/>");
                }*/

                book_name = request.getParameter("book_name");
                book_name = book_name.trim();

                int stat = 0;

                iss_cont = request.getParameter("issuer_cont");

                test = request.getParameter("price");
                if (!test.isEmpty()) {
                    price = Integer.parseInt(request.getParameter("price"));
                    if (!iss_cont.isEmpty()) {
                        stat = 3;   //price !empty and cont !empty
                    } else {
                        stat = 1;   //price !empty and cont empty
                    }
                } else {
                    if (!iss_cont.isEmpty()) {
                        stat = 2;   //price empty and cont !empty
                    } else {
                        stat = 0;   //price empty and cont empty
                    }
                }

                auth_pub = request.getParameter("auth_pub");
                auth_pub = auth_pub.trim();

                iss_name = request.getParameter("issuer_name");
                iss_name = iss_name.trim();

                iss_add = request.getParameter("issuer_add");
                iss_add = iss_add.trim();
                //out.println(iss_add);

                iss_date = request.getParameter("issue_date");
                //out.println(iss_date);

                boolean status = false;

                if (stat == 3) {
                    sql = "INSERT INTO `issues` (`Book_Name`, `Price`, `Author/Publication`, `Issuer _Name`, `Issuer_Address`, `Issuer_Contact_Info`, `Issue_Date`, `time`, `Returned`) VALUES ('" + book_name + "', '" + price + "', '" + auth_pub + "', '" + iss_name + "', '" + iss_add + "', '" + iss_cont + "', '" + iss_date + "', CURRENT_TIMESTAMP, 'NO');";
                    status = true;
                }
                if (stat == 2) {
                    sql = "INSERT INTO `issues` (`Book_Name`, `Price`, `Author/Publication`, `Issuer _Name`, `Issuer_Address`, `Issuer_Contact_Info`, `Issue_Date`, `time`, `Returned`) VALUES ('" + book_name + "', NULL, '" + auth_pub + "', '" + iss_name + "', '" + iss_add + "', '" + iss_cont + "', '" + iss_date + "', CURRENT_TIMESTAMP, 'NO');";
                    status = true;
                }
                if (stat == 1) {
                    sql = "INSERT INTO `issues` (`Book_Name`, `Price`, `Author/Publication`, `Issuer _Name`, `Issuer_Address`, `Issuer_Contact_Info`, `Issue_Date`, `time`, `Returned`) VALUES ('" + book_name + "', '" + price + "', '" + auth_pub + "', '" + iss_name + "', '" + iss_add + "', NULL, '" + iss_date + "', CURRENT_TIMESTAMP, 'NO');";
                    status = true;
                }
                if (stat == 0) {
                    sql = "INSERT INTO `issues` (`Book_Name`, `Price`, `Author/Publication`, `Issuer _Name`, `Issuer_Address`, `Issuer_Contact_Info`, `Issue_Date`, `time`, `Returned`) VALUES ('" + book_name + "', NULL, '" + auth_pub + "', '" + iss_name + "', '" + iss_add + "', NULL, '" + iss_date + "', CURRENT_TIMESTAMP, 'NO');";
                    status = true;
                }

                int i = 0;
                if (status) {
                    i = st.executeUpdate(sql);
                }
                if (i > 0) {
                    request.setAttribute("data", "Record Inserted");
                    rd.forward(request, response);
                }
                st.close();
                con.close();
            } catch (ClassNotFoundException | SQLException ex) {
                out.println("Exception caught.");
                out.println(ex.toString());

            } catch (Exception e) {
                out.println("Global Exception Caught");
                out.println(e.toString());
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
