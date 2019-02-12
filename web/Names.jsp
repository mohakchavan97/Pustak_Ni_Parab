<%-- 
    Document   : Names
    Created on : 29 Sep, 2018, 7:58:18 PM
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
        <title>Names</title>
        <script type="text/javascript" src="Names.js">
        </script>
    </head>
    <body>

        <%
            int ser_no = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pustak_ni_parab", "root", "");
                Statement st = con.createStatement();

                String sql = "SELECT * FROM `names`";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    rs.last();
                    ser_no = rs.getInt(1);
                    rs.close();
                }
                st.close();
                con.close();
            } catch (Exception ex) {
                out.println("Exception Caught " + ex.toString());
            }
        %>

        <div id = "header" style = "position: fixed; top: 0.5%; width: 100%;">
            <h1 style="color: blue; font-family: cursive;" align="center">Pustak Ni Parab</h1>
        </div>

        <div align="center" id="links" style="position: fixed; top: 12%; width: 100%; background-color: white;">

            <span style="margin-right: 2%; font-size: larger; font-weight: bold;">LINKS:</span>
            
            <a href="./Issues.jsp" style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; font-size: medium; color: black;">Issues</button></a>
            <strong>|</strong>
            <a href="./Return.jsp" style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; font-size: medium;  color: black;">Return</button></a>
            <strong>|</strong>
            <a href="./Search_Book.jsp" style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; font-size: medium; color: black;">Search By Book Name</button></a>
            <strong>|</strong>
            <a style="margin-left: 1%; margin-right: 1%;"><button style="border-radius: 8px; background-color: white; border-style: none; text-decoration: underline; font-size: medium; color: black;">Names</button></a>
            
        </div>

        <div align="center" id="record_names" style="background-color: bisque; margin-top: 10%;">

            <form id="name" action="./Names_Backend" onsubmit="return validation()" method="post">
                <table style="margin-top: 5%;"  cellpadding="3%">
                    <caption style="margin-top: 2%; margin-bottom: 1%; font-weight: bold; font-size: larger">NAMES</caption>
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
                        <th align="left" style="font-size: large;">Full Name</th>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">First Name:</th>
                        <td align="left" style="margin-left: 2%;">
                            <input type="text" name="f_name" autofocus required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Last Name:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="l_name" autofocus required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2"><hr></th>
                    </tr>
                    <tr>
                        <th align="left" style="font-size: large;">Address</th>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Block/Flat No.:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="blk_flat" style="padding: 2%;" required/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Street Name:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="strt_name" required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Locality/Area:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="text" name="local_area" value="Isanpur" required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2"><hr></th>
                    </tr>
                    <tr>
                        <th align="right" style="margin-right: 2%;">Contact No:</th>
                        <td align="left" style="margin-left: 2%">
                            <input type="number" name="cont_no" id="cont_no" required style="padding: 2%;"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" style="height: 40px">
                            <input type="submit" value="Submit" style="border-radius: 10px; font-weight: bold; padding: 2%; font-size: medium;"/>
                        </td>
                        <td align="center" style="height: 40px">
                            <input type="button" value="View All" onclick="viewall()" style="border-radius: 10px; font-weight: bold; padding: 2%; font-size: medium;"/>
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
