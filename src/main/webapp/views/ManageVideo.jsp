<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .nd{
            display: grid;
            grid-template-columns: 200px 300px;
        }
    </style>
</head>
<body>
    <c:url var="url" value="/video"></c:url>
    <form action="${url}/index" method="POST">
        <div class="nd">
            <div>
                <img src="" alt="">
            </div>
            <div>
                Youtube id? <br>
                <input type="text" name="id" id="" value="${form.id }"> <br>
                Video Title <br>
                <input type="text" name="title" id="" value="${form.title }"> <br>
                View Count? <br>
                <input type="text" name="views" id="" value="${form.views }"> <br>
                <input type="checkbox" name="active" id="" value="true" ${form.active?'checked':'' }>Active
                <input type="checkbox" name="active" id="" value="false" ${form.active?'':'checked' }>Inactive <br>

            </div>
        </div>
        Description? <br>
        <textarea name="" id="" cols="50" rows="5">

        </textarea> <br>
        <button formaction="${url }/create">Create</button>
        <button formaction="${url }/update">Update</button>
        <button formaction="${url }/delete">Delete</button>
        <button formaction="${url }/index">Reset</button>
    </form>
    <hr> <hr>
    <table border="1" style="width:600px">
        <c:forEach var="item" items="${items }">
            <tr>
                <td>${item.id }</td>
                <td>${item.title }</td>
                <td>${item.views }</td>
                <td>${item.active?'Active':'Inactive' }</td>
                <td><a href="${url}/edit/${item.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>