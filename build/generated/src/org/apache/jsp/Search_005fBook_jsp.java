package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Search_005fBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Search Book</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id = \"header\" style = \"position: fixed; top: 0.5%; width: 100%;\">\n");
      out.write("            <h1 style=\"color: blue; font-family: cursive;\" align=\"center\">Pustak Ni Parab</h1>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div align=\"center\" id=\"links\" style=\"position: fixed; top: 12%; width: 100%; background-color: white;\">\n");
      out.write("\n");
      out.write("            <span style=\"margin-right: 2%; font-size: larger; font-weight: bold;\">OTHER LINKS:</span>\n");
      out.write("\n");
      out.write("            <button style=\"margin-left: 1%; margin-right: 1%; border-radius: 8px;\"><a href=\"./Return.jsp\"  style=\"text-decoration: none; font-size: medium; color: black; margin: 5px;\">Return</a></button>\n");
      out.write("            <strong>|</strong>\n");
      out.write("            <button style=\"margin-left: 1%; margin-right: 1%; border-radius: 8px;\"><a href=\"./Issues.jsp\"  style=\"text-decoration: none; font-size: medium; color: black; margin: 5px;\">Issues</a></button>\n");
      out.write("            <strong>|</strong>\n");
      out.write("            <button style=\"margin-left: 1%; margin-right: 1%; border-radius: 8px; border-style: none; text-decoration: underline; background-color: white;\"><a href=\"\" style=\"font-size: medium; color: black; margin: 5px;\">Search By Book Name</a></button>\n");
      out.write("            <strong>|</strong>\n");
      out.write("            <button style=\"margin-left: 1%; margin-right: 1%; border-radius: 8px;\"><a href=\"\"  style=\"text-decoration: none; font-size: medium; color: black; margin: 5px;\">Names</a></button>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div align=\"center\" id=\"search_books\" style=\"background-color: bisque; margin-top: 10%;\">\n");
      out.write("            \n");
      out.write("            <form id=\"search_books\" action=\"./Search_Book_Backend\" method=\"post\">\n");
      out.write("                <table style=\"margin-top: 5%;\" cellpadding=\"3%\">\n");
      out.write("                    <caption style=\"margin-top: 2%; margin-bottom: 1%; font-weight: bold; font-size: larger\">Search Book</caption>\n");
      out.write("                    <tr>\n");
      out.write("                        <th align=\"right\" style=\"margin-right: 2%;\">Enter Book Name:</th>\n");
      out.write("                        <td align=\"left\" style=\"margin-left: 2%;\">\n");
      out.write("                            <input type=\"text\" name=\"book_name\" id=\"book_name\" autofocus required style=\"padding: 2%;\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"2\" align=\"center\" style=\"height: 40px;\">\n");
      out.write("                            <input type=\"submit\" value=\"Search\" style=\"border-radius: 10px; font-weight: bold; padding: 2%; font-size: medium;\"/>\n");
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
      out.write("            \n");
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
