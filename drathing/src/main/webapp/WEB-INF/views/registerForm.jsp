<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='/drathing/css/login01.css'>
    
    <title>DraThing</title>

</head>


<body>
<script>
    <c:if test="${msg != null}">
    <c:forEach var="alert" items="${msg}">
    var message = "${alert}";
    alert(message);
    </c:forEach>
    </c:if>
</script>
    <!-- 로고 이미지 -->
    <div id="img">
        <h1><span class="pink-text">Dra</span><span class="green-text">Thing</span></h1>
    </div>

    <!-- 회원가입 폼 -->
    <div class="login-container">
		<form class="login-form" id="form" action="/drathing/register" method="post">
            <input type="hidden" name="lg" value="${lg}">
            <input type="hidden" name="pg" value="${pg}">
		         <div class="form-group">
                <label for="uid">Email:</label>
                <input type="email" id="uid" name="uid" required>
            </div>
            <div class="form-group">
                <label for="upassword">Password:</label>
                <input type="password" id="upassword" name="upassword" required>
            </div>
            <div class="form-group">
                <label for="cpassword">Confirm Password:</label>
                <input type="password" id="cpassword" name="cpassword" required>
            </div>
            <div class="button-container">
                <button type="submit" class="button" >Create Account</button>
            </div>
        </form>
    </div>

		<form action="/drathing/login" method="get">
            <input type="hidden" name="lg" value="${lg}">
            <input type="hidden" name="pg" value="${pg}">
    <button type="submit" class="guest-button" id="button2">Already have an account? Login</button>
		</form>

</body>

</html>