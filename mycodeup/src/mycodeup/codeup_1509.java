package mycodeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup_1509 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] board = new int[11][10];
		
		//���� ���� ���º���
		final int FALL = 2;
		final int CRASH = 3;

		StringTokenizer st;
		//������ ����
		for (int i = 0; i < board.length; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int k = 0; k < board[i].length; k++) {

				board[i][k] = Integer.parseInt(st.nextToken());
			}

		}

		// �������� 
		for (int i = 0; i < 10; i++) {

			int point = 0;
			int life = 0;
			
			for (int k = 0; k < 10; k++) {

				// ���� ���� ������ ���
				if (point < board[k][i]) {
					life = CRASH;
				}
				// ���� �������� ���
				if (point > board[k][i]) {
					life = FALL;
				}

			
				//����Ʈ�� �� �ձ��� �������
				if (k == 9) {
					//��ĭ �� �鿩�� ���� ���� �ִ��� ������ Ȯ��
					if (board[k + 1][i] == 1) {
						// ���� ������ ����
						if (life == FALL) {
							System.out.printf("%d fall\n", i + 1);
							// ���� �ھ��� ���
						} else if (life == CRASH) {
							System.out.printf("%d crash\n", i + 1);
						} else if (life == 0) {
							System.out.printf("%d safe\n", i + 1);
						}
					}
				} //�� ����Ȯ�� if�� ����
				
			}// �� Ȯ�� ���� �� k++


		} // ��ü for�� ����


	}

}
