package hr.unipu.projekt.WatchUp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.unipu.projekt.WatchUp.model.Sat;

@Repository
public interface SatRepository extends JpaRepository<Sat, Long> {
    
    List<Sat> findByModelContainingIgnoreCaseOrBrandNazivContainingIgnoreCase(String model, String brandNaziv);
}
