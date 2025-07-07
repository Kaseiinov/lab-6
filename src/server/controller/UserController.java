package server.controller;

import server.BasicServer;

import java.io.IOException;

public class UserController extends BasicServer {
    protected UserController(String host, int port) throws IOException {
        super(host, port);
    }
}
