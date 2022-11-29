package BankAccount_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Map<Integer, BankAccount> accountsMap = new HashMap<>();



        while (!input[0].equals("End")) {
            String command = input[0];

            switch (command){
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accountsMap.put(bankAccount.getId(), bankAccount);
                    System.out.println
                            (String.format("Account ID%d created", bankAccount.getId()));
                    break;
                case "Deposit":
                    int currentId = Integer.parseInt(input[1]);
                    double depositAmount = Double.parseDouble(input[2]);
                    if(accountsMap.containsKey(currentId)){
                        BankAccount bankAccountFromMap = accountsMap.get(currentId);
                        bankAccountFromMap.deposit(depositAmount);
                        System.out.println(String.format
                                ("Deposited %.0f to ID%d", depositAmount, currentId));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(input[1]);
                    BankAccount.setInterestRate(newInterest);
                    break;

                case "GetInterest":
                    int currentId1 = Integer.parseInt(input[1]);
                    int years = Integer.parseInt(input[2]);
                    if(accountsMap.containsKey(currentId1)){
                        BankAccount bankAccount1 = accountsMap.get(currentId1);
                        System.out.println(String.format("%.2f", bankAccount1.getInterest(years)));
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;
            }

            input = scanner.nextLine().split("\\s+");
            command = input[0];
        }
    }
}
