import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The actual socket server 
 * implementation which uses the 
 * java.net.ServerSocket and
 * ExecutorService fpr managing thread
 * pool.
 * 
 * @author Shahbaz.Alam
 *
 */
public class SocketServer {
	private final int port = 8080;
	private ServerSocket serverSocket = null;
	private ExecutorService threadsPool = null;
	private final int max_limit = 5;//can be managed
	
	public void runServer(){
		try{
			serverSocket = new ServerSocket(port);
			threadsPool = Executors.newFixedThreadPool(max_limit);
		}catch(IOException e){
			e.printStackTrace();
		}
		while (!Thread.interrupted()){
			try{
				Socket socket = serverSocket.accept();
				threadsPool.execute(new Thread(new AdditionRunnable(socket)));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		try {
			serverSocket.close();//closing the serversocket
		} catch (IOException e) {
			e.printStackTrace();//needs to have better exception handling
		}
	}

}
