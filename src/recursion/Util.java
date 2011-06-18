package recursion;

public class Util {
	
	public static int binarySearch(int[] arr, int target)
	{
		int lastIndex = arr.length - 1;
		return binarySearchHelper(arr, 0, lastIndex, target);
	}
	
	private static int binarySearchHelper(int[] arr, int lower, int upper, int target)
	{
		int mid = ((upper - lower) / 2) + lower;
		if (lower > upper)
		{
			return -1;
		}
		else if (arr[mid] == target)
		{
			return mid;
		}
		else if (arr[mid] < target)
		{
			return binarySearchHelper(arr, mid+1, upper, target);
		}
		else
		{
			return binarySearchHelper(arr, lower, mid-1, target);
		}
	}
	
	public static int binarySearchIt(int[] arr, int target)
	{
		int lower = 0;
		int upper = arr.length - 1;
		int mid;
		
		while((lower <= upper))
		{
			mid = ((upper- lower) / 2) + lower;
			if (arr[mid] == target)
			{
				return mid;
			}
			else if (arr[mid] < target)
			{
				lower = mid + 1;
			}
			else
			{
				upper = mid - 1;
			}
		}
		return -1;
	}
	
	public static void permute(String s)
	{
		permute("", s);
	}
	
	private static void permute(String prefix, String s)
	{
		if (s.length() == 0)
		{
			System.out.println(prefix);
		}
		else
		{
			for (int i = 0; i < s.length(); i ++)
			{
				permute((prefix + s.charAt(i)), s.substring(0, i) + s.substring(i+1, s.length()));
			}
		}
	}
	
	public static void main(String[] args)
	{
		permute("abcd");
	}

}
