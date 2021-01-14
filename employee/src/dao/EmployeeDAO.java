package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import config.DBManager;
import vo.EmployeeVO;

//싱글톤 적용
public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private DBManager manager;
	public EmployeeDAO() {
		manager = DBManager.getInstance();
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public void insertEmployee(EmployeeVO vo) {
		Connection conn = manager.getConnection();
		String sql = "insert into employee values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEno());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getDepartment());
			pstmt.setInt(4, vo.getPosition());
			
			int count = pstmt.executeUpdate();
			
			if(count == 0) {
				System.out.println("사원 등록 실패");
				conn.rollback();
			}else {
				System.out.println("사원 등록 성공");
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public ArrayList<EmployeeVO> selectAllEmployee() {
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		Connection conn = manager.getConnection();
		String sql = "select * from employee";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new EmployeeVO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		return list;
	}

	public ArrayList<EmployeeVO> selectNameEmployee(String name) {
		Connection conn = manager.getConnection();
		name = "%" + name + "%";//와일드카드 양쪽에 붙이는 방법
		String sql = "select * from employee where name like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new EmployeeVO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updateEmployee(EmployeeVO vo) {
		Connection conn = manager.getConnection();
		String sql = "update employee set name=?,department=?,position=? "
				+ "where eno = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, vo.getEno());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getDepartment());
			pstmt.setInt(3, vo.getPosition());
			
			int count = pstmt.executeUpdate();
			
			if(count == 0) {
				System.out.println("사원 수정 실패");
				conn.rollback();
			}else {
				System.out.println("사원 수정 성공");
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteEmployee(String eno) {
		Connection conn = manager.getConnection();
		String sql = "delete from employee where eno = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			
			int count = pstmt.executeUpdate();
			
			if(count == 0) {
				System.out.println("사원 삭제 실패");
				conn.rollback();
			}else {
				System.out.println("사원 삭제 성공");
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public HashMap<String, Integer> positionAvgSalary() {
		Connection conn = manager.getConnection();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String sql = 
				"SELECT decode(POSITION,1,'사원',2,'주임',3,'대리',4,'과장',5,'차장',6,'부장',7,'사장'), FLOOR(AVG(SALARY)) FROM EMPLOYEE GROUP BY POSITION";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) 
				map.put(rs.getString(1), rs.getInt(2));//평균 연봉
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return map;
	}

	public String monthDispatch() {
		Connection conn = manager.getConnection();
		String sql = "select to_char(start_date,'mm') || '월', count(*) from DISPATCH "
				+ "group by to_char(start_date,'mm') order by to_char(start_date,'mm')";
		ResultSet rs = null;
		String result = "";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result += rs.getString(1) + "\t" + rs.getInt(2) + "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<EmployeeVO> maxMinEmployee() {
		Connection conn = manager.getConnection();
		String sql = "select * from employee e "
				+ "where salary = (select max(salary) from employee) "
				+ "or "
				+ "salary = (select min(salary) from employee)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new EmployeeVO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
}









