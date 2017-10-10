import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
 
public class Server {
	   public static void main(String[] args) throws IOException {
	     ServerSocket servidor = new ServerSocket(12345);
	     System.out.println("Porta 12345 aberta!");
	     
	     Socket cliente = servidor.accept();
	     System.out.println("Nova conexão com o cliente " +  cliente.getInetAddress().getHostAddress());
	     
	     Scanner entrada = new Scanner(cliente.getInputStream());
	     PrintStream input = new PrintStream(cliente.getOutputStream());
	     while (entrada.hasNextLine()) {
	    	 System.out.println(entrada.nextLine());
	    	 input.println("Pong");
	     }
	     
	     
	     entrada.close();
	     servidor.close();
	   }
	 }