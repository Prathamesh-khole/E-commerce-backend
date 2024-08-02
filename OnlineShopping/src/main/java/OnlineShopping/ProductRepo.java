package OnlineShopping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> 
{

	List<Product> findAllBysellerId(int sellerID);

	Product findByProductId(int i);
	
	@Query(value="SELECT * FROM product WHERE seller_id = :sellerId AND product_count < 10",nativeQuery = true)
	List<Product> findProductsBySellerWithLowStock(@Param("sellerId") int sellerId);
    
	

}
