package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVo;

public class MemberDao {

	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static MemberDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static MemberDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new MemberDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member order by m_idx";

		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet ������

			rs = pstmt.executeQuery();

			//4.����(record -> Vo -> list)

			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.

				//Vo�� ����
				MemberVo vo = new MemberVo();
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_email(rs.getString("m_email"));
				
				
				//list�� �߰�

				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
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
	
	
	
}
