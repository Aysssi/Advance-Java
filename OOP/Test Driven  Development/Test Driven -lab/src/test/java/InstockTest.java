import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

 public class InstockTest {
 private final String DEFAULT_PRODUCT_LABEL = "Label";
 private final int DEFAULT_PRODUCT_QUANTITY = 200;
 private final double DEFAULT_PRODUCT_PRICE = 2.5;


  private final Product third = new Product(DEFAULT_PRODUCT_LABEL + "3" ,10,10);
  private   Product product;
  private   Product second;
  private Instock stock;


  @Before
    public void setup(){
      this.product = new Product(DEFAULT_PRODUCT_LABEL,DEFAULT_PRODUCT_PRICE,DEFAULT_PRODUCT_QUANTITY);
      this.second = new Product(DEFAULT_PRODUCT_LABEL + "2" ,20,10);
      this.stock = new Instock();
    }
    @Test
    public void TestShouldAddProduct(){

     this.stock.add(product);

    assertTrue(this.stock.contains(product));


    }
  @Test
  public void TestShouldHaveNonZeroCountAfterProductAdded(){

    this.stock.add(product);

    assertEquals(1, this.stock.getCount());


  }@Test
  public void TestShouldHaveCountEqualsToProductAdded(){

    extracted(product, product, product);

    assertEquals(3, this.stock.getCount());

  }
  @Test
public void TestShouldReturnFalseIfProductNotContained(){

  assertFalse( this.stock.contains(product));

}
@Test
  public void TestContainsShouldReturnTrueIfProductLabelsMatch(){
    this.second.setLabel(DEFAULT_PRODUCT_LABEL);
    this.stock.add( this.second);
    assertTrue( this.stock.contains(product));

  }
  @Test
  public void TestShouldReturnCorrectProductByInsertionOrder(){
    this.stock.add(product);

    Product actual = this.stock.find(1);
    assertEquals(product,actual);

  }
  @Test
  public void TestShouldReturnCorrectProductByInsertionOrderWhenSingleProduct(){
    this.stock.add(product);

    Product actual = this.stock.find(1);
    assertEquals(product,actual);

  }
  @Test
  public void TestShouldReturnCorrectProductByInsertionOrderWhenMultipleProduct(){

    extracted(product, second, third);

    Product actual = this.stock.find(3);
    assertEquals(third,actual);

  }
  @Test (expected = IndexOutOfBoundsException.class)
  public void TestShouldThrowExceptionWhenFindCalledWithInvalidIndex(){

    this.stock.find(1);

  }
  @Test
  public void TestShouldAddQuantityToExistingProduct(){

   this.stock.add(product);

   this.stock.changeQuantity(product.getLabel(),DEFAULT_PRODUCT_QUANTITY);
   Product actual = this.stock.find(1);

  assertEquals(2 * DEFAULT_PRODUCT_QUANTITY, actual.getQuantity());
  }
  @Test
  public void TestShouldAddQuantityToExistingProductMultipleTime(){

    this.stock.add(product);

    this.stock.changeQuantity(product.getLabel(),DEFAULT_PRODUCT_QUANTITY);
    this.stock.changeQuantity(product.getLabel(),DEFAULT_PRODUCT_QUANTITY);
    this.stock.changeQuantity(product.getLabel(),DEFAULT_PRODUCT_QUANTITY);

    Product actual = this.stock.find(1);

    assertEquals(4 * DEFAULT_PRODUCT_QUANTITY, actual.getQuantity());
  }
  @Test(expected = IllegalArgumentException.class)
  public void TestShouldThrowExceptionIfProductDoesNotExist(){

    this.stock.changeQuantity(product.getLabel(),DEFAULT_PRODUCT_QUANTITY);

  }

  @Test
  public void TestFindByLabelShouldReturnProduct(){
    this.stock.add(product);
    Product actual = this.stock.findByLabel(product.getLabel());

    assertEquals(product,actual);
  }

  @Test
  public void TestFindByLabelShouldReturnCorrectResultForMultipleProducts(){

    extracted(product, second, third);

    Product actual = this.stock.findByLabel(DEFAULT_PRODUCT_LABEL +"2");

    assertEquals(second,actual);

  }
  @Test(expected = IllegalArgumentException.class)
  public void TestFindByLabelShouldThrowExceptionIfLabelProductDoesNotExist(){

    this.stock.findByLabel(product.getLabel());

  }
  @Test
  public void TestShouldReturnValidResultForZeroProductsInFindFirstByAlphabeticalOrder(){


    extracted(second, third, product);

    Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);

    assertFalse(actual.iterator().hasNext());

  }
  @Test
  public void TestShouldReturnValidResultForEmptyStockInFindFirstByAlphabeticalOrder(){

    Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);

    assertFalse(actual.iterator().hasNext());

  }
  @Test
  public void TestShouldReturnValidResultForNegativeCountEmptyStockInFindFirstByAlphabeticalOrder(){

    Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);

    assertFalse(actual.iterator().hasNext());

  }
  @Test
  public void TestShouldReturnValidResultForGreatCountFindFirstByAlphabeticalOrder(){


    extracted(second, third, product);

    Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(5);

     assertFalse(actual.iterator().hasNext());

  }
  @Test
  public void TestShouldValidResultForFindFirstByAlphabeticalOrder(){


    extracted(second, third, this.product);

    Product[] sorted = {this.product,second,third};

    Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(3);
    Iterator<Product> iterator = actual.iterator();

    assertTrue(actual.iterator().hasNext());
    int i = 0;
    while (iterator.hasNext()){
      assertEquals(sorted[i++],iterator.next());
    }

  }
  @Test
  public void TestFindAllInPriceRangeShouldReturnEmptyIterableForEmptyStock(){

    Iterable<Product> actual = this.stock.findAllInRange(5,15);

    assertFalse(actual.iterator().hasNext());

  }

  @Test
  public void TestFindAllInPriceRangeShouldReturnEmptyIterableIfNoneMatchesThePrice(){
    this.stock.add(this.product);

    Iterable<Product> actual = this.stock.findAllInRange(5,15);

    assertFalse(actual.iterator().hasNext());

  }

  @Test
  public void TestFindAllInPriceRangeShouldReturnEmptyIterableForNegativePrices(){
    this.stock.add(this.product);

    Iterable<Product> actual = this.stock.findAllInRange(-5,-15);

    assertFalse(actual.iterator().hasNext());

  }
  @Test
  public void TestFindAllInPriceRangeShouldReturnExactPriceForSameLowerUpperBound(){
    extracted(this.product, this.second, this.third);

    Iterable<Product> actual = this.stock.findAllInRange(DEFAULT_PRODUCT_PRICE -1,DEFAULT_PRODUCT_PRICE +1);

    Iterator<Product> iterator = actual.iterator();

    assertTrue(iterator.hasNext());
    assertEquals(product,iterator.next());
    assertFalse(iterator.hasNext());

  }

  private void extracted(Product product, Product second, Product third) {
    this.stock.add(product);
    this.stock.add(second);
    this.stock.add(third);
  }

  @Test
  public void TestFindAllInPriceRangeShouldReturnCorrectResult(){
    extracted(this.product, this.second, this.third);

    Iterable<Product> actual = this.stock.findAllInRange(DEFAULT_PRODUCT_PRICE -1,DEFAULT_PRODUCT_PRICE +1);

    Iterator<Product> iterator = actual.iterator();

    assertTrue(iterator.hasNext());
    assertEquals(product,iterator.next());
    assertFalse(iterator.hasNext());

  }
  @Test
  public void TestFindAllInPriceRangeShouldReturnCorrectResultForHigherBoundEdge (){
    extracted(this.product, this.second, this.third);

    Iterable<Product> actual = this.stock.findAllInRange(DEFAULT_PRODUCT_PRICE -1,DEFAULT_PRODUCT_PRICE );

    Iterator<Product> iterator = actual.iterator();

    assertTrue(iterator.hasNext());
    assertEquals(product,iterator.next());
    assertFalse(iterator.hasNext());

  }

  @Test
  public void TestFindAllByPriceRangeShouldReturnCorrectResult(){
    extracted(this.product, this.second, this.third);

    Iterable<Product> actual = this.stock
    .findAllByPrice(DEFAULT_PRODUCT_PRICE );

    Iterator<Product> iterator = actual.iterator();

    assertTrue(iterator.hasNext());
    assertEquals(product,iterator.next());
    assertFalse(iterator.hasNext());

  }
  @Test
  public void TestFindAllByPriceRangeShouldReturnEmptyForInvalidPrice(){
    extracted(this.product, this.second, this.third);

    Iterable<Product> actual = this.stock
            .findAllByPrice(0);

    assertFalse(actual.iterator().hasNext());

  }
}
