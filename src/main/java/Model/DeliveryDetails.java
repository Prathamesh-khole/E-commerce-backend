package Model;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeliveryDetails 
{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     int id;
     
     String BuyerName;
     int BuyerId;
     String buyerEmail;
     String BuyerNumber;
     String BuyerAddress;
     

	 int productId;
     String ProductName;
     int productCount;
     double price ;
     
     Date PurchaseDate ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuyerName() {
		return BuyerName;
	}

	public void setBuyerName(String buyerName) {
		BuyerName = buyerName;
	}

	public int getBuyerId() {
		return BuyerId;
	}

	public void setBuyerId(int buyerId) {
		BuyerId = buyerId;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerNumber() {
		return BuyerNumber;
	}

	public void setBuyerNumber(String buyerNumber) {
		BuyerNumber = buyerNumber;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPurchaseDate() {
		return PurchaseDate;
	}

	public void setPurchaseDate(java.util.Date date) {
		PurchaseDate = (Date) date;
	}
	 public String getBuyerAddress() {
			return BuyerAddress;
		}

		public void setBuyerAddress(String buyerAddress) {
			BuyerAddress = buyerAddress;
		}
}
