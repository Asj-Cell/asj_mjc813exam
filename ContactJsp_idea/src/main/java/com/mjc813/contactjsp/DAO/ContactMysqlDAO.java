package com.mjc813.contactjsp.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; // SQLException 임포트 추가
import java.util.ArrayList;

import com.mjc813.contactjsp.DTO.ContactDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContactMysqlDAO {

	Connection conn = null;    /// RDBMS 접속하는 객체
	PreparedStatement ps = null;   /// sql 쿼리를 실행하는 객체
	ResultSet rs = null;   /// SELECT sql 쿼리를 실행하고 결과 값이 리턴되는 것을 읽어오는 객체


	public static Connection getConnection() throws Exception{
		String url = "jdbc:mysql://localhost:3306/numbers_db?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8"; // 접속 문자열
		String user = "root"; // 사용자 이름
		String password = "dkstjdwns!"; // 비밀번호
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.printf("getConnection : con=%s\n", con);
		/// 로그가 없으므로 콘솔에 출력했다
		return con;
	}




	public String insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String zipNumber = request.getParameter("zipNumber");
		String email = request.getParameter("email");
		/// Controller 에서 매개변수로 전달한 request 의 getParameter 로 클라이언트 화면에 입력된 값을 저장했다.
		/// 옛날 20년전 소스들은 request, response 를 계속 전달하여 사용하던 형태가 많았었다.
		int result = 0;
		try {
			conn = getConnection();
			/// prepareStatement는 순서에 따라 값이 등록된다.
			String sql = "INSERT INTO contact_tbl(name, phoneNumber, zipNumber, email) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);

			/// sql Insert, Update 쿼리가 실행될때 저장할 값을 1번부터 7번까지 설정하여 sql 쿼리문장을 만든다.
			/// 옛날 20년전 소스들은 이렇게 Java 소스에서 SQL 쿼리 문장을 만들었었는데 순서가 바뀌거나 번호가 꼬이면 에러를 찾기 매우 어려웠다.
			ps.setString(1, name);
			ps.setString(2, phoneNumber);
			ps.setString(3, zipNumber);
			ps.setString(4, email);
			System.out.printf("insert : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			result = ps.executeUpdate();
			/// sql 쿼리를 실행한다.
			System.out.println(result);
			// conn.close(); // 자원 닫기는 finally 블록에서 일관되게 처리하는 것이 좋습니다.
			// ps.close();   // 자원 닫기는 finally 블록에서 일관되게 처리하는 것이 좋습니다.

		}catch(Exception e) {
			e.printStackTrace();
		} finally { // 자원 해제를 위한 finally 블록 추가
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "list";
	}

	public String selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ContactDto>list = new ArrayList<ContactDto>();

		try {
			conn = getConnection();
			/// 연락처리스트 가져오기
			String sql = "SELECT id, name, phoneNumber, zipNumber, email FROM contact_tbl ORDER BY id";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ContactDto dto = new ContactDto();
				dto.setId(rs.getInt("id")); // 컬럼명으로 가져오는 것을 권장 (가독성 및 유지보수 용이)
				dto.setName(rs.getString("name"));
				dto.setPhoneNumber(rs.getString("phoneNumber"));
				dto.setZipNumber(rs.getString("zipNumber"));
				dto.setEmail(rs.getString("email"));
				list.add(dto);
			}
			request.setAttribute("list",list);
			/// list.jsp  list = (ArrayList<ContactDto>)request.getAttribute("list"); 값으로 치환되어 list 배열에 저장

			// conn.close(); // 자원 닫기는 finally 블록에서 일관되게 처리하는 것이 좋습니다.
			// ps.close();   // 자원 닫기는 finally 블록에서 일관되게 처리하는 것이 좋습니다.
			// rs.close();   // 자원 닫기는 finally 블록에서 일관되게 처리하는 것이 좋습니다.
		}catch(Exception e) {
			e.printStackTrace();
		} finally { // 자원 해제를 위한 finally 블록 추가
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "list.jsp";
	}


	public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String zipNumber = request.getParameter("zipNumber");
		String email = request.getParameter("email");
		/// Controller 에서 매개변수로 전달한 request 의 getParameter 로 클라이언트 화면에 입력된 값을 저장했다.
		/// 옛날 20년전 소스들은 request, response 를 계속 전달하여 사용하던 형태가 많았었다.
		int result = 0;
		try {
			conn = getConnection();

			String sql = "UPDATE contact_tbl SET";
			sql+= " name = ? , ";
			sql+= " phoneNumber = ? , ";
			sql+= " zipNumber = ? , ";
			sql+= " email = ?";
			sql+= " WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phoneNumber);
			ps.setString(3, zipNumber);
			ps.setString(4, email);
			ps.setInt(5, id);
			/// sql Insert, Update 쿼리가 실행될때 저장할 값을 1번부터 7번까지 설정하여 sql 쿼리문장을 만든다.
			/// 옛날 20년전 소스들은 이렇게 Java 소스에서 SQL 쿼리 문장을 만들었었는데 순서가 바뀌거나 번호가 꼬이면 에러를 찾기 매우 어려웠다.

			System.out.printf("update : sql=%s\n", sql);
			/// 로그가 없으므로 콘솔에 출력했다
			result = ps.executeUpdate();
			/// sql 쿼리를 실행한다.

			// conn.close(); // 자원 닫기는 finally 블록에서 일관되게 처리하는 것이 좋습니다.
			// ps.close();   // 자원 닫기는 finally 블록에서 일관되게 처리하는 것이 좋습니다.

		}catch(Exception e) {
			e.printStackTrace();
		} finally { // 자원 해제를 위한 finally 블록 추가
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		try {
			conn = getConnection();
			String id = request.getParameter("id");
			/// Controller 에서 매개변수로 전달한 request 의 getParameter 로 클라이언트 화면에 입력된 값을 저장했다.
			/// 옛날 20년전 소스들은 request, response 를 계속 전달하여 사용하던 형태가 많았었다.
			String sql = "DELETE FROM contact_tbl WHERE id=?";
			System.out.printf("delete : sql=%s (id=%s)\n", sql, id); // 로그 수정
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();

			// conn.close(); // 자원 닫기는 finally 블록에서 일관되게 처리하는 것이 좋습니다.
			// ps.close();   // 자원 닫기는 finally 블록에서 일관되게 처리하는 것이 좋습니다.
		}catch(Exception e) {
			e.printStackTrace();
		} finally { // 자원 해제를 위한 finally 블록 추가
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ContactDto modify(int id) {
		ContactDto dto = null;
		try {
			conn = getConnection();
			String sql = "SELECT id, name, phoneNumber, zipNumber, email FROM contact_tbl WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new ContactDto();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setPhoneNumber(rs.getString("phoneNumber"));
				dto.setZipNumber(rs.getString("zipNumber"));
				dto.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in selectOne: " + e.getMessage());
		}
		return dto;
	}
}