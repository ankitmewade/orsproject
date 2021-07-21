<%@page import="in.co.rays.ors.util.DataUtility"%>
<%@page import="in.co.rays.ors.util.ServletUtility"%>
<%@page import="in.co.rays.ors.controller.RoleCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16"/>
<title> Role Register</title>

</head>
<body>
        <jsp:useBean id="bean" class="in.co.rays.ors.bean.RoleBean" scope="request"></jsp:useBean>
    <form action="<%=ORSView.ROLE_CTL%>" method="post">
        <%@ include file="Header.jsp"%>
        <center>
        
           
<div align="center">
			
			<% if( bean != null && bean.getId() >0 ){ %>
			 <h1>Update Role</h1>
			<%}else{%>
			 <h1>Add Role</h1>
			<% }%>
	
            <H2><font color="green"> <%=ServletUtility.getSuccessMessage(request)%></font></H2>
            <H2><font color="red"> <%=ServletUtility.getErrorMessage(request)%></font></H2>
</div>
            <input type="hidden" name="id" value="<%=bean.getId()%>">
            <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
            <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>"> 
            <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
            <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">
            

            <table>
                <tr>
                    <th align="right">Name <span style="color:red">*</span></th>
                    <td><input type="text" name="name" placeholder="Enter Role Name" Size="25"
                          value="<%=DataUtility.getStringData(bean.getName())%>">
                         </td><td style="position: fixed"> <font color="red"> <%=ServletUtility.getErrorMessage("name", request)%></font></td>
                </tr>
             <tr><th style="padding: 3px"></th></tr>     
                <tr>
                    <th align="right">Description <span style="color:red">*</span></th>
                    <td><input type="text" name="description"  placeholder="Enter Description" Size="25"
                        value="<%=DataUtility.getStringData(bean.getDescription())%>">
                        </td><td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("description", request)%></font></td>
                </tr>
                  <tr><th style="padding: 3px"></th></tr>     
                <tr><th></th>                
           
                <%if(bean.getId()>0) {%>    
                <td colspan="2">
                    
                    <input type="submit" name="operation" value="<%=RoleCtl.OP_UPDATE%>"> 
                    <input type="submit" name="operation" value="<%=RoleCtl.OP_CANCEL%>"></td>
                <%}else{ %>
                	<td colspan="2">
                    
                    <input type="submit" name="operation" value="<%=RoleCtl.OP_SAVE%>"> 
                    <input type="submit" name="operation" value="<%=RoleCtl.OP_RESET%>"></td>
                <%} %>
                </tr>
            </table>
    </form>
    </center>
    <%@ include file="Footer.jsp"%>
</body>
</html>
