import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpenseTest {

    private Expense expense;
    
    @Before
    public void init() {
         expense = new Expense();
    }

    @Test
    public void shouldCreateExpenseWithAmount() {
        expense.setAmount(5);
        Assert.assertEquals(5, expense.getAmount());
    }

    @Test
    public void canChangeExpenseAmount() {
        expense.setAmount(5);
        expense.setAmount(6);
        Assert.assertEquals(6, expense.getAmount());
    }

    @Test
    public void shouldCreateExpenseWithDescription() {
        expense.setDescription("expense 1");
        Assert.assertEquals("expense 1", expense.getDescription());
    }

    @Test
    public void canChangeExpenseDescription() {
        expense.setDescription("expense 1");
        expense.setDescription("expense 1 changed");
        Assert.assertEquals("expense 1 changed", expense.getDescription());
    }
}
