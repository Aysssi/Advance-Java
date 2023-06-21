package P03BankAccountLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer,BankAccount> allAccountsMap = new HashMap<>();


        String [] inputArr = scanner.nextLine().split(" ");
        String command =  inputArr[0];
        while (!command.equals("End")){
            String output = null;
            switch (command){
                case "Create":
                    BankAccount account = new BankAccount();
                    allAccountsMap.put(account.getId(), account);;
                    output = String.format("Account ID%d created", account.getId());
                    break;
                case "Deposit":
                    int accountId = Integer.parseInt(inputArr[1]);
                    double amount = Double.parseDouble(inputArr[2]);
                   BankAccount current = allAccountsMap.get(accountId);
                  if (current == null) {
                      System.out.println("Account does not exist");
                  }else {
                      current.deposit(amount);
                      allAccountsMap.put(accountId,current);
                      output = String.format("Deposited %.0f to ID%d", amount,accountId);
                  }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(inputArr[1]);
                    BankAccount.setInterestRate(interest);

                    break;
                case"GetInterest":
                    int id = Integer.parseInt(inputArr[1]);
                    int numbersOfYears = Integer.parseInt(inputArr[2]);

                    BankAccount inputCurrent = allAccountsMap.get(id);
                    if (inputCurrent == null) {
                        System.out.println("Account does not exist");
                    }else {
                     output = (String.format("%.2f",inputCurrent.getProfitAfterYears(numbersOfYears)));
                        allAccountsMap.put(id,inputCurrent);
                    }

                    break;
                }
                if (output != null){
               System.out.println(output);
                }



            inputArr = (scanner.nextLine().split(" "));
            command = inputArr[0];
        }
    }

}


