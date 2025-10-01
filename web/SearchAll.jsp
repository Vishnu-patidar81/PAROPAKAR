<%@ page import="java.sql.*" %>
<%@ page import="database.DbConnection" %>

<%
    String blood = request.getParameter("bloodgroup");
    if (blood != null && !blood.trim().equals("")) {
        String bloodGroup = blood.toUpperCase();

        try {
            Statement statement = DbConnection.getStatement();
//        Connection con = DbConnection.getConnection();  agr connection close nhi karna hai

            String sql = "SELECT username,mobile,email,blood,age,address,pincode,diseases FROM donorslist WHERE blood='" + blood + "'";
            ResultSet rs = statement.executeQuery(sql);

%>
<html>
    <head>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                margin: 40px;
            }
            h1 {
                color: #333;
                text-align: center;
                margin-bottom: 30px;
            }
            table {
                width: 90%;
                margin: 0 auto;
                border-collapse: collapse;
                box-shadow: 0 2px 8px rgba(0,0,0,0.1);
                background-color: #fff;
            }
            th, td {
                padding: 12px 15px;
                border: 1px solid #ddd;
                text-align: left;
            }
            th {
                background-color: #007BFF;
                color: white;
                text-transform: uppercase;
                letter-spacing: 0.1em;
            }
            tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            tr:hover {
                background-color: #f1f7ff;
            }
        </style>
    </head>
    <body>
        <h1>Donors List</h1>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Mobile</th>
                <th>Email</th>
                <th>BloodGroup</th>
                <th>Age</th>
                <th>Address</th>
                <th>Pincode</th>
                <th>HealthInfo</th>
            </tr>
            <%            while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getString(1)%></td>
                <td><%= rs.getString(2)%></td>
                <td><%= rs.getString(3)%></td>
                <td><%= rs.getString(4)%></td>
                <td><%= rs.getString(5)%></td>
                <td><%= rs.getString(6)%></td>
                <td><%= rs.getString(7)%></td>
                <td><%= rs.getString(8)%></td>
            </tr>
            <%
                        }
                    } catch (Exception e) {
                        out.println(e);
                    }

                } else {
                    response.sendRedirect("home.html");
                }
            %>   </table>
    </body>
</html>
