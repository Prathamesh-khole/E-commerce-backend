package OnlineShopping;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Category;
import Model.DeliveryDetails;
import Model.Product;
import Model.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(value="*")
public class AdminController 
{
	@Autowired
	catRepo catrepo;
	
	
	@Autowired
	UserRepo userepo;
	
	@Autowired
	DeliveryRepo deliveryrepo ;
	
	@Autowired
	ProductRepo productrepo;
	
      @PostMapping("AddCat")
      public Category AddCategory (@RequestBody Category cat)
      {
    	  Category  C = new Category();
    	  C.setName(cat.getName());
    	  C.setDate(new Date());
    	  C.setUserid(cat.getUserid());

    	  return catrepo.save(C);
      }
      
      
      
      @DeleteMapping("deleteCat/{id}")
      public void deleteCat(@PathVariable int id)
      {
    	  System.out.println(id);
    	  catrepo.deleteById(id);
      }
      
      
      @GetMapping("GetCat")
      public List<Category> getCategory() 
      {
          return catrepo.findAll();
      }
      
      
      @GetMapping("getName/{id}")
      public String[] getName(@PathVariable int id)
      {
    	 User user =  userepo.findById(id).get();
    	 System.out.print(user.getName());
    	   String sa []= {user.getName()};
          return  sa;
      }   
          
          @GetMapping("DeliveryDetails")
          public List<DeliveryDetails> Details()
          {
        	  return deliveryrepo.findAll();
          }
      
          
          @Scheduled(fixedRate = 3600000) 
          public void checkUnavailableProducts() {
              List<Product> products = productrepo.findAll();
              Date now = new Date();

              for (Product product : products) 
              {
                  if (!product.isAvalibility() && product.getUnavalibilitysince() != null) {
                      long diffInMillies = now.getTime() - product.getUnavalibilitysince().getTime();
                      System.out.println(diffInMillies+"Milisecc");
                      long diffHours = diffInMillies / (60 * 60 * 1000);
                      System.out.println(diffHours+"Hour");

                      if (diffHours > 1) {
                          productrepo.delete(product); 
                      }
                      
                  }
              }
          }
      
}

