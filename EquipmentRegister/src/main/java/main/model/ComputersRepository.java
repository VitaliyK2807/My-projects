package main.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComputersRepository extends JpaRepository<Computers, Integer> {
    List<Computers> findByNameIgnoreCase(String name);
    List<Computers> findByColor(String color);
    List<Computers> findByProcessorType(String type);

    @Query("select c from Computers c where c.price < ?1")
    List<Computers> findByPriceBefore(double price);

    @Query("select c from Computers c where c.price > ?1")
    List<Computers> findByPriceAfter(double price);

    @Query("select c from Computers c where c.price > ?1 and c.price < ?2")
    List<Computers> findBuPriceBeforeAfter(double price, double price1);
}
