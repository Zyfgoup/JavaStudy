package OtherSort;

import java.util.Arrays;
import java.util.Scanner;

/*
 �������ݣ������������������е�ǰk������topK������Ϊ������̫�󣬲���ȫ���洢���ڴ��У�ֻ��һ��һ���شӴ��̻��������϶�ȡ���ݣ�
  �����һ����Ч���㷨������������
 ��һ�У��û�����K������Ҫ���topK
 ����N�������ƣ��У�ÿһ����һ�����������û����������
 �û�����-1����������ֹ
 �����topK����С���󣬿ո�ָ�
 
 1.ά��һ������Ϊk�������ȴ���k�����ݣ�Ȼ������� ������k+1ʱ���͸���������С�����Ƚϣ������min��ͽ�����С�Ͳ���
 ��������k+2ʱ����ô�͸��µ������е���Сֵ����ôʱ�临�ӶȾ�����ɨ��K������  Ȼ����ǣ�n-k��*k�����Сֵ
 ���Ծ���k +(n-k)*k
 
 2.���ǵ�������k�����󣬽���k���������С���ѣ� ��Ϊ��������������Ҫ����С�Ƚ� ����ΪС����
 ����ı��˶Ѷ������µ���
 ��ôʱ�临�ӶȾ��� �ѻ���k/2*logk + ����(n-k)�����µ��� ���ǣ�n-k��log(n-k)
 �������廹��O(nlogn)
 */
public class TopK {
	static int k;
	static int[] heap ;
	static int index=0;//��Ϊǰk��������heap��
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		k = cin.nextInt();
		heap = new int[k];
		int x = cin.nextInt();
		while(x!=-1) {
			deal(x);
			x = cin.nextInt();
		}
		System.out.println(Arrays.toString(heap));
	}
	
	private static void deal(int x) {
		if(index<k) {
			heap[index++] = x;
			if(index==k) {
				HeapSortMin.makeMinHeap(heap);
				index++;
			}
		}
		
		
		//���ǵ�����k���������һ�βŽ��жѻ�����������������k+1�ν����˶ѻ�����û�н��бȽϲ���
//		else if(index==k) {
//			HeapSortMin.makeMinHeap(heap);
//			index++;//��ֹ�ٴζѻ�
//		}
		
		//������k+1�����Ƚ���Ѷ��Ĵ�С����x��ֵ����Ѷ���ֵ  Ȼ�����µ�������С����
		else if(heap[0]<x){
				heap[0] = x;
				//�ԶѶ��������µ������ҳ���ʼ��Ϊk
				HeapSortMin.minHeapFixDown(heap, 0, k);
			}

	}
}
