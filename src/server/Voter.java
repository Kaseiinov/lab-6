//package server;
//
//import com.sun.net.httpserver.HttpExchange;
//import server.models.Candidate;
//import server.models.User;
//import utils.FileUtils;
//import utils.Utils;
//
//import java.io.IOException;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Voter extends Register{
//    public List<Candidate> candidateList = FileUtils.readFile();
//
//    public Voter(String host, int port) throws IOException {
//        super(host, port);
//
//        registerGet("/", this::voteHandler);
//        registerGet("/thankyou", this::thankYouHandler);
//        registerGet("/votes", this::votesHandler);
//    }
//
//    private void voteHandler(HttpExchange exchange) {
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("candidates", candidateList);
//
//        renderTemplate(exchange, "/candidates.ftlh", data);
//    }
//
//    private void thankYouHandler(HttpExchange exchange) {
//        Map<String, Object> data = new HashMap<>();
//
//        String stringQuery = exchange.getRequestURI().getQuery();
//        Map<String, String> params = Utils.parseUrlEncoded(stringQuery, "&");
//        String canId = params.get("candidateId");
//
//        String stringCookie = getCookie(exchange);
//        Map<String, String> cookieParams = Utils.parseUrlEncoded(stringCookie, "&");
//        String userEmail = cookieParams.get("userId");
//        System.out.println(userEmail);
//
//        User user = users
//                .stream()
//                .filter(u -> u.getEmail().equals(userEmail))
//                .findFirst()
//                .orElse(null);
//
//        if(user == null) {
//            sendError(exchange, "Пользовател не найден");
//            return;
//        }
//
//        addVotes(canId);
//
//        Candidate candidate = candidateList
//                .stream()
//                .filter(can -> can.getId().equals(canId))
//                .findFirst()
//                .orElse(null);
//
//        if(candidate == null) {
//            sendError(exchange, "Кандидат не найден");
//            return;
//        }
//
////        candidate.setVoter(user);
//
//        data.put("candidate", candidate);
//        System.out.println(candidate);
//        renderTemplate(exchange, "/thankyou.ftlh", data);
//    }
//
//    private void votesHandler(HttpExchange exchange) {
//        Map<String, Object> data = new HashMap<>();
//
//        candidateList.forEach(candidate -> candidate.calculatePercentage(candidateList));
//
//        List<Candidate> sortedCandidates  = candidateList
//                .stream()
//                .sorted(Comparator.comparingInt(Candidate::getVotes).reversed())
//                .toList();
//
//        data.put("sortedCandidates", sortedCandidates);
//        renderTemplate(exchange, "/votes.ftlh", data);
//    }
//
//    private void addVotes(String canId) {
//        candidateList
//                .stream()
//                .filter(can -> can.getId().equals(canId))
//                .findFirst()
//                .ifPresent(can -> {
//                    can.setVotes(can.getVotes() + 1);
//                    can.calculatePercentage(candidateList);
//                });
//    }
//
//}
