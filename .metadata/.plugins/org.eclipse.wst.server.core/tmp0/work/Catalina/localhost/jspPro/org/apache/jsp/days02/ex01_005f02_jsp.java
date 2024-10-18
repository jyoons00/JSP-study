/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-10-16 06:12:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.days02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import com.util.DBConn;
import org.doit.domain.DeptVO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class ex01_005f02_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(10);
    _jspx_imports_classes.add("org.doit.domain.DeptVO");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("com.util.DBConn");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

   Connection conn = null;
   PreparedStatement pstmt = null;
   String sql = " SELECT * "
            + " FROM dept";
   ResultSet rs = null;
   
   int deptno;
   
   String dname, loc;
   DeptVO vo = null;
   ArrayList<DeptVO> list = null;
   Iterator<DeptVO> ir = null;
   
   try{
      conn = DBConn.getConnection();
      System.out.println("conn은 " +conn);
      System.out.println("닫혀있나 " + conn.isClosed());
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if( rs.next() ){
         list = new ArrayList<>();
         do{
            
            deptno = rs.getInt("deptno");
            dname = rs.getString("dname");
            loc = rs.getString("loc");
            
            vo = new DeptVO().builder().deptno(deptno).dname(dname).loc(loc).build();
            list.add(vo);
         }while(rs.next());
      }
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         pstmt.close();
         DBConn.close();
      }catch(Exception e){
         e.printStackTrace();
      }
      
   }
   

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"http://localhost/jspPro/images/SiSt.ico\">\r\n");
      out.write("<!-- <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script> -->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://localhost/jspPro/resources/cdn-main/example.css\">\r\n");
      out.write("<script src=\"http://localhost/jspPro/resources/cdn-main/example.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.14.0/themes/base/jquery-ui.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"/resources/demos/style.css\">\r\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.7.1.js\"></script>\r\n");
      out.write("  <script src=\"https://code.jquery.com/ui/1.14.0/jquery-ui.js\"></script>\r\n");
      out.write("  \r\n");
      out.write("   <script>\r\n");
      out.write("  $( function() {\r\n");
      out.write("    $( \"#dept :checkbox\" ).checkboxradio();\r\n");
      out.write("  } );\r\n");
      out.write("  </script>\r\n");
      out.write("  \r\n");
      out.write("  <style>\r\n");
      out.write(" span.material-symbols-outlined{\r\n");
      out.write("    vertical-align: text-bottom;\r\n");
      out.write(" }  \r\n");
      out.write("</style>\r\n");
      out.write("  \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("  <h1 class=\"main\"><a href=\"#\" style=\"position: absolute;top:30px;\">Seeker Home</a></h1>\r\n");
      out.write("  <ul>\r\n");
      out.write("    <li><a href=\"#\">로그인</a></li>\r\n");
      out.write("    <li><a href=\"#\">회원가입</a></li>\r\n");
      out.write("  </ul>\r\n");
      out.write("</header>\r\n");
      out.write("<div>\r\n");
      out.write(" <xmp class=\"code\">\r\n");
      out.write("    \r\n");
      out.write("  </xmp>\r\n");
      out.write(" <h2>Checkbox</h2>\r\n");
      out.write(" \r\n");
      out.write(" <!-- <form action=\"ex01_emp_02.jsp\" method=\"get\"> -->\r\n");
      out.write(" \r\n");
      out.write("    <fieldset id=\"dept\">\r\n");
      out.write("      <legend>dept check : </legend>\r\n");
      out.write("      <!-- <label for=\"deptno-부서번호\">부서명/label>\r\n");
      out.write("      <input type=\"checkbox\" name=\"deptno\" id=\"deptno-부서번호\" value=\"부서번호\">\r\n");
      out.write("      \r\n");
      out.write("      <label for=\"checkbox-2\">3 Star</label>\r\n");
      out.write("      <input type=\"checkbox\" name=\"checkbox-2\" id=\"checkbox-2\">\r\n");
      out.write("      \r\n");
      out.write("      <label for=\"checkbox-3\">4 Star</label>\r\n");
      out.write("      <input type=\"checkbox\" name=\"checkbox-3\" id=\"checkbox-3\">\r\n");
      out.write("      \r\n");
      out.write("      <label for=\"checkbox-4\">5 Star</label>\r\n");
      out.write("      <input type=\"checkbox\" name=\"checkbox-4\" id=\"checkbox-4\"> -->\r\n");
      out.write("      ");

        ir = list.iterator();
        while(ir.hasNext()){
           vo = ir.next();
           deptno = vo.getDeptno();
           dname = vo.getDname();
     
      out.write("\r\n");
      out.write("        <label for=\"deptno-");
      out.print( deptno );
      out.write('"');
      out.write('>');
      out.print( dname );
      out.write("</label>\r\n");
      out.write("         <input type=\"checkbox\" name=\"deptno\" id=\"deptno-");
      out.print( deptno );
      out.write("\" value=\"");
      out.print( deptno );
      out.write("\">\r\n");
      out.write("   ");
      
        }//while
   
      out.write("\r\n");
      out.write("    </fieldset>\r\n");
      out.write("    \r\n");
      out.write("    <!-- 지금은 폼태그 안 묶어 location.href 사용 한다 -->\r\n");
      out.write("     <input type=\"button\" value=\"사원 확인\">\r\n");
      out.write("     \r\n");
      out.write("    <!-- <input type=\"submit\" value=\"사원 확인\"> -->\r\n");
      out.write("    \r\n");
      out.write("    <!-- </form> -->\r\n");
      out.write("    <script>\r\n");
      out.write("    	// ex01_emp_02.jsp?deptno=20\r\n");
      out.write("    			$(\":button[value='사원 확인']\").on(\"click\", function (event) {\r\n");
      out.write("					if ($(\":checkbox[name=deptno]:checked\").length == 0) {\r\n");
      out.write("						alert(\"부서를 체크 하시오\");\r\n");
      out.write("						return;\r\n");
      out.write("					}\r\n");
      out.write("					\r\n");
      out.write("					// href 속성을 만드는게 목적이다.\r\n");
      out.write("					\r\n");
      out.write("					// 2번째 방법\r\n");
      out.write("					const deptnoArr = []; //3\r\n");
      out.write("					$(\":checkbox[name=deptno]:checked\").each(function (index, element) {\r\n");
      out.write("						let deptno = element.value;\r\n");
      out.write("						deptnoArr.push(`deptno=${deptno}`) // 2 4\r\n");
      out.write("					})\r\n");
      out.write("					location.href = `ex01_emp_02.jsp?${deptnoArr.join('&')}` // 5\r\n");
      out.write("					\r\n");
      out.write("    			}); \r\n");
      out.write("    			\r\n");
      out.write("					// 1번째 방법\r\n");
      out.write("					/* \r\n");
      out.write("					let hrefValue = \"ex01_emp_02.jsp?\" //2\r\n");
      out.write("					\r\n");
      out.write("					$(\":checkbox[name=deptno]:checked\").each(function (index, element) {\r\n");
      out.write("						let deptno = element.value;\r\n");
      out.write("						hrefValue += `deptno=${deptno}&` //3\r\n");
      out.write("					})\r\n");
      out.write("					\r\n");
      out.write("					location.hret = `hrefValue; // 4\r\n");
      out.write("					*/\r\n");
      out.write("\r\n");
      out.write("    		\r\n");
      out.write("				\r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
      out.write("</div> \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
