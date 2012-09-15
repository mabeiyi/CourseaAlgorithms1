

public class Week1Test {
	public static void main(String[] args){
		Percolation pro=new Percolation(6);
		//pro.open(1, 0);
		pro.open(1, 6);
		pro.open(2, 6);
		
		pro.open(3, 6);
//		if(pro.con(6, 0, 1, 0)){
//			System.out.print("ok ");
//		}else{
//			System.out.print("asd ");
//		}
		pro.open(4, 6);
		pro.open(5, 6);
		
		pro.open(5,5);
		pro.open(4,4);
		pro.open(2,4);
		pro.open(3, 4);
		pro.open(2, 3);
		
		pro.open(2, 2);
		pro.open(2,1);
		
		
		pro.open(3, 1);
		pro.open(4, 1);
		
		pro.open(5, 1);
		pro.open(5, 2);

		

		
		pro.open(6, 2);
		if(pro.isFull(2, 1)){
			System.out.print("ok ");
		}else{
			System.out.print("asd ");
		}
//		if(pro.con(6, 2, 5, 2)){
//			System.out.print("ok ");
//		}else{
//			System.out.print("asd ");
//		}
		if(pro.percolates()){
			System.out.print("ok ");
		}else{
			System.out.print("asd ");
		}
		pro.open(5, 4);
		if(pro.percolates()){
			System.out.print("ok ");
		}else{
			System.out.print("asd ");
		}
	}
//    public static void main(String[] args) {
//        // N-by-N percolation system (read from command-line, default = 10)
//        int N = 10;          
//        if (args.length == 1) N = Integer.parseInt(args[0]);
//
//        // repeatedly open site specified my mouse click and draw resulting system
//        StdOut.println(N);
//
//        StdDraw.show(0);
//        Percolation perc = new Percolation(N);
//        PercolationVisualizer.draw(perc, N);
//        StdDraw.show(0);
//
//        while (true) {
//
//            // detected mouse click
//            if (StdDraw.mousePressed()) {
//
//                // screen coordinates
//                double x = StdDraw.mouseX();
//                double y = StdDraw.mouseY();
//
//                // convert to row i, column j
//                int i = (int) (N - Math.floor(y));
//                int j = (int) (1 + Math.floor(x));
//
//                // open site (i, j) provided it's in bounds
//                if (i >= 1 && i <= N && j >= 1 && j <= N) {
//                    if (!perc.isOpen(i, j)) { 
//                        StdOut.println(i + " " + j);
//                    }
//                    perc.open(i, j);
//                }
//
//                // draw N-by-N percolation system
//                StdDraw.show(0);
//                PercolationVisualizer.draw(perc, N);
//            }
//            StdDraw.show(20);
//        }
//    }
}
