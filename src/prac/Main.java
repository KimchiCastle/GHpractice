package prac;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int w = 0; // �迭 ����
		int h = 0; // �迭 ����

		int n = 0; // ���밳��

		int x = 0; // x��ǥ
		int y = 0; // y��ǥ

		int l = 0; // ������ ����
		int d = 0; // ������ ����

		// System.out.print("�迭���� : ");
		w = scan.nextInt();
		h = scan.nextInt();

		// if ((w <= 0 && w > 100) || (h <= 0 && h > 100)) break;

		// System.out.println("w : "+ w);
		// System.out.println("h : "+ h);

		int[][] array = new int[w][h];

		/*
		 * // ������ �迭 0���� �� ä��� for (int i = 0; i < array.length; i++) {
		 * 
		 * for (int k = 0; k < array[i].length; k++) {
		 * 
		 * array[i][k] = 0;
		 * 
		 * }
		 * 
		 * }
		 */
		// System.out.print("���밳�� : ");

		n = scan.nextInt();

		// if (n <= 0 && n > 10)break;

		// System.out.println("���� �Է�");
		for (int i = 0; i < n; i++) {

			// �������
			l = scan.nextInt();
			// ����
			d = scan.nextInt();
			// ��ǥ
			x = scan.nextInt();
			y = scan.nextInt();

			if ((d == 0 || d == 1) != true) {
				System.out.println("������ �߸� �Է� �Ͽ����ϴ�.");
				i--;
				continue;
			}

			// ���� �迭�� �ֱ�
			for (int k = 0; k < l; k++) {

				// System.out.println("�Է�for�� �����ϴ�.");

				// ���� �����϶�
				if (d == 0) {

					array[x - 1][y - 1] = 1;
					y++; // y��ǥ ��ĭ ����������

					// ���� ����
				} else {

					array[x - 1][y - 1] = 1;
					x++;

				}

			} // ���� for ����

		} // for-end

		// �迭���
		for (int i = 0; i < array.length; i++) {
			for (int k = 0; k < array[i].length; k++) {

				System.out.printf("%d ", array[i][k]);

			}
			System.out.println(); // �迭 �ٹٲ�
		}

	}

}
