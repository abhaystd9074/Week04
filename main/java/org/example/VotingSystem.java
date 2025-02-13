package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;
public class VotingSystem {
    private HashMap<String, Integer> voteCount;
    private LinkedHashMap<String, Integer> voteOrder;

    public VotingSystem() {
        voteCount = new HashMap<>();
        voteOrder = new LinkedHashMap<>();
    }

    public void vote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    public void displayResults() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteCount);
        System.out.println("Results in Sorted Order:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayVoteOrder() {
        System.out.println("Vote Order:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.vote("Abhay");
        system.vote("Nishank");
        system.vote("Abhay");
        system.vote("Tikesh");
        system.vote("Amaan");
        system.vote("Abhay");

        system.displayResults();
        system.displayVoteOrder();
    }
}

