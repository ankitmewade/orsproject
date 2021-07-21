<%@page import="in.co.rays.ors.model.RoleModel"%>
<%@page import="in.co.rays.ors.model.UserModel"%>
<%@page import="in.co.rays.ors.util.HTMLUtility"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.ors.util.ServletUtility"%>
<%@page import="in.co.rays.ors.controller.UserListCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16"/>
<title> User List</title>

<script src="<%=ORSView.APP_CONTEXT %>/js/jquery.min.js"></script>
<script src="<%=ORSView.APP_CONTEXT %>/js/Checkbox11.js"></script>

</head>
<body>
<jsp:useBean id="bean" class="in.co.rays.ors.bean.UserBean" scope="request" ></jsp:useBean>
    <form action="<%=ORSView.USER_LIST_CTL%>" method="post">
<%@include file="Header.jsp"%>

    <center>
    
	<div align="center">
    			<h1>User List</h1>
                <h2><font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
                <font color="green"><%=ServletUtility.getSuccessMessage(request)%></font></h2>
                    
	</div>

	<%
		List<RoleBean> rolelist = (List<RoleBean>)request.getAttribute("RoleList"); 
	%>
	    <%
                    int pageNo = ServletUtility.getPageNo(request);
                    int pageSize = ServletUtility.getPageSize(request);
                    int index = ((pageNo - 1) * pageSize) + 1;

                    List list = ServletUtility.getList(request);
                    Iterator<UserBean> it = list.iterator();
                    
                    if(list.size() !=0){
                    	
        %>

            <table width="100%" align="center">
                <tr><th></th>
                    <td align="center"><label>FirstName :</label> 
                    <input type="text" name="firstName" placeholder="Enter First Name" value="<%=ServletUtility.getParameter("firstName", request)%>">
                     
                    <label> Role :</label> 
                    <%=HTMLUtility.getList("roleid", String.valueOf(bean.getRoleId()), rolelist) %>
                    
                    <label>LoginId:</label> 
                    <input type="text" name="login" placeholder="Enter Login-Id" value="<%=ServletUtility.getParameter("login", request)%>">
                    &nbsp; 
                    <input type="submit" name="operation" value="<%=UserListCtl.OP_SEARCH %>">
                    &nbsp; 
                    <input type="submit" name="operation" value="<%=UserListCtl.OP_RESET %>">
         	
                    </td>
                </tr>
            </table>
            <br>

            <table border="1" width="100%" align="center" cellpadding=6px cellspacing=".2">
                <tr>
                	<th> <input type="checkbox" id="select_all" name="select">Select All </th>
                    
                    <th>S.No.</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Role</th>
                    <th>LoginId</th>
                    <th>Gender</th>
                    <th>Date Of Birth</th>
                    <th>Mobile No </th>
                    <th>Edit</th>
                </tr>
				
				<%
					while (it.hasNext())
					{
						bean = it.next();
						RoleModel model = new RoleModel();
						RoleBean rolebean = new RoleBean();
								rolebean = model.findByPK(bean.getRoleId());
				
				%>


                <tr align="center">
                    <td><input type="checkbox" class="checkbox" name="ids" value="<%=bean.getId()%>"
                    <%if(userBean.getId() == bean.getId() || bean.getRoleId() == RoleBean.ADMIN) {                    
                    %>
                    <%="disabled" %><% } %>

                    ></td>
                    <td><%=index++%></td>
                    <td><%=bean.getFirstName()%></td>
                    <td><%=bean.getLastName()%></td>
                    <td><%=rolebean.getName()%></td>
                    <td><%=bean.getLogin()%></td>
                    <td><%=bean.getGender()%></td>
                    <td><%=bean.getDob()%></td>
                    <td><%=bean.getMobileNo()%></td>
                    <td><a href="UserCtl?id=<%=bean.getId()%>"
                    
                    <%if(userBean.getId() == bean.getId() || bean.getRoleId() == RoleBean.ADMIN) {%>
 						onclick = "return false;"                   
                    <% } %>>Edit</a></td>
                </tr>
                <%
                    }
                %>
            </table>
				
            <table width="100%">
                <tr><th></th>
					<%if(pageNo == 1){ %> 
                   <td ><input type="submit" name="operation" disabled="disabled" value="<%=UserListCtl.OP_PREVIOUS%>"></td>
                    <%}else{ %>
                    <td ><input type="submit" name="operation"  value="<%=UserListCtl.OP_PREVIOUS%>"></td>
                    <%} %>
                     
                     <td ><input type="submit" name="operation" value="<%=UserListCtl.OP_DELETE%>"></td>
                     <td ><input type="submit" name="operation" value="<%=UserListCtl.OP_NEW%>"></td>
                     
                     <%	UserModel model = new UserModel();
                     %>
                     
                     <% if(list.size() < pageSize || model.nextPK()-1 == bean.getId() ){%>

                     		<td align="right"><input type="submit" name="operation" disabled="disabled" value="<%=UserListCtl.OP_NEXT%>"></td>
                     <% }else{%>
                     		<td align="right"><input type="submit" name="operation" value="<%=UserListCtl.OP_NEXT%>"></td>
                     <%} %>
       
                </tr>          
            </table>
            		<%}if(list.size() == 0){ %>
            		<td align="center"><input type="submit" name="operation" value="<%=UserListCtl.OP_BACK%>"></td>	
            		<% } %>
            		
            <input type="hidden" name="pageNo" value="<%=pageNo%>"> 
            <input type="hidden" name="pageSize" value="<%=pageSize%>">
        </form>
    </center>
<br><br><br><br><br>
    <%@include file="Footer.jsp"%>
</body>
</html>	