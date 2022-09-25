package ��һ��;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

//������ѧ�ӿ�
interface ISignUp{
	// ��ӡ������
	public void print();
	// ����Ƿ��� stuType��Ӧ�İ༶����
	// ���û��ʣ������뷵�� false ������ѧ������������ð༶������ true
	public boolean addStudent (int stuType);
	// ��������������Ĳ�������ʽ�������ĵ�����
	public static IParams parse() throws Exception{
		String input = "";
		int input1;
		
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        System.out.print("���룺");
		try {
			input = bufferedReader.readLine();
			String[] p = input.split("");
			for(String k:p) {
				System.out.print(k);
			}
			/*Scanner s = new Scanner(System.in);
			input1 = s.nextInt();*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	};
}

interface IParams {
	// ��ȡ�������
	public int getBig();
	// ��ȡ�а�����
	public int getMedium();
	// ��ȡС������
	public int getSmall();
	// ��ȡ��ѧ���У����� [1 2 2 3] ��ʾ ���α�����ѧһ�����ѧ�����а�ѧ�����а�ѧ����С��ѧ��
	public ArrayList<Integer> getPlanSignUp ();
}

public class SchoolSystem implements ISignUp,IParams {
	Scanner s = new Scanner(System.in);
	String str = s.next().toString();
	String[] arr  = str.split(",");
	int[] b = new int[arr.length];
	
	//System.out.println("���������ʣ�������");
	int big,medium,small;
	
	public int getBig() {
		big = s.nextInt();
		return big;
	}
	
	public int getMedium() {
		medium = s.nextInt();
		return medium;
	}

	public int getSmall() {
		small = s.nextInt();
		return small;
	}
	
	SchoolSystem(Integer big, Integer medium, Integer small){
		this.big = big;
		this.medium = medium;
		this.small = small;
	}
	
	public ArrayList<Integer> getPlanSignUp (){
		 for (int i = 0; i < b.length - 1; i++) {
	            for (int j = 0; j < b.length - 1 - i; j++) {
	                if (b[j] > b[j + 1]) {
	                   int temp = b[j];
	                    b[j] = b[j + 1];
	                    b[j + 1] = temp;
	                }
	            }
	        }
	        //System.out.print("�������У�");
	        for (int planSignUp : b) {
	            System.out.print(planSignUp + "\t");
	        }
	        return getPlanSignUp();
	}
	
	
	
	public void print() {
		System.out.println( + )
	}
	
	public boolean addStudent(int stuType) {
		int number = s.nextInt();
		if(number == 1 && big != 0) {
			big--;
			return true;
		}else if(number == 2 && medium != 0) {
			medium--;
			return true;
		}else if(number == 3 && small != 0) {
			small--;
			return true;
		}else
			return false;
	}
	
	
	public static void main(String[] args) throws Exception {
    IParams params = ISignUp.parse();//SchoolSystem.parse();
    SchoolSystem sc = new SchoolSystem (params.getBig(), params.getMedium(),params.getSmall());
    ArrayList<Integer> plan = params. getPlanSignUp ();
    for (int i = 0; i < plan.size(); i++) {
        sc. addStudent (plan.get(i));
    }
    sc.print();
	}
}
