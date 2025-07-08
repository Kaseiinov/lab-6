package server.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private static final List<User> users = new ArrayList<>();

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Candidate> votes;

    public User() {}

    public User(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.votes = new ArrayList<>();
    }

    public List<Candidate> getVotes() {
        return votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVotes(List<Candidate> votes) {
        this.votes = votes;
    }

    public void addCandidate(Candidate candidate) {
        this.votes.add(candidate);
    }

    public static void addUser(User user){
        users.add(user);
    }

    public static List<User> getUsers() {
        return users;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", votes=" + votes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
