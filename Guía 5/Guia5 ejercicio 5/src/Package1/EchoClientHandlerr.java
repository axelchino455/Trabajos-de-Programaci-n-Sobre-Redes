package Package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Scanner;


public class EchoClientHandlerr extends Thread{ // texto reverse  multi

	private Socket socket;

	public EchoClientHandlerr(Socket socket) {
		this.socket = socket;
	}
	
	public void handle() {
		this.start();
	}

	public void run() {
		
		try (Scanner in = new Scanner(socket.getInputStream());
			 PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
			 {
			//COMIENZO
				//Infomación que voy a tener que almacenar
				//El tamañio del Array
				int tamanio_vec1 = in.nextInt();
				int vec1[] = new int[tamanio_vec1];
				
				int ArrayInvertido1[] = new int[tamanio_vec1];
				
				// Cargamos el vector que creamos.
				for(int i=0; i<tamanio_vec1; i++) {
					vec1[i] = in.nextInt();
				}
				
				
				// Invertir el Vector vec1
				
				for(int i=0; i<vec1.length; i++) {
					ArrayInvertido1[i] = vec1[vec1.length-i-1];
				}

				// enviar la respuesta del servidor al cliente 
				for(int i=0; i<ArrayInvertido1.length; i++) {
					out.println(ArrayInvertido1[i]);
				}
				out.flush();
				
			//FIN
				
				
				
		} catch (Exception e) {
			System.err.println("Error communicating with client");
			e.printStackTrace();
		}

			if (this.socket != null) {
				try {
					this.socket.close();
				} catch (IOException e) {
					System.err.println("Error closing socket.");
				} finally {
					this.socket = null;
				}
			}
		}
	
	/*public static String reverse(String text)
	{
		String text2 = null;
		char[] cText = new char[text.length()];
		
		cText = text.toCharArray();
		char z = ' ';
		
		for(int i=0; i<text.length()/2; i++)
		{
			System.out.println(cText[i]);
			z = cText[i];
			cText[i] = cText[text.length()-i-1];
			cText[text.length()-i-1] = z;
		}
		
		text2 = String.valueOf(cText);
		
		return text2;
	}*/
}