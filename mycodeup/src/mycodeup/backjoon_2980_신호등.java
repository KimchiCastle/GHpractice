package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_2980_��ȣ�� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
	ù° �ٿ� ��ȣ���� ���� N�� ������ ���� L�� �־�����. (1 �� N �� 100, 1 �� L �� 1000)

���� N�� �ٿ��� �� ��ȣ���� ���� D, R, G�� �־�����. (1 �� D < L, 1 �� R �� 100, 1 �� G �� 100) 

D�� ��ȣ���� ��ġ�̸�, R�� G�� ������, �ʷϻ��� ���ӵǴ� �ð��̴�.

��ȣ���� D�� �����ϴ� ������ �־�����, ���� ��ġ�� �ִ� ��ȣ���� �� �� �̻� �ִ� ���� ����.

���
ù° �ٿ� ����̰� ������ ������ �̵��ϴµ� �ɸ��� �ð��� ����Ѵ�.

���� �Է� 1 
2 10
3 5 5
5 2 2
���� ��� 1 
12
���� �Է� 2 
4 30
7 13 5
14 4 4
15 3 10
25 1 1
���� ��� 2 
36	
		
*/		
		
		/*
		 * Ȯ���ؾ��ϴ°�. 
		 * 1. ���������� �ʷϺ����� ����Ȯ��
		 * 2. ���� ����ġ�� �ɸ� �ð�
		 * 3. ���� ��ȣ�� ��ġ
		 * 4. ������ ��ȣ��� �����Ÿ�
		 */
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int mytime = 0;
		
		int myL = 0;
		
		int [][] sinho = new int [N][3];
		
		for (int i = 0; i < N; i++) {
		
			st = new StringTokenizer(br.readLine());
			
			for (int k = 0; k < sinho[i].length; k++) {
				
				sinho[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
	
		for (int i = 0; i < N; i++) {

			//		����ð� + ���ݽ�ȣ�� - ����ȣ��
			mytime = mytime + (sinho[i][0] - myL); // �ɸ��ð�

			myL = sinho[i][0]; // ���� �� �Ÿ�
			
			//ex) 7%18 = �״�� 7
			int RG = mytime % (sinho[i][1] + sinho[i][2]); //���������� �ʷϺ����� Ȯ�� ����
			
			if (RG <= sinho[i][1]) { // �������ϰ�� ��ٸ���
				//		7�� + (13 - 7 = 6)
				mytime = mytime +  (sinho[i][1] - RG);
				
			}

		} // for - end
		
		/*
		 �ʹ� ���� �����ؼ� Ǯ���� �ߴ�.
		 ���ݴ� ���ٹ���� ���Ӱ� �����ؼ� Ǯ��
		for (int i = 0; i < sinho.length; i++) {
			if (sinho[i][0] < sinho[i][1]) {
				L = sinho[i][1] - sinho[i][0] + L;
			}
		}
		
		
			if ((i + 1) == N) { // �Ǹ����� ��ȣ���ΰ�쿡��?
				if (mytime % RG >= sinho[i][1]) { // �ʷϺ��ϰ��
					mytime = mytime + (L - sinho[i][0]);
				} // else ������ ��ȣ �ð� ����� mytime = mytime + (L-sinho[i][0]);
			}
		*/
		/*
		for (int i = 0; i < sinho.length; i++) {
			for (int k = 0; k < sinho[i].length; k++) {
				System.out.printf("%d ",sinho[i][k]);
			}
			System.out.println();
		}
		*/
		System.out.printf("%d",(mytime +(L - myL)));
		
		
	}

}
