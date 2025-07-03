package com.mjc813.hrd.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mjc813.hrd.DTO.MemberDto;
import com.mjc813.hrd.DTO.MoneyDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberOracleDAO {
	
	Connection conn = null;	/// RDBMS 접속하는 객체
	PreparedStatement ps = null;	/// sql 쿼리를 실행하는 객체
	ResultSet rs = null;	/// SELECT sql 쿼리를 실행하고 결과 값이 리턴되는 것을 읽어오는 객체
	
	/*
	 * RDBMS 접속하기 위한 정적 메소드 이다. 인스턴스 할 필요 없이 MemberDAO 클래스에서는 한개만 선언되는 정적 메소드
	 */
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/XE","mjc813","0123456789");
		/// oracle 의 localhost 서버, 1521 포트, xe 리스너, 사용자계정 : system, 암호 : 1234 로 접속한다.
		System.out.printf("getConnection : con=%s\n", con);
		/// 로그가 없으므로 콘솔에 출력했다
		return con;
	}

	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다.
	 */
	public String nextCustno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			conn = getConnection();
			/// 회원번호+1 가져오기

			/// Mybatis 없던 시절인 약 20년 전에 사용했었던 옛날 방식이며
			/// Java 소스에 sql 쿼리가 있으므로 유지보수의 문제점이 매우 어렵고 심각한 버전 이었음 (이딴걸 누가 지금 사용하겠는가 ?)
			String sql = "SELECT max(custno)+1 custno FROM member_tbl_02";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int custno = 0;
			if(rs.next()) {
				custno = rs.getInt(1);
				/// sql 쿼리가 리턴하는 첫번쨰 컬럼의 값을 가져온다. 이것은 배열이 아니므로 0 부터 사용하지 않고 1 부터 시작한다.
			}
			
			request.setAttribute("custno", custno);	/// add.jsp 30 라인의 <%=custno %> 값으로 치환
			conn.close();
			ps.close();
			rs.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음

			System.out.printf("nextCustno : custno=%d\n", custno);
			/// 로그가 없으므로 콘솔에 출력했다
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "add.jsp";
	}

	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다. 
	 */
	public String selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberDto>list = new ArrayList<MemberDto>();
		try {
			conn = getConnection();
			/// 회원리스트 가져오기
			String sql = " SELECT ";
				   sql+= " custno, ";
				   sql+= " custname, ";
				   sql+= " phone, ";
				   sql+= " address, ";
				   sql+= " TO_CHAR(joindate,'YYYY-MM-DD') joindate, ";
				   sql+= " DECODE(grade,'A','VIP','B','일반','직원') grade, ";
				   sql+= " city ";
				   sql+= " FROM member_tbl_02 ";
				   sql+= " ORDER BY custno";
			System.out.printf("selectAll : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				/// sql 쿼리가 리턴하는 행 수 만큼 while 문을 반복한다.
				MemberDto member = new MemberDto();
				member.setCustno(rs.getInt(1));
				member.setCustname(rs.getString(2));
				member.setPhone(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setJoindate(rs.getString(5));
				member.setGrade(rs.getString(6));
				member.setCity(rs.getString(7));
				/// 컬럼의 값을 가져온다. 이것은 배열이 아니므로 0 부터 사용하지 않고 1 부터 7개 컬럼의 값을 member 객체에 가져온다.
				list.add(member);
				/// member 객체를 list 배열에 추가한다.
			}		
			request.setAttribute("list",list);
			/// list.jsp 8 라인의 list = (ArrayList<Member>)request.getAttribute("list"); 값으로 치환되어 list 배열에 저장
			/// list.jsp 37~51 라인의 for 루프 블록의 list 배열에 사용됨
			
			conn.close();
			ps.close();
			rs.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "list.jsp";
	}

	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다. 
	 */
	public String modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberDto>list = new ArrayList<MemberDto>();
		try {
			conn = getConnection();
			int custno = Integer.parseInt(request.getParameter("custno"));
			/// 수정할 회원정보 가져오기
			String sql = " SELECT ";
			       sql+= " custname, ";
			       sql+= " phone, ";
			       sql+= " address, ";
			       sql+= " TO_CHAR(joindate,'YYYY-MM-DD') joindate, ";
			       sql+= " grade, ";
			       sql+= " city ";
			       sql+= " FROM member_tbl_02 WHERE custno ="+custno;
			System.out.printf("modify : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				/// sql 쿼리가 리턴하는 행 이 있다면 값을 설정한다.
				MemberDto member = new MemberDto();
				member.setCustno(custno);
				member.setCustname(rs.getString(1));
				member.setPhone(rs.getString(2));
				member.setAddress(rs.getString(3));
				member.setJoindate(rs.getString(4));
				member.setGrade(rs.getString(5));
				member.setCity(rs.getString(6));
				/// 컬럼의 값을 가져온다. 이것은 배열이 아니므로 1 부터 6개 컬럼의 값을 member 객체에 가져온다.
				list.add(member);
				/// member 객체 한 개만 list 배열에 추가한다.
			}
				
			request.setAttribute("list",list);
			/// modify.jsp 8 라인의 list = (ArrayList<Member>)request.getAttribute("list"); 값으로 치환되어 list 배열에 저장
			/// modify.jsp 10~16 라인의 list 배열 0 index 변수의 값을 화면에 출력하는데 사용됨
			
			conn.close();
			ps.close();
			rs.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "modify.jsp";
	}

	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다. 
	 */
	public String selectResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MoneyDto>list = new ArrayList<MoneyDto>();
		try {
			conn = getConnection();
			/// 회원번호+1 가져오기
			String sql = "SELECT ";
			       sql+= "m1.custno, ";
			       sql+= "m1.custname, ";
			       sql+= "DECODE(m1.grade,'A','VIP','B','일반','직원')grade, ";
			       sql+= "SUM(m2.price)price ";
			       sql+= "FROM member_tbl_02 m1, money_tbl_02 m2 ";
			       sql+= "WHERE m1.custno = m2.custno ";
			       sql+= "GROUP BY (m1.custno, m1.custname, grade) ";
			       sql+= "ORDER BY price DESC";
			System.out.printf("selectResult : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				/// sql 쿼리가 리턴하는 행 수 만큼 while 문을 반복한다.
				MoneyDto money = new MoneyDto();
				money.setCustno(rs.getInt(1));
				money.setCustname(rs.getString(2));
				money.setGrade(rs.getString(3));
				money.setPrice(rs.getInt(4));
				/// 컬럼의 값을 가져온다. 이것은 배열이 아니므로 0 부터 사용하지 않고 1 부터 4개 컬럼의 값을 money 객체에 가져온다.
				list.add(money);
				/// money 객체를 list 배열에 추가한다.
			}
			request.setAttribute("list", list);
			/// result.jsp 8 라인의 list = (ArrayList<Money>)request.getAttribute("list"); 값으로 치환되어 list 배열에 저장
			/// result.jsp 33~41 라인의 for 루프 블록의 list 배열에 사용됨
			
			conn.close();
			ps.close();
			rs.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "result.jsp";
	}

	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다.
	 */
	public String insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		/// Controller 에서 매개변수로 전달한 request 의 getParameter 로 클라이언트 화면에 입력된 값을 저장했다.
		/// 옛날 20년전 소스들은 request, response 를 계속 전달하여 사용하던 형태가 많았었다.
		int result = 0;
		try {
			conn = getConnection();
			/// prepareStatement는 순서에 따라 값이 등록된다.
			String sql = "INSERT INTO member_tbl_02 VALUES(?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
			ps = conn.prepareStatement(sql);

			/// sql Insert, Update 쿼리가 실행될때 저장할 값을 1번부터 7번까지 설정하여 sql 쿼리문장을 만든다.
			/// 옛날 20년전 소스들은 이렇게 Java 소스에서 SQL 쿼리 문장을 만들었었는데 순서가 바뀌거나 번호가 꼬이면 에러를 찾기 매우 어려웠다. 
			ps.setInt(1, custno);
			ps.setString(2, custname);
			ps.setString(3, phone);
			ps.setString(4, address);
			ps.setString(5, joindate);
			ps.setString(6, grade);
			ps.setString(7, city);
			System.out.printf("insert : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			result = ps.executeUpdate();
			/// sql 쿼리를 실행한다.
			System.out.println(result);
			conn.close();
			ps.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다. 
	 */
	public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		/// Controller 에서 매개변수로 전달한 request 의 getParameter 로 클라이언트 화면에 입력된 값을 저장했다.
		/// 옛날 20년전 소스들은 request, response 를 계속 전달하여 사용하던 형태가 많았었다.
		int result = 0;
		try {
			conn = getConnection();
			
			String sql = "UPDATE member_tbl_02 SET";
				   sql+= " custname = ? , ";
				   sql+= " phone = ? , ";
				   sql+= " address = ? , ";
				   sql+= " joindate = TO_DATE(?,'YYYY-MM-DD'), ";
				   sql+= " grade = ? , ";
				   sql+= " city = ? ";
				   sql+= " WHERE custno = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, custname);
			ps.setString(2, phone);
			ps.setString(3, address);
			ps.setString(4, joindate);
			ps.setString(5, grade);
			ps.setString(6, city);
			ps.setInt(7, custno);
			/// sql Insert, Update 쿼리가 실행될때 저장할 값을 1번부터 7번까지 설정하여 sql 쿼리문장을 만든다.
			/// 옛날 20년전 소스들은 이렇게 Java 소스에서 SQL 쿼리 문장을 만들었었는데 순서가 바뀌거나 번호가 꼬이면 에러를 찾기 매우 어려웠다.

			System.out.printf("update : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			result = ps.executeUpdate();
			/// sql 쿼리를 실행한다.
			
			conn.close();
			ps.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다. 
	 */
	public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		try {
			conn = getConnection();
			String custno = request.getParameter("custno");
			/// Controller 에서 매개변수로 전달한 request 의 getParameter 로 클라이언트 화면에 입력된 값을 저장했다.
			/// 옛날 20년전 소스들은 request, response 를 계속 전달하여 사용하던 형태가 많았었다.
			String sql = "DELETE FROM member_tbl_02 WHERE custno="+custno;
			System.out.printf("delete : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
			/// sql 쿼리를 실행한다.
			
			conn.close();
			ps.close();
			/// RDBMS 접속하고 사용 했었던 자원을 해제해야 한다. 이거 안하면 자원 누수로 나중에 프로그램 뻗었었음	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}