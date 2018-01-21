import java.util.Scanner;

public class Ejercicio3 {
	int NumeroObtenido;


public static int tiraDado (int n){
	int NumeroObtenido;
	Scanner Teclado = new Scanner(System.in);
	n = Teclado.nextInt();
	while (n<=0){
		System.out.println("En numero debe ser mayor que 0");
	}
	n = Teclado.nextInt();
	NumeroObtenido =(int)Math.random()*n+1;
	return NumeroObtenido;
}
}
