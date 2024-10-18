<%@page import="org.doit.domain.EmpVO"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
		// ex01_emp.jsp?deptno=
		int deptno;
		String pDeptno = request.getParameter("deptno");
		
		//System.out.println(">>> " + pDeptno);
		
		try{
			deptno = Integer.parseInt(pDeptno);
		} catch(Exception e) {
		 	deptno = 10;
		}
		
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " SELECT empno, ename, job, mgr, "
					   + " TO_CHAR(hiredate, 'yyyy-MM-dd') hiredate, sal, comm, deptno "
					   + " FROM emp "
					   + " WHERE deptno = ? "; /* ?는 파라미터 값이다. */
		ResultSet rs = null;
					   
		int empno, mgr;
		String ename, job;
		Date hiredate;
		double sal, comm;

		String dname, loc;
		EmpVO vo = null;
		ArrayList<EmpVO> list = null;
		
		Iterator<EmpVO> ir = null;
		
		try{
			conn = DBConn.getConnection();
			
			
			pstmt = conn.prepareStatement(sql);
			// ? 물음표에 해당하는 값을 줘야함
			pstmt.setInt(1,deptno);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<>();
				do {
					
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					mgr = rs.getInt("mgr");
					hiredate = rs.getDate("hiredate");
					sal = rs.getDouble("sal");
					comm = rs.getDouble("comm");
					
					vo = new EmpVO().builder()
							.empno(empno)
							.ename(ename)
							.job(job)
							.mgr(mgr)
							.hiredate(hiredate)
							.sal(sal)
							.comm(comm)
							.build();
					
					list.add(vo);
					
					
				} while(rs.next() );
			} // if
			
		} catch(Exception e) {
			
		} finally {
			
			try{
				pstmt.close();
				DBConn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} // try

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
   
  	  </xmp>
  	  
  	  <h2>emp list</h2>
  	  <table>
  	  	<thead>
  	  		<th>empno</th>
  	  		<th>ename</th>
  	  		<th>job</th>
  	  		<th>mgr</th>
  	  		<th>hiredate</th>
  	  		<th>sal</th>
  	  		<th>comm</th>
  	  		<th>deptno</th>
  	  	</thead>
  	  	
  	  	<tbody>
  	  		<%
  	  		if(list == null) {
  	  		%>
  	  		<tr>
  	  			<td colspan="8">사원이 존재 X</td>
  	  		</tr>
  	  		<%
  	  		} else {
  	  			ir = list.iterator();
  	  			while (ir.hasNext()) {
  	  				vo = ir.next();
  	  		%>
  	  			<tr>
  	  				<td> <%= vo.getEmpno() %></td>
  	  				<td><%= vo.getEname() %></td>
  	  				<td><%= vo.getJob() %> </td>
  	  				<td><%= vo.getMgr() %></td>
  	  				<td><%= vo.getHiredate() %></td>
  	  				<td><%= vo.getSal() %></td>
  	  				<td><%= vo.getComm() %></td>
  	  				<td><%= vo.getDeptno() %></td>
  	  			</tr>
  	  		<%
  	  			} // while
  	  		} // if
  	  		%>
  	  	</tbody>
  	  	
  	  	<tfoot>
  	  	  <tr>
  	  		<td colspan = "8"> 
  	  			<span class = "badge left red"> <%= list == null?0:list.size() %></span>명.
  	  			<a href="javascript:history.back()">뒤로 가기</a>
  	  		</td>
  	  	  </tr>
  	  	</tfoot>
  	  	
  	  </table>
  	  
    </div>
    
  </body>
</html>
