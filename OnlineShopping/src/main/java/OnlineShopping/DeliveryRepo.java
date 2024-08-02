package OnlineShopping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Model.DeliveryDetails;
import jakarta.transaction.Transactional;

@Repository
public interface DeliveryRepo extends JpaRepository<DeliveryDetails, Integer>
{

	 @Modifying
     @Transactional
	@Query(value = "DELETE FROM delivery_details WHERE product_id =:productId AND buyer_id =:buyerId ", nativeQuery = true)
   void deleteByBuyerIdAndProductId(@Param("buyerId") int buyerId, @Param("productId") int productId);
}


