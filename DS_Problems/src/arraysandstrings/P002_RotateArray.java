package arraysandstrings;
import java.util.Arrays;

import org.junit.Test;

public class P002_RotateArray {

	@Test
	public void dataSet_One()
	{
		int[] array= {1,2,3,4,5,6,8};
		int count=25;
		int[] rotate = right_rotate(array,count);
		System.out.println("Right:"+Arrays.toString(rotate));
		int[] arrayDup={1,2,3,4,5,6,8}; 
		rotate = left_rotate(arrayDup,count);
		System.out.println("Left:"+Arrays.toString(rotate));

	}

	@Test public void dataSet_Two() 
	{ 
		int[] array= {4,3,2,3,2,1,0}; int count=2;
		int[] rotate = right_rotate(array,count);
		System.out.println("Right:"+Arrays.toString(rotate));
		int[] arrayDup= {4,3,2,3,2,1,0}; 
		rotate = left_rotate(arrayDup,count);
		System.out.println("Left:"+Arrays.toString(rotate));
	}

	@Test
	public void dataSet_Three()
	{ 
		int[] array= {4,-1,-2,-3,5,0,7,8}; 
		int count=9; 
		int[] rotate = right_rotate(array,count);
		System.out.println("Right:"+Arrays.toString(rotate));
		int[] arrayDup= {4,-1,-2,-3,5,0,7,8}; 
		rotate = left_rotate(arrayDup,count);
		System.out.println("Left:"+Arrays.toString(rotate));
	}
	//Solution 1

	private int[] rotate2(int[] numbers, int rcount)
	{
		int actualcount=rcount%numbers.length;//0[1]
		int temp1=0;
		for(int i=0;i<actualcount;i++)
		{
			temp1=numbers[0];
			for(int j=0;j<numbers.length-1;j++)
			{
				numbers[j]=numbers[j+1];//0[M*N]-->0[N^2]
			}
			numbers[numbers.length-1]=temp1;//0[N]
		}
		return numbers;//0[1]
	}

	//Total time complexity -->0[1]+0[N^2]+0[N]+0[1]=0[N^2]
	//------------------------------------------------------

	//Solution 2
	
	// Rotate right:
	//	1.Reverse the Whole array(0 to size-1)
	//	2.Reverse the array from 0 to rotate count-1
	//	3. Reverse the array from rotateCount to size-1

	private int[] right_rotate(int[] numbers, int rcount)
	{
		int size=numbers.length;
		int actualCount=rcount%size;//O[1]
		reverseArray(numbers,0,size-1);//O[N]
		reverseArray(numbers,0,actualCount-1);//O[N]
		reverseArray(numbers,actualCount,size-1);//O[N]
		return numbers;
	}
	
	//Rotate Left:
	//	1. Reverse the array from 0 to rotate count-1
	//	2. Reverse the array from rotateCount to size-1
	//	3. .Reverse the Whole array(0 to size-1)
	private int[] left_rotate(int[] numbers, int rcount)
	{
		int size=numbers.length;
		int actualCount=rcount%size;//O[1];
		reverseArray(numbers,0,actualCount-1);//O[N]
		reverseArray(numbers,actualCount,size-1);//O[N]
		reverseArray(numbers,0,size-1);//O[N]
		return numbers;
	}
	
	
	//Declare Two Pointers, start=0, and end=size-1
	//Swap the elements at start and end
	//Increment Start and Decrement end
	//Continue till start<end
	
	private int[] reverseArray(int[] array,int startIndex,int endIndex)
	{
		int j= endIndex;int temp=0;int i=startIndex;
		while(i<j)
		{
			temp=array[j];
			array[j]=array[i];
			array[i]=temp;
			j--;i++;
		}
		return array;
	}
	//Total time complexity=O[1]+O[N]+O[N]+O[N]==>O[3N]
}
