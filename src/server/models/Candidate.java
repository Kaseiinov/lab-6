package server.models;

import java.util.ArrayList;
import java.util.List;

public class Candidate {
    private String id;
    private String name;
    private String photo;
    private int votes;
    private double percentage;
    private List<User> voter = new ArrayList<>();

    public Candidate(String name, String photo, int votes) {
        this.id += 1;
        this.name = name;
        this.photo = photo;
        this.votes = votes;
    }

    public void calculatePercentage(List<Candidate> allCandidates) {
        int totalVotes = allCandidates.stream()
                .mapToInt(Candidate::getVotes)
                .sum();

        if (totalVotes == 0) {
            this.percentage = 0;
        } else {
            this.percentage = ((double) this.votes / totalVotes) * 100;
        }

        this.percentage = Double.parseDouble(String.format("%.1f", this.percentage));
    }

    public void addVoters(User user) {
        this.voter.add(user);
    }

    public List<User> getVoter() {
        return voter;
    }

    public void setVoter(List<User> voter) {
        this.voter = voter;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImg() {
        return photo;
    }

    public void setUrlImg(String photo) {
        this.photo = photo;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", votes=" + votes +
                ", percentage=" + percentage +
                ", voter=" + voter +
                '}';
    }
}
