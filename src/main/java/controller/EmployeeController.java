package controller;

import entity.Employee;
import model.EmployeeModel;

import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeController {
    Scanner sc = new Scanner(System.in);
    EmployeeModel model = new EmployeeModel();

    public void doRegister() {
        System.out.println("------ Trang đăng ký -------");
        System.out.println("------ ************* -------\n");
        while (true) {
            System.out.println("Nhập họ và tên: ");
            String fullName = sc.nextLine();
            System.out.println("Đại chỉ:");
            String address = sc.nextLine();
            System.out.println("Email:");
            String email = sc.nextLine();
            System.out.println("Tên tài khoản: ");
            String account = sc.nextLine();
            System.out.println("Mật khẩu: ");
            String password = sc.nextLine();

            Employee emp = new Employee(fullName, address, email, account, password);

            if (!model.checkExistAccount(emp.getAccount())) {
                boolean registerSuccess = model.register(emp);
                if (!registerSuccess) {
                    System.out.println("Đã có lỗi xảy ra, vui lòng thử lại!");
                } else {
                    System.out.println("Đăng ký thành công!");
                    return;
                }
            }


            System.err.println("Tên tài khảon đã tồn tại, vui lòng nhập lại!");
            sc.nextLine();
        }
    }

    public void doLogin(){
        System.out.println("------ Trang đăng nhập -------");
        System.out.println("------ *************** -------");
        System.out.println("Tên đăng nhập:");
        String account = sc.nextLine();
        System.out.println("Mật khẩu: ");
        String password = sc.nextLine();
        Employee emp = model.login(account, password);
        if (emp == null){
            System.out.println("Tên tài khoản hoặc mật khẩu không đúng!");
            return;
        }else{
            System.out.printf("%35s | %15s | %15s | %15s\n", "Mã", "Tên", "Địa chỉ", "Tên tài khoản");
                System.out.printf("%34s | %14s | %15s | %14s\n",
                        emp.getId(), emp.getFullName(), emp.getAddress(), emp.getAccount());
//            System.out.println(emp.toString());
        }


    }
}
