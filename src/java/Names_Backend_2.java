/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
public class Names_Backend_2 extends HttpServlet {

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
        RequestDispatcher rd_return = request.getRequestDispatcher("./Names.jsp");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Names_Backend_2</title>");
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet Names_Backend_2 at " + request.getContextPath() + "</h1>");

            out.println("        <div id=\"header\" style=\"position: fixed; top: 0.5%; width: 100%;\">\n"
                    + "            <h1 style=\"color: blue; font-family: cursive;\" align=\"center\">Pustak Ni Parab</h1>\n"
                    + "        </div>");

            String sql;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pustak_ni_parab", "root", "");
                Statement st = con.createStatement();

                sql = "SELECT `Serial_No`, `First_Name`, `Last_Name`, `Block/Flat_No`, `Street_Name`, `Locality/Area`, `Contact_No` FROM `names`";

                ResultSet rs = st.executeQuery(sql);
                if (rs.first()) {

                    out.println("<div align=\"center\" id=\"names_2\" style=\"background-color: bisque; margin-top: 7%;\">\n"
                            + "\n"
                            + "            <form id=\"names_2\" action=\"./Names.jsp\" method=\"post\">\n"
                            + "                <table style=\"margin-top: 5%; width: 98%; border-width: thin;\" border=\"0\">\n"
                            + "                    <tr>\n"
                            + "                        <th align=\"center\">Serial No</th>\n"
                            + "                        <th align=\"center\" colspan=\"2\">Full Name</th>\n"
                            + "                        <th align=\"center\">Block/Flat No</th>\n"
                            + "                        <th align=\"center\">Street Name</th>\n"
                            + "                        <th align=\"center\">Locality/Area</th>\n"
                            + "                        <th align=\"center\">Contact No</th>\n"
                            + "                    </tr>");

                    do {
                        out.println("<tr>");
                        for (int i = 1; i <= 7; i++) {
                            out.println("<td ");

                            switch (i) {
                                case 2:
                                    out.println("align=\"right\"> ");
                                    break;
                                case 3:
                                    out.println("align=\"left\"> ");
                                    break;
                                default:
                                    out.println("align=\"center\">");
                                    break;
                            }

                            out.println(rs.getString(i) + "</td>");
                        }
                        out.println("</tr>");
                    } while (rs.next());

                     out.println("<td colspan=\"7\" align=\"center\" style=\"height: 40px\"><input type=\"submit\" value=\"OK\" style=\"margin: 0.5%; border-radius: 10px; font-weight: bold; font-size: medium; color: green;\"/></td>"
                            + "</tr>");
                    
                    out.println("</table></form>");
                } else {
                    request.setAttribute("data", "No Record Found");
                    rd_return.forward(request, response);
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
