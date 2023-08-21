package assignment2;

import java.util.ArrayList;


public class Bank {
    private String bankName = "Bank name";
    private String branchLocation = "Somewhere";
    private BranchLocations branchLocations = BranchLocations.BARRIE;
    public ArrayList<Account> accountList = new ArrayList<>();

    public static enum BranchLocations {
        TORONTO,
        BARRIE,
        SEOUL,
        TOKYO,
        LONDON
    };

    // Default constructor
    public Bank() {}

    // Constructor with 2 arguments x 2
    public Bank(String bankName, String branchLocation) {
      setBankName(bankName);
      setBranchLocation(branchLocation);
    }
    public Bank(String bankName, BranchLocations branchLocation) {
        setBankName(bankName);
        setBranchLocation(branchLocation);
    }

    // getBankName
    public String getBankName() {
        return bankName;
    }

    // setBankName
    public boolean setBankName(String bankName) {

        char[] charArr = bankName.toCharArray();
        int numberNum = 0;
        int spaceNum = 0;
        boolean alphabet = false;

        for (char c : charArr) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '&') {
                alphabet = true;
            } else if (c >= '0' && c <= '9') {
                numberNum++;
            } else if (c == ' ') {
                spaceNum++;
            }
        }

        if (charArr.length > 7 && numberNum < 4 && spaceNum < 2 && alphabet) {
            this.bankName = bankName;
            return true;
        }
        return false;
    }

    // setBranchLocation x 2
    public boolean setBranchLocation(String branchLocation) {
        for (BranchLocations branch : BranchLocations.values()) {
            if (branch.name().equals(branchLocation)) {
                this.branchLocation = String.valueOf(branch);
                return true;
            }
        }
        return false;
    }
    public boolean setBranchLocation(BranchLocations branchLocation) {
        for (BranchLocations location : BranchLocations.values()) {
            if (location == branchLocation) {
                this.branchLocation = String.valueOf(branchLocation);
                return true;
            }
        }
        return false;
    }

    // getBranchLocation
    public String getBranchLocation() {
        return branchLocation;
    }

    public Account getAccountByNumber(int accountNumber) {

        for(int i=0; i< accountList.size(); i++) {
            if(accountList.get(i).getAccountNumber() == accountNumber) {
                return accountList.get(i);
            }
        }
        return new Account();
    }

    // addAccount x 2
    public boolean addAccount(Account account) {

        for (Account customer : accountList) {
            if (customer.getAccountNumber() == account.getAccountNumber()) {
                return false;
            }
        }
        accountList.add(account);
        return true;
    }
    public boolean addAccount(String accountName, int accountNumber, double accountBalance) {
        for (Account account : accountList) {
            if (account.getAccountNumber() == accountNumber) {
                return false;
            }
        }
        accountList.add(new Account(accountName, accountNumber, accountBalance));
        return true;
    }

    public Account viewAccount(int accountNumber) {
        for(int i=0; i<accountList.size(); i++) {
            if(accountList.get(i).getAccountNumber() == accountNumber) {
                return accountList.get(i);
            }
        }
        return new Account();
    }

    public Account viewAccount(byte index) {
        for(int i=0; i<accountList.size(); i++) {
            if(i == index) {
                return accountList.get(i);
            }
        }
        return new Account();
    }

    // Modify method x 6
    public boolean modifyAccount(int accountNumber, String accountName) {
        for(int i=0; i<accountList.size(); i++ ) {
            if(accountList.get(i).getAccountNumber() == accountNumber) {
                accountList.get(i).setAccountName(accountName);
                return true;
            }
        }
        return false;
    }
    public boolean modifyAccount(int accountNumber, double accountBalance) {
        for(int i=0; i<accountList.size(); i++ ) {
            if(accountList.get(i).getAccountNumber() == accountNumber) {
                accountList.get(i).setAccountBalance(accountBalance);
                return true;
            }
        }
        return false;
    }

    public boolean modifyAccount(int accountNumber, String accountName, double accountBalance) {
        for(int i=0; i<accountList.size(); i++ ) {
            if(accountList.get(i).getAccountNumber() == accountNumber) {
                accountList.get(i).setAccountName(accountName);
                accountList.get(i).setAccountBalance(accountBalance);
                return true;
            }
        }
        return false;
    }

    public boolean modifyAccount(byte index, String accountName) {
        for(int i=0; i<accountList.size(); i++) {
            if(i == index) {
                accountList.get(i).setAccountName(accountName);
                return true;
            }
        }
        return false;
    }

    public boolean modifyAccount(byte index, double accountBalance) {
        for(int i=0; i<accountList.size(); i++) {
            if(i == index) {
                accountList.get(i).setAccountBalance(accountBalance);
                return true;
            }
        }
        return false;
    }
    public boolean modifyAccount(byte index, String accountName, double accountBalance) {
        for(int i=0; i<accountList.size(); i++) {
            if(i == index) {
                accountList.get(i).setAccountName(accountName);
                accountList.get(i).setAccountBalance(accountBalance);
                return true;
            }
        }
        return false;
    }

    // DeleteAccount method x 2
    public boolean deleteAccount(int accountNumber) {
        for(int i=0; i<accountList.size(); i++) {
            if(accountList.get(i).getAccountNumber() == accountNumber) {
                accountList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean deleteAccount(byte index) {
        for(int i=0; i<accountList.size(); i++) {
            if(i == index) {
                accountList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", branchLocation='" + branchLocation + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
