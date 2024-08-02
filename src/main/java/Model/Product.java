package Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int productId;
    int sellerId;
    
    String productName;
    String description;
    boolean avalibility;
    int  category;
    
    long price;
    int productCount;
    double discount;
    Date date ;
    double rating;
    double priceAfterDicount;
    Date unavalibilitysince;      
    
   
	
	
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public Date getUnavalibilitysince() {
		return unavalibilitysince;
	}
	public void setUnavalibilitysince(Date unavalibilitysince) {
		this.unavalibilitysince = unavalibilitysince;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getPriceAfterDicount() {
		return priceAfterDicount;
	}
	public void setPriceAfterDicount(double d) {
		this.priceAfterDicount = d;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvalibility() {
		return avalibility;
	}
	public void setAvalibility(boolean avalibility) {
		this.avalibility = avalibility;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getproductCount() {
		return productCount;
	}
	public void setproductCount(int itemsRemaing) 
	    {
		this.productCount = itemsRemaing;
		if(this.productCount<1)
			this.avalibility=false;
		else
			this.avalibility=true;
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
	public void setDate(Date date)
	{
		this.date=date;
	}
    
	

 
}
