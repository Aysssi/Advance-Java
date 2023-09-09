import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {;
        return this.products.contains(product);


    }

    @Override
    public void add(Product product) {
    this.products.add(product);
    }

    @Override
    public void changeQuantity(String label, int quantity) {
    Product product = this.findByLabel(label);

    int newQuantity = product.getQuantity() + quantity;
    product.setQuantity(newQuantity);


    // 1v:      int i = this.products.indexOf(new Product(product,1,1));
//         if (i == -1){
//             throw new IllegalArgumentException();
//         }
//
//         int currentQuantity = this.products.get(i).getQuantity();
//
//         this.products.get(i).setQuantity(currentQuantity + quantity);


    // 2v :      this.products.replaceAll(p -> {
//            if (p.getLabel().equals(product)){
//                int newQuantity = p.getQuantity() + quantity;
//              p.setQuantity(newQuantity);
//            }
//            return p;
//        });
    }

    /**
     *
     * @param index
     * @return
     */

    @Override
    public Product find(int index) {
        return this.products.get(index -1);
    }

    @Override
    public Product findByLabel(String label) {

    return this.products
                .stream()
                .filter(p -> p.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException ::new);

    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
      ArrayList<Product> result  = new ArrayList<>();


      //if  (!(count <= 0 || count > this.getCount()))
      if (count > 0 || count <= this.getCount()){
          this.products
                  .stream()
                  .sorted((f,s) -> f.compareTo(s))
                  .limit(count)
                  .forEach(e -> result.add(e));
      }
      return result;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
     return   this.products
               .stream()
               .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
               .sorted((f,s)-> Double.compare(s.getPrice(),f.getPrice()))
               .collect(Collectors.toList());

    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
       return this.findAllInRange(price - 0.000001,price );
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }
}
