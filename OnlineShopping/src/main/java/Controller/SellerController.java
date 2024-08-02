package Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Category;
import Model.Product;
import Model.User;
import OnlineShopping.ProductRepo;
import OnlineShopping.UserRepo;
import OnlineShopping.catRepo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@CrossOrigin(value = "*")
public class SellerController 
{
	@Autowired
	ProductRepo productrepo;
	
	@Autowired
	UserRepo userepo;
	
	@Autowired
	catRepo catrepo;
	
   @PostMapping("AddProduct")
   public  Product AddProduct(@RequestBody Product product) 
   {
	   
	   Product addproduct = new Product();
	   addproduct.setProductName(product.getProductName());
	   addproduct.setCategory(product.getCategory());
	   addproduct.setDescription(product.getDescription());
	   addproduct.setSellerId(product.getSellerId());
	   
	   if(product.getDiscount()>0)
	   {
		      double price = (product.getDiscount() / 100) * product.getPrice();
		   	  addproduct.setPriceAfterDicount(product.getPrice()-price);
		   	 addproduct.setDiscount(product.getDiscount());
	   }
	   else
	   {
		      addproduct.setPriceAfterDicount(product.getPrice());
		      addproduct.setDiscount(product.getDiscount());
	   }
	   
	   addproduct.setPrice(product.getPrice());
	   addproduct.setDate(new Date());
	   addproduct.setproductCount(product.getproductCount());
	   
	   return productrepo.save(addproduct);
       
    }
   
   @GetMapping("getAllproduct/{sellerID}")
   public List<Product> getAllproduct(@PathVariable int sellerID) 
   {
	  return productrepo.findAllBysellerId(sellerID);
       
   }
   
   @GetMapping("getSelerName/{id}")
   public String[] getSelerName(@PathVariable int id)
   {
 	 User user =  userepo.findById(id).get();
 	 System.out.print(user.getName());
 	   String sa []= {user.getName()};
       return  sa;
   }
   
   @GetMapping("getCategories")
   public List<Category> getCategories() 
   {
	   
       return catrepo.findAll();
   }
   
   @DeleteMapping("deleteProduct/{id}")
   public void deleteProduct(@PathVariable int id)
   {
	   Product product = productrepo.findById(id).get();
	   product.setAvalibility(false);
	   product.setproductCount(0);
	   //productrepo.deleteById(id);
	   productrepo.save(product);
   }
   
   @GetMapping("ProductWithLowStock/{id}")
   public List<Product> ProductWithLowStock(@PathVariable int id) 
   {
	   
       return productrepo.findProductsBySellerWithLowStock(id);
   }
   @PutMapping("updateProduct/{id}")
   public Product updateProduct(@PathVariable int id, @RequestBody Product product) 
   {
       // Check if the product exists
      
           // Fetch the existing product
           Product existingProduct = productrepo.findById(id).get();
           
           // Update the existing product's details
           existingProduct.setProductName(product.getProductName());
           existingProduct.setCategory(product.getCategory());
           existingProduct.setDescription(product.getDescription());
           existingProduct.setSellerId(product.getSellerId());
           
           if(product.getDiscount() > 0)
           {
               double price = (product.getDiscount() / 100) * product.getPrice();
               existingProduct.setPriceAfterDicount(product.getPrice() - price);
               existingProduct.setDiscount(product.getDiscount());
           }
           else
           {
               existingProduct.setPriceAfterDicount(product.getPrice());
               existingProduct.setDiscount(product.getDiscount());
           }
           
           existingProduct.setPrice(product.getPrice());
           existingProduct.setproductCount(product.getproductCount());
           
           // Save the updated product
           return productrepo.save(existingProduct);
       
       
   }
   
}
