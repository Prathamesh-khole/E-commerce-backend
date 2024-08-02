package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Model.BuyerCart;
import Model.Product;
import Model.User;
import OnlineShopping.ByerRepo;
import OnlineShopping.ProductRepo;
import OnlineShopping.UserRepo;
import OnlineShopping.catRepo;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(value = "*")
public class BuyerController
{
         @Autowired
         ByerRepo byerrepo;
         
         @Autowired
         ProductRepo productrepo;
         
         @Autowired
         UserRepo userepo;
         
         @Autowired
         catRepo catrepo;
         
         
         @PostMapping("addToCart")
         public BuyerCart addToCart(@RequestBody BuyerCart cart) 
         {
        	 
        	 
        	 BuyerCart newProduct = new BuyerCart();
        	 
          	 Product product = productrepo.findByProductId(cart.getProductId());
        	 
          	 newProduct.setBuyerid(cart.getBuyerid());
        	 newProduct.setProductCount(cart.getProductCount());
        	 newProduct.setProductId(cart.getProductId());
        	 newProduct.setProductPrice(product.getPrice());
        	 newProduct.setProductDiscount(product.getDiscount());
        	 newProduct.setProductName(product.getProductName());
        	 newProduct.setDate(new Date());
        	 newProduct.setPriceAfteDiscount(product.getPriceAfterDicount());
        	 newProduct.setAvablitily(product.isAvalibility());
        	 
        	 return byerrepo.save(newProduct);
        	 
          }
         
         
         
         @GetMapping("ShowCart/{id}")
         public List<BuyerCart> ShowCart(@PathVariable int id) 
         {
        	// List<Product> cartProducts = new ArrayList<Product>();
        	 List<BuyerCart> cartitem = byerrepo.findAllBybuyerid(id);
        	 System.out.println(cartitem);
        	 for(BuyerCart cartItem : cartitem)
        	 {
        		  Product product = productrepo.findByProductId(cartItem.getProductId());
        		  
        			    cartItem.setProductName(product.getProductName());
        	            cartItem.setProductPrice(product.getPrice());
        	            cartItem.setProductDiscount(product.getDiscount());
        	            cartItem.setPriceAfteDiscount(product.getPriceAfterDicount());
        	            cartItem.setAvablitily(product.isAvalibility());
        	            cartItem.setProductDiscount(product.getDiscount());
        	        
        		  }

             return cartitem;
        	 }
         
         
         @GetMapping("getBuyerName/{id}")
         public String[] getBuyerName(@PathVariable int id)
         {
        	 System.out.println(id);
       	 User user =  userepo.findById(id).get();
       	 System.out.print(user.getName());
       	   String sa []= {user.getName()};
             return  sa;
         }
         
         @GetMapping("getProducts")
         public List<Product> getProducts() 
         {
        	 
             return productrepo.findAll();
         }
     
         @DeleteMapping("RemoveCart/{id}")
         public void RemoveCart (@PathVariable int id )
         {
        	 byerrepo.RemoveCart(id);
         }
         
         
}
