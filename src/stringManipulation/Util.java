package stringManipulation;

import java.util.HashMap;

public class Util {
	
	public static Character firstNonRep(String s)
	{
		HashMap <Character, Integer> map = new HashMap<Character, Integer>();
		int len = s.length();
		Character curr;
		Integer value;
		int intValue;
		
		for (int i = 0; i < len; i++)
		{
			curr = new Character(s.charAt(i));
			value = map.get(curr);
			if (value == null)
			{
				map.put(curr, new Integer(1));
			}
			else
			{
				intValue = value.intValue();
				intValue++;
				map.put(curr, new Integer(intValue));
			}
		}
		
		for (int i = 0; i < len; i++)
		{
			curr = new Character(s.charAt(i));
			if (map.get(curr).intValue() == 1)
			{
				return curr;
			}
		}
		return null;
	}
	
	public static String removeChars(String str, String remove)
	{
		HashMap<Character, Object> map = new HashMap<Character, Object>();
		int removeLen = remove.length();
		Character c;
		Object rem = new Object();
		
		for (int i = 0; i < removeLen; i++)
		{
			c = new Character(remove.charAt(i));
			map.put(c, rem);
		}
		
		StringBuilder strbld = new StringBuilder();
		int strLen = str.length();
		for (int i = 0; i < strLen; i++)
		{
			c = new Character(str.charAt(i));
			if (map.get(c) != rem)
			{
				strbld.append(c);
			}
		}
		return strbld.toString();
	}
	
	public static String revWords(String s)
	{
		String[] words = s.split(" ");
		int lastIndex = words.length - 1;
		StringBuilder sb = new StringBuilder();
		for (int i = lastIndex; i > -1; i--)
		{
			sb.append(words[i] + " ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(revWords("Do or do not, there is no try."));
	}

}
