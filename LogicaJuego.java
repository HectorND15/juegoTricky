package juegoTricky;

import java.util.Random;

import javax.swing.JOptionPane;

public class LogicaJuego {
	private int[][] tablero =new int[3][3]; //{{1,2,1},{0,1,0},{1,2,2}}
	
	
	public int[][] getTablero() {
		return tablero;
	}

	public LogicaJuego() {
		
	}
	
	public void leerJugada() {
		
		boolean aux = true;
		while(aux) {
			int jugada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición entre el 1 y el 9"));
			/*
			 * Como la varaible jugada puede ser un valor entre 1 y 9. Y las posicciones
			 * del tablero pueden ser [0,0] hasta [2,2]
			 */
			
			// Verifico que se ingresó una posicion valida
			if(0<jugada && jugada<10) {
				
				// recorren la matriz
				for (int fila=0; fila<3; fila++) {
					for (int columna=0; columna<3; columna++) {
						
						// Verifico a que posición corresponde la jugada
						if ((3*fila + columna + 1) == jugada) {
							
							// Verificar que la casilla está vacia
							if (tablero[fila][columna] == 0) {
								tablero[fila][columna] = 1;
								aux = false;
							} else {
								System.out.println("Escoge otra posición");
							}
						}
						
					}
				}
			} else {
				System.out.println("Opción inválida");
			}
		}
	}
	
	public void jugadaMaquina() {
		boolean aux = true;
		while(aux) {
			Random random = new Random();
	        int jugada = random.nextInt(10);
			
			if(0<jugada && jugada<10) {
				
				// recorren la matriz
				for (int fila=0; fila<3; fila++) {
					for (int columna=0; columna<3; columna++) {
						
						// Verifico a que posición corresponde la jugada
						if ((3*fila + columna + 1) == jugada) {
							
							// Verificar que la casilla está vacia
							if (tablero[fila][columna] == 0) {
								tablero[fila][columna] = 2;
								aux = false;
							}
						}
						
					} 
				}
			} 
		}
		
	}
	
	public void mostrarTablero() {
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //System.out.print(tablero[i][j]);
            	switch (tablero[i][j]) {
            		case 0:
            			System.out.print(" ");
            			break;
            		case 1:
            			System.out.print("X");
            			break;
            		case 2:
            			System.out.print("O");
            			break;
            	}
            	
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
		System.out.println("\n\n");
	}
	
	public boolean verificarVictoria(int player) {
		// verificar columnas
		for (int i=0; i<3; i++) {
			if((tablero[0][i]==player) && (tablero[1][i]==player) && (tablero[2][i]==player) ) {
				return true;
			}
		}
		
		// Verificar Filas
		for (int i=0; i<3; i++) {
			if((tablero[i][0]==player) && (tablero[i][1]==player) && (tablero[i][2]==player) ) {
				return true;
			}
		}
		
		// Verificar Diagonal principal
		if((tablero[0][0]==player) && (tablero[1][1]==player) && (tablero[2][2]==player) ) {
			return true;
		}
		
		// Verificar Diagonal secundaria
		if((tablero[0][2]==player) && (tablero[1][1]==player) && (tablero[2][0]==player) ) {
			return true;
		}
		
		return false;
	}
	

	
}
