package server.controller;

import com.sun.net.httpserver.HttpExchange;
import server.BasicServer;
import server.ContentType;
import server.Cookie;
import server.ResponseCodes;
import server.models.User;
import utils.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserController extends BasicServer {
    public UserController(String host, int port) throws IOException {
        super(host, port);
        registerGet("/login", this::loginGetFreemarkerHandler);
        registerPost("/login", this::loginPost);
        registerGet("/register", this::registerGet);
        registerPost("/register", this::registerPost);
        registerGet("/logout", this::logoutHandler);
    }



    private void logoutHandler(HttpExchange exchange){
        exchange.getResponseHeaders().add("Set-Cookie", "userEmail=; Max-Age=0; Path=/");
        redirect(exchange, "/login");
    }

    private void registerPost(HttpExchange exchange) throws FileNotFoundException {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        User newUser = new User();
        newUser.setId(User.getUsers().size()+1L);
        newUser.setEmail(parsed.get("email"));
        newUser.setPassword(parsed.get("user-password"));
        newUser.setFirstName(parsed.get("user-firstName"));
        newUser.setLastName(parsed.get("user-lastName"));

        if(User.getUsers().contains(newUser)){
            String fmt = "%s -> user with that email already registered! " +
                    "%s -> code response " +
                    "<a href='/register'>try again</a>";
            sendResponse(exchange, fmt, newUser.getEmail(), ResponseCodes.CONFLICT.getCode());
        } else{
            User.addUser(newUser);
            redirect(exchange, "/login");
        }
    }

    private void registerGet(HttpExchange exchange){
        renderTemplate(exchange, "auth/register.ftlh", null);
    }

    private void loginGetFreemarkerHandler(HttpExchange exchange) {
        Map<String, String> responseData = new HashMap<>();
        URI uri = exchange.getRequestURI();

        if (uri.getQuery() != null) {
            responseData = Utils.parseUrlEncoded(uri.getQuery(), "&");
        }

        renderTemplate(exchange, "auth/login.ftlh", responseData);
    }

    private void loginPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");

        Optional<User> user = User.getUsers().stream()
                .filter(e -> e.getEmail().equals(parsed.get("email")))
                .findFirst();

        if (user.isEmpty()) {
            redirect(exchange, "/login?response=User not found");
            return;
        }

        if (user.get().getPassword().equals(parsed.get("user-password"))) {
            Cookie cookie = Cookie.make("userId", user.get().getId());
            cookie.setHttpOnly(true);
            cookie.setMaxAge(300);
            setCookie(exchange, cookie);

            redirect(exchange, "/");
            return;
        }

        redirect(exchange, "/login?response=Incorrect password");

    }

    public void sendResponse(HttpExchange exchange, String fmt, String value, int code){
        String data = String.format(fmt, value, code);
        try {
            sendByteData(exchange, ResponseCodes.OK,
                    ContentType.TEXT_HTML, data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
