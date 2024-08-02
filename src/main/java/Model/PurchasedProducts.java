package Model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PurchasedProducts
{
	
	
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    int productId;
    int sellerId;
    int buyerId;
    
   
	String productName;
    
    boolean avalibility;
   
    
    long price;
    int productCount;
    double discount;
    Date date ;
   
    double priceAfterDicount;
    
    
    
    
	
    public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
		public boolean isAvalibility() {
		return avalibility;
	}
	public void setAvalibility(boolean avalibility) {
		this.avalibility = avalibility;
	}
	
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getPriceAfterDicount() {
		return priceAfterDicount;
	}
	public void setPriceAfterDicount(double priceAfterDicount) {
		this.priceAfterDicount = priceAfterDicount;
	}
	
	
    
   
    
}
