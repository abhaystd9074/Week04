package org.example;
import java.time.LocalDate;
import java.util.*;

public class InsuranceSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding policies
        manager.addPolicy(new Policy2("P101", "Nisha", LocalDate.of(2024, 5, 20)));
        manager.addPolicy(new Policy2("P102", "Ajay", LocalDate.of(2024, 6, 10)));
        manager.addPolicy(new Policy2("P103", "Suraj", LocalDate.of(2024, 4, 15))); // Expired
        manager.addPolicy(new Policy2("P104", "Vivek", LocalDate.of(2024, 5, 25)));

        // Fetching a policy
        System.out.println("Policy P101 details: " + manager.getPolicyByNumber("P101"));

        // Listing policies expiring in the next 30 days
        System.out.println("Policies expiring in the next 30 days:");
        for (Policy2 policy : manager.getPoliciesExpiringSoon()) {
            System.out.println(policy);
        }

        // Listing policies for a specific policyholder
        System.out.println("Policies for Nisha:");
        for (Policy2 policy : manager.getPoliciesByHolder("Nisha")) {
            System.out.println(policy);
        }

        // Removing expired policies
        System.out.println("Removing expired policies...");
        manager.removeExpiredPolicies();

        // Displaying all policies in insertion order
        System.out.println("Policies after removing expired ones (in insertion order):");
        manager.displayPoliciesInInsertionOrder();
    }
}

class InsurancePolicyManager {
    private Map<String, Policy2> policyMap = new HashMap<>();
    private final LinkedHashMap<String, Policy2> linkedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy2>> expiryPolicyMap = new TreeMap<>();

    // Adding a policy
    public void addPolicy(Policy2 policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        linkedPolicyMap.put(policy.getPolicyNumber(), policy);

        // Storing in TreeMap based on expiry date
        expiryPolicyMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieving policy by policy number
    public Policy2 getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Listing all policies expiring in the next 30 days
    public List<Policy2> getPoliciesExpiringSoon() {
        List<Policy2> expiringSoon = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy2>> entry : expiryPolicyMap.entrySet()) {
            if (!entry.getKey().isAfter(thresholdDate)) {
                expiringSoon.addAll(entry.getValue());
            }
        }
        return expiringSoon;
    }

    // Listing all policies for a specific policyholder
    public List<Policy2> getPoliciesByHolder(String policyHolderName) {
        List<Policy2> holderPolicies = new ArrayList<>();
        for (Policy2 policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName)) {
                holderPolicies.add(policy);
            }
        }
        return holderPolicies;
    }

    // Removing expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<Policy2>>> iterator = expiryPolicyMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<Policy2>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy2 policy : entry.getValue()) {
                    policyMap.remove(policy.getPolicyNumber());
                    linkedPolicyMap.remove(policy.getPolicyNumber());
                }
                iterator.remove();
            }
        }
    }

    public void displayPoliciesInInsertionOrder() {
        for (Policy2 policy : linkedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}

class Policy2 {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    public Policy2(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Policy Number='" + policyNumber + '\'' +
                ", Policy Holder='" + policyHolderName + '\'' +
                ", Expiry Date=" + expiryDate +
                '}';
    }
}
