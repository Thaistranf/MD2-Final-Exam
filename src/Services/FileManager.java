package Services;

import Models.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void writeToFile(List<Products> PRODUCTS){
        try {
            FileWriter fileWriter = new FileWriter("data.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Products product : PRODUCTS) {
                bufferedWriter.write(product.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static List<Products> readFromFile(){
        List<Products> PRODUCTS = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true){
                line = bufferedReader.readLine();
                if (line == null){
                    break;
                }
                String txt[] = line.split(";");
                Integer id = Integer.parseInt(txt[0]);
                String name = txt[1];
                Integer quantity = Integer.parseInt(txt[2]);
                Integer price = Integer.parseInt(txt[3]);
                String description = txt[4];
                PRODUCTS.add(new Products(id, name, quantity, price, description));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return PRODUCTS;
    }
}
