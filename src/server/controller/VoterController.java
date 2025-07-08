package server.controller;

import com.sun.net.httpserver.HttpExchange;
import server.models.Candidate;
import server.models.User;
import utils.FileUtils;
import utils.Utils;

import java.io.IOException;
import java.util.*;

public class VoterController extends UserController {
    public List<Candidate> candidateList = new ArrayList<>();

    public VoterController(String host, int port) throws IOException {
        super(host, port);

        registerGet("/", this::voteHandler);
        registerGet("/thankyou", this::thankYouHandler);
        registerGet("/votes", this::votesHandler);
        candidateList = FileUtils.readFile();
        candidateList.forEach(System.out::println);
    }

    private void voteHandler(HttpExchange exchange) {

        Map<String, Object> data = new HashMap<>();
        data.put("candidates", candidateList);

        renderTemplate(exchange, "/index.ftlh", data);
    }

    private void thankYouHandler(HttpExchange exchange) {
        Map<String, Object> data = new HashMap<>();

        String stringQuery = exchange.getRequestURI().getQuery();
        Map<String, String> params = Utils.parseUrlEncoded(stringQuery, "&");
        Long canId = Long.valueOf(params.get("candidateId"));

        String stringCookie = getCookie(exchange);

        if(stringCookie.isEmpty()) {
            redirect(exchange, "/login");
            return;
        }

        Map<String, String> cookieParams = Utils.parseUrlEncoded(stringCookie, "&");
        Long userId = Long.valueOf(cookieParams.get("userId"));

        User user = User.getUsers()
                .stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElse(null);

        addVotes(canId);

        Candidate candidate = candidateList
                .stream()
                .filter(can -> can.getId().equals(canId))
                .findFirst()
                .orElse(null);

        if(candidate == null) {
            sendError(exchange, "Candidate not found");
            return;
        }
//        if (user != null) {
//            System.out.println("Before candidate.addVoters(user)");
//            candidate.addVoters(user);
//            System.out.println("After candidate.addVoters(user)");
//
//            System.out.println("Before user.addCandidate(candidate)");
//            user.addCandidate(candidate);
//            System.out.println("After user.addCandidate(candidate)");
//        }



        data.put("candidate", candidate);
        System.out.println(candidate);
        renderTemplate(exchange, "thankyou.ftlh", data);
    }

    private void votesHandler(HttpExchange exchange) {
        Map<String, Object> data = new HashMap<>();

        candidateList.forEach(candidate -> candidate.calculatePercentage(candidateList));

        List<Candidate> sortedCandidates  = candidateList
                .stream()
                .sorted(Comparator.comparingInt(Candidate::getVotes).reversed())
                .toList();

        data.put("sortedCandidates", sortedCandidates);
        renderTemplate(exchange, "/votes.ftlh", data);
    }

    private void addVotes(Long canId) {
        candidateList
                .stream()
                .filter(can -> can.getId().equals(canId))
                .findFirst()
                .ifPresent(can -> {
                    can.setVotes(can.getVotes() + 1);
                    can.calculatePercentage(candidateList);
                });
    }
}
