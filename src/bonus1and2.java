/**
 * Count the number of ways it is possible to return change.
 * Print all permutations of a string.
 *
 * @author LET375-39
 * @version 2017-06-01
 */

public class bonus1and2{
  // parameters
  // amount the amount to be changed
  // val the different values arranged in ascending order
  // n the number of different values
  public static int change( int amount, int[] val, int n ){

    // Are both the amount and n still in allowed ranges?
    if (amount < val[0] || n <= 0) {
      return 0;
    }
    // Have we reached the smallest allowed number? (have we succeeded)
    else if (amount == val[0]) {
      return 1;
    }
    // The first change will decrease the length of val and the other change will subtract the biggest number still used in val from the amount.
    else
      return change(amount, val, n-1) + change(amount - val[n-1], val, n);
  }

  // The inital input that prepares for the recursive version
  public static void permutations(String str){
    permutations("", str, str.length());
  }

  // The recursive version that prints all permutations of a given string
  private static void permutations(String prefix, String str, int n){
    // Print if there are no more letters to add to prefix
    if (n <= 0)
      System.out.println(prefix);
    else {
      // Loops over all letters in str to add all permutations of it to prefix
      for (int i = 0; i < n; i++)
        //permutations("add char to end of prefix", "remove the char we added to prefix", "nr of letters left next recursion")
        permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1), n-1);
    }
  }

  public static void main(String[] args) {
    int[] sekValues = { 1, 5, 10, 20, 50, 100, 500, 1000 };
    System.out.println("Antal sätt att växla " + change(12, sekValues, sekValues.length));
    permutations("abc");
  }
}

/*
 T(n) = T(n-1) * O(n) = n!
 T(1) = O(1)
  Since the first letter can be put at n different locations that leave n-1 locations for the second letter and so on down to the last letter.

Ex:
 T(3) = T(2) * O(3) =
        T(1) * O(2) * O(3) =
        O(1) * O(2) * O(3) =
        1 * 2 * 3 = 3!
  */