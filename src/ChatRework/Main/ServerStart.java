package ChatRework.Main;

import ChatRework.Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-16
 */

public class ServerStart {
    public static void main(String[] args) {
        System.out.println("Now running......");
        ExecutorService pool = Executors.newFixedThreadPool(500);
        try (ServerSocket listener = new ServerSocket(59001)){
            while (true) {
                pool.execute(new Server.Handler(listener.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
