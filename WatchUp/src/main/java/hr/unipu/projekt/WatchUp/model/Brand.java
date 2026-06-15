package hr.unipu.projekt.WatchUp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String drzavaPodrijetla;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Sat> satovi;

    public Brand() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }
    public String getDrzavaPodrijetla() { return drzavaPodrijetla; }
    public void setDrzavaPodrijetla(String drzavaPodrijetla) { this.drzavaPodrijetla = drzavaPodrijetla; }
    public List<Sat> getSatovi() { return satovi; }
    public void setSatovi(List<Sat> satovi) { this.satovi = satovi; }
}
