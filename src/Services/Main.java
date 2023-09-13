package Services;


import Models.Products;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Products> PRODUCTS = new ArrayList<>();
    public static void menu(){
        System.out.println("----------------CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM-------------------");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào file");
        System.out.println("9. Thoát");
    }
    public static void main(String[] args) {
        int function = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            menu();
            try{
                System.out.print("Chọn chức năng: ");
                function = scanner.nextInt();
                switch (function){
                    case 1:
                        ProductService.display();
                        break;
                    case 2:
                        ProductService.insert();
                        break;
                    case 3:
                        ProductService.update();
                        break;
                    case 4:
                        ProductService.remove();
                        break;
//                    case 5:
//
//                        break;
                    case 6:
                        ProductService.findProductFromPriceMax(PRODUCTS);
                        break;
                    case 7:
                        FileManager.readFromFile();
                        break;
                    case 8:
                        FileManager.writeToFile(PRODUCTS);
                        break;

                }

            } catch (InputMismatchException err) {
                System.out.println("Nhập sai lựa chọn, vui lòng nhập lại");
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } while (function != 9);
        System.out.println("Exit");
    }
}