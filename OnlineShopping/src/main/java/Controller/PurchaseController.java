package Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import Model.DeliveryDetails;
import Model.DeliverySave;
import Model.Product;
import Model.PurchasedProducts;
import OnlineShopping.DeliveryRepo;
import OnlineShopping.ProductRepo;
import OnlineShopping.PurchaseRepo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@CrossOrigin(value="*")
public class PurchaseController 
{
	@Autowired
    ProductRepo productrepo;
	
	@Autowired
	PurchaseRepo purchaserepo;
	
	@Autowired
	DeliveryRepo Deliver;
	
	
	@PostMapping("Purchesed")
	public PurchasedProducts Purchesed (@RequestBody DeliverySave deliverySave  ) 
	{
	  
		
		PurchasedProducts newPurchase = new PurchasedProducts();
		int purchesed[] = deliverySave.getPurchased();
		DeliveryDetails Delivery= deliverySave.getDeliveryDetails();
   	 
     	Product product = productrepo.findByProductId(purchesed[0]);
     	
     	
     	newPurchase.setSellerId(product.getSellerId());
     	newPurchase.setBuyerId(purchesed[1]);
        newPurchase.setAvalibility(product.isAvalibility());
     	newPurchase.setDiscount(product.getDiscount());
     	newPurchase.setPriceAfterDicount(product.getPriceAfterDicount());
     	newPurchase.setPrice(product.getPrice());
     	newPurchase.setProductCount(purchesed[2]);
     	newPurchase.setDate(new Date());
     	newPurchase.setProductName(product.getProductName());
     	newPurchase.setDiscount(product.getDiscount());
     	newPurchase.setProductId(product.getProductId());
     	
     	product.setproductCount(product.getproductCount()-purchesed[2]);
     	
     	//Delivery
     	DeliveryDetails Details = new DeliveryDetails();
     	
     	System.out.println(Delivery.getBuyerAddress());
     	Details.setBuyerAddress(Delivery.getBuyerAddress());
     	Details.setBuyerEmail(Delivery.getBuyerEmail());
     	Details.setBuyerName(Delivery.getBuyerName());
     	Details.setBuyerId(purchesed[1]);
        Details.setProductId(purchesed[0]);
        Details.setProductName(product.getProductName());
        Details.setPurchaseDate(new Date());
        Details.setPrice(product.getPriceAfterDicount());
        Details.setProductCount(purchesed[2]);
        Details.setBuyerNumber(Delivery.getBuyerNumber());
        
       Deliver.save(Details);
        
     	return purchaserepo.save(newPurchase);
     
		
		
	}
	
	@GetMapping("getAllPurchasedProducts/{id}")
	public  List<PurchasedProducts> getMethodName(@PathVariable int id) 
	{
		System.out.println(id);
		return purchaserepo.findAllByBuyerId(id);
	}
	
	@DeleteMapping("/cancelOrder/{buyerId}/{productId}")
    public void cancelOrder(@PathVariable int buyerId, @PathVariable int productId) 
	{
		purchaserepo.deleteByBuyerIdAndProductId(buyerId, productId);
		Deliver.deleteByBuyerIdAndProductId(buyerId, productId);
	}

}
