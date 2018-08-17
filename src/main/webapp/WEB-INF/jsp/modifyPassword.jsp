<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>改密码</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link href="../resources/demo.css" rel="stylesheet" type="text/css" />
    <script src="resources/scripts/boot.js" type="text/javascript"></script>
    <style type="text/css">
    </style>
</head>
<body>
    <h1>修改密码</h1>      
    <div id="modifyForm" style="padding:15px;padding-top:10px;">
<!-- <form name="modifyPassword" action="modifyPassword.do" method="post"> -->   
<table border="0" cellpadding="1" cellspacing="2">
    <tr>
        <td style="width:80px;">原密码：</td>
        <td style="width:100px">
            <input name="pwd_old" class="mini-password" onvalidation="onPwdValidation"/>
        </td>
    </tr>
    <tr>
        <td >新密码：</td>
        <td >
            <input name="pwd_new" class="mini-password" onvalidation="onPwdValidation"/>
        </td>
    </tr>
    <tr>
        <td >密码确认：</td>
        <td >
            <input name="pwd_new2" class="mini-password" onvalidation="onNewPwdValidation"/>
        </td>
    </tr>
    <tr>
    	<td></td>
        <td style="padding-top:5px;">
        	<a onclick="onLoginClick" class="mini-button" style="width:60px;">确认</a>
            <a onclick="onResetClick" class="mini-button" style="width:60px;">清空</a>
        </td>
    </tr>
</table>
</div> 
<p style="color:red">${msg}</p><hr>
<script>
function onLoginClick(e) {
    var form = new mini.Form("#modifyForm");

    form.validate();
    if (form.isValid() == false) return;

    var data = form.getData();      //获取表单多个控件的数据
    var json = $.parseJSON(mini.encode(data));
    $.ajax({
        url: "modifyPassword.do",
        type: "post",
        data:json,
        success: function (text) {
            //alert("提交成功"+json+"，返回结果:" + text);
            /*if(text == "0"){
            	alert("修改成功");
            }else{
            	alert("修改失败，错误代码:"+text);
            }*/
            switch (text)
            {
            case "0":
            	alert("修改成功");
              	break;
            case "1":
            	alert("修改失败,两次密码输入不一致");
              	break;
            case "2":
            	alert("修改密码失败");
              	break;
            case "3":
            	alert("原密码错误");
              	break;
            default:
            }
            
        },
        error:function () {
            alert("error");
        }
    })
    form.clear();
}

function onResetClick(e) {
    var form = new mini.Form("#modifyForm");
    form.clear();
}

function onPwdValidation(e) {
    if (e.isValid) {
        if (e.value.length < 5) {
            e.errorText = "密码不能少于5个字符";
            e.isValid = false;
        }
    }
}
function onNewPwdValidation(e) {
    if (e.isValid) {
        if (e.value != $("input[ name='pwd_new']").val()) {
            e.errorText = "两次输入密码不一致";
            e.isValid = false;
        }
    }
}
</script>
</body>
</html>

