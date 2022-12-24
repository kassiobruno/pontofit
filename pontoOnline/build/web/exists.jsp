<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pontofit", "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT  * FROM login WHERE " +
                    "usuario = ?");
            ps.setString(1,request.getParameter("usuario"));
            ResultSet res = ps.executeQuery();
            if(res.first()){
                out.print("Usuário ja existe");
            }else{
                out.print("Usuário disponível");
            }
        }catch (Exception e){
            System.out.println(e);  
        }
%>