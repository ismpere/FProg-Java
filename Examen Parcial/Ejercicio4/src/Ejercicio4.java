import java.util.Scanner;
import java.util.*;
public class Ejercicio4 {
	
	public static void main (String [] args) {
		int[][] matriz = new int[8][7];
		IniciaMatriz(matriz);

		
	}
public static void IniciaMatriz (int matriz[][]){
	for (int fila = 0; fila<matriz.length ; fila++){
		System.out.print("[ ");
		for (int columna = 0; columna<matriz[fila].length ; columna++){
			matriz[fila][columna] = (int)(Math.random()*7)+1;
			System.out.print(matriz[fila][columna] + " ");
		}
		System.out.println("]");
	}
}
}
	


	

