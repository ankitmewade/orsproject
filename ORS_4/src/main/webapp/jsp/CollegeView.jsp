<%@page import="in.co.rays.ors.controller.CollegeCtl"%>
<%@page import="in.co.rays.ors.util.DataUtility"%>
<%@page import="in.co.rays.ors.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16"/>
<title> College Registration Page</title>
</head>
<body>
  <jsp:useBean id="bean" class="in.co.rays.ors.bean.CollegeBean" scope="request"></jsp:useBean>
  <form action="CollegeCtl" method="post">
  <%@ include file="Header.jsp"%>

    

        
        <center>
           <h1>
            	<%
            		if(bean != null && bean.getId()>0){
            	%>
            		<tr><th><font>Update College</font></th></tr>
            	
            	<% }else{%>
            		
            		<tr><th><font>Add College</font></th></tr>
            	<% }%>            
            </h1>

      <div>
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
                    <th align="right">Name <span style="color: red">*</span></th>
                    <td><input type="text" name="name" placeholder="Enter College Name" size="25px" value="<%=DataUtility.getStringData(bean.getName())%>">
                    </td><td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("name", request)%></font></td>
                </tr>
       <tr><th style="padding: 3px"></th></tr>        
                <tr>
                    <th align="right">Address <span style="color: red">*</span></th>
                    <td><input type="text" name="address" placeholder="Enter College Address" size="25px" value="<%=DataUtility.getStringData(bean.getAddress())%>">
                    </td><td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("address", request)%></font></td>
                </tr>
      <tr><th style="padding: 3px"></th></tr>          
                <tr>
                    <th align="right">State <span style="color: red">*</span></th>
                    <td><input type="text" name="state"  placeholder="Enter State" size="25px" value="<%=DataUtility.getStringData(bean.getState())%>">
                    </td><td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("state", request)%></font></td>
                </tr>
      <tr><th style="padding: 3px"></th></tr>
                <tr>
                    <th align="right">City <span style="color: red">*</span></th>
                    <td><input type="text" name="city" placeholder="Enter City" size="25px" value="<%=DataUtility.getStringData(bean.getCity())%>">
                    </td><td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("city", request)%></font></td>
                </tr>
     <tr><th style="padding: 3px"></th></tr>            
                <tr>
                    <th align="right">MobileNo <span style="color: red">*</span></th>
                    <td><input type="text" name="phoneNo" placeholder="Enter Mobile No" maxlength="10"  size="25px" value="<%=DataUtility.getStringData(bean.getPhoneNo())%>">
                   </td><td style="position: fixed"> <font color="red"> <%=ServletUtility.getErrorMessage("phoneNo", request)%></font></td>
                </tr>
     <tr><th style="padding: 3px"></th></tr>            
                <tr><th></th>
                <%if(bean.getId()>0) {%>
                    <td colspan="2">
                    <input type="submit" name="operation" value="<%=CollegeCtl.OP_UPDATE%>">                    
                     
                     <input type="submit" name="operation" value="<%=CollegeCtl.OP_CANCEL%>"></td>
                <%}else{ %>
                	 <td colspan="2">
                    <input type="submit" name="operation" value="<%=CollegeCtl.OP_SAVE%>">                    
                     
                     <input type="submit" name="operation" value="<%=CollegeCtl.OP_RESET%>"></td>
                <%} %>
                </tr>
            </table>
    </form>
    </center>
    <%@ include file="Footer.jsp"%>
</body>
</html>