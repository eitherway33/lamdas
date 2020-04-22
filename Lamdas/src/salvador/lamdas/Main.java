package salvador.lamdas;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


//MÉTODO QUE OBTIENE LOS NOMBRES DE LOS PRODUCTOS 
   public List<String> nomProduct()
   {
       final List<Product> listName = Util.getProducts();
       final Stream<String> stream = listName.stream().map(Product::getName);
       return stream.collect(Collectors.toList());
   }

   // MUESTRA LOS NOMBRES DEL PRODUCTO QUE TENGAN UNA EXISTENCIA MENOR A 10 EN EL
   // ALMACEN

   public List<String> existMenor10() {
       final List<Product> listProd = Util.getProducts();
       final Stream<String> stream = listProd.stream().filter(p -> p.getUnitInStock() < 10).map(Product::getName);
       return stream.collect(Collectors.toList());
   }

   // OBTENER LA SUMA DEL PRECIO UNITARIO DE TODOS LOS PRODUCTOS AGRUPADOS POR EL
   // NÚMERO DE EXISTENCIASEN EL ALMACÉN

   public List<Product> sumaPrecUnitProd() {
       final List<Product> products = Util.getProducts();
       final Stream<Product> stream = products.stream();
       final Map<Integer, Double> collect = products.stream().filter(p -> p.getName().startsWith("L")).collect(
               Collectors.groupingBy(Product::getUnitInStock, Collectors.summingDouble(Product::getUnitPrice)));
       System.out.println("UnitStock" + " ; " + "Punitario");
       collect.forEach((s, u) -> System.out.println(s + ";" + u));
       return stream.collect(Collectors.toList());

   }

   // MUESTRA LOS NOMBRES DE PRODUCTOS QUE TENGAN UNA EXISTENCIA MENOR a 10
   // UNIDADES ORD ASC EN EL ALMACEN
   public List<String> existMenor10OrdAsc() {
       final List<Product> products = Util.getProducts();
       final Stream<String> streams = products.stream().filter(p -> p.getUnitInStock() < 10)
               .sorted(Comparator.comparingDouble(Product::getUnitInStock)).map(Product::getName);
       return streams.collect(Collectors.toList());
   }

   // OBTENER LA SUMA DEL PRECIO UNITARIO DE LOS PROD, SOLO DONDE LA SUMA DE LOS
   // REGISTROS SEA >100 
   public List<Product> havingJava() {
       final List<Product> products = Util.getProducts();
       final Stream<Product> streams = products.stream();
       final List<Map.Entry<String, Double>> imprimir= products.stream() //NECESARIO PARA PODER HACER LA IMPRESION
               .collect(Collectors.groupingBy(Product::getName, Collectors.summingDouble(Product::getUnitPrice)))
               .entrySet().stream().filter(p -> p.getValue() > 100) // filtramos simula el having
               .collect(Collectors.toList());          
               imprimir.forEach(list -> System.out.printf("en stock: %s, suma: %s\n",list.getKey(), list.getValue()));

               return streams.collect(Collectors.toList());
               
              
   }

   public static void main(final String args[]) {
       final Main m = new Main();
      // m.nomProduct().forEach(x-> System.out.println(x)); 
      // m.existMenor10().forEach(p->System.out.println(p)); 
      //m.sumaPrecUnitProd();
      m.havingJava();
   } 

   
}