import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class DateServer extends UnicastRemoteObject implements DateService {
	
	public DateServer() throws RemoteException {
	}

	
	@Override
	public String getTimeAndDate() throws RemoteException {
// This println is not necessary, but helps verifying whether
// the server has received the call or not on the remote machine
	Date date = new Date();
	System.out.println(date.toString());
	return date.toString();
	}
}