<#-- @ftlvariable name="list" type="rui.model.User[]" -->
<html>
<head>
    <title>用户展示数据</title>
    <meta charset="UTF-8">
</head>
<body>
<table border="1px" align="center" width="50%">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
    </tr>
    <#list list as user >
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
    </#list>
</table>
</body>
</html>