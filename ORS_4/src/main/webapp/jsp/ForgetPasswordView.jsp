<%@page import="in.co.rays.ors.controller.ForgetPasswordCtl"%>
<%@page import="in.co.rays.ors.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16"/>
<title> Forget Password</title>

</head>
<body>
  <jsp:useBean id="bean" class="in.co.rays.ors.bean.UserBean" scope="request"></jsp:useBean>
  <%@ include file="Header.jsp"%>
    <form action="<%=ORSView.FORGET_PASSWORD_CTL%>" method="post">
    
  	   
 <div align="center">
    <h1 align="center">Forgot your password ?</h1>
                 <lable>Submit your Email id and we will send your password.</lable><br><br>
	        
		    <H2>
                <font color="green"> <%=ServletUtility.getSuccessMessage(request)%></font></H2>
            <H2>
                <font color="red"> <%=ServletUtility.getErrorMessage(request)%></font></H2>
</div>

	<div align="center">

            <input type="hidden" name="id" value="<%=bean.getId()%>">

            <table align="center">
                <tr><th>Email Id <span style="color:red; ">*</span></th>
                <td><input type="text" name="login" size="25"  placeholder="Enter the Valid-Id" value="<%=ServletUtility.getParameter("login", request)%>"></td>
                <td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("login", request)%></font></td>
		
		<tr><th style="padding: 3px"></th></tr>
				
		            <tr><th></th>
		            <td>
	            	<input type="submit" name="operation" value="<%=ForgetPasswordCtl.OP_GO%>">
	            	&nbsp;
	            	 <input type="submit" name="operation" value="<%=ForgetPasswordCtl.OP_RESET%>">
	            	 </td>
	            	 </tr>
            </table>      
	</div>
    </form>
    </center>
    <%@ include file="Footer.jsp"%>
</body>
</html>