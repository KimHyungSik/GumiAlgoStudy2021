package bj_4884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			long G = sc.nextInt(); //number of groups
			long T = sc.nextInt(); //teams per group
			long A = sc.nextInt(); //qualified teams per group
			long D = sc.nextInt(); //tournament seed
			if(G == -1) break;
			long group_games = 0;
			long tnmt_teams = 0;
			long tnmt_games = 0;
			long add_teams = 0;
			long i = 0;
			long tmp = T-1;
			group_games = G*(tmp*(tmp+1)/2);
			tnmt_teams = A*G + D;
//			System.out.println("group teams "+ T + " " + group_games + "*" + G);
			while(true) {
				
//				System.out.println((int)Math.pow(2, i));
				if((long)Math.pow(2, i) <= tnmt_teams && 
						tnmt_teams < (long)Math.pow(2, i+1) ) {
					break;
				}
				i++;
			}
			long p1 = (long)Math.pow(2, i);
			long p2 = (long)(long)Math.pow(2, i+1);
			if (tnmt_teams != p1) {
				{
					add_teams = p2 - tnmt_teams;
					tnmt_teams = p2;
				}
			}
			tmp = (long)Math.pow(2,(long)((Math.log10(tnmt_teams) / Math.log10(2))));
			tnmt_games = tmp-1;
//			System.out.println("tnmt teams "+tnmt_teams + " " + tnmt_games);
			System.out.println(G+"*"+A+"/"+T+"+"+D+"="+(tnmt_games+group_games)+"+"+add_teams);
		}
		sc.close();
	}

}
/*
 * Comments:
 * input ������ �� Ȯ���ؾ� �ϴ� ���������ϴ�.
 * ��� ��ǲ�� 2^16���� ������ �߰� ���������� int ������ �Ѿ������ ��찡 �տ� ���� �� �ֱ� ������
 * �� 8byte ������Ÿ���� long�� ����ؾ� �����մϴ�.
 * */
//G ���� �׷� ��
//T �� �׷��� �����ϴ� ���� ��
//A �� ������ ��ʸ�Ʈ �����ϴ� ���� ��
//D ��ʸ�Ʈ ����
//
//X = �� ����
//Y = �߰��ؾ� �ϴ� ���� ��
//
//������� ��
//
//
//��ʸ�Ʈ ����
//2^n = n(n+1)/2
//2 1
//4 2+1
//8
//16 8+4+2+1
//
//2 -> 1
//3 -> 1+2
//4 -> 1+2+3
//5 -> 1+2+3+4
