import java.util.ArrayList;
import java.util.List;

public class ExpenseList {
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
}
