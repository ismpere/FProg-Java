/* Rojo Alvarez Victor*/
/* Perez Martin Ismael*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ismpere {

	public static void main(String[] args) {
		//Creamos los dos obetos de scanner//
		
		Scanner puntuacionesmaxl; //para escribir//
		PrintWriter puntuacionesmaxe; //para leer//
		int contador;
		double aux;
		final int multiplicador = 100000;
		try {
			puntuacionesmaxl = new Scanner(new File("PuntuacionesMax.txt")); //Comprueba si el fichero existe, y sino lo crea e inicializa
			puntuacionesmaxl.close();
		} catch (FileNotFoundException e) {
			try {
				puntuacionesmaxe = new PrintWriter("PuntuacionesMax.txt"); //Con los dos siguientes comandos busca excepciones en las puntuaciones y las elimina
				for (contador = 0; contador < 10; contador++) {
					puntuacionesmaxe.println(multiplicador);
				}
				puntuacionesmaxe.close();
			} catch (FileNotFoundException w) {
				System.out.println("Error");
			}

		}
	
		int[][] tablero = new int[8][8]; //Crea la matriz 8x8, la cual contiene el marco
		int[][] matrizaux = new int[8][8];
		int fila = 0;
		int columna = 0;
		int nivel = 5; //El nivel 5 es el nivel predeterminado al comenzar el juego, el nivel normal//
		int golpes = 0;
		double puntuaciontablero = 1; //ponemos las puntuaciones a 1 al principio del juego
		double[] puntuacionjuego = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		Scanner teclado = new Scanner(System.in);
		
		// Imprime en pantalla el objetivo del juego y todas las instrucciones//
		System.out.println("El objetivo del juego es conseguir que el tablero este lleno de 0.");
		System.out.println("Para ello debe introducir las coordenadas de el numero que desea \"golpear\"");
		System.out.println("Cuando golpeamos un numero este y los de arriba, abajo y los lados decrementan");
		System.out.println("en 1, si el numero al decrementar era 0 pasará a 3 de nuevo.");
		System.out.println("Para recomenzar el nivel introduzca 01, para un nivel nuevo 02, para ver las");
		System.out.println("clasificaciones 03, para cambiar de nivel 04 y para salir 0-2");
		System.out.println();
		
		generamatriz(tablero, nivel);
		imprimematriz(tablero);
		iniciamatriz(matrizaux);
		copiamatriz(tablero, matrizaux);
		
		//Imprime en pantalla el nivel y los golpes
		System.out.println(
				"Nivel de juego: " + nivel + " (" + nivel * 3 + " golpes)   Puntuacion: " + puntuacionjuego[nivel - 1]);
		System.out.println("Golpes realizados: " + golpes + "            Golpe realizado: " + fila + " " + columna);
		System.out.println("Primero introduzca las filas, despues las columnas.");
		
		while (columna != -2) { 
			//Las columnas con -2 se corresponden al marco del tablero, el cual no se imprime en pantalla//
			
			//Realiza la validación de datos
			fila = teclado.nextInt();
			while (fila < 0 | fila > (tablero.length - 2)) {
				System.out.println("El numero introducido para las filas no es valido, vuelva a introducirlo:");
				fila = teclado.nextInt();
			}
			columna = teclado.nextInt();
			if (fila == 0) {
				while (columna == 0 | columna < -2 | columna > 4 | columna == -1) {
					System.out.println("El segundo numero no es valido, vuelva a introducirlo:");
					System.out.println("Para recomenzar el nivel introduzca 1, para un nivel nuevo 2, para ver las");
					System.out.println("clasificaciones 3, para cambiar de nivel 4 y para salir -2");
					columna = teclado.nextInt();
				}
			} else {
				while (columna < 1 | columna > (tablero.length - 2)) {
					System.out.println("El numero introducido para las columnas no es valido, vuelva a introducirlo:");
					columna = teclado.nextInt();
				}
			}
			//Reinicia el tablero
			if (fila == 0 && columna == 1) {
				System.out.println("Tablero reiniciado:");
				System.out.println();
				copiamatriz(matrizaux, tablero);
				imprimematriz(tablero);
				System.out.println("Nivel de juego: " + nivel + " (" + nivel * 3 + " golpes)   Puntuacion: "
						+ puntuacionjuego[nivel - 1]);
				System.out.println(
						"Golpes realizados: " + golpes + "            Golpe realizado: " + fila + " " + columna);
			} else if (fila == 0 && columna == 2) {
				if (golpes > 0) {
					puntuacionjuego[nivel - 1] = puntuacionjuego[nivel - 1] * 0.5;
				}
				System.out.println("Nuevo tablero generado:");
				System.out.println();
				iniciamatriz(tablero);
				generamatriz(tablero, nivel);
				copiamatriz(tablero, matrizaux);
				golpes = 0;
				imprimematriz(tablero);
				System.out.println("Nivel de juego: " + nivel + " (" + nivel * 3 + " golpes)   Puntuacion: "
						+ puntuacionjuego[nivel - 1]);
				System.out.println(
						"Golpes realizados: " + golpes + "            Golpe realizado: " + fila + " " + columna);
			} else if (fila == 0 && columna == 4) {
				if (golpes > 0) {
					puntuacionjuego[nivel - 1] = puntuacionjuego[nivel - 1] * 0.5;
				}
				System.out.println("Introduzca el nivel deseado:");
				nivel = teclado.nextInt();
				while (nivel < 1 | nivel > 10) {
					System.out.println("El nivel debe estar entre 1 y 10, vuelva a introducirlo:");
					nivel = teclado.nextInt();
				}
				golpes = 0;
				puntuaciontablero = 1;
				generamatriz(tablero, nivel);
				imprimematriz(tablero);
				copiamatriz(tablero, matrizaux);
				System.out.println("Nivel de juego: " + nivel + " (" + nivel * 3 + " golpes)   Puntuacion: "
						+ puntuacionjuego[nivel - 1]);
				System.out.println(
						"Golpes realizados: " + golpes + "            Golpe realizado: " + fila + " " + columna);
			} else if (fila == 0 && columna == 3) {
				System.out.println("Calificaciones:");
				try {
					puntuacionesmaxl = new Scanner(new File("PuntuacionesMax.txt"));
					contador = 1;
					while (puntuacionesmaxl.hasNextDouble()) {
						aux = puntuacionesmaxl.nextDouble();
						System.out.println("Nivel " + contador + "(" + (contador * 3) + " golpes): "
								+ (double) aux / multiplicador + " Puntos.");
						contador++;
					}
					puntuacionesmaxl.close();
				} catch (FileNotFoundException e) {
					System.out.println("Error al leer las puntuaciones");
				}
				System.out.println("Deseas borrar las puntuaciones? 1 para si, 0 para no.");
				contador = teclado.nextInt();
				while (contador != 0 && contador != 1) {
					System.out.println("Numero no valido, 1 para borrar, 0 para no.");
					contador = teclado.nextInt();
				}
				if (contador == 1) {
					try {
						puntuacionesmaxe = new PrintWriter("PuntuacionesMax.txt");
						for (contador = 0; contador < 10; contador++) {
							puntuacionesmaxe.println(multiplicador);
						}
						puntuacionesmaxe.close();
					} catch (FileNotFoundException e) {
						System.out.println("Error");
					}
				}

			} else if (fila > 0) {
				golpe(fila, columna, tablero);
				imprimematriz(tablero);
				golpes++;
				puntuaciontablero = ((double) nivel * 3) / golpes;
				System.out.println("Nivel de juego: " + nivel + " (" + nivel * 3 + " golpes)   Puntuacion: "
						+ puntuacionjuego[nivel - 1]);
				System.out.println(
						"Golpes realizados: " + golpes + "            Golpe realizado: " + fila + " " + columna);
				if (resuelto(tablero)) {
					puntuacionjuego[nivel - 1] = puntuaciontablero * puntuacionjuego[nivel - 1];
					System.out.println("Resuelto, tu puntuacion en este tablero es: " + puntuaciontablero
							+ "  Ha sido resuelto en " + golpes + " golpes.");
					golpes = 0;
					puntuaciontablero = 1;
					generamatriz(tablero, nivel);
					imprimematriz(tablero);
					copiamatriz(tablero, matrizaux);
					System.out.println("Nivel de juego: " + nivel + " (" + nivel * 3 + " golpes)   Puntuacion: "
							+ puntuacionjuego[nivel - 1]);
					System.out.println(
							"Golpes realizados: " + golpes + "            Golpe realizado: " + fila + " " + columna);

				}
			}
		}
		System.out.println("Fin del juego");
		try {
			puntuacionesmaxl = new Scanner(new File("PuntuacionesMax.txt")); //lee las puntuaciones 
			for (nivel = 1; nivel <= 10 && puntuacionesmaxl.hasNextDouble(); nivel++) {
				aux = puntuacionesmaxl.nextDouble();
				if (aux != multiplicador && puntuacionjuego[nivel - 1] * multiplicador == multiplicador) {
					puntuacionjuego[nivel - 1] = aux / multiplicador;
				} else if (aux != multiplicador && puntuacionjuego[nivel - 1] * multiplicador != multiplicador) {
					if (aux > puntuacionjuego[nivel - 1]) {
						puntuacionjuego[nivel - 1] = aux / multiplicador;
					}
				}

			}
			puntuacionesmaxl.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error en la lectura de datos"); //busca excepciones en las puntuaciones
		}
		try {
			puntuacionesmaxe = new PrintWriter("PuntuacionesMax.txt");
			for (nivel = 1; nivel <= 10; nivel++) {
				puntuacionesmaxe.println((int) (puntuacionjuego[nivel - 1] * multiplicador));
			}
			puntuacionesmaxe.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error en la escritura de datos");
		}

	}

	//Metodo que imprime en pantalla la matriz
	public static void imprimematriz(int[][] matriz) {
		for (int fila = 1; fila <= (matriz.length) - 2; fila++) {
			System.out.print("[ ");
			for (int columna = 1; columna <= (matriz.length) - 2; columna++) {
				System.out.print((matriz[fila][columna]) + " ");
			}
			System.out.println("]");

		}
		System.out.println();
	}

	//Metodo que ejecuta los golpes
	//Resta uno a la casilla elegida y sus colindantes
	public static void golpe(int fila, int columna, int[][] matriz) {
		if (matriz[fila][columna] == 0) {
			matriz[fila][columna] = 3;
		} else {
			matriz[fila][columna]--; //casilla elegida
		}
		if (matriz[fila + 1][columna] == 0) { //la casilla superior
			matriz[fila + 1][columna] = 3;
		} else {
			matriz[fila + 1][columna]--;
		}
		if (matriz[fila][columna + 1] == 0) { //La casilla lateral derecha
			matriz[fila][columna + 1] = 3;
		} else {
			matriz[fila][columna + 1]--;
		}
		if (matriz[fila - 1][columna] == 0) { //La casilla inferior
			matriz[fila - 1][columna] = 3;
		} else {
			matriz[fila - 1][columna]--;
		}
		if (matriz[fila][columna - 1] == 0) { //La casilla lateral izquierda
			matriz[fila][columna - 1] = 3;
		} else {
			matriz[fila][columna - 1]--;
		}
	}

	//Metodo que genera la matriz, el tablero en el que jugaremos
	public static void generamatriz(int[][] matriz, int nivel) {
		int fila, columna;
		iniciamatriz(matriz);
		for (int contador = 3 * nivel; contador > 0; contador--) {
			fila = (int) (Math.random() * 6 + 1);
			columna = (int) (Math.random() * 6 + 1);
			if (matriz[fila][columna] == 3) {
				matriz[fila][columna] = 0;
			} else {
				matriz[fila][columna]++;
			}
			if (matriz[fila + 1][columna] == 3) {
				matriz[fila + 1][columna] = 0;
			} else {
				matriz[fila + 1][columna]++;
			}
			if (matriz[fila][columna + 1] == 3) {
				matriz[fila][columna + 1] = 0;
			} else {
				matriz[fila][columna + 1]++;
			}
			if (matriz[fila - 1][columna] == 3) {
				matriz[fila - 1][columna] = 0;
			} else {
				matriz[fila - 1][columna]++;
			}
			if (matriz[fila][columna - 1] == 3) {
				matriz[fila][columna - 1] = 0;
			} else {
				matriz[fila][columna - 1]++;
			}
		}
	}

	//Retorna un booleano para saber si esta resuelto o no el tablero
	public static boolean resuelto(int[][] matriz) {
		boolean resuelto = true;
		for (int fila = 1; fila < matriz.length - 2; fila++) {
			for (int columna = 1; columna < matriz.length - 2; columna++) {
				if (matriz[fila][columna] != 0) {
					resuelto = false;
				}
			}
		}
		return resuelto;
	}

	//Metodo dedicado a copiar la matriz
	public static void copiamatriz(int[][] origen, int[][] destino) {
		for (int fila = 1; fila < origen.length - 2; fila++) {
			for (int columna = 1; columna < origen.length - 2; columna++) {
				destino[fila][columna] = origen[fila][columna];
			}
		}
	}

	//Metodo dedicado a inicializar la matriz
	public static void iniciamatriz(int[][] matriz) {
		for (int fila = 0; fila < matriz.length - 1; fila++) {
			for (int columna = 0; columna < matriz.length - 1; columna++) {
				matriz[fila][columna] = 0;
			}
		}
	}

}