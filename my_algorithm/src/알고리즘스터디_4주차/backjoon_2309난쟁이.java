package �˰����͵�_4����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon_2309������ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
�Է�
��ȩ ���� �ٿ� ���� �����̵��� Ű�� �־�����. �־����� Ű�� 100�� ���� �ʴ� �ڿ����̸�, 
��ȩ �������� Ű�� ��� �ٸ���, ������ ������ ���� ������ ��쿡�� �ƹ��ų� ����Ѵ�.

���
�ϰ� �������� Ű�� ������������ ����Ѵ�. �ϰ� �����̸� ã�� �� ���� ���� ����.
	
*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] nan = new int[9];

		int nan_hap = 0;

		for(int i=0; i<nan.length; i++) {
			nan[i] = Integer.parseInt(br.readLine());
			nan_hap += nan[i];
		}
		//��¥�� ã�� ���� ����
		int nan_liar = nan_hap - 100;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<nan.length; i++) {
			//��ã������ ��ĭ�� �÷���
			for(int k=i+1; k<nan.length; k++) {
				
				if(nan[i] + nan[k] == nan_liar) {
					//���ļ� ������ ã������ �׵� 0���� �ٲٰ�
					nan[i] = 0;
					nan[k] = 0;
					//����
					Arrays.sort(nan);
					//������ 0,1 ������ append
					for(int x=2; x<nan.length; x++) {
						sb.append(nan[x]).append("\n");
					}// 3��° for end;
					// ������ �� ã���� ��� �����ؼ� ���θ޼ҵ带 ������������.
					// ���� ���� �� ����ϰ� ����!!
					System.out.println(sb);
					//���θ޼ҵ� ��ü�� ����
					return;
				}// �񱳹� end;
				
				
			}// �ι�° for-end
		} // ù��° for-end
		
		
		
		
		
		
	}

}
