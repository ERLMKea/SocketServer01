import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try (var listener = new ServerSocket(59090)) {
            System.out.println("the date server is running");
            while (true) {
                try (var socket = listener.accept()) {
                    var out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                }
            }
        } catch (Exception e) {
            System.out.println("FEJL i socket e=" + e.getMessage());
        }

    }
}
