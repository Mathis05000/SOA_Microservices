import Controller.CreateUser;

import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;

public class UserApplication {
    public static String host = "localhost";
    public static short port = 8089;

    public void startService() {
        String url = "http://" + host + ":" + port + "/";
        Endpoint.publish(url, new CreateUser());
    }

    public static void main(String[] args) throws MalformedURLException {
        new UserApplication().startService();
        System.out.println("service is running");
    }
}
