package src.com.datastruct;

/*
 * Parenthesis Matching
 * Given a string with a number of opening parenthesis it returns the number of closing parenthesis.
 * If the closing parenthesis is not found then it returns -1
 */

public class ParanthesisMatching {

	public static void main(String[] args) {
		ParanthesisMatching p = new ParanthesisMatching();
		System.out.println(p.findCorrespondingParanthesis(
				"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.",
				10));
	}

	int findCorrespondingParanthesis(String s, int position) {
		int count = 0;
		for (int i = position + 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				count++;
			else if (c == ')') {
				if (count == 0)
					return i;
				count--;
			}
		}
		return -1;
	}
}
