import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;

public class DateClient {
	public static void main(String[] args) {
		DateClient script = new DateClient();
		script.launch();
	}

	private void launch() {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
			
		try {
			Remote service = Naming.lookup("//localhost/date");
			DateService dateService = (DateService) service;
			String receivedDate = dateService.getTimeAndDate();
			
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