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
public class Return_Backend extends HttpServlet {

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

        StringBuffer sb=request.getRequestURL();
        RequestDispatcher rd_return = request.getRequestDispatcher("./Return.jsp");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Return_Backend</title>");

            out.println("<script type=\"text/javascript\">"
                    + "function goback(){"
                    + "location.href=\"./Return.jsp\";"
//                    + "location.href=\"http://localhost:8084/Pustak_Ni_Parab/Return.jsp\";"
//                    + "location.href=\""+sb.replace(sb.lastIndexOf("/"), sb.length(), "/Return.jsp\";")
                    + "}"
                    + "</script>");

            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet Return_Backend at " + request.getContextPath() + "</h1>");

            out.println("        <div id=\"header\" style=\"position: fixed; top: 0.5%; width: 100%;\">\n"
                    + "            <h1 style=\"color: blue; font-family: cursive;\" align=\"center\">Pustak Ni Parab</h1>\n"
                    + "        </div>");

            String sql, serial = request.getParameter("serial_no");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pustak_ni_parab", "root", "");
                Statement st = con.createStatement();

                sql = "SELECT `Serial_No`, `Book_Name`, `Price`, `Author/Publication`, `Issuer _Name`, `Issuer_Address`, `Issuer_Contact_Info`, `Issue_Date`, `Returned` FROM `issues` WHERE `Serial_No` = " + serial;

                boolean status = false;
                ResultSet rs = st.executeQuery(sql);
                if (rs.first()) {

                    out.println("<div align=\"center\" id=\"returns_2\" style=\"background-color: bisque; margin-top: 7%;\">\n"
                            + "\n"
                            + "            <form id=\"returns_2\" action=\"./Return_Backend_2\" onreset=\"goback()\" method=\"post\">\n"
                            + "                <table style=\"margin-top: 5%; width: 98%; border-width: thin;\" border=\"0\">\n"
                            + "                    <tr>\n"
                            + "                        <th align=\"center\">Serial No</th>\n"
                            + "                        <th align=\"center\">Book Name</th>\n"
                            + "                        <th align=\"center\">Price</th>\n"
                            + "                        <th align=\"center\">Author/Publication</th>\n"
                            + "                        <th align=\"center\">Issuer Name</th>\n"
                            + "                        <th align=\"center\">Issuer Address</th>\n"
                            + "                        <th align=\"center\">Contact No</th>\n"
                            + "                        <th align=\"center\">Issue Date</th>\n"
                            + "                    </tr>");

                    do {
                        out.println("<tr>");
                        for (int i = 0; i < 8; i++) {
                            out.println("<td align=\"center\">" + rs.getString(i + 1) + "</td>");
                        }
                        if (rs.getString(9).contentEquals("YES")) {
                            status = true;
                        }
                        out.println("</tr>");
                    } while (rs.next());
                    out.print("<tr>"
                            + "<td colspan=\"4\" align=\"center\" style=\"height: 40px\"><input type=\"submit\" value=\"Confirm\" ");
                    if (status) {
                        out.print("disabled");
                    }
                    out.println(" style=\"margin: 0.5%; border-radius: 10px; font-weight: bold; font-size: medium; color: green;\"/>");
                    if (status) {
                        out.print("<span style=\"color: red;\"> Book Already Returned</span>");
                    }
                    out.println("</td>");
                    out.println("<td colspan=\"4\" align=\"center\" style=\"height: 40px\"><input type=\"reset\" value=\"Cancel\" style=\"margin: 0.5%; border-radius: 10px; font-weight: bold; font-size: medium; color: red;\"/></td>"
                            + "</tr>");
                    out.println("<tr><td style=\" border: hidden;\"><input type=\"hidden\" name=\"serial\" value=\"" + serial + "\"/></td></tr>");
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
