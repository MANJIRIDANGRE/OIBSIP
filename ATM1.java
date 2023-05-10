import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String type;
    private double amount;
    private Date timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = new Date();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.println("Withdrawal successful. Updated balance: " + balance);
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposit successful. Updated balance: " + balance);
    }

    public void transfer(Account destinationAccount, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Transfer failed.");
        } else {
            balance -= amount;
            destinationAccount.balance += amount;
            transactionHistory.add(new Transaction("Transfer", amount));
            System.out.println("Transfer successful. Updated balance: " + balance);
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getType() + " - Amount: " + transaction.getAmount() +
                    " - Timestamp: " + transaction.getTimestamp());
        }
    }
}

public class ATM1 {
public static void main(String[] args) {
        Account account1 = new Account("123456789", 5000.0);
        Account account2 = new Account("987654321", 3000.0);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean quit = false;
            System.out.println("ENTER YOUR USER ID:-");
            String userid = scanner.nextLine();
            System.out.println("ENTER YOUR USER PIN:-");
            int userpin = scanner.nextInt();

            if(userid != null && userpin != 0)
            {
                System.out.println("LOGIN SUCCESSFUL");
            }
            else{
                System.out.println("INVALID ENTRY,TRY AGAIN");
            }


            while (!quit) {
                System.out.println("Welcome to the ATM!");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Transfer");
                System.out.println("4. Transaction History");
                System.out.println("5. Quit");
                System.out.print("Please enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account1.withdraw(withdrawAmount);
                        break;
                    case 2:
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account1.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter the amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        account1.transfer(account2, transferAmount);
                        break;
                    case 4:
                        account1.printTransactionHistory();
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Thank you for using the ATM.");
                        System.out.println("VISIT AGAIN");
                }}
        }}}
