import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;

public class DateServerLauncher {
	public static void main(String[] args) {
		DateServerLauncher script = new DateServerLauncher();
		script.launch();
	}

	private void launch() {
// 1. If there is no security manager, start one
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
// 2. Create the registry if there is not one
			LocateRegistry.createRegistry(1099);
// 3. Create the server object
			DateServer server = new DateServer();
// 4. Register (bind) the server object on the registy.
// The registry may be on a different machine
			String registryHost = "//localhost/";
			String serviceName = "date";
			Naming.rebind(registryHost + serviceName, server);
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}
}	