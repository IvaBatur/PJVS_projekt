package hr.unipu.projekt.WatchUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.unipu.projekt.WatchUp.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}