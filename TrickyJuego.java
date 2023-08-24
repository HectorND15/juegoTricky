package juegoTricky;

public class TrickyJuego {
	
	public static void main(String[] args) {
		LogicaJuego juego = new LogicaJuego();
		
		while (true){
			// usuario
			juego.leerJugada();
			if(juego.verificarVictoria(1)) {
				System.out.println("HAS GANADO!");
				juego.mostrarTablero();
				break;
			}
			// maquina
			juego.jugadaMaquina();
			if(juego.verificarVictoria(2)) {
				System.out.println("HA GANADO LA MAQUINA!");
				juego.mostrarTablero();
				break;
			}
			
			juego.mostrarTablero();
		}
		
		
	}

}
