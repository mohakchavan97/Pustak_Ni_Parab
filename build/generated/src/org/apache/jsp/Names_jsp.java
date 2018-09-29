package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class Names_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Names</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"Names.js\">\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            int ser_no = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pustak_ni_parab", "root", "");
                Statement st = con.createStatement();

                String sql = "SELECT * FROM `names`";
                ResultSet rs = st.executeQuery(sql);
                if (!rs.wasNull()) {
                    rs.last();
                    ser_no = rs.getInt(1);
                    rs.close();
                }
                st.close();
                con.close();
            } catch (Exception ex) {
                out.println("Exception Caught " + ex);
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <div id = \"header\" style = \"position: fixed; top: 0.5%; width: 100%;\">\n");
      out.write("            <h1 style=\"color: blue; font-family: cursive;\" align=\"center\">Pustak Ni Parab</h1>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div align=\"center\" id=\"links\" style=\"position: fixed; top: 12%; width: 100%; background-color: white;\">\n");
      out.write("\n");
      out.write("            <span style=\"margin-right: 2%; font-size: larger; font-weight: bold;\">LINKS:</span>\n");
      out.write("\n");
      out.write("            <button style=\"margin-left: 1%; margin-right: 1%; border-radius: 8px;\"><a href=\"./Issues.jsp\" style=\"text-decoration: none; font-size: medium; color: black;\">Issues</a></button>\n");
      out.write("            <strong>|</strong>\n");
      out.write("            <button style=\"margin-left: 1%; margin-right: 1%; border-radius: 8px;\"><a href=\"./Return.jsp\" style=\"text-decoration: none; font-size: medium; color: black;\">Return</a></button>\n");
      out.write("            <strong>|</strong>\n");
      out.write("            <button style=\"margin-left: 1%; margin-right: 1%; border-radius: 8px;\"><a href=\"./Search_Book.jsp\"  style=\"text-decoration: none; font-size: medium; color: black;\">Search By Book Name</a></button>\n");
      out.write("            <strong>|</strong>\n");
      out.write("            <button style=\"margin-left: 1%; margin-right: 1%; border-radius: 8px; border-style: none; text-decoration: underline; background-color: white;\" disabled><a  style=\"font-size: medium; color: black;\">Names</a></button>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div align=\"center\" id=\"record_names\" style=\"background-color: bisque; margin-top: 10%;\">\n");
      out.write("\n");
      out.write("            <form id=\"name\" action=\"./Names_Backend\" onsubmit=\"return validation()\" method=\"post\">\n");
      out.write("                <table style=\"margin-top: 5%;\"  cellpadding=\"3%\">\n");
      out.write("                    <caption style=\"margin-top: 2%; margin-bottom: 1%; font-weight: bold; font-size: larger\">NAMES</caption>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"right\" style=\"margin-right: 2%;\">Serial No:</th>\n");
      out.write("                        <td align=\"left\" style=\"margin-left: 2%;\">\n");
      out.write("                            <input type=\"text\" style=\"background-color: #cccccc; padding: 2%; text-align: center; font-size: medium;\" readonly name=\"serial_no\" value=\"");
      out.print((ser_no + 1));
      out.write("\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"2\"><hr></th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"left\">Full Name</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"right\" style=\"margin-right: 2%;\">First Name:</th>\n");
      out.write("                        <td align=\"left\" style=\"margin-left: 2%;\">\n");
      out.write("                            <input type=\"text\" name=\"f_name\" autofocus required style=\"padding: 2%;\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"right\" style=\"margin-right: 2%;\">Last Name:</th>\n");
      out.write("                        <td align=\"left\" style=\"margin-left: 2%\">\n");
      out.write("                            <input type=\"text\" name=\"l_name\" autofocus required style=\"padding: 2%;\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"2\"><hr></th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"left\">Address</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"right\" style=\"margin-right: 2%;\">Block/Flat No.:</th>\n");
      out.write("                        <td align=\"left\" style=\"margin-left: 2%\">\n");
      out.write("                            <input type=\"text\" name=\"blk_flat\" style=\"padding: 2%;\" required/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"right\" style=\"margin-right: 2%;\">Street Name:</th>\n");
      out.write("                        <td align=\"left\" style=\"margin-left: 2%\">\n");
      out.write("                            <input type=\"text\" name=\"strt_name\" required style=\"padding: 2%;\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"right\" style=\"margin-right: 2%;\">Locality/Area:</th>\n");
      out.write("                        <td align=\"left\" style=\"margin-left: 2%\">\n");
      out.write("                            <input type=\"text\" name=\"local_area\" value=\"Isanpur\" required style=\"padding: 2%;\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"2\"><hr></th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"right\" style=\"margin-right: 2%;\">Contact No:</th>\n");
      out.write("                        <td align=\"left\" style=\"margin-left: 2%\">\n");
      out.write("                            <input type=\"number\" name=\"cont_no\" id=\"cont_no\" required style=\"padding: 2%;\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"2\" align=\"center\" style=\"height: 40px\">\n");
      out.write("                            <input type=\"submit\" value=\"Submit\" style=\"border-radius: 10px; font-weight: bold; padding: 2%; font-size: medium;\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"2\" align=\"center\" style=\"color: red;\">\n");
      out.write("                            ");

                                String data = null;
                                try {
                                    data = (request.getAttribute("data")).toString();
                                } catch (Exception ex) {
                                }
                                if (data != null) {
                                    out.println(data);
                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
