/**
 * Starter Class for launching 
 * the server
 * 
 * @author Shahbaz.Alam
 *
 */
public class AdditionServer {

	public static void main(String[] args) {
		System.out.println("--------Server Terminal----------");
		new SocketServer().runServer();
	}

}
