package Model;



import java.util.Date;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuyerCart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
    int buyerid;
    int productId;
    String productName;
    long productPrice;
    int productCount;
    double productDiscount;
    Date date;
    double priceAfteDiscount;
    boolean avablitily;
    
    
    
    
	public boolean isAvablitily() {
		return avablitily;
	}
	public void setAvablitily(boolean avablitily) {
		this.avablitily = avablitily;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPriceAfteDiscount() {
		return priceAfteDiscount;
	}
	public void setPriceAfteDiscount(double priceAfteDiscount) {
		this.priceAfteDiscount = priceAfteDiscount;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	public int getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date)
	{
		this.date=date;
	}
    
}
