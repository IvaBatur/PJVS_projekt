package hr.unipu.projekt.WatchUp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Sat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Model je obavezan")
    private String model;

    @NotNull(message = "Cijena mora biti definirana")
    @DecimalMin(value = "0.0", inclusive = true, message = "Cijena ne može biti negativna")
    private Double cijena;

    @NotNull(message = "Količina mora biti definirana")
    @Min(value = 0, message = "Količina ne može biti negativna")
    private Integer kolicina;
    
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Sat() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Double getCijena() { return cijena; }
    public void setCijena(Double cijena) { this.cijena = cijena; }

    public Integer getKolicina() { return kolicina; }
    public void setKolicina(Integer kolicina) { this.kolicina = kolicina; }

    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }
}