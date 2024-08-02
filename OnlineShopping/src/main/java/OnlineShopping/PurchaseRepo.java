package OnlineShopping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import Model.PurchasedProducts;
import jakarta.transaction.Transactional;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchasedProducts, Integer>
{

	List<PurchasedProducts> findAllByBuyerId(int buerId);

	 @Modifying
   @Transactional
	@Query(value = "DELETE FROM purchased_products WHERE product_id = :productId AND buyer_id = :buyerId", nativeQuery = true)
    void deleteByBuyerIdAndProductId(@Param("buyerId") int buyerId, @Param("productId") int productId);

}
