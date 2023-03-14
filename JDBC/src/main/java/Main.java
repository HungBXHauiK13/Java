import dao.PersonDAO;
import model.Person;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        List<Person> list = personDAO.getAll();
        System.out.println(list);

//        Person person = new Person();
//        person.setName("Lê Minh Trung");
//        person.setAddress("Thanh Hóa");
//        person.setPhone("0867354834");
//        person.setEmail("trung@gmail.com");
//        personDAO.insert(person);
//        System.out.println(list);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id cần tìm");
        long id = sc.nextInt();
        personDAO.getById(id);
    }
}
