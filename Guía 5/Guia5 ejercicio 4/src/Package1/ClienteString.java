package Package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteString {

	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)) {
			//PASO PREVIO .-
			/*
			Desarrollar una aplicación cliente-servidor donde el cliente envíe dos vectores
			de la misma longitud al servidor. El servidor debe calcular el producto escalar de 
			ambos vectores (sumatoria de las multiplicaciones de sus elementos) y devolver el 
			resultado al cliente, quien lo mostrará por pantalla.
			*/
			int vector1[]= {1,2,3,4,5}; // longitud 5
			int vector2[]= {5,4,3,2,1}; // longitud 5

		

				try(Socket socket = new Socket("localhost", 12345);
		
					Scanner input = new Scanner(socket.getInputStream());
					PrintWriter output = new PrintWriter(socket.getOutputStream())) {
	
					// 1.- Se envía el tamaño de los vecctores.
					output.println(vector1.length);
					output.println(vector2.length);					
					
					// 2.- Se envían los valores de los vectores.
					
					for (int i=0; i<vector1.length; i++) {
						output.println(vector1[i]);
					}
					
					for (int i=0; i<vector2.length; i++) {
						output.println(vector2[i]);
					}
					
					//2.- Se asegura que la información se envíe al servidor.
					output.flush();
	
					// 3.- Se espera por el resultado que envía el servidor.
					// en este caso la variable resultado es de tipo entero proque los vectores son de tipo entero.
					int resultado = input.nextInt();
	
					
					//5.-Se imprime por pantalla el resultado.
					System.out.println(String.format("El producto escalar de los dos vectores es: "+resultado));
					
					
					//6.- No hay más
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}