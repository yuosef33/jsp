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
    	String loggedIn = (String) session.getAttribute("login");

    	if(loggedIn=="yes"){

    		response.sendRedirect("ItemController");

        	
    		
    		
    	}

    }



%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login & Sign Up</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
            <form action="loger" class="sign-in-htm" method="post">
                <div class="group">
                    <label for="user1" class="label">Username</label>
                    <input id="user1" type="text" name="un" class="input">
                </div>
                <div class="group">
                    <label for="pass2"  class="label">Password</label>
                    <input id="pass2" type="password" name="pass" class="input" data-type="password">
                </div>
                <div class="group">
                    <input id="check" type="checkbox" name="keep" value=X class="check" checked>
                    <label for="check"><span class="icon"></span> Keep me Signed in</label>
                  
                </div>
                <div class="group">
               <!--       <input type="hidden" name="action" value="LOG_IN"> --> 
                    <input type="submit" class="button" value="Sign In">
                </div>
                <div class="hr"></div>
            </form>
            
            
            
            
            
            
            
            <form action="register" class="sign-up-htm" method="post">
                <div class="group">
                    <label for="user" class="label">Username</label>
                    <input id="user" type="text" name="add_un" class="input">
                </div>
                <div class="group">
                    <label for="pass"  class="label">Password</label>
                    <input id="pass" type="password" name="add_pass"class="input" data-type="password">
                  
                </div>
                <div class="group">
          <!--   <input  type="hidden" name="action" value="ADD_USER"> -->  
                    <input type="submit" class="button" value="Sign Up">
                </div>
                <div class="hr"></div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
