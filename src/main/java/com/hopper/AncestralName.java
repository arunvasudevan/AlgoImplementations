package com.hopper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    Problem: Ancestral Names

    Given a list of Strings comprised of a name and a Roman numeral, sort the list first by name, then by decimal value of the Roman Numeral.

    In Roman numerals, a value is not repeated more than three times. At that point, a smaller value precedes a larger value to indicate subtraction. For example the letter I represents numer 1, and V represents 5. Reason through the formation of 1 to 10 below, and see how it is applied in the following lines.

    - I, II, III, IV, V, VI, VII, VIII, IX and X represent 1 through 10.
    - XX, XXX and XL and L are 20, 30, 40 and 50
    - For any other two digit number < 50, concatenate the roman numeral(s) that repersent its multiple of ten with the Roman numeral(s) for its values < 10. For example: 43 is 40 + 3 = 'XL' + 'III' = 'XLIII'


    Example:

    names = ['Steven XL', 'Steven XVI', 'David IX', 'Mary XV', 'Mary XIII', 'Mary XX']

    Written in Decimal and Sorted
    Result = ['David 9', 'Mary 13', 'Mary 15', 'Mary 20', 'Steven 16', 'Steven 40']

    Actual Result to be returned
    Result = ['David IX', 'Mary XIII', 'Mary XV', 'Mary XX', 'Steven XVI', 'Steven XL']


    Constraints:

    1 <= n <= 50
    Each names[i] would contains givenName and RomanNumeral
    Romannumeral contains numbers between 1 and 50 (inclusive)
    1 <= |givenName| <= 20
    Each givenName starts with Uppercase Letter ascii[A-Z] followed by lowercase letters ascii[a-z]
    There is a space between givenName and RomanNumeral

*/

public class AncestralName {

  public static List<String> sortRoman(List<String> names) {

    List<MyObject> list = new ArrayList<>();

    for(String name: names) {
      list.add(new MyObject(name.split(" ")[0], name.split(" ")[1]));
    }


    Collections.sort(list, Comparator.comparing(MyObject::getName)
        .thenComparingInt(MyObject::getNumeral));

    List<String> output = new ArrayList<>();

    for(MyObject obj: list) {
      String str = obj.getName() + " " + obj.getRomanNumeral();
      output.add(str);
    }

    return output;
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Steven XL");
    list.add("Steven XVI");
    list.add("David IX");
    list.add("Mary XV");
    list.add("Mary XIII");
    list.add("Mary XX");

    List<String> output = sortRoman(list);

    System.out.println("Output: ");

    for(String name: output) {
      System.out.println(name);
    }
  }

}

class MyObject {

  String name;
  String romanNumeral;
  int numeral;

  Map<Character, Integer> map = new HashMap<>();


  MyObject(String name, String numeral) {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    this.name = name;
    this.romanNumeral = numeral;
    this.numeral= getRomanValue(numeral);
  }

  String getName() {
    return this.name;
  }

  String getRomanNumeral() {
    return this.romanNumeral;
  }

  int getNumeral() {
    return this.numeral;
  }

  int getRomanValue(String str) {
    int result= map.get(str.charAt(0));

    for(int i = 1; i < str.length(); i++) {
      if(map.get(str.charAt(i)) > map.get(str.charAt(i-1))) {
        result += map.get(str.charAt(i)) - map.get(str.charAt(i-1));
        result -= map.get(str.charAt(i-1));
      } else {
        result += map.get(str.charAt(i));
      }
    }

    return result;
  }

}
