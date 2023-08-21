package assignment2;

import java.util.Objects;
import java.util.regex.Pattern;

public class Account {

    // 3 instance variables which are accessible in the Account class
    private String accountName = "name";
    private int accountNumber = 0;
    private double accountBalance = 0.0;

    // Default constructor + a constructor with 3 arguments
    // If the validation is not passed, default value will be set
    public Account() {}
    public Account(String accountName, int accountNumber, double accountBalance) {
        if( setAccountName(accountName)  &&  setAccountNumber(accountNumber) && setAccountBalance(accountBalance) ){
            this.accountName = accountName;
            this.accountNumber = accountNumber;
            this.accountBalance = accountBalance;
        }
        new Account();
    }

    // Getters and setters
    public String getAccountName() {
      return accountName;
    }
    public boolean setAccountName(String accountName) {
        // Checking the validation by using ASCII code
        char[] charArr = accountName.toCharArray();
        int singleQuoteNum = 0;
        int spaceNum = 0;
        boolean alphabet = false;

        for (char c : charArr) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '-') {
                alphabet = true;
            } else if (c == '\'') {
                singleQuoteNum++;
            } else if (c == ' ') {
                spaceNum++;
            }
        }

        if (charArr.length > 5 && singleQuoteNum < 2 && spaceNum < 2 && alphabet) {
            this.accountName = accountName;
            return true;
        }
        return false;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    // Checking the validation by using Regular Expression
    public boolean setAccountNumber(int accountNumber) {
        String accountNumberString = String.valueOf(accountNumber);
        boolean check = Pattern.matches("[0-9]{5,8}", accountNumberString);
        if (check) {
            this.accountNumber = accountNumber;
            return true;
        }
        return false;
    }

    public double getAccountBalance() {
        return Math.floor(accountBalance*100.0)/100.0;
    }

    public boolean setAccountBalance(double value) {
        if (value >= 0) {
            this.accountBalance = Math.floor(value * 100) / 100.0;
            this.accountBalance = value;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) {
            return false;
        }
        Account a = (Account) obj;
        if(accountNumber == a.accountNumber && Objects.equals(accountName, a.accountName) && Math.abs(accountBalance - a.accountBalance) < 0.01) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
