<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- set 방식은 utf-8 안잡혀서 이렇게 넣어줘야 함 -->
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="http://localhost/jspPro/images/SiSt.ico"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="http://localhost/jspPro/resources/cdn-main/example.css"
    />
    <script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
    <style>
      span.material-symbols-outlined {
        vertical-align: text-bottom;
      }
    </style>
  </head>
  <body>
    <header>
      <h1 class="main">
        <a href="#" style="position: absolute; top: 30px">jyoons HOme</a>
      </h1>
      <ul>
        <li><a href="#">로그인</a></li>
        <li><a href="#">회원가입</a></li>
      </ul>
    </header>
    <div>
      <xmp class="code">
   			ex02_ok.jsp
        </xmp>
   			<%
   			String name = request.getParameter("name");
   			int age = Integer.parseInt(request.getParameter("age"));
   			%>
   			> name = <%= name %><br>
   			> age = <%= age %><br>
  	  <hr>
   			> name = ${ param.name }<br>
   			> age = ${ param.name }<br>
   			
    </div>
    
  </body>
</html>
