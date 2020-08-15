package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExpenseList implements Iterable<Expense> {
    private List<Expense> list = new ArrayList<>();

    public void add(Expense expense) {
        list.add(expense);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getTotalExpenseAmount() {
        return list.stream()
                .mapToInt(Expense::getAmount)
                .sum();
    }

    @Override
    public Iterator<Expense> iterator() {
        return list.iterator();
    }

    public boolean contains(Expense e) {
        return list.contains(e);
    }

    public int size() {
        return list.size();
    }
}
