package main.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Integer> {
    List<Fridge> findByNameIgnoreCase(String name);
    List<Fridge> findByColor(String color);
    List<Fridge> findByDoorsCount(Integer count);

    @Query("select f from Fridge f where f.price < ?1")
    List<Fridge> findByPriceBefore(double price);

    @Query("select f from Fridge f where f.price > ?1")
    List<Fridge> findByPriceAfter(double price);

    @Query("select f from Fridge f where f.price > ?1 and f.price < ?2")
    List<Fridge> findBuPriceBeforeAfter(double price, double price1);
}
