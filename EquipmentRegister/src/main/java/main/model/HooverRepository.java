package main.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HooverRepository extends JpaRepository<Hoover, Integer> {
    List<Hoover> findByNameIgnoreCase(String name);
    List<Hoover> findByColor(String color);
    List<Hoover> findByDustContainerVolume(Double volume);

    @Query("select h from Hoover h where h.price < ?1")
    List<Hoover> findByPriceBefore(double price);

    @Query("select h from Hoover h where h.price > ?1")
    List<Hoover> findByPriceAfter(double price);

    @Query("select h from Hoover h where h.price > ?1 and h.price < ?2")
    List<Hoover> findBuPriceBeforeAfter(double price, double price1);
}
