package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.VisitVo;

public class VisitDao {

	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static VisitDao single = null;

	//스태틱은 무조건 스태틱으로만
	public static VisitDao getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new VisitDao();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private VisitDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Visit order by idx desc";

		try {
			//1.connection 얻어오기
			//				 커낵션 객체생성, DB에게 커낵션얻기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet 얻어오기

			rs = pstmt.executeQuery();

			//4.포장(record -> Vo -> list)

			while (rs.next()) {
				//rs가 가리키는 행(레코드)의 값을 읽어온다.

				//Vo로 포장
				VisitVo vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				//list에 추가

				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//연결(생성) 되었으면 닫아라.(생성 역순으로 닫기)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
	
	//로그인 한 회원이 쓴 글만 조회
	public List<VisitVo> selectListOne(String m_id) {
		
		List<VisitVo> list = new ArrayList<VisitVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Visit where m_id = ? order by idx desc";
		
		try {
			//1.connection 얻어오기
			//				 커낵션 객체생성, DB에게 커낵션얻기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//3.ResultSet 얻어오기
			pstmt.setString(1, m_id);
			
			rs = pstmt.executeQuery();
			
			//4.포장(record -> Vo -> list)
			
			while (rs.next()) {
				//rs가 가리키는 행(레코드)의 값을 읽어온다.
				
				//Vo로 포장
				VisitVo vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				//list에 추가
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				//연결(생성) 되었으면 닫아라.(생성 역순으로 닫기)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	//글쓰기 Dao 메서드
	public int insert(VisitVo vo) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "insert into visit values(seq_visit_v_idx.nextVal,?, ?, ?, ?, sysdate)";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//3.pstmt의 변수처리된 parameter 설정과정
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIp());
			
			
			//4.DML(insert/update/delete)명령 실행, res는 처리된 행수를반환
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//닫기 (열린 역순)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//리턴을 0으로 받으면 명령 실패!
		return res;
	}
	
	
	
	//idx에 해당되는 객체 1건 구하기
	public VisitVo selectListOne(int idx) {

		VisitVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//	parameter(전달 인자) index
		String sql = "select * from visit where idx = ?";

		try {
			//1.connection 얻어오기
			//				 커낵션 객체생성, DB에게 커낵션얻기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.pstmt셋팅
			pstmt.setInt(1, idx);
			
			
			//4.ResultSet 얻어오기

			rs = pstmt.executeQuery();

			//5.포장(record -> Vo)
			if (rs.next()) {
				//rs가 가리키는 행(레코드)의 값을 읽어온다.

				//Vo로 포장
				vo = new VisitVo();
				vo.setM_id(rs.getString("m_id"));
				vo.setIdx(rs.getInt("idx"));
				vo.setPwd(rs.getString("pwd"));
				vo.setContent(rs.getString("content"));
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//연결(생성) 되었으면 닫아라.(생성 역순으로 닫기)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}
	
	//삭제
	public int delete(int idx) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "delete from visit where idx = ?";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//3.pstmt의 변수처리된 parameter 설정과정
			pstmt.setInt(1, idx);
			
			//4.DML(insert/update/delete)명령 실행, res는 처리된 행수를반환
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//닫기 (열린 역순)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//리턴을 0으로 받으면 명령 실패!
		return res;
	}
	
	public int update(VisitVo vo) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "update visit set m_id=?, pwd=?, content=?, ip=?, regdate=sysdate where idx = ?";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//3.pstmt의 변수처리된 parameter 설정과정
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getIdx());
			
			//4.DML(insert/update/delete)명령 실행, res는 처리된 행수를반환
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//닫기 (열린 역순)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//리턴을 0으로 받으면 명령 실패!
		return res;
	}
	
}

