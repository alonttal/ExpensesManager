package view;

import core.Expense;
import core.ExpenseList;

import java.util.Scanner;

public class ConsoleView {
    ExpenseList expenseList = new ExpenseList();

    private void start() {
        System.out.println("Hi and welcome to expense manager console view");
        System.out.println("What do you want to do?");
        System.out.println("1. To add expense type: add expense [description] [amount]");
        System.out.println("2. To display all expenses type: display expenses");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String inputLine = scanner.nextLine().trim();
            if (inputLine.startsWith("add expense")) {
                String[] words = inputLine.split("\\s+");
                if (words.length < 3) {
                    System.out.println("You didn't give description and amount to the expense. core. Expense wasn't added");
                    continue;
                }
                if (words.length < 4) {
                    System.out.println("You didn't give an amount to the expense. core. Expense wasn't added");
                    continue;
                }
                int amount;
                try {
                    amount = Integer.parseInt(words[3]);
                } catch (NumberFormatException e) {
                    System.out.println("the amount given is '" + words[3] + "', which is not an integer value. Expense wasn't added");
                    continue;
                }
                Expense expense = new Expense();
                expense.setDescription(words[2]);
                expense.setAmount(amount);
                expenseList.add(expense);
                System.out.println("Expense Added");
            } else if (inputLine.equals("display expenses")) {
                System.out.println("Expenses:");
                System.out.println("=========");
                for (Expense e : expenseList) {
                    System.out.format("%s\t(%d)\n", e.getDescription(), e.getAmount());
                }
                System.out.println("=========");
                System.out.println("Total expenses: " + expenseList.size());
                System.out.println("Total amount: " + expenseList.getTotalExpenseAmount());
            } else {
                System.out.println("Incorrect command '" + inputLine + "', please try again");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        consoleView.start();
    }
}
