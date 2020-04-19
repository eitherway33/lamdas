package salvador.lamdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util { 

    public static List<Product> getProducts()
    {  
        //Cargar el archivo ubicado en la carpeta resource 
        ClassLoader classloader = Util.class.getClassLoader();
        Scanner cs = new Scanner(classloader.getResourceAsStream("products.csv")); 

        cs.nextLine(); //Comenzar a leeer desde la segunda linea
        cs.useDelimiter(","); 

        List<Product> products = new ArrayList<>(); 

        while (cs.hasNextLine())
        {
           Product prod = new Product();
           prod.setId(cs.nextInt());
           prod.setName(cs.next());  
           prod.setSupplier(cs.nextInt());  
           prod.setCategory(cs.nextInt());
           cs.next(); 
           prod.setUnitPrice(cs.nextDouble()); 
           prod.setUnitInStock(cs.nextInt()); 

           products.add(prod);
           cs.nextLine();
        } 
        cs.close();
        return  products;
    }

}