package model;

import entity.Employee;
import utility.SqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {
    Connection cnn = null;

    SqlQuery sql = new SqlQuery();

    public void initConnection(){
        ConnectionDb Db = new ConnectionDb();
        try {
            if (cnn == null || cnn.isClosed()){

                cnn = Db.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean register(Employee emp){
        initConnection();
        try {
            PreparedStatement stt = cnn.prepareStatement(sql.empInsert);
            stt.setString(1, emp.getId());
            stt.setString(2, emp.getFullName());
            stt.setString(3, emp.getAddress());
            stt.setString(4, emp.getEmail());
            stt.setString(5, emp.getAccount());
            stt.setString(6, emp.getPassword());
            stt.setLong(7, emp.getCreated_at());
            stt.setLong(8, emp.getUpdated_at());
            stt.setInt(9, emp.getStatus());
            stt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkExistAccount(String account){
        initConnection();
        try {
            PreparedStatement stt = cnn.prepareStatement(sql.empGetAccount);
            stt.setString(1, account);
            ResultSet rs = stt.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employee login(String account, String password){
        initConnection();
        try {
            PreparedStatement stt = cnn.prepareStatement(sql.empGetAccountAndPassword);
            stt.setString(1, account);
            stt.setString(2, password);
            ResultSet rs = stt.executeQuery();
            if (rs.next()) return new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getLong(7),
                    rs.getLong(8), rs.getInt(9));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
