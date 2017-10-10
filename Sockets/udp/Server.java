import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
 
public class Server  {

   ObjectOutputStream output;
   ObjectInputStream input;
   byte[] message ;
   int port = 4042;
   InetAddress addr =null;
 
   public Server(){
   
   }
 
   public void runServer() throws InterruptedException{
	   
	   DatagramSocket ds = null;
      try {
    	  
    	  
         while ( true) {
          
            int port = 4040;
             ds = new DatagramSocket(port);     
            System.out.println("Ouvindo a porta: " + port);
            byte[] msg = new byte[256];
            DatagramPacket pkg = new DatagramPacket(msg, msg.length); 
            
            ds.receive(pkg);

            String MENSSAGEM =new String(pkg.getData()).trim(); 
            System.out.println( "Mensagem recebida: " + MENSSAGEM +" \nRecebido de :"+  pkg.getAddress().getHostName()+"\n");
            
            Thread.sleep(5000);
            this.addr = InetAddress.getByName("127.0.0.1");
       	 	message = new String("Pong").getBytes();
       	 	DatagramPacket pkgs = new DatagramPacket(message,message.length, addr, this.port);
       	 	DatagramSocket dss = new DatagramSocket();

            dss.send(pkgs);

            dss.close();  
    
            if(ds != null)
           	 ds.close(); 
         }
            
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
 
 
   public static void main( String args[] ) throws InterruptedException{
      Server app = new Server();
      app.runServer();
   }
}
