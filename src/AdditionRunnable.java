import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AdditionRunnable implements Runnable {
	
	protected Socket socket = null;
	private AdditionCalculator addCalc = null;
	
	public AdditionRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
			if(in.readLine().equalsIgnoreCase("Add")){
				int num1 = Integer.parseInt(in.readLine());
				int num2 = Integer.parseInt(in.readLine());
				
				this.addCalc = new AdditionCalculator(num1, num2);
			}
			out.println(addCalc.add());
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
