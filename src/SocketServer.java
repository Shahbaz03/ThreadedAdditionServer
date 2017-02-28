import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class SocketServer {
	private final int port = 8080;
	private ServerSocket serverSocket = null;
	private ExecutorService threadPool;
	
	public void runServer(){
		try{
			serverSocket = new ServerSocket(port);
		}catch(IOException e){
			e.printStackTrace();
		}
		while(true){
			try{
				Socket socket = serverSocket.accept();
				new Thread(new AdditionRunnable(socket)).start();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	

}
