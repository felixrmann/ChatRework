package ChatRework.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-16
 */

public class Server {

    private static final Set<String> names = new HashSet<>();
    private static Set<PrintWriter> writers = new HashSet<>();

    public static class Handler implements Runnable {
        private String name;
        private Socket socket;
        private PrintWriter out;

        public Handler(Socket socket){
            this.socket = socket;
        }

        public void run() {
            try {
                Scanner in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream(), true);
                while (true){
                    out.println("SUBMITNAME");
                    name = in.nextLine();
                    if (name == null) return;

                    synchronized (names){
                        if (!names.isEmpty() && !names.contains(name)){
                            names.add(name);
                            break;
                        }
                    }
                }

                out.println("NAMEACCEPTED " + name);
                System.out.println("Hello " + name);
                for (PrintWriter writer : writers){
                    writer.println("MESSAGE " + name + " has joined");
                }
                writers.add(out);

                while (true){
                    String input = in.nextLine();
                    if (input.toLowerCase().startsWith("/quit")) {
                        return;
                    }
                    for (PrintWriter writer : writers){
                        writer.println("MESSAGE " + name + ": " + input);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null){
                    writers.remove(out);
                }
                if (name != null){
                    System.out.println(name + " is leaving");
                    names.remove(name);
                    for (PrintWriter writer : writers){
                        writer.println("MESSAGE " + name + " has left");
                    }
                }
                try {
                    socket.close();
                } catch (IOException ignored){}
            }
        }
    }

}
