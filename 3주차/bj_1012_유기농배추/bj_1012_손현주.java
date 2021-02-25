package BJ;

import java.io.*;
import java.util.*;

public class bj_1012 {
	static int[] di = new int[] { -1, 1, 0, 0 };	// ����� �迭
	static int[] dj = new int[] { 0, 0, -1, 1 };	// ������ �迭
	static int[][] grounds;							// ���߹� �迭
	static int M, N;								// ���߹� ����, ����
	static int cnt;									// ���� ���� �׷� ���� 
	static boolean isCnt = false;					// �ѹ��� ī����(�׷��̴ϱ�)���� �÷���
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Int(br.readLine());					// ���ɸ� �Է¹޴´�.
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Int(st.nextToken());				// ��
			N = Int(st.nextToken());				// ��
			int K = Int(st.nextToken());			// ���� ����
			grounds = new int[M][N];				// ���߹� �迭 �Ҵ�
			cnt = 0;								// ī��Ʈ �ʱ�ȭ
			for (int i = 0; i < K; ++i) {			// ���߹� �Է�
				st = new StringTokenizer(br.readLine(), " ");
				grounds[Int(st.nextToken())][Int(st.nextToken())] = 1;
			}
			for (int i = 0; i < M; ++i) {
				for (int j = 0; j < N; ++j) {
					isCnt = true;					// ī��Ʈ �ʱ�ȭ
					search(i,j);					// Ž��
				}
			}
			System.out.println(cnt);				// ���
		}
	}

	static void search(int i, int j) {
		if(grounds[i][j] != 1) return;				// �̹� �湮������ ����
		else if (grounds[i][j] == 1) {				// ���߰� �ɾ��������� ����
			if(isCnt) {								// ùī�����̸�
				cnt++;								// ī����
				isCnt = false;						// ī��Ʈ �÷��� off
			}
			grounds[i][j] = -1;						// �湮 ó��
			for (int d = 0; d < 4; ++d) {			// 4���� Ž�� ����
				int ni = i + di[d];					// �̵��� �� ����
				int nj = j + dj[d];					// �̵��� �� ����
													// ���� �� && �̵� ��ġ�� ���߸� 
				if (isBoundary(ni, nj) && grounds[ni][nj] == 1) {
					search(ni,nj);					// ��Ž�� 
				}
			}
		}
	}

	static boolean isBoundary(int i, int j) {		// ���� ���� �ִ��� �˻�
		if (0 <= i && i < M && 0 <= j && j < N)
			return true;
		return false;
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
