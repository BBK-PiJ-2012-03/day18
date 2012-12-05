import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;

public class Client {
	public static void main(String[] args) {
		Client script = new Client();
		script.launch();
	}

	private void launch() {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		EchoService echoService = null;
		try {
			Remote service = Naming.lookup("//localhost/echo");
			echoService = (EchoService) service;
			String receivedEcho = echoService.echo("Hello!");
			
		}
		catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		catch (NotBoundException ex) {
			ex.printStackTrace();
		}
		
	
		
	}
}	