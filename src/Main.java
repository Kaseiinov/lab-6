import server.controller.UserController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new UserController("localhost", 8080).start();
    }
}