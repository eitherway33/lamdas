package salvador.lamdas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

   //MÉTODO QUE OBTIENE LOS NOMBRES DE LOS PRODUCTOS 
   public List<String> nomProduct()
   {
    List<Product> listName =Util.getProducts(); 
    Stream<String> stream = listName.stream().map(Product::getName);  
    return stream.collect(Collectors.toList());
   } 

   //MUESTRA LOS NOMBRES DEL PRODUCTO QUE TENGAN UNA EXISTENCIA MENOR A 10 EN EL ALMACEN 

   public List<String> existMenor10()
   {
       List<Product> listProd = Util.getProducts(); 
       Stream<String> stream = listProd.stream().filter(p->p.getUnitInStock()<10).map(Product::getName); 
       return stream.collect(Collectors.toList());
   }

   //OBTENER LA SUMA DEL PRECIO UNITARIO DE TODOS LOS PRODUCTOS AGRUPADOS POR EL NÚMERO DE EXISTENCIASEN EL ALMACÉN 

   public List<Product> sumaPrecUnitProd()
   {
       List<Product> products = Util.getProducts(); 
       Stream<Product> stream = products.stream(); 
       Map<Integer,Double> collect = products.stream().filter(p->p.getName().startsWith("L"))
         .collect(Collectors.groupingBy(Product::getUnitInStock, Collectors.summingDouble(Product::getUnitPrice))); 
         System.out.println("UnitStock"+" ; "+"Punitario");  
         collect.forEach((s,u)->System.out.println(s +";"+u));
        return stream.collect(Collectors.toList());

   }




   public static void main(String args[]) 
   {
       Main m = new Main(); 
      // m.nomProduct().forEach(x-> System.out.println(x)); 
      // m.existMenor10().forEach(p->System.out.println(p)); 
      m.sumaPrecUnitProd();
   } 

   
}