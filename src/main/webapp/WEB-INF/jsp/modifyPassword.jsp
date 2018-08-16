<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>改密码</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <!-- 
    <link href="../demo.css" rel="stylesheet" type="text/css" />
    <script src="static/scripts/boot.js" type="text/javascript"></script> -->
    <style type="text/css">
    </style>
</head>
<body>
    <h1>修改密码</h1>      
<form name="modifyPassword" action="modifyPassword.do" method="post">    
<table border="0" cellpadding="1" cellspacing="2">
    <tr>
        <td style="width:80px;">原密码：</td>
        <td style="width:100px">
            <input name="pwd_old" class="mini-password" />
        </td>
    </tr>
    <tr>
        <td >新密码：</td>
        <td >
            <input name="pwd_new" class="mini-password" />
        </td>
    </tr>
    <tr>
        <td >密码确认：</td>
        <td >
            <input name="pwd_new2" class="mini-password" />
        </td>
    </tr>
    <tr>
        <td ><input type="submit" value="确定"/></td>
    </tr>
</table>
</form> 
<p style="color:red">${msg}</p><hr>
</body>
</html>
