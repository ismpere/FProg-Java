import java.util.Scanner;

public class Examen5 {

	public static void main(String args[]) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Distancia entre cada par de primos: ");
		int n;
		do {
			System.out.print("Introduzca un numero entero positivo:");
			n = teclado.nextInt();
			if (n <= 1) {
				System.out.println("Dato erroneo");
			} else {
				paresPrimos(n);
			}
		} while (n <= 1);
		teclado.close();

	}
	
	private static void paresPrimos(int numero) {
		for (int actual = 2; actual < numero; actual++) {
			int anterior = 1;
			int distancia = 0;
			if (esPrimo(actual)) {
				distancia = actual - anterior;
				System.out.println("Par primo encontrado:" + anterior + "-"
						+ actual + ".Distancia entre ambos:" + distancia);
				anterior = actual;
			}
		}
	}


	
	private static boolean esPrimo(final int num) {
		for (int div = 2; div < num; div++)
			if (num % div == 0)
				return false;
		return true;
	}

}
