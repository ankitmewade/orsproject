<%@page import="in.co.rays.ors.controller.LoginCtl"%>
<%@page import="in.co.rays.ors.util.DataUtility"%>
<%@page import="in.co.rays.ors.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16"/>
<title> Login Page</title>
</head>
<body>
	<jsp:useBean id="bean" class="in.co.rays.ors.bean.UserBean" scope="request"></jsp:useBean>
	<form action="<%=ORSView.LOGIN_CTL%>" method="post">
	<%@ include file="Header.jsp"%>

              <input type="hidden" name="id" value="<%=bean.getId()%>">
              <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
              <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>"> 
              <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
              <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">
            
              
<div align="center" >
            <h1>Login</h1>
            <H2><font color="red"> <%=ServletUtility.getErrorMessage(request)%></font></H2>
            <H2><font color="Green"> <%=ServletUtility.getSuccessMessage(request)%></font></H2>
            
			<%
			String msg =(String) request.getAttribute("message");
            if(msg!= null){ 
            %>
            <h1 align="center"><font style="color: red"><%=msg %></font>
            <%} %></h1>

            <table>
                <tr>
                    <th align="left">LoginId <span style="color: red">*</span></th>
                    <td ><input type="text" name="login" placeholder="Enter Valid LoginID"  
                     size=25 value="<%=DataUtility.getStringData(bean.getLogin())%>">
                   <%System.out.println("========>.."+bean.getLogin());
                    %>
                   </td>
                    <td style="position: fixed;"><font color="red" ><%=ServletUtility.getErrorMessage("login", request)%></font></td>
                </tr>
               	
               	<tr><th style="padding: 3px"></th></tr>
              	<tr><th></th></tr>
                
                <tr>
                    <th align="left">Password <span style="color: red">*</span></th>
                    <td><input type="password" name="password" placeholder="Enter Valid Password" size=25 value="<%=DataUtility.getStringData(bean.getPassword())%>">
                    </td><td style="position:fixed; "><font color="red"> <%=ServletUtility.getErrorMessage("password", request)%></font></td>
                </tr>
	            
	            <tr><th style="padding: 3px"></th></tr>
              	<tr><th></th></tr>            	    
                
                <tr>
                    <th></th>
                    <td colspan="4" >
                    
                    <input type="submit" name="operation" value="<%=LoginCtl.OP_SIGN_IN %>">   
                    <input type="submit" name="operation" value="<%=LoginCtl.OP_SIGN_UP %>" >
                    </td>
                </tr>
                <tr><th style="padding: 3px"></th>
                </tr>
                <tr><th></th>
                <td><font size="4px" ; color="red"><a href="<%=ORSView.FORGET_PASSWORD_CTL%>"><b>Forget my password</b></a></font></td>
            </tr>
            </table>    
    </form>
    </div>
    
    <%@ include file="Footer.jsp"%>
</body>
</html>