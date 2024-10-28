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
            <th>Model</th>
            <th>Type</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        
        <c:forEach var="item" items="${allItemsDetails}">
	        <tr>
	            <td>${item.id}</td>
	            <td>${item.name}</td>
	            <td>${item.price}</td>
	            <td>${item.totalNumber}</td>
				<td>${item.model}</td>
	            <td>${item.type}</td>
	            <td>${item.description}</td>
	        </tr>
        </c:forEach>
        
        </tbody>
    </table>


    <button class="back f">
        <a href="ItemController" method="post" >Back To Items</a>
    </button>

</div>

</body>
</html>