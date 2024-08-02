package OnlineShopping;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Model.BuyerCart;
import Model.Category;
import jakarta.transaction.Transactional;

@Repository
public interface catRepo extends JpaRepository<Category, Integer> 
{

	
}
