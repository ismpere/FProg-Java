package estudio;
import java.awt.*;

public class estudio{
	public static void main (String[] args){
	 int[][] matriz = new int[4][4];
	 for(int i = 0; i<matriz.length; i++){
		 for(int j = 0; j<matriz[i].length; j++){
			 matriz[i][j] = j;
		 }
	 }
	 for (int k = 0; k<matriz.length; k++){
		 for(int w = matriz[k].length -k; w<matriz[k].length; w++){
			 System.out.print(" " + matriz[k][w]);
		 }
	 }
}
}