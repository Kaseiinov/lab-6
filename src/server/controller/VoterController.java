package server.controller;

import java.io.IOException;

public class VoterController extends UserController {
    protected VoterController(String host, int port) throws IOException {
        super(host, port);
    }
}
