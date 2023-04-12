package main.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TVRepository extends JpaRepository<TV, Integer> {
    List<TV> findByNameIgnoreCase(String name);
    List<TV> findByColor(String color);
    List<TV> findByCatTV(String catTV);

    @Query("select t from TV t where t.price < ?1")
    List<TV> findByPriceBefore(double price);

    @Query("select t from TV t where t.price > ?1")
    List<TV> findByPriceAfter(double price);

    @Query("select t from TV t where t.price > ?1 and t.price < ?2")
    List<TV> findBuPriceBeforeAfter(double price, double price1);


}
