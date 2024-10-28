<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String cok=null;
    Cookie[] coo=request.getCookies();
    if(coo!=null){
    	for(int i=0;1<coo.length;i++){
    		if(coo[i].getName().equals("go")){
    			cok=coo[i].getName();
    			break;
    		}
    	}
    }
    if(cok==null){
    String loggedIn = (session != null) ? 
    		(String) session.getAttribute("login") : "no";
    if(loggedIn!="yes"){

    	response.sendRedirect("theFirst");
    	
    }
    }

    

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Items</title>
    <link rel="stylesheet" href="css/show-items.css">
</head>
<body>

<div class="layer">
    <table>
        <h1>Items</h1>
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>TOTAL_NUMBER</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        
        <c:forEach var="item" items="${allItems}">
	        <tr>
	            <td>${item.id}</td>
	            <td>${item.name}</td>
	            <td>${item.price}</td>
	            <td>${item.totalNumber}</td>
	     
	            <td>
	                <a href="ItemController?action=LOAD_ITEM&id=${item.id}" >Update</a>
	                
	                
	                <a href="ItemController?action=DELETE&id=${item.id}" >Delete</a>
	         <c:choose>       
	              <c:when test="${item.haveCon=='true'}"> 
	               
	            
	                </c:when>
	              <c:otherwise>
	                 <a href="add-item-details.jsp?id=${item.id}">ADD ITEM DETAILS</a>
	              
	              </c:otherwise>
	                </c:choose>
	            </td>
	        </tr>
        </c:forEach>
        
        
        </tbody>
    </table>


    <button class="f"><a href="add-item.jsp" >Add Item</a></button>
    <p class="ff">
		<button class="f"><a href="ItemController?action=LOAD_ITEM_DETAILS"  >Show All Details</a></button>
	</p>
</div>

</body>
</html>