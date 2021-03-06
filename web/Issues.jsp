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
            int ser_no = 0, i = 1, id;
            String bk_nm, pr, ap;
            boolean getid = false;
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
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (Exception ex) {
                id = 0;
                getid = false;
            }
            try {
                bk_nm = request.getParameter("bk_nm").toString();
            } catch (Exception ex) {
                bk_nm = "";
            }
            try {
                pr = request.getParameter("pr").toString();
            } catch (Exception ex) {
                pr = "";
            }
            try {
                ap = request.getParameter("ap").toString();
            } catch (Exception ex) {
                ap = "";
            }
        %>

        <div id = "header" style = "position: fixed; top: 0.5%; width: 100%;">
            <h1 style="color: blue; font-family: cursive;" align="center">Pustak Ni Parab</h1>
        </div>

        <div align="center" id="links" style="position: fixed; top: 12%; width: 100%; background-color: white;">

            <span style="margin-right: 2%; font-size: larger; font-weight: bold;">LINKS:</span>

            <a style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; border-style: none; text-decoration: underline; background-color: white; font-size: medium; color: black;">Issues</button></a>
            <strong>|</strong>
            <a href="./Return.jsp" style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; font-size: medium;  color: black;">Return</button></a>
            <strong>|</strong>
            <a href="./Search_Book.jsp" style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; font-size: medium; color: black;">Search By Book Name</button></a>
            <strong>|</strong>
            <a href="./Names.jsp" style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; font-size: medium; color: black;">Names</button></a>

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
                        <th colspan="2"><hr></th>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Book Name:</th>
                        <td align="left" style="margin-left: 2%;">
                            <input type="text" name="book_name" id="book_name"
                                   <%
                                       if (!(bk_nm.isEmpty())) {
                                           out.print(" value=\"" + bk_nm.trim().toString() + "\"");
                                       }
                                   %>
                                   autofocus required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Price:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="number" name="price" id="price"
                                   <%
                                       if (!(pr.isEmpty())) {
                                           out.print(" value=\"" + pr.trim().toString() + "\"");
                                       }
                                   %>
                                   style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Author/Publication:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="auth_pub" id="auth_pub"
                                   <%
                                       if (!(ap.isEmpty())) {
                                           out.print(" value=\"" + ap.trim().toString() + "\"");
                                       }
                                   %>
                                   style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2"><hr></th>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Select ID:</th>
                        <td align="left" style="margin-left: 2%">
                            <select name="sel_name" style="padding: 2%;" onchange="getname()" id="sel_name">
                                <option value="0_0"
                                        <%                                            if (id == 0) {
                                                out.print(" selected");
                                            }
                                        %>
                                        >Select Name</option>
                                <%
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pustak_ni_parab", "root", "");
                                        Statement st = con.createStatement();

                                        String sql = "SELECT * FROM `names`";
                                        ResultSet rs = st.executeQuery(sql);
                                        if (rs.next()) {
                                            do {
                                                out.print("<option value=\"" + rs.getInt(1) + "\"");
                                                if (id == rs.getInt(1)) {
                                                    out.print(" selected");
                                                    getid = true;
                                                }
                                                out.println(">" + rs.getInt(1) + "</option>");
                                            } while (rs.next());
                                        }

                                %>
                                <option value="-2"
                                        <%if (id == -2) {
                                                out.print(" selected");
                                            }
                                        %>
                                        >Other</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Issuer Name:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="issuer_name"
                                   <%
                                       sql = "SELECT * FROM `names` WHERE `Serial_No` = " + id;
                                       rs = st.executeQuery(sql);
                                       rs.next();

                                       if (getid) {
                                           out.print(" value=\"" + rs.getString(2) + " " + rs.getString(3) + "\"");
                                       }
                                   %>
                                   required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Issuer Address:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="issuer_add"
                                   <%
                                       if (getid) {
                                           out.print(" value=\"" + rs.getString(4) + ", " + rs.getString(5) + ", " + rs.getString(6) + "\"");
                                       }
                                   %>
                                   style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Issuer Contact No:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="number" name="issuer_cont" id="issuer_cont"
                                   <%
                                       if (getid) {
                                           out.print(" value=\"" + rs.getString(7) + "\"");
                                       }
                                   %>
                                   style="padding: 2%;"/>
                            <%
                                } catch (Exception ex) {
                                    out.println(ex.toString());
                                }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2"><hr></th>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Issue Date:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" onfocus="ins_date()" name="issue_date" id="issue_date" required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" style="height: 40px">
                            <input type="submit" value="Submit" style="border-radius: 10px; font-weight: bold; padding: 2%; font-size: medium;"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" style="color: red;">
                            <%                                String data = null;
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
