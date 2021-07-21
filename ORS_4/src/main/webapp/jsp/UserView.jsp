<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.ors.util.HTMLUtility"%>
<%@page import="in.co.rays.ors.util.DataUtility"%>
<%@page import="in.co.rays.ors.util.ServletUtility"%>
<%@page import="in.co.rays.ors.controller.UserCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16"/>
<title> User Register</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#udatee" ).datepicker({
      changeMonth: true,
      changeYear: true,
	  yearRange:'1980:2020',
	  dateFormat:'dd-mm-yy'
    });
  } );
  </script>
</head>

<body>
   <jsp:useBean id="bean" class="in.co.rays.ors.bean.UserBean" scope="request"></jsp:useBean>
    <form action="<%=ORSView.USER_CTL%>" method="post">
   <%@ include file="Header.jsp"%>
   
   <center>

        <%
            List l = (List) request.getAttribute("roleList");
        %>

    <div align="center">    
            <h1>
 				
           		<% if(bean != null && bean.getId() > 0) { %>
            <tr><th><font size="5px"> Update User </font>  </th></tr>
            	<%}else{%>
			<tr><th><font size="5px"> Add User </font>  </th></tr>            
            	<%}%>
            </h1>
   
            <h2><font color="red"> <%=ServletUtility.getErrorMessage(request)%></font>
            <font color="green"> <%=ServletUtility.getSuccessMessage(request)%></font>
            </h2>
	       
</div>
            <input type="hidden" name="id" value="<%=bean.getId()%>">
            <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
            <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>"> 
            <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
            <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

            <table>
                <tr>
                    <th align="right">First Name <span style="color: red">*</span></th>
                    <td><input type="text" name="firstName" placeholder="Enter First Name" size="25"  value="<%=DataUtility.getStringData(bean.getFirstName())%>"></td>
                    <td style="position: fixed "><font color="red"><%=ServletUtility.getErrorMessage("firstName", request)%></font></td> 
                    
                </tr>
    
    <tr><th style="padding: 3px"></th></tr>          
              
              <tr>
                    <th align="right">Last Name <span style="color: red">*</span> </th>
                    <td><input type="text" name="lastName" placeholder="Enter Last Name" size="25" value="<%=DataUtility.getStringData(bean.getLastName())%>"></td>
                     <td style="position: fixed"><font  color="red"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></td>
                </tr>
    <tr><th style="padding: 3px"></th></tr>          

                <tr>
                    <th align="right">LoginId <span style="color: red">*</span></th>
                    <td><input type="text" name="login" placeholder="Enter Vallid Email-Id" size="25" value="<%=DataUtility.getStringData(bean.getLogin())%>"
                        <%=(bean.getId() > 0) ? "readonly" : ""%>> </td>
                       <td style="position: fixed"> <font  color="red"> <%=ServletUtility.getErrorMessage("login", request)%></font></td>
                </tr>
				
				<% if(bean.getId()>0 && bean != null){ %>
                <tr>
                   
                    <td><input type="hidden" name="password" value="<%=DataUtility.getStringData(bean.getPassword())%>"></td>
                   <td><input type="hidden" name="confirmPassword"  value="<%=DataUtility.getStringData(bean.getPassword())%>"></td>
                   </tr>
				
                <%}else{ %>
    <tr><th style="padding: 3px"></th></tr>          

                <tr>
                    <th align="right">Password <span style="color: red">*</span></th>
                    <td><input type="password" name="password" placeholder="Amit@123" size="25"value="<%=DataUtility.getStringData(bean.getPassword())%>"></td>
                       <td style="position: fixed"> <font  color="red"> <%=ServletUtility.getErrorMessage("password", request)%></font></td>
                </tr>
    <tr><th style="padding: 3px"></th></tr>          

                <tr>
                    <th align="right" >Confirm Password <span style="color: red">*</span></th>
                    <td><input type="password" name="confirmPassword" placeholder="Re-Enter Password" size="25" value="<%=DataUtility.getStringData(bean.getPassword())%>"></td>
                      <td style="position: fixed" >  <font color="red"> <%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></td>
                </tr>
                <%} %>
    <tr><th style="padding: 3px"></th></tr>          

                <tr>
                    <th align="right" > Gender <span style="color: red">*</span></th>
                    <td>
                        <%
                            HashMap map = new HashMap();
                            map.put("Male", "Male");
                            map.put("Female", "Female");

                            String htmlList = HTMLUtility.getList("gender", bean.getGender(), map);
                        %> <%=htmlList%>
                   </td>
                   <td style="position: fixed" ><font color="red"> <%=ServletUtility.getErrorMessage("gender", request)%></font></td>
                 </tr>
    <tr><th style="padding: 3px"></th></tr>          
                 
                 <tr>
                  	<th align="right">Role <span style="color: red">*</span></th>
                  	 <td>
                    <%=HTMLUtility.getList("rolename",String.valueOf(bean.getRoleId()), l)%></td>
                <td style="position: fixed">  <font style="position: fixed" color="red"> <%=ServletUtility.getErrorMessage("rolename", request)%></font></td>
                </tr>
    <tr><th style="padding: 3px"></th></tr>          
                
                <tr>
                    <th align="right">Date Of Birth <span style="color: red">*</span> </th>
                    <td><input type="text" name="dob" placeholder="Greater then 18 year" size= "25" readonly="readonly" id="udatee" value="<%=DataUtility.getDateString(bean.getDob())%>"></td>
                      <td style="position: fixed;">	<font color="red"> <%=ServletUtility.getErrorMessage("dob", request)%></font></td>
                </tr>
                <tr>
    <tr><th style="padding: 3px"></th></tr>          
                
                <tr>
                    <th align="right">Mobile No <span style="color: red">*</span></th>
                    <td><input type="text" name="mobileno" maxlength="10" placeholder="Enter Mobile No" size= "25" value="<%=DataUtility.getStringData(bean.getMobileNo())%>"></td>
                    <td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("mobileno", request)%></font></td>
                </tr>
    <tr><th style="padding: 3px"></th></tr>          

                <tr ><th></th>
                <%
                if(bean.getId()>0){
                %>
                <td colspan="2" >
                    <input type="submit" name="operation" value="<%=UserCtl.OP_UPDATE%>">
                     
                    <input type="submit" name="operation" value="<%=UserCtl.OP_CANCEL%>"></td>
                
                <% }else{%>
                
                <td colspan="2" > 
                    <input type="submit" name="operation" value="<%=UserCtl.OP_SAVE%>">
                    
                    <input type="submit" name="operation" value="<%=UserCtl.OP_RESET%>"></td>
                
                <% } %>
                </tr>
            </table>
    </form>
    </center>
    <%@ include file="Footer.jsp"%>
</body>
</html>