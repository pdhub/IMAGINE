package hearth.moonFrog;

import java.util.Scanner;

public class FitThePaintings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String nm[] = in.nextLine().split(" ");
		String ab[] = in.nextLine().split(" ");
		String cd[] = in.nextLine().split(" ");
		
		 canpaintingFit(Integer.valueOf(ab[0]), Integer.valueOf(ab[1]), Integer.valueOf(cd[0]), Integer.valueOf(cd[1]),
				 Integer.valueOf(nm[0]), Integer.valueOf(nm[1]));
		 System.out.println();
		
	}

	public static void canpaintingFit(int a, int b, int c, int d, int n, int m){
		
		boolean canFit = false;
		
		if(a+c<=n && b<=m && d<=m){
			canFit = true;
		}else if(a+d<=n && b<=m && c<=m){
			canFit = true;
		}else if(a+c<=m && b<=n && d<=n){
			canFit = true;
		}else if(a+d<=m && b<=n && c<=n){
			canFit = true;
		}
		
		if(canFit)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
}
