<%@page import="in.co.rays.ors.controller.MarksheetCtl"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.ors.util.HTMLUtility"%>
<%@page import="in.co.rays.ors.util.DataUtility"%>
<%@page import="in.co.rays.ors.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16"/>
<title> Marksheet Register</title>

</head>
<body>
 <jsp:useBean id="bean" class="in.co.rays.ors.bean.MarksheetBean" scope="request"></jsp:useBean>
    <form action="<%=ORSView.MARKSHEET_CTL%>" method="post">      

<%@ include file="Header.jsp"%>

        <%
            List l = (List) request.getAttribute("studentList");
        
        %>

        <div align="center">    
    		  <%  if(bean!=null && bean.getId()>0){%>
					<h1>Update Marksheet</h1>
	  		  <%}else{%>
         			<h1>Add Marksheet</h1>
        	  <%} %>
            <H2>
                <font color="red"> <%=ServletUtility.getErrorMessage(request)%></font>
                <font color="green"> <%=ServletUtility.getSuccessMessage(request)%></font>
            </H2>
		</div>
<center>
		    <input type="hidden" name="id" value="<%=bean.getId()%>">
            <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
            <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>"> 
            <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
            <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">
            

            <table align="center">
                <tr>
                    <th align="right">Rollno<span style="color: red">*</span></th>
                    <td><input type="text" name="rollNo" placeholder="00EC0000" size="25"
                        value="<%=DataUtility.getStringData(bean.getRollNo())%>"></td>
                        <td style="position: fixed;"> 
                        <font color="red"> <%=ServletUtility.getErrorMessage("rollNo", request)%></font></td> 
                </tr>
                <tr><th style="padding: 3px"></th></tr>
                  <tr>
                    <th align="right"> Name <span style="color: red">*</span></th>
                    <td><%=HTMLUtility.getList("studentId",String.valueOf(bean.getStudentId()),l)%></td>
               
                    <td style="position: fixed"> 
                    <font color="red" > <%=ServletUtility.getErrorMessage("studentId", request)%></font></td>
         
                </tr>
<tr><th style="padding: 3px"></th></tr>                 
                  <tr>
                    <th align="right">Physics<span style="color: red">*</span></th>
                  <td><input type="text" name="physics" placeholder="Enter Physics Marks"  size="25"
                        value="<%=(DataUtility.getStringData(bean.getChemistry()))%>"">
                        </td>
                 
                   <%--  <td><input type="text" name="physics" placeholder="Enter Physics Marks"  size="25"
                        value="<%=DataUtility.getStringData(bean.getPhysics())%>">
                        </td> --%>
                        
                        <td style="position: fixed;">
                        <font color="red"> <%=ServletUtility.getErrorMessage("physics", request)%></font></td>
                </tr>
                <tr><th style="padding: 3px"></th></tr>
                <tr>
                    <th align="right">Chemistry<span style="color: red">*</span></th>
                     <td><input type="text" name="chemistry" placeholder="Enter Chemistry Marks"  size="25"
                        value="<%=(DataUtility.getStringData(bean.getChemistry()))%>">
                        </td>
                        
                  <%--   <td><input type="text" name="chemistry" placeholder="Enter Chemistry Marks"  size="25"
                        value="<%=DataUtility.getStringData(bean.getChemistry())%>">
                        </td> --%>
                        <td style="position: fixed;">
                        <font color="red"> <%=ServletUtility.getErrorMessage("chemistry", request)%></font></td>
                </tr>
                <tr><th style="padding: 3px"></th></tr>
                <tr >
                    <th align="right"> Maths <span style="color: red">*</span></th>
                  <td><input type="text" name="maths" placeholder="Enter Maths Marks"  size="25"
                         value="<%=(DataUtility.getStringData(bean.getMaths()).equals("0")?"":DataUtility.getStringData(bean.getMaths()))%>">
                        </td>
                   <%--  <td><input type="text" name="maths" placeholder="Enter Maths Marks"  size="25"
                         value="<%=DataUtility.getStringData(bean.getMaths())%>">
                        </td> --%>
                        <td style="position: fixed;">
                        <font  color="red"><%=ServletUtility.getErrorMessage("maths", request)%></font></td>

                </tr>
                <tr><th style="padding: 3px"></th></tr>
                <tr>
                    <th></th>
                        <%
							if(bean.getId()>0 && bean !=null){
						%> 
 	 <td> <input type="submit" name ="operation" value="<%=MarksheetCtl.OP_UPDATE%>">
 <input type="submit" name ="operation" value="<%=MarksheetCtl.OP_CANCEL%>"></td>
 

					<%}else{ %>
                    
   <td colspan="2">
   <input type="submit" name="operation" value="<%=MarksheetCtl.OP_SAVE%>"> 
   <input type="submit" name="operation" value="<%=MarksheetCtl.OP_RESET%>"></td>
                        <%} %>
                        </tr>
                        </table>
        </form>
   </center>

       <%@include file="Footer.jsp"%>
    </body>
</html>