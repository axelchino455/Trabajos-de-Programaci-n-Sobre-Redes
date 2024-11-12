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
			Desarrollar una aplicación cliente-servidor donde el cliente envíe un array
			de enteros al servidor. El servidor debe invertir el array y devolverlo al
			cliente, quien lo mostrará por pantalla.
			
			*/
			int vector1[]= {1,2,3,4,5}; // longitud 5
			int ArrayInvertido[] = new int[vector1.length];
		

				try(Socket socket = new Socket("localhost", 12345);
		
					Scanner input = new Scanner(socket.getInputStream());
					PrintWriter output = new PrintWriter(socket.getOutputStream())) {
	
					// 1.- Se envía el tamaño del Array.
					output.println(vector1.length);
								
					
					// 2.- Se envían los valores del Array.
					
					for (int i=0; i<vector1.length; i++) {
						output.println(vector1[i]);
					}
					
					
					//2.- Se asegura que la información se envíe al servidor.
					output.flush();
	
					// 3.- Se espera por el resultado que envía el servidor.
					// en este caso la variable resultado es de tipo entero proque el Array es de tipo entero.
					for(int i=0; i<vector1.length; i++) {
						ArrayInvertido[i] = input.nextInt();
					}
	
					
					//5.-Se imprime por pantalla el resultado.
					System.out.println("El vector invertido es:");
					System.out.print("[");
					for(int num : ArrayInvertido) {
						System.out.print(num+" ");
					}
					System.out.print("]");
					
					
					
					//6.- No hay más
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}