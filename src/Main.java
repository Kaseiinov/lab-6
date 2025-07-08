import server.controller.VoterController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new VoterController("localhost", 8080).start();
    }
}