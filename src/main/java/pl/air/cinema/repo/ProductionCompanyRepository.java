package pl.air.cinema.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.air.cinema.model.ProductionCompany;

import java.util.Optional;

public interface ProductionCompanyRepository extends JpaRepository<ProductionCompany, Long> {

Optional<ProductionCompany> deleteProductionCompanyById(Long id);

}
