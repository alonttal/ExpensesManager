package core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

public class ExpenseListTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private ExpenseList expenses;

    @Mock
    private Expense expense1;
    @Mock
    private Expense expense2;
    @Mock
    private Expense expense3;

    @Before
    public void init() {
        expenses = new ExpenseList();

        Mockito.when(expense1.getAmount()).thenReturn(1);
        Mockito.when(expense2.getAmount()).thenReturn(2);
        Mockito.when(expense3.getAmount()).thenReturn(3);
    }

    @Test
    public void shouldBeEmptyOnCreation() {
        Assert.assertTrue(expenses.isEmpty());
    }

    @Test
    public void canAddExpense() {
        expenses.add(expense1);
        Assert.assertFalse(expenses.isEmpty());
    }

    @Test
    public void shouldHaveZeroExpenseAmountWhenNoExpenses() {
        Assert.assertEquals(0, expenses.getTotalExpenseAmount());
    }

    @Test
    public void shouldCalculateExpenseAmountForOneExpense() {
        expenses.add(expense1);
        Assert.assertEquals(1, expenses.getTotalExpenseAmount());
    }

    @Test
    public void shouldCalculateExpenseAmountForMultipleExpenses() {
        expenses.add(expense1);
        expenses.add(expense2);
        expenses.add(expense3);
        Assert.assertEquals(6, expenses.getTotalExpenseAmount());
    }

    @Test
    public void canIterateOverExpensesWithForEach() {
        expenses.add(expense1);
        expenses.add(expense2);
        expenses.add(expense3);
        List<Expense> expectedExpenses = Arrays.asList(expense1, expense2, expense3);
        for (Expense e : expenses) {
            Assert.assertTrue(expectedExpenses.contains(e));
        }
    }

    @Test
    public void shouldContainAllAddedExpenses() {
        expenses.add(expense1);
        expenses.add(expense2);
        expenses.add(expense3);
        Assert.assertTrue(expenses.contains(expense1));
        Assert.assertTrue(expenses.contains(expense2));
        Assert.assertTrue(expenses.contains(expense3));
    }

    @Test
    public void shouldNotContainExpensesIfEmpty() {
        Assert.assertFalse(expenses.contains(expense1));
        Assert.assertFalse(expenses.contains(expense2));
        Assert.assertFalse(expenses.contains(expense3));
    }

    @Test
    public void shouldNotContainNotAddedExpenses() {
        expenses.add(expense1);
        Assert.assertTrue(expenses.contains(expense1));
        Assert.assertFalse(expenses.contains(expense2));
        Assert.assertFalse(expenses.contains(expense3));
    }

    @Test
    public void shouldHaveZeroSizeOnCreation() {
        Assert.assertEquals(0, expenses.size());
    }

    @Test
    public void shouldHaveSizeOfOneWhenAddingOneExpense() {
        expenses.add(expense1);
        Assert.assertEquals(1, expenses.size());
    }

    @Test
    public void shouldHaveSizeOfThreeWhenAddingThreeExpenses() {
        expenses.add(expense1);
        expenses.add(expense2);
        expenses.add(expense3);
        Assert.assertEquals(3, expenses.size());
    }
}
