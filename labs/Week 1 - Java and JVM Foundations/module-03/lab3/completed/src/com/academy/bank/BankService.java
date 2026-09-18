package com.academy.bank;

import java.time.LocalDate;
import java.util.Scanner;

public class BankService {

    private static final int MAX_CUSTOMERS = 50;
    private static final int MAX_ACCOUNTS = 100;
    private static final int MAX_TRANSACTIONS = 500;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private final Account[] accounts = new Account[MAX_ACCOUNTS];
    private final Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];

    private int customerCount = 0;
    private int accountCount = 0;
    private int transactionCount = 0;
    private int nextAccountNumber = 10001;
    private int nextTransactionNumber = 1;

    private final Scanner scanner;

    public BankService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createCustomer() {
        // TODO: read customerId / name / email / phone; reject duplicate IDs
        // TODO: store new Customer; print "Customer Created Successfully."
        if (customerCount >= MAX_CUSTOMERS) {
            System.out.println("Error: Cannot create customer. Maximum limit reached.");
            return;
        }

        System.out.println("Customer ID: ");
        String id = scanner.nextLine();

        if (findCustomer(id) != null) {
            System.out.println("Error: Customer ID already exists.");
            return;
        }

        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(id, name, email, phone);
        customers[customerCount] = customer;
        customerCount++;

        System.out.println("Customer Created Successfully.");
    }

    public void createSavingsAccount() {
        // TODO: read existing customer, initial balance, interest rate
        // TODO: create SavingsAccount with nextAccountNumber++; store in accounts[]
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Error: Cannot create account. Maximum limit reached.");
            return;
        }

        System.out.println("Customer ID: ");
        String id = scanner.nextLine();

        Customer associatedCustomer = findCustomer(id);

        if (associatedCustomer == null) {
            System.out.println("Error: Customer ID not found. Account creation aborted.");
            return;
        }

        System.out.println("Initial balance: ");
        double balance = Double.parseDouble(scanner.nextLine());

        System.out.println("Interest rate (%): ");
        double interestRate = Double.parseDouble(scanner.nextLine());

        String accountNumberStr = String.valueOf(nextAccountNumber);

        SavingsAccount newAccount = new SavingsAccount(accountNumberStr, balance, associatedCustomer, interestRate);

        accounts[accountCount] = newAccount;
        accountCount++;
        nextAccountNumber++;

        System.out.println("Account with ID " + newAccount.getAccountNumber() + " created successfully!");
    }

    public void createCurrentAccount() {
        // TODO: read existing customer, initial balance, transaction fee
        // TODO: create CurrentAccount with nextAccountNumber++; store in accounts[]
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Error: Cannot create account. Maximum limit reached.");
            return;
        }

        System.out.println("Customer ID: ");
        String id = scanner.nextLine();

        Customer associatedCustomer = findCustomer(id);

        if (associatedCustomer == null) {
            System.out.println("Error: Customer ID not found. Account creation aborted.");
            return;
        }

        System.out.println("Initial balance: ");
        double balance = Double.parseDouble(scanner.nextLine());

        System.out.println("Transaction fee: ");
        double transactionFee = Double.parseDouble(scanner.nextLine());

        String accountNumberStr = String.valueOf(nextAccountNumber);

        CurrentAccount newAccount = new CurrentAccount(accountNumberStr, balance, associatedCustomer, transactionFee);

        accounts[accountCount] = newAccount;
        accountCount++;
        nextAccountNumber++;

        System.out.println("Account with ID " + newAccount.getAccountNumber() + " created successfully!");
    }

    public void deposit() {
        // TODO: read existing account + amount; account.deposit; recordTransaction DEPOSIT
        // TODO: print updated balance
        System.out.println("Account id: ");
        String id = scanner.nextLine();

        Account account = findAccount(id);

        if (account == null) {
            System.out.println("Error: Account not found. Deposit aborted.");
            return;
        }

        System.out.println("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        account.deposit(amount);

        recordTransaction(account.getAccountNumber(), amount, "DEPOSIT");
        System.out.println("Updated balance: " + account.getBalance());
    }

    public void withdraw() {
        // TODO: read existing account + amount; account.withdraw; record on success
        // TODO: for CurrentAccount, print fee + total deducted; print updated balance
        System.out.println("Account id: ");
        String id = scanner.nextLine();

        Account account = findAccount(id);

        if (account == null) {
            System.out.println("Error: Account not found. Withdraw aborted.");
            return;
        }

        System.out.println("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (account instanceof CurrentAccount currentAcc) {
            double fee = currentAcc.getTransactionFee();
            account.withdraw(amount);

            System.out.println("Fee applied: " + fee);
            System.out.println("Total deducted from account: " + (amount + fee));
        } else {
            account.withdraw(amount);
        }

        recordTransaction(account.getAccountNumber(), amount, "WITHDRAW");
        System.out.println("Updated balance: " + account.getBalance());
    }

    public void displayAccounts() {
        // TODO: if empty print message; else loop displayAccount() for each
        for (Account account : accounts) {
            if (account == null) {
                break;
            } else {
                account.displayAccount();
            }
        }
    }

    public void displayCustomers() {
        if (customerCount == 0) {
            System.out.println("No customers available.");
            return;
        }

        System.out.println("----------------------------------");
        for (int i = 0; i < customerCount; i++) {
            customers[i].display();
            System.out.println("----------------------------------");
        }
    }

    public void transferMoney() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayTransactionHistory() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayHighestBalanceCustomer() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void generateAccountSummaryReport() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    private Customer readExistingCustomer() {
        if (customerCount == 0) {
            System.out.println("Create a customer first.");
            return null;
        }

        System.out.print("Customer ID : ");
        String customerId = scanner.nextLine().trim();
        Customer customer = findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
        }

        return customer;
    }

    private Account readExistingAccount() {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.print("Account Number : ");
        String accountNumber = scanner.nextLine().trim();
        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        }

        return account;
    }

    private Customer findCustomer(String customerId) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equalsIgnoreCase(customerId)) {
                return customers[i];
            }
        }
        return null;
    }

    private Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    private void recordTransaction(String accountNumber, double amount, String type) {
        if (transactionCount >= MAX_TRANSACTIONS) {
            return;
        }

        String transactionId = "T" + nextTransactionNumber++;
        String date = LocalDate.now().toString();
        transactions[transactionCount++] = new Transaction(transactionId, amount, type, date, accountNumber);
    }

    private double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value < 0) {
                    System.out.println("Amount must not be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid amount. Please try again.");
            }
        }
    }
}
