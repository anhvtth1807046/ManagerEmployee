package view;

import controller.EmployeeController;

import java.util.Scanner;

public class EmployeeMenu {
    Scanner sc = new Scanner(System.in);
    EmployeeController controller =  new EmployeeController();
    public void menu(){
        while (true){
            System.out.println("------------ Employees ------------");
            System.out.println("1. Đăng nhập ");
            System.out.println("2. Đăng ký ");
            System.out.println("3. Thoát");
            System.out.println("------------- ******** ------------");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    controller.doLogin();
                    break;
                case 2:
                    controller.doRegister();
                    break;
                case 3:
                    System.out.println("Hẹn gặp lại bạn lần sau!!!!");
                    break;
                default:
                    System.out.println("Lựa chọn sai, vui lòng lựa chọn từ 1 đến 4...");
                    break;
            }
            if (choice == 3){
                System.exit(1);
            }
        }
    }
}
