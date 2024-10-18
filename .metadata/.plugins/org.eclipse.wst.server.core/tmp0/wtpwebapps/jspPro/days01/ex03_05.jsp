<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // ex03_05.jsp?num=        ""
    // ex03_05.jsp?num         ""
    		
    // ex03_05.jsp 요청       ?num=5
    // request.getParameter("num")  == null
    // Integer.parseInt( null ) 500 서버 오류 발생.
    
    // int num = Integer.parseInt(request.getParameter("num"));
    String  pNum = request.getParameter("num");
    
    int num = 0;
    if( pNum != null && !pNum.equals("")){
    	num = Integer.parseInt( pNum );
    } // 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="http://localhost/jspPro/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="http://localhost/jspPro/resources/cdn-main/example.css">
<script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
</head>
<body>
<header>
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">kenik HOme</a></h1>
  <ul>
    <li><a href="#">로그인</a></li>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<div>
  <xmp class="code">                           
  </xmp>
    <!-- 
      // 문제2
      // 가운데 커서, 포커스
      // 숫자 유효성 검사(js)
      // 엔터치면 [스트립트릿 - 서버에서 처리] 1+2+3=6 이거 뽑아내기
      // 다시 입력창 선택됨
      -->
  <!-- <form> -->
  정수 : <input type="text" id="num" name="num" autofocus="autofocus" value="<%= num%>"><br>
  <p id="demo">
  <%  
    if( pNum != null && !pNum.equals("") ){
		    int sum = 0;
		    for(int i=1; i<= num ; i++){ // 위의 변수 num
		    	sum += i;
		  %><%= i %>+<%        
		    } // for
		  %>=<%= sum %>
		  <%
    } // if
  %>
  </p>
  <!-- </form> -->
  <script>
    $("#num")
      .css("text-align","center")
      .on({
    	  "keydown":function (e){
    		  if ( !(e.which >= 48 && e.which <= 57    				 
    	              || e.which == 8
    	              || e.which == 13
    	              || e.which == 229
    	          )){
    			  alert("숫자만 입력하세요.");
    			  e.preventDefault();
    		  } // if
    	  },
    	  "keyup":function (event){
    		 //if( $("#num").val().length != 0  && event.which == 13){
    		 if( event.which == 13){	 
    			 // js BOM
    			 // $("form").submit();
    			 let numValue = $("#num").val();
    			 location.href = `ex03_05.jsp?num=\${numValue}`; // 파라미터 값을 만든 것임
    		 } // if
    	  }
      });
    
  </script>
</div> 
</body>
</html>

