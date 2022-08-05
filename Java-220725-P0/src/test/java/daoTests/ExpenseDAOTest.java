//package daoTests;
//
//import dao.expenseDaos.ExpenseDAO;
//import dao.expenseDaos.ExpenseDaoLocal;
//import entities.employees.Employee;
//import entities.employees.EmployeeType;
//import entities.expenses.Expense;
//import entities.expenses.ExpenseType;
//import entities.expenses.Status;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class ExpenseDAOTest {
//
//    static ExpenseDAO expenseDAO = new ExpenseDaoLocal();
//
//    //CREATE
//    @Test
//    void create_expense_empID_1_test() {
//        Employee testEmployee = new Employee(0, EmployeeType.ASSOCIATE.name(), "Sarah", "Farrens");
//        Expense expense = new Expense(0, ExpenseType.CERTIFICATION,0 , 20.00);
//        int check = expenseDAO.createExpense(expense);
//
//        Assertions.assertEquals(1, check);
//    }
//
//    @Test
//    void create_expense_employee_id_0_test() {
//        Employee testEmployee = new Employee(0, EmployeeType.ASSOCIATE, "Sarah", "Farrens");
//        Expense expense = new Expense(0, ExpenseType.MEALS, 2,20.00);
//        int check = expenseDAO.createExpense(expense);
//
//        Assertions.assertEquals(1, check);
//    }
//
//    @Test
//    void create_expense_employee_id_not_found_test() {
//        Employee testEmployee = new Employee(0, EmployeeType.ASSOCIATE, "Sarah", "Farrens");
//
//    }
//
//
//}
