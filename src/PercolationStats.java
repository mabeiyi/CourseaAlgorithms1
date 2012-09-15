public class PercolationStats {
   private double[] percent;
   private Percolation per;
   private int t;
   public PercolationStats(int N, int T) {
         // perform T independent computational experiments on an N-by-N grid
      if (N < 1 || T < 1) {
         throw new IllegalArgumentException("ill");
      }
      try {
            percent = new double[T];
            t = T;
            int count = 0;
            for (int i = 0; i < t; i++) {
               count = 0;
               per = new Percolation(N);
               while (!per.percolates()) {
                 int m = makeRandomInt(N);
                 int n = makeRandomInt(N);
                  
                  if (!per.isOpen(m, n)) {
                     count++;
                     per.open(m, n);
                  }
                  
               }
               percent[i] = (double) count/(N * N);
            }
   } catch (IllegalArgumentException e) {
         System.err.println("wrong");
   }
   }
   private int makeRandomInt(int n) {
      int min = 1;
      int max = n;
      int re = min + (int) (Math.random() * ((max - min) + 1));
      return re;

   }
   public double mean() {
      // sample mean of percolation threshold
      double sum = 0.0;
      for (int i = 0; i < t; i++) {
         sum += percent[i];
      }
//      System.out.print(" mean==");
//      System.out.print(sum);
      return (sum/t);
   }
   public double stddev()  {
      // sample standard deviation of percolation threshold
      double sum = 0;
      for (int i = 0; i < t; i++) {
         sum += (percent[i]-mean())*(percent[i]-mean());
      }
      return Math.sqrt(sum/(t-1));
   }
   public static void main(String[] args) {
      // test client, described below
      PercolationStats pro = new PercolationStats(10, 20);
//      for (int i = 0; i < 1; i++) {
//         System.out.print(pro.percent[0]);
//      }
//      System.out.print(" mean==");
//      System.out.print(pro.mean());
//      System.out.print(" std==");
//      System.out.print(pro.stddev());
   }
}
