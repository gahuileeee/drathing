<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<c:set var="loginOutLink" value="${sessionScope.user==null ? '/drathing/login' : '/drathing/logout'}"/>
<c:set var="loginOut" value="${sessionScope.user==null ? 'Login' : 'Logout'}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href='/drathing/css/bulletin.css'>
    <title>DraThing</title>
</head>

<body>
    <div id="title">
        <h1><span class="pink-text">Dra</span><span class="green-text">Thing</span></h1>
    </div>

    <div id="nav">
        <form action="/drathing/index"  >
            <button type="submit" class="button" id='button2'>
                <h3>home</h3>
            </button>
        </form>
        <form action="${loginOutLink}" >
            <input type="hidden" name="lg" value="1">
            <input type="hidden" name="pg" value="${pg}">
            <button type="submit" class="button" id='button2'>
                <h3>${loginOut}</h3>
            </button>
        </form>
    </div>

    <div id="context">
    <br>
        <h3 class="subject">Subject: <u>${print.name}</u></h3>
            <h4 class="person">User Name: <u>${print.user}</u></h4>
    <br>
        <div class="image-container">
            <img src="data:image/png;base64,${print.printing}" alt="Print Image"/>
        </div>

          <div class="like-button">
            <form action="/drathing/like" method="post">
                <input type="hidden" value="${print.number}" name="number">
                <input type="hidden" value="${print.like}" name="like">
                <button type="submit">
                    <span class="heart-icon">&#x2665;</span>
                    <span class="like-text" style=" font-size: 16px;">Like ${print.like}</span>
                </button>
            </form>
        </div>
          <div id="comment-section">
              <br>
    <div id="comments-container">
        <form  style="text-align: right;" action="/drathing/board" method="get">
            <input type="hidden" value="${pg}" name="pg">
            <input type="submit" value="return to list" id="return">
        </form>
    <h3 style="text-align: left;">comments</h3>
    </div>

              <style>
                  #return{
                      font-family: 'Finger Paint', 바탕;
                      text-decoration: none;
                      color: #ffffff;
                      border: none;
                      background:#fdbdc9;
                      padding: 2px;
                      cursor: pointer;
                      border-radius: 4px;
                  }
              </style>

    <!-- 댓글 입력 폼 -->
    <form id="comment-form" action ="/drathing/comment" method="post">
        <textarea id="comment-input" name="comment" rows="4" cols="50"></textarea>
       <input type="hidden" name="number" value="${print.number}">
        <button type="submit" >Submit Comment</button>
    </form>
    <br>
       <div id="comments">

          <c:forEach var="comment" items="${lists}">
        <div>
        <p>${comment.comment_id}</p>
        <p>${comment.content}</p>
        </div>
          </c:forEach>
           <br>

    </div>
</div>
    </div>
    </div>
</body>
</html>