package main.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryComputersRepository extends JpaRepository<CategoryComputers, Integer> {
}
