package Services;

import Models.Products;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProductService {
    public static void display(){
        System.out.println("----------------------------------Danh sách sản phẩm----------------------------------");
        String header = String.format("%s%20s%20s%15s%20s", "Mã", "Tên sản phẩm", "Số lượng", "Giá tiền", "Mô tả");
        System.out.println(header);
        for (Products item : Main.PRODUCTS) {
            String row = String.format("%d%20s%20d%15d%20s", item.getProductID(), item.getProductName(), item.getQuantity(), item.getPrice(), item.getDescription());
            System.out.println(row);
        }
    }
    public static void insert(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin sản phẩm:");

        try{
            System.out.print("Mã sản phẩm: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Tên sản phẩm: ");
            String name = scanner.nextLine();

            System.out.print("Số lượng: ");
            Integer quantity = scanner.nextInt();

            System.out.print("Giá tiền: ");
            Integer price = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Mô tả: ");
            String description = scanner.nextLine();

            Products product = new Products(id ,name, quantity, price, description);
            Main.PRODUCTS.add(product);

        } catch (InputMismatchException e) {
            System.out.println("Nhập sai giá trị, vui lòng nhập lại");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static void update(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Nhập mã của sản phẩm: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            Products product = null;

            for (Products item : Main.PRODUCTS) {
                if (item.getProductID().equals(id)){
                    product = item;
                    break;
                }
            }

            if (product == null){
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
            }

            //Nhập thông tin mới cho sản phẩm
            for (int i = 0; i < Main.PRODUCTS.size(); i++) {
                if (id.equals(Main.PRODUCTS.get(i).getProductID())){
                    System.out.println("Mã sản phẩm:");
                    Integer productID = Integer.parseInt(scanner.nextLine());

                    System.out.print("Tên sản phẩm: ");
                    String name = scanner.nextLine();

                    System.out.print("Số lượng: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Giá tiền: ");
                    int price = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Mô tả: ");
                    String description = scanner.nextLine();

                    Main.PRODUCTS.get(i).setProductID(productID);
                    Main.PRODUCTS.get(i).setProductName(name);
                    Main.PRODUCTS.get(i).setQuantity(quantity);
                    Main.PRODUCTS.get(i).setPrice(price);
                    Main.PRODUCTS.get(i).setDescription(description);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Nhập sai giá trị, vui lòng nhập lại");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static void remove(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Nhập mã của sản phẩm cần xóa: ");
            Integer id = Integer.parseInt(scanner.nextLine());

            Products product = null;

            for (Products item : Main.PRODUCTS) {
                if (item.getProductID().equals(id)){
                    product = item;
                    break;
                }
            }

            if (product == null){
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
            }

            //Duyệt ds và xóa
            String yes;
            System.out.println("Nhập 'Y' để xác nhận xóa sản phẩm hoặc một phím bất kì để thoát");
            yes = scanner.nextLine();
            if (Objects.equals(yes, "Y")){
                for (Products item : Main.PRODUCTS) {
                    if (item.getProductID().equals(id)){
                        Main.PRODUCTS.remove(product);
                        break;
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Nhập sai giá trị, vui lòng nhập lại");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static Products findProductFromPriceMax(List<Products> PRODUCTS){
        Products maxPriceProduct = PRODUCTS.get(0);
        for (Products item : PRODUCTS) {
            if (item.getPrice() > maxPriceProduct.getPrice()){
                maxPriceProduct = item;
            }
        }
        return maxPriceProduct;
    }

}
