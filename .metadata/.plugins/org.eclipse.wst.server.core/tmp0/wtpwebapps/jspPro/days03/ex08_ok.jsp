<%@page import="javax.tools.DocumentationTool.Location"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// html 다 지웠음 == 응답 안한다는 뜻

String id = request.getParameter("id");
String pw = request.getParameter("pw");
// SELECT ~ DB 연동처리 해야하지만 이번엔 X 
String location;

if ( id.equals("admin") && pw.equals("1234") ) {
   //관리자 로그인 성공
   
   location = "ex08_main.jsp";
   
} else if( id.equals("hong") && pw.equals("1234") ) {
   //일반 로그인 성공
   
   location = "ex08_main.jsp";
   
} else {
   //로그인 실패
   // ex08.jsp?파라미터를 부여함으로써 로그인 실패해서 왔음을 알림
   location = "ex08.jsp?error";
   
}

// [1] 리다이렉트 (redirect)
/* response.sendRedirect(location); */ // [2]가기 전 마지막 주석
// 서버 (스크립트릿)에서 실행할 코드이므로 location.href = "ex08.jsp" 안됨 !! (js라서)

// [2] 포워딩 (forward)
// Dispatcher 발송담당자, 급파하는 사람.

RequestDispatcher dispatcher= request.getRequestDispatcher(location);
dispatcher.forward(request, response);






%>

