package Package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteString {

	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)) {
			//PASO PREVIO .- Ingreso una cadena de texto
			String cadenaString = "Hola soy una cadena de texto";

		

				try(Socket socket = new Socket("localhost", 12345);
		
					Scanner input = new Scanner(socket.getInputStream());
					PrintWriter output = new PrintWriter(socket.getOutputStream())) {
	
					// 1.- Se envía la cadena de texto al servidor.
					output.println(cadenaString);
					
					
					//3.- Se asegura que la información se envíe al servidor.
					output.flush();
	
					// 4.- Se espera por el resultado que envía el servidor.
					int resultado = input.nextInt();
	
					
					//5.-Se imprime por pantalla el resultado.
					System.out.println(String.format("El texto ingresado cuenta con "+resultado+" vocales"));
					
					//6.- No hay más
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}