import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Arrays; 
import java.util.Scanner; 
import java.io.IOException; 
import java.util.*; 


//3 way merge sort 
public class MegaSort
{
	int partition(int[] a, int min, int max)
	{
		int pivot = a[max]; //Chooses highest element as pivot
		int i = (min-1); 

		for(int j = min; j < max; j++)
		{	
			//Element in array is less than pivot
			if(a[j] < pivot)
			{
				i++; 

				//Swap elements
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp; 
				
			}
		}

		//Element in array is greater than pivot
		//Swap elements
		int temp = a[i+1];
		a[i+1] = a[max];
		a[max] = temp;

		return i+1; 
	}

	void quickSort(int a[], int min, int max)
	{
		int partition = partition(a,min,max); //Places the pivot in the correct position. 

		if(partition-1 > min)
		{
			//Recursively calls quicksort on the left side of the partitioned array
			quickSort(a,min,partition-1);
		}

		if(partition+1 < max)
		{
			//Recursively calls quicksort on the right side of the partitioned array
			quickSort(a, partition+1,max);
		}
	}

	public void sort(int a[])
	{
		//Calls quicksort function for an array from beginning to end. 
		quickSort(a,0,a.length-1);
	}

	public static void main(String[] args)
	{
		int[] numArr = new int[1000000];

		if(args.length > 0) //On terminal, file name must be specified. 
		{
			File file = new File(args[0]); 
		} 

		else
		{
			System.out.println("Error : File name must be specified"); 
		}

		try
		{
			File f = new File("1m-ints.txt"); 
			Scanner scan = new Scanner(f); 

			int counter = 0; 

			while(scan.hasNext()) //While scanner is reading file
			{
				counter++;  
				scan.nextInt(); 
			}

			numArr = new int[counter]; 
			Scanner scan1 = new Scanner(f); 

			for(int i = 0; i < numArr.length; i++) //Adds lines being read into an array of integers 
			{
				numArr[i] = scan1.nextInt(); 
			}

			MegaSort qs = new MegaSort(); //Call merge sort function

			qs.sort(numArr); 

			for(int i = 0; i < numArr.length;i++) //Prints array
			{
				System.out.println(numArr[i] +" "); 
			}

		}

		catch(Exception e) //If file not found
		{
			System.out.println("Could not find file"); 
			;
		}
			

	}
}