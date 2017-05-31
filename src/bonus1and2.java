public class bonus1and2{
  int[] sekValues = { 1, 5, 10, 20, 50, 100, 500, 1000 };
  // parameters
  // amount the amount to be changed
  // val the different values arranged in ascending order
  // n the number of different values
  public static int change( int amount, int[] val, int n ){
    int i = 0;
    while (i =< n) {
      if (amount < val[i]) {
        // ta bort val[i] och framåt
      }
      i++;
    }
    if (i == n) {
      return 0;
    }
    // ropar på sig själv med amount-val[val.length], om detta är större än 0
  }

  public void permutations(String str){

  }

  public static void main(String[] args) {
    System.out.println(change(12,sekValues,sekValues.length));
  }
}
