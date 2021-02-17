package BJ;
import java.util.*;
public class bj_1010 {
	static int[][] isVisited = new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();							// ���� �Է�
		for(int tc=1; tc<=T; tc++) { 
			int R = sc.nextInt(); 						// ���� N => nPr ���Ǹ� ���� ������ ����  
			int N = sc.nextInt(); 						// ���� M
			sb.append(Combination(N,R)).append('\n');
		}
		System.out.println(sb);
		sc.close();
	}
	
	public static int Combination(int n, int r) {
		if(isVisited[n][r]>0) return isVisited[n][r]; 	// �̹� �湮��(����Ǿ��ִ�)��� ����
		if(n==r || r ==0) return isVisited[n][r] = 1; 	// nPn, nP1 ��� 1�̴ϱ� ����
		else return isVisited[n][r] = Combination(n-1, r-1)+Combination(n-1,r);
	}

}
