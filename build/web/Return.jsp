<%-- 
    Document   : Return
    Created on : 1 Aug, 2018, 11:24:13 PM
    Author     : Mohak Chavan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return</title>
    </head>
    <body>

        <div id="header" style="position: fixed; top: 0.5%; width: 100%;">
            <h1 style="color: blue; font-family: cursive;" align="center">Pustak Ni Parab</h1>
        </div>

        <div align="center" id="links" style="position: fixed; top: 12%; width: 100%; background-color: white;">

            <span style="margin-right: 2%; font-size: larger; font-weight: bold;">LINKS:</span>
            
            <a href="./Issues.jsp" style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; font-size: medium; color: black;">Issues</button></a>
            <strong>|</strong>
            <a style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; background-color: white; border-style: none; text-decoration: underline; font-size: medium;  color: black;">Return</button></a>
            <strong>|</strong>
            <a href="./Search_Book.jsp" style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; font-size: medium; color: black;">Search By Book Name</button></a>
            <strong>|</strong>
            <a href="./Names.jsp" style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; font-size: medium; color: black;">Names</button></a>
            
        </div>

        <div align="center" id="returns" style="background-color: bisque; margin-top: 10%;">

            <form id="returns" action="./Return_Backend" method="post">
                <table style="margin-top: 5%;"  cellpadding="3%">
                    <caption style="margin-top: 2%; margin-bottom: 1%; font-weight: bold; font-size: larger">RETURN</caption>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Enter Serial No:</th>
                        <td align="left" style="margin-left: 2%;">
                            <input type="number" name="serial_no" id="serial_no" autofocus required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" style="height: 40px;">
                            <input type="submit" value="Search" style="border-radius: 10px; font-weight: bold; padding: 2%; font-size: medium;"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" style="color: red;">
                            <%
                                String data = null;
                                try {
                                    data = (request.getAttribute("data")).toString();
                                } catch (Exception ex) {
                                }
                                if (data != null) {
                                    out.println(data);
                                }
                            %>
                        </td>
                    </tr>
                </table>
            </form>

        </div>

    </body>
</html>
