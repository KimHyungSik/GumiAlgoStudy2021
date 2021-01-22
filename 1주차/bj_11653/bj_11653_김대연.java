package bj_11653;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		// �����佺�׳׽��� ü
		ArrayList<Integer> primes = new ArrayList<>();
		boolean[] ar = new boolean[input+1];
		for (int i = 2; i<input+1; i++) {
			if (ar[i] == false) {
				primes.add(i);
			}
			else {
				continue;
			}
			for (int itr = i; itr < input+1; itr += i) {
				ar[itr] = true;
			}
		}
		// �����佺�׳׽��� ü ��
		
		/*
		 * https://coding-groot.tistory.com/4 
		 * �� ��ũ�� �Ҽ� ���ϱ� ���� ������ �� �Ǿ� �ֽ��ϴ�.
		 * �����佺�׳׽��� ü�� 1-N������ �Ҽ��� ���� ��,
		 * n*boolean(1bit) ��ŭ�� ������ �ʿ��մϴ�.
		 * ������ ū ������ ������ ������ �˰����� �����ϰų�
		 * �ſ� ���� �޸� ���������� �ɷ��ִٸ� 
		 * �����ս��� ����ؼ� �� ������ sqrt(n)������ �˻��ϴ�
		 * brute force�� �����Ͻô� �͵� ����帳�ϴ�. 
		 * bigO ������ �����Ƽ� ������ ������...����;
		 */
		
//		for (Integer a : primes) {
//			System.out.println(a);
//		}
		int quotient = input;
		int divider = 0;
		int itr = 0;
		while(quotient != 1) {
			divider = primes.get(itr);
			if(quotient % divider != 0) {
				itr += 1;
				continue;
			}
			System.out.println(divider);
			quotient = quotient / divider;
		}
	}
}
