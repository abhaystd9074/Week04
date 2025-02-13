package org.example;

import java.util.*;

public class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;
    //constructor to initialize

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" + "policyNumber='" + policyNumber + '\'' + ", policyholderName='" + policyholderName + '\'' + ", expiryDate=" + expiryDate + ", coverageType='" + coverageType + '\'' + ", premiumAmount=" + premiumAmount + '}';
    }
}

class PolicyService {
    //method to display all the policies
    public static void displayAllPolicies(Set<Policy> policies) {
        System.out.println("All Policies:");
        for (Policy policy : policies) {
            System.out.println(policy);
        }
    }

    //method to display policies according to their expiry date
    public static void displayExpiringSoon(Set<Policy> policies) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date thresholdDate = calendar.getTime();

        System.out.println("Policies expiring within 30 days:");
        for (Policy policy : policies) {
            if (policy.expiryDate.before(thresholdDate)) {
                System.out.println(policy);
            }
        }
    }

    //Display policies by coverage type
    public static void displayByCoverageType(Set<Policy> policies, String type) {
        System.out.println("Policies with coverage type: " + type);
        for (Policy policy : policies) {
            if (policy.coverageType.equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    //method to find duplicate policies
    public static void findDuplicatePolicies(Set<Policy> policies) {
        Map<String, Integer> policyCount = new HashMap<>();
        for (Policy policy : policies) {
            policyCount.put(policy.policyNumber, policyCount.getOrDefault(policy.policyNumber, 0) + 1);
        }

        System.out.println("Duplicate Policies:");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + " - Duplicates: " + entry.getValue());
            }
        }
    }
}
class PolicyStorage {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    //adding policies
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public Set<Policy> getAllPolicies() {
        return hashSet;
    }

    public Set<Policy> getSortedPolicies() {
        return treeSet;
    }
}
class Main {
    public static void main(String[] args) {
        //Obj of the class

        //Adding members with policy
        PolicyStorage storage=new PolicyStorage();

        storage.addPolicy(new Policy("P001", "Abhay", new Date(System.currentTimeMillis() + 1000000000), "Health", 500.0));
        storage.addPolicy(new Policy("P002", "Tikesh", new Date(System.currentTimeMillis() + 500000000), "Auto", 600.0));
        storage.addPolicy(new Policy("P003", "Nishank", new Date(System.currentTimeMillis() + 200000000), "Home", 700.0));
        storage.addPolicy(new Policy("P001", "Abhay", new Date(System.currentTimeMillis() + 1000000000), "Health", 500.0));
        storage.addPolicy(new Policy("P001", "Vikas", new Date(System.currentTimeMillis() + 1000000000), "Health", 500.0));
        //call method to get all the policies
        Set<Policy> policies = storage.getAllPolicies();
        //to display all the policies
        PolicyService.displayAllPolicies(policies);
        System.out.println();

        PolicyService.displayExpiringSoon(storage.getSortedPolicies());
        System.out.println();
        //by id
        PolicyService.displayByCoverageType(policies, "Health");
        //method to find duplicate policies
        PolicyService.findDuplicatePolicies(policies);
    }
}