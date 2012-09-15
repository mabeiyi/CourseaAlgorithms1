

public class Percolation {
   private int n;
   private boolean[][] openMark;
   private WeightedQuickUnionUF uf;
   public Percolation(int N) {
      // create N-by-N grid, with all sites blocked
      n = N;
      uf = new WeightedQuickUnionUF((N + 1) * (N + 1));
      openMark  =  new boolean[N+1][N+1]; 
      for (int i  =  0; i < N+1; i++) {
         for (int j = 0; j < N+1; j++) {
            openMark[i][j]  =  false;
         }
        }
   }
     public void open(int i, int j) { //throws IndexOutOfBoundsException {
      // open site (row i, column j) if it is not already
         if (i < 1 || j < 1 || i > n || j > n) {
             throw new IndexOutOfBoundsException("");
          }
         try {

             if (!isOpen(i, j)) { 
                 openMark[i][j] = true;
                 if (i == 1 || i == n) {
                    uf.union(trans(i, 0), trans(i, j));
                    //System.out.print("111 \n ");
                    
                 }
                 
                 //System.out.printf("original:  %d %d \n ", i, j);
                 if (isOpen(i + 1, j)) {
                    uf.union(trans(i, j), trans(i+1, j));
                    //System.out.printf("%d %d \n ", i + 1, j);
                 }
                 if (isOpen(i-1, j)) {
                    uf.union(trans(i, j), trans(i-1, j));
                   // System.out.printf("%d %d \n ", i-1, j);
                 }
                 if (isOpen(i, j+1)) {
                    uf.union(trans(i, j), trans(i, j+1));
                  //  System.out.printf("%d %d \n ", i, j+1);
                 }
                 if (isOpen(i, j-1)) {
                    uf.union(trans(i, j), trans(i, j-1));
                  //  System.out.printf("%d %d \n ", i, j-1);
                 }

              }
         } catch (IndexOutOfBoundsException e) {
            //System.err.println("");
         }
     }
   public boolean isOpen(int i, int j) { //throws IndexOutOfBoundsException {
      // is site (row i, column j) open?
//      if (i < 1 || j < 1 || i > n || j > n) {
//         //throw new IndexOutOfBoundsException("");
//      }
      try {
          if (i < 1 || j < 1 || i > n || j > n) {
              throw new IndexOutOfBoundsException("");
           }
          if (openMark[i][j]) {
              return true;
          }
      } catch (IndexOutOfBoundsException e) {
         //System.err.println("");
      }
      return false;
   }
   public boolean isFull(int i, int j) { //throws IndexOutOfBoundsException {
      // is site (row i, column j) full?
       if (i < 1 || j < 1 || i > n || j > n) {
           throw new IndexOutOfBoundsException("");
       }
      try {

          if (openMark[i][j]) {
              if (uf.connected(trans(i, j), trans(1, 0))) {
                 return true;
              }
          }
      } catch (IndexOutOfBoundsException e) {
         //System.err.println("");
      }
      return false;
   }
   public boolean percolates() {
      // does the system percolate?
       if (uf.connected(trans(1, 0), trans(n, 0))) {
          return true;
       }
      return false;
   }
   private int trans(int i, int j) {
      return (i*(n+1) +j);
   }
//   public boolean con(int a, int s, int d, int f){
//       if (uf.connected(trans(a, s), trans(d, f))) {
//           return true;
//        }
//       return false;
//   }
}
