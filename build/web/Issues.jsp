<%-- 
    Document   : Issues
    Created on : 31 Jul, 2018, 2:38:10 PM
    Author     : Mohak Chavan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Issues</title>
        <script type="text/javascript" src="Issues.js">
        </script>
    </head>
    <body>

        <%
            int ser_no = 0,i=1;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pustak_ni_parab", "root", "");
                Statement st = con.createStatement();

                String sql = "SELECT * FROM `issues`";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    rs.last();
                    ser_no = rs.getInt(1);
                }
                rs.close();
                st.close();
                con.close();
            } catch (Exception ex) {
                out.println("Exception Caught");
            }
        %>

        <div id = "header" style = "position: fixed; top: 0.5%; width: 100%;">
            <h1 style="color: blue; font-family: cursive;" align="center">Pustak Ni Parab</h1>
        </div>

        <div align="center" id="links" style="position: fixed; top: 12%; width: 100%; background-color: white;">

            <span style="margin-right: 2%; font-size: larger; font-weight: bold;">LINKS:</span>

            <button style="margin-left: 1%; margin-right: 1%; border-radius: 8px; border-style: none; text-decoration: underline; background-color: white;" disabled><a  style="font-size: medium; color: black;">Issues</a></button>
            <strong>|</strong>
            <button style="margin-left: 1%; margin-right: 1%; border-radius: 8px;"><a href="./Return.jsp" style="text-decoration: none; font-size: medium; color: black;">Return</a></button>
            <strong>|</strong>
            <button style="margin-left: 1%; margin-right: 1%; border-radius: 8px;"><a href="./Search_Book.jsp"  style="text-decoration: none; font-size: medium; color: black;">Search By Book Name</a></button>
            <strong>|</strong>
            <button style="margin-left: 1%; margin-right: 1%; border-radius: 8px;"><a href="./Names.jsp" style="text-decoration: none; font-size: medium; color: black;">Names</a></button>

        </div>

        <div align="center" id="record_data" style="background-color: bisque; margin-top: 10%;">

            <form id="issue" action="./Issues_Background" onsubmit="return validation()" method="post">
                <table style="margin-top: 5%;"  cellpadding="3%">
                    <caption style="margin-top: 2%; margin-bottom: 1%; font-weight: bold; font-size: larger">ISSUES</caption>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Serial No:</th>
                        <td align="left" style="margin-left: 2%;">
                            <input type="text" style="background-color: #cccccc; padding: 2%; text-align: center; font-size: medium;" readonly name="serial_no" value="<%=(ser_no + 1)%>"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Book Name:</th>
                        <td align="left" style="margin-left: 2%;">
                            <input type="text" name="book_name" autofocus required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Price:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="number" name="price" style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Author/Publication:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="auth_pub" style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Issuer Name:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="issuer_name" required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Issuer Address:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="issuer_add" style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Issuer Contact No:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="number" name="issuer_cont" id="issuer_cont" style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Issue Date:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="date" name="issue_date" required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" style="height: 40px">
                            <input type="submit" value="Submit" style="border-radius: 10px; font-weight: bold; padding: 2%; font-size: medium;"/>
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
