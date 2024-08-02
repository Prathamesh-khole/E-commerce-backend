package OnlineShopping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Model.BuyerCart;
import jakarta.transaction.Transactional;

@Repository
public interface ByerRepo  extends JpaRepository<BuyerCart,Integer>
{

	List<BuyerCart> findAllById(int id);
	
    @Modifying
   @Transactional
   @Query(value="delete from Buyer_cart where id = :id " , nativeQuery = true)
	 void RemoveCart(@Param("id") int id );
	 
	 
	 @Query(value ="select * from buyer_cart where buyerid= :buyerId", nativeQuery = true)
	 List<BuyerCart> findAllBybuyerid(@Param("buyerId") int buyerId);

}
