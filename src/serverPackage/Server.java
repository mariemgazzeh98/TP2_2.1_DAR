package serverPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		try{
		ServerSocket socketServeur =  new ServerSocket(1234);
		System.out.println("Je suis un serveur en attente la connexion d'un client ");
		Socket socket = socketServeur.accept();
		System.out.println("un client est connecté");
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr= new InputStreamReader(is); 
		BufferedReader br = new BufferedReader(isr); 
		
		String ch=br.readLine();
		String[] p =ch.split(" ");

	    int x1 = Integer.parseInt(p[0]);
	    String o = p[1];
	    int x2 = Integer.parseInt(p[2]);
		
		int res = 0;
		switch (o) {
			case "+":
				res = x1+x2;
				System.out.println("Addition : " + x1 + " + "+x2+" = " + res);
				break;
			case "-":
				res = x1-x2;
				System.out.println("Soustraction : " + x1 +" -  "+x2+" = " + res);
				break;
			case "*":
				res = x1*x2;
				System.out.println("Multiplication : " + x1 + " *  "+x2+" = " + res);
				break;
			case "/":
				if(x2 !=0) {
					res = x1/x2;
					System.out.println("Division : " + x1 + " /  "+x2+" = " + res);
				}
				else
				{System.out.println("Division par zéro impossible");}
				break;
			default:
				System.out.println("Erreur : operateur invalide");
		}
		
		OutputStream os = socket.getOutputStream();
		os.write(res);
		socketServeur.close();
		socket.close();
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}



}


