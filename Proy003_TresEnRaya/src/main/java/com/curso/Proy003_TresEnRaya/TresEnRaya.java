package com.curso.Proy003_TresEnRaya;

public class TresEnRaya {
	// atributos

	private Character[][] tablero;
	private Character jugadorActual;

	// constructor
	public TresEnRaya() {
		this.tablero = new Character[3][3]; // al ser un objeto están todos inicializados a null
		this.jugadorActual = 'x';
	}
	

	public int suma(int n, int n2) {
		return n + n2;
	}

	public void jugar(int x, int y) {

		validarCoordenadaX(x);
		validarCoordenadaY(y);
		ponerFicha(x, y);

	}

	public Character getFicha(int x, int y) {
		// TODO VALIDAR X e Y
		validarCoordenadaX(x);
		validarCoordenadaY(y);
		return tablero[x][y];
	}
	
	public Character getJugadorActual() {
		return this.jugadorActual;
	}
	
	public Character comprobarGanador() {
		
		
		
		return null;
	}

	private void validarCoordenadaX(int x) {
		if (x < 0 || x > 2) {
			throw new RuntimeException("La ficha no se puede colocar fuera del tablero. Coordenada x mal");
		}

	}

	private void validarCoordenadaY(int y) {
		if (y < 0 || y > 2) {
			throw new RuntimeException("La ficha no se puede colocar fuera del tablero. Coordenada x mal");
		}

	}

	private void ponerFicha(int x, int y) {
		if (tablero[x][y] != null) {
			throw new RuntimeException("La ficha no se puede colocar en una posicion ocupada");
		}

		tablero[x][y] = this.jugadorActual;
		if(this.jugadorActual == 'x') {
			this.jugadorActual = 'o';
		}else {
			this.jugadorActual = 'x';
		}
	}
	
	private Character comprobarHorizontal() {
		boolean correctoX = false;
		boolean correctoO = false;
		int i = 0;
		int j = 0;
		while(((!correctoX)||(!correctoO)) && i< this.tablero.length) {
			int contadorX = 0;
			int contadorO = 0;
			while(!correctoX && j< this.tablero[i].length) {
				if(this.tablero[i][j]=='x') {
					contadorX++;
				}else if(this.tablero[i][j]=='O') {
					contadorO++;
				}
				
				if(contadorX == 3) {
					correctoX= true;
				}
				if(contadorO == 3) {
					correctoO = true;
				}
				j++;
			}
			i++;
		}
		if(correctoO) {
			return 'o';
		}else if(correctoX){
			return 'x';
		}else {
			return 'n';
		}
		
	}
	
	private Character comprobarVertical() {
		boolean correctoX = false;
		boolean correctoO = false;
		int i = 0;
		int j = 0;
		while(((!correctoX)||(!correctoO)) && j< this.tablero.length) {
			int contadorX = 0;
			int contadorO = 0;
			while(!correctoX && i< this.tablero[i].length) {
				if(this.tablero[i][j]=='x') {
					contadorX++;
				}else if(this.tablero[i][j]=='O') {
					contadorO++;
				}
				
				if(contadorX == 3) {
					correctoX= true;
				}
				if(contadorO == 3) {
					correctoO = true;
				}
				i++;
			}
			j++;
		}
		if(correctoO) {
			return 'o';
		}else if(correctoX){
			return 'x';
		}else {
			return 'n';
		}
	}
	
	// comprobar diagonal me falta de pensar
	private Character comprobarDiagonal() {
		boolean correctoX = false;
		boolean correctoO = false;
		int i = 0;
		int j = 0;
		while(((!correctoX)||(!correctoO)) && j< this.tablero.length) {
			int contadorX = 0;
			int contadorO = 0;
			while(!correctoX && i< this.tablero[i].length) {
				if(this.tablero[i][j]=='x') {
					contadorX++;
				}else if(this.tablero[i][j]=='O') {
					contadorO++;
				}
				
				if(contadorX == 3) {
					correctoX= true;
				}
				if(contadorO == 3) {
					correctoO = true;
				}
				i++;
			}
			j++;
		}
		if(correctoO) {
			return 'o';
		}else if(correctoX){
			return 'x';
		}else {
			return 'n';
		}
	}

}
