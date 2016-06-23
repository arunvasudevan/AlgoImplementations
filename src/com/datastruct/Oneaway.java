package com.datastruct.practice;

public class Oneaway {

	public static void main(String[] args) {
		Oneaway o = new Oneaway();

		if (o.findOperation("bake", "pale"))
			System.out.println("Its One Away");
		else
			System.out.println("Its not One Away");
	}

	boolean findOperation(String s1, String s2) {
		if (s1.length() == s2.length())
			return replace(s1, s2);
		else if (s1.length() + 1 == s2.length())
			return replace(s1, s2);
		else if (s1.length() - 1 == s2.length())
			return replace(s2, s1);
		else
			return false;
	}

	boolean replace(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		boolean oneAway = false;
		// System.out.println(s1+","+s2);
		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (oneAway) {
					return false;
				}
				// System.out.println("Set One way");
				oneAway = true;
			}
			// System.out.println("Index1:"+index1+"Index2:"+index2);
			else{
				if(s1.length()!=s2.length())
					index1++;
			}
			if(s1.length()==s2.length())
				index1++;
			index2++;
		}
		return true;
	}

}