package utility;

public class SqlQuery {
    public String empInsert = "insert into employees (id, fullName, address, email, account, password, created_at, updated_at, status)" +
            " value (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public String empGetAccount = "select account from employees where account = ?";
    public String empGetAccountAndPassword = "select * from employees where account = ? and password = ?";
}