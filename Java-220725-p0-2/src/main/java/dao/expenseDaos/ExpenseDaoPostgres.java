package dao.expenseDaos;

import entities.expenses.Expense;
import entities.expenses.Status;
import utils.ConnectUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoPostgres implements ExpenseDAO{

    private int idMaker = 1000;
    @Override
    public int createExpense(Expense expense) {
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "insert into expenses values (?,?,?,?,default)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idMaker);
            idMaker ++;
            ps.setObject(2,expense.getExpenseType(), Types.OTHER);
            ps.setInt(3, expense.getEmployeeID());
            ps.setDouble(4,expense.getExpenseAmount());

            ps.execute();

            return 1;

    } catch (SQLException e){
            e.printStackTrace();
        }

        return 2;
    }

    @Override
    public List<Expense> getAllExpenses() {
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "select * from expenses";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Expense> expenseList = new ArrayList<>();

            while (rs.next()) {
                Expense expense = new Expense();
                expense.setExpenseID(rs.getInt("expense_id"));
                expense.setExpenseType(rs.getString("expense_type"));
                expense.setEmployeeID(rs.getInt("employee_id"));
                expense.setExpenseAmount(rs.getDouble("amount"));
                expense.setExpenseStatus(rs.getString("Status"));
                expenseList.add(expense);
            }

            return expenseList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }
    @Override
    public List<Expense> getExpensesByEmployee(int id) {
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "select * from expenses where employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            List<Expense> expenseList = new ArrayList<>();

            while (rs.next()) {
                Expense expense = new Expense();
                expense.setExpenseID(rs.getInt("expense_id"));
                expense.setExpenseType(rs.getString("expense_type"));
                expense.setEmployeeID(rs.getInt("employee_id"));
                expense.setExpenseAmount(rs.getDouble("amount"));
                expense.setExpenseStatus(rs.getString("Status"));
                expenseList.add(expense);
            }

            return expenseList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Expense getExpenseById(int id) {
        Expense expense = new Expense();
        expense.setExpenseID(0);

        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "select * from expenses where expense_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                expense.setExpenseID(rs.getInt("expense_id"));
                expense.setExpenseType(rs.getString("expense_type"));
                expense.setEmployeeID(rs.getInt("employee_id"));
                expense.setExpenseAmount(rs.getDouble("amount"));
                expense.setExpenseStatus(rs.getString("status"));
                return expense;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return expense;
    }

    @Override
    public int updateExpense(Expense expense) {
         try (Connection conn = ConnectUtil.getConnection()) {

             if (expense.getExpenseStatus() == Status.PENDING) {
                 String sql = "update expenses set expense_type = ?, amount = ? where expense_id = ?";
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ps.setObject(1, expense.getExpenseType(), Types.OTHER);
                 ps.setDouble(2, expense.getExpenseAmount());
                 ps.setInt(3, expense.getExpenseID());

                 ps.execute();
             } else {
                 String sql = "update expenses set status = ? where expense_id = ?";
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ps.setObject(1, expense.getExpenseStatus(), Types.OTHER);
                 ps.setInt(2, expense.getExpenseID());

                 ps.execute();
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }
         return 2;
    }

    @Override
    public int deleteExpense(int id) {
         try (Connection conn = ConnectUtil.getConnection()) {
         String sql = "delete from expenses where expense_id = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1, id);

         ps.execute();

         } catch (SQLException e) {
             e.printStackTrace();
         }
         return 2;
    }
}