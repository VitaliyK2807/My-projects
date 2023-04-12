package main.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SmartphonesRepository extends JpaRepository<Smartphones, Integer> {

    List<Smartphones> findByNameIgnoreCase(String name);
    List<Smartphones> findByColor(String color);
    List<Smartphones> findByMemory(String memory);

    @Query("select sm from Smartphones sm where sm.price < ?1")
    List<Smartphones> findByPriceBefore(double price);

    @Query("select sm from Smartphones sm where sm.price > ?1")
    List<Smartphones> findByPriceAfter(double price);

    @Query("select sm from Smartphones sm where sm.price > ?1 and sm.price < ?2")
    List<Smartphones> findBuPriceBeforeAfter(double price, double price1);
}
