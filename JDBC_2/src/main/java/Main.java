import Employees.Employees;
import EmployeesDAO.employeesDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("======================== Quản lý nhân sự ======================");
        System.out.println("----------- 1.Thêm nhân viên                  ----");
        System.out.println("----------- 2.Danh sách nhân viên             ----");
        System.out.println("----------- 3.Tìm kiếm nhân viên theo tên     ----");
        System.out.println("---------- 4.Cập nhật thông tin nhân viên    ----");
        System.out.println("----------- 5.Xoá nhân viên theo mã           ----");
        System.out.println("-------- 6.Lọc ra top 5 lương cao nhất     ----");
        System.out.println("-------- 7.In ra trung bình mức lương của nhân viên nữ     ----");
        System.out.println("-------- 8.Exit                ----");
        System.out.println("===============================================");
    }
    public static void main(String[] args) {
        employeesDAO eDAO = new employeesDAO();
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        do {
            menu();
            System.out.println("nhập lựa chọn: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception e) {
                System.out.println("Nhập sai định dạng");
                continue;
            }

            if (option < 0 || option > 8) {
                System.out.println("Xin mời nhập lại");
                continue;
            }
            switch (option) {
                case 1:
                    System.out.println("--- Thêm nhân viên ---");
                    Employees e = new Employees();

                    System.out.println("Nhập tên nhân viên: ");
                    String fn = scanner.nextLine();

                    System.out.println("Nhập địa chỉ nhân viên: ");
                    String add = scanner.nextLine();

                    System.out.println("Nhập email nhân viên: ");
                    String email = scanner.nextLine();

                    System.out.println("Nhập sdt nhân viên: ");
                    String sdt = scanner.nextLine();

                    System.out.println("Nhập giới tính nhân viên: ");
                    int gd = scanner.nextInt();

                    System.out.println("Nhập lương nhân viên: ");
                    int sa = scanner.nextInt();
                    e.setFull_name(fn);
                    e.setCity(add);
                    e.setEmail(email);
                    e.setPhone(sdt);
                    e.setGender(gd);
                    e.setSalary(sa);
                    eDAO.insertNewE(e);
                case 2:
                    eDAO.getEmployees();
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
            }

        } while (option != 7);
        //Employees employee1 = new Employees(1,"Bùi Xuân Hưng","Hải Dương","Hung@gmail.com","0923072891",1,12600000);
        //eDAO.insertNewE(employee1);
        System.out.println(eDAO);
    }
}
