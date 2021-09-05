<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý người dùng</title>
    <style>
        .manage{
            display: grid;
            grid-template-columns: 300px 300px;
        }
        .button{
            margin-left: 350px;
        }
    </style>
 
</head>
<body>
<h2>${mess }</h2>

	<c:url var="url" value="/user" />
    <form action="${url }/index" method="POST">
        <h1>Quản lý người dùng</h1>
        <div class="manage">
            <div >
                Username? <br>
                <input type="text" name="id" id="" value="${form.id }"> <br>
                Fullname? <br>
                <input type="text" name="fullname" id="" value="${form.fullname }"> <br>
            </div>
            <div>
                Password? <br>
                <input type="text" name="password" id="" value=" ${form.password}"> <br>
                Email Address?<br>
                <input type="text" name="email" id="" value=" ${form.email }"> <br>
                Role <br>
                <input type="radio" name="admin" id="" ${form.admin?'checked':'' } value="true"> Admin
                <input type="radio" name="admin" id="" ${form.admin?'':'checked' } value="false"> User
            </div>
        </div> <br>
        <div class="button">
            <button formaction="${url}/create">Create</button>
            <button formaction="${url}/update">Update</button>
            <button formaction="${url}/delete">Delete</button>
            <a href="${url}/index">Reset</a>
            
        </div>
        </form> <br>
        <hr> <hr>
        

            <table border="1" style="width:600px">
				<c:forEach var="item" items="${items}">			
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.password}</td>
                        <td>${item.fullname}</td>
                        <td>${item.email}</td>
                        <td>${item.admin?'Admin':'User'}</td>
                        <td><a href="${url}/edit/${item.id}">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>

</body>
</html>