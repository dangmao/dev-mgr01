<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Login</title>
<!--     <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link href="static/demo.css" rel="stylesheet" type="text/css" />
 -->
    <style type="text/css">
    body
    {
        width:100%;height:100%;margin:0;overflow:hidden;
    }
    </style>
<!--    
    <script src="static/scripts/boot.js" type="text/javascript"></script>
  -->   
</head>
<body >   
    <form name="login" action="login.do" method="post">
	用户名: 
		<input type="text" id="uname" name="uname"  size="20"/>
	<br />密  码: 
	<input type="password" id="password" name="password" size="20"/>
	<br />
		<input type="submit" value="登录"/>
	</form> 
	<p style="color:red">${msg}</p><hr>
</body>
</html>