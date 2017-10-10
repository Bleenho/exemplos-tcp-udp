import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
 
public class Client {
   
   ObjectOutputStream output;
   ObjectInputStream input;
   byte[] message ;
   int port = 4040;
   InetAddress addr =null;
 
   public Client(){
    
   }
   
   public void runServer(){
	   
	   DatagramSocket ds = null;
      try {
    	  
    	  
             
            int port = 4042;
             ds = new DatagramSocket(port);     
            System.out.println("Ouvindo a porta: " + port);
            byte[] msg = new byte[256];
            DatagramPacket pkg = new DatagramPacket(msg, msg.length); 
            
            ds.receive(pkg);

            String MENSSAGEM =new String(pkg.getData()).trim(); 
            System.out.println( "Mensagem recebida: " + MENSSAGEM +" \nRecebido de :"+  pkg.getAddress().getHostName()+"\n");
            
             if(ds != null)
           	 ds.close(); 
            
      }catch ( EOFException eof ) {
         System.out.println( "Client terminated connection" );
         if(ds != null)
           	 ds.close(); 
      }catch ( IOException io ) {
         io.printStackTrace();
         if(ds != null)
           	 ds.close(); 
      }
   }
 
   public void runClient(){

    	  Scanner teclado = new Scanner(System.in);
    	  
    	  while(teclado.hasNextLine()) {
    		  sendData(teclado.nextLine());
    	  }
   }
 
   private void sendData( String s ){
      try {
    	 this.addr = InetAddress.getByName("127.0.0.1");
    	 message = s.getBytes();
    	 DatagramPacket pkg = new DatagramPacket(message,message.length, addr, port);
    	 DatagramSocket ds = new DatagramSocket();

         ds.send(pkg);

         ds.close();  
         
         runServer();
         
      }catch ( IOException cnfex ) {
      }
   }
 
   public static void main( String args[] ){
      Client app = new Client();
      app.runClient();
   }
} 
