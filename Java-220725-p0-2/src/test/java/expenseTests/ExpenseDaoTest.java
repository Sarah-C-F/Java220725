package expenseTests;

import dao.expenseDaos.ExpenseDAO;
import dao.expenseDaos.ExpenseDaoPostgres;
import entities.expenses.Expense;
import entities.expenses.ExpenseType;
import entities.expenses.Status;
import org.junit.jupiter.api.*;
import utils.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static entities.expenses.ExpenseType.TRAVEL;
import static entities.expenses.Status.PENDING;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExpenseDaoTest {
    ExpenseDAO expenseDAO = new ExpenseDaoPostgres();

    @BeforeAll
    static void connect() {
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "drop table \"expenses\";\n" +
                    "\n" + "delete from \"employees\";\n" +
                    "create table \"expenses\" \n" +
                    "(\n" +
                    "\"expense_id\" int not null primary key,\n" +
                    "\"expense_type\" expense_type,\n" +
                    "\"employee_id\" int references employees(employee_id),\n" +
                    "\"amount\" numeric(50, 2),\n" +
                    "\"status\" status default 'PENDING'\n" +
                    ");INSERT INTO \"employees\" (\"employee_id\", \"firstname\", \"lastname\" ) VALUES (100, N'Adams', N'Andrew');";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void create_expense_test_standard () {
        Expense testExpense = new Expense(1000, "TRAVEL", 100, 1259.26);
        int result = expenseDAO.createExpense(testExpense);

        Assertions.assertEquals(1, result);
    }

    @Test
    @Order(2)
    void get_all_expenses_test_standard() {
        List<Expense> testList;
        testList = expenseDAO.getAllExpenses();

        Assertions.assertEquals(1, testList.size());

    }

    @Test
    @Order(3)
    void get_expense_by_id_standard () {
        int testId = 1000;
        Expense testExpense = expenseDAO.getExpenseById(testId);

        Assertions.assertEquals(100, testExpense.getEmployeeID());
    }

    @Test
    @Order(4)
    void update_expense_test_standard () {
        Expense test = new Expense(1000, "TRAVEL", 127, 129.82, "PENDING");
        int testExpense =expenseDAO.updateExpense(test);

        Assertions.assertEquals(2, testExpense);
    }

    @Test
    @Order(5)
    void delete_expense_test_standard () {
        int result = expenseDAO.deleteExpense(1000);

        Assertions.assertEquals(2,result);
    }


}
