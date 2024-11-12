package Package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteString {

	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)) {
			//PASO PREVIO .- Ingreso mi vector a mano
			int vector[] = {1, 9, 17, 5, 2, 30};

		

				try(Socket socket = new Socket("localhost", 12345);
		
					Scanner input = new Scanner(socket.getInputStream());
					PrintWriter output = new PrintWriter(socket.getOutputStream())) {
	
					// 1.- Se envía el tamaño del vector al servidor.
					output.println(vector.length);
	
					//2.- Se envían los valores del vector
					for(int i=0; i<vector.length; i++) {
						output.println(vector[i]);
					}
					
					//3.- Se asegura que la información se envíe al servidor.
					output.flush();
	
					// 4.- Se espera por el resultado que envía el servidor.
					int valorMaximo = input.nextInt();
					int posMaximo = input.nextInt();
					
					//5.-Se imprime por pantalla el resultado.
					System.out.println(String.format("El máximo es " + valorMaximo + " y se encuentra en la posicion " + posMaximo ));
					
					//6.- No hay más
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}