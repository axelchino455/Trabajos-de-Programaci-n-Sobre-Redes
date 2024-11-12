package Package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
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
				//La cadena de texto = "Hola soy una cadena de texto"
				String texto = in.nextLine(); 
				// creamos una variable con todas las vocales
				String vocales = "aeiouAEIOU";
				// Cantidad de vocales
				int can_vocales = 0; 
	
				// el for crea una variable c donde se guarda cada caracter de la variable texto
				// el metodo toCharArray() combierte la cadena de texto en un arreglo(vector)
				// por ejemplo texto="hola", con dicho metodo te devuelve ["h", "o", "l", "a"]
				for (char c : texto.toCharArray()) {
					// vocales.indexOf(c) esto buscara desde la variable vocales si coinside con la variable c
					// si c no se encunetra en la cadena de vocales vocales.indexOf(c) devolvera -1
					if(vocales.indexOf(c) != -1) {
						can_vocales++;
					}
				}
				
				out.println(can_vocales);
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