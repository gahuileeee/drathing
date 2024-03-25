<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<c:set var="loginOutLink" value="${sessionScope.user==null ? '/drathing/login' : '/drathing/logout'}"/>
<c:set var="loginOut" value="${sessionScope.user==null ? 'Login' : 'Logout'}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <!-- <link rel="stylesheet" href='/css/board01.css'> -->
    <title>DraThing</title>
   <style>
       @import url('https://fonts.googleapis.com/css2?family=Finger+Paint&display=swap');

       #title{
           text-align: center;
           font-family: 'Finger Paint', 바탕;
           background-color: rgb(255, 243, 224);
       }
       h1 {
           display: inline-block;
           padding: 5px 10px;
       }

       .pink-text {
           color: pink;
       }

       .green-text {
           color: rgb(146, 231, 146);
       }
       #nav{
           font-family: 'Finger Paint', 바탕;
           height: 55px;
           background-color: pink;
           text-align: right;
           margin-top:10px;
           margin-bottom:10px;
           display: flex;
           justify-content: flex-end;
           align-items: center;
       }
       #context{
           box-sizing: border-box ;
           width: auto;
           height: auto;
           background-color: rgb(255, 243, 224);
           text-align: left;
       }
       .image-container {
           display: inline-block;
           margin-top: 10px;
           margin-left: 8px;
           margin-bottom: 15px;
           width: calc(25% - 15px);
           height: auto;
           text-align: center;
           background-color: white;
           border: 1px solid black;
           box-sizing: border-box;
       }
       .image-container img {
           width: 90%;
           height: 90%;
           object-fit: cover;
       }
       h5{
           font-family: 'Finger Paint', 바탕;
       }

       #button1 {
           border: none; /* 테두리 제거 */
           padding: 0; /* 내부 여백 제거 */
           background: none; /* 배경 제거 */
           color: inherit; /* 부모 요소의 텍스트 색상 상속 */
           cursor: pointer;
           text-decoration: underline; /* 텍스트에 밑줄 추가 */
           font-size: inherit; /* 부모 요소의 폰트 크기 상속 */
           margin: 0; /* 마진 제거 */
       }
       #button2{
           border: none;
           padding: 0px 5px;
           margin-right : 25px;
           background: pink;
           color: white;
           cursor: pointer;
           font-size: inherit;
           height: 20px;
           box-sizing : border-box;
           flex-grow: 1;
       }

       #pagination {
           margin-top: 20px;
           text-align: center;
       }

       #pagination a {
           font-family: 'Finger Paint', 바탕;
           text-decoration: none;
           color: black;
           border-radius: 5px;
           margin-right: 2px;
       }

       .page {
           background-color: #fdbdc9;
       }
       #page {
           display: inline-block;
           width: 20px;
           background-color: #fdbdc9;
           text-align: center;
       }
       #current {
           display: inline-block;
           width: 20px;
           background-color: #e8d5d7;
           border-radius: 5px;
       }
   </style>
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
        <form action="${loginOutLink}" method="get">
            <input type="hidden" name="lg" value="1">
            <input type="hidden" name="pg" value="${currentPg}">
            <button type="submit" class="button" id='button2'>
                <h3>${loginOut}</h3>
            </button>
        </form>
    </div>
    
   <div id="context">
    <!-- 이미지를 표시할 공간 -->
       <c:forEach var="print" items="${prints}">
        <div class="image-container"  >
            <img src="data:image/png;base64,${print.printing}" alt="Print Image"/>
            <form action="/drathing/bulletin"  >
                <input type ="hidden" name="number" value="${print.number}">
                <input type ="hidden" name="pg" value="${currentPg}">
                <button type = "sumbit" class ="button" id="button1" >
                    <h5 >${print.name}</h5>
                </button>
            </form>
        </div>
       </c:forEach>

       <div id="pagination">
           <c:if test="${pageGroupStart gt 1}">
               <a href="/drathing/board?pg=${pageGroupStart-1}" class="page">Previous</a>
           </c:if>
           <c:forEach var="n" begin="${pageGroupStart}" end="${pageGroupEnd}">
               <c:set var="linkClass" value="page"/>
               <c:if test="${currentPg eq n}">
                   <c:set var="linkClass" value="current"/>
               </c:if>
               <a href="/drathing/board?pg=${n}" id="${linkClass}">${n}</a>
           </c:forEach>
           <c:if test="${pageGroupEnd lt lastPageNum}">
               <a href="/drathing/board?pg=${pageGroupEnd + 1}" class="page">Next</a>
           </c:if>
       </div>
       <br>
        </div>

</body>
</html>