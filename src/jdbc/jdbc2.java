package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");

		// 2. DB접속
		String user = "root";
		String password = "mysql";
		String url = "jdbc:mysql://localhost:3306/java";

		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("접속 완료!");

		// 3.SQL 문장 실행 준비
		String sql = "";
		sql += "SELECT * FROM EMP ";

		PreparedStatement stmt = con.prepareStatement(sql);

		// 4. SQL실행
		ResultSet rs = stmt.executeQuery();// DB값(행)반환 ,stmt앞에 변수rs를 지정
		// ResultSet ID, PW, NAME을 표로 만들어줌 , 화살표가 생기면서 가르키는 부분을 뽑아냄
//		for (int i = 0; i < 14; i++) {
	//		rs.next(); // 1번째 행 데이터
		while(rs.next()) {
			String empno = rs.getString("EMPNO");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			String mgr = rs.getString("mgr");
			String hiredate = rs.getString("hiredate");
			String sal = rs.getString("sal");
			String comm = rs.getString("comm");
			String deptno = rs.getString("deptno");

			System.out.printf("%s %s \n", empno, ename);

		}
	}
}