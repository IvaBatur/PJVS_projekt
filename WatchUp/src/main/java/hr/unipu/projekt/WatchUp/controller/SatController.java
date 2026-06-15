package hr.unipu.projekt.WatchUp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hr.unipu.projekt.WatchUp.model.Sat;
import hr.unipu.projekt.WatchUp.repository.BrandRepository;
import hr.unipu.projekt.WatchUp.repository.SatRepository;
import jakarta.validation.Valid;

@Controller
public class SatController {

    @Autowired
    private SatRepository satRepository;

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping("/")
    public String pocetna() {
        return "pocetna";
    }

    @GetMapping("/satovi")
    public String index(Model model, @RequestParam(value = "query", required = false) String query) {
        List<Sat> satovi;
        if (query != null && !query.isEmpty()) {
            satovi = satRepository.findByModelContainingIgnoreCaseOrBrandNazivContainingIgnoreCase(query, query);
        } else {
            satovi = satRepository.findAll();
        }
        
        int ukupnoSatova = satovi.stream().mapToInt(Sat::getKolicina).sum();
        
        model.addAttribute("satovi", satovi);
        model.addAttribute("ukupno", ukupnoSatova);
        return "index";
    }

    @GetMapping("/detalji/{id}")
    public String detalji(@PathVariable Long id, Model model) {
        Sat sat = satRepository.findById(id).orElseThrow();
        model.addAttribute("sat", sat);
        return "detaljiSata";
    }

    @GetMapping("/dodaj")
    public String prikaziDodaj(Model model) {
        model.addAttribute("sat", new Sat());
        model.addAttribute("brandovi", brandRepository.findAll());
        return "dodajSat";
    }

@PostMapping("/spremi")
public String spremiSat(@Valid @ModelAttribute("sat") Sat noviSat,
                        BindingResult result,
                        RedirectAttributes redirectAttributes,
                        Model model) {
    
    if (result.hasErrors()) {
    model.addAttribute("brandovi", brandRepository.findAll());
    return noviSat.getId() != null ? "urediSat" : "dodajSat";
}

    String noviBrandNaziv = "";
    if (noviSat.getBrand() != null && noviSat.getBrand().getId() != null) {
        noviBrandNaziv = brandRepository.findById(noviSat.getBrand().getId())
                .map(b -> b.getNaziv())
                .orElse("");
    }

    final String brandZaUsporedbu = noviBrandNaziv;

    Optional<Sat> postojeciSat = satRepository.findAll().stream()
        .filter(s -> s.getModel().equalsIgnoreCase(noviSat.getModel()) 
                && s.getBrand() != null
                && s.getBrand().getNaziv().equalsIgnoreCase(brandZaUsporedbu))
        .findFirst();


    if (postojeciSat.isPresent() && noviSat.getId() == null) {
        redirectAttributes.addFlashAttribute("upozorenje",
            "Sat '" + noviSat.getModel() + "' za brend '" + brandZaUsporedbu + "' je već u bazi! Idite na 'Uredi' ako želite promijeniti količinu ili cijenu.");
        return "redirect:/satovi";
    }

    satRepository.save(noviSat);
    redirectAttributes.addFlashAttribute("poruka", "Sat je uspješno spremljen!");
    return "redirect:/satovi";
}

    @GetMapping("/obrisi/{id}")
    public String obrisi(@PathVariable Long id) {
        satRepository.deleteById(id);
        return "redirect:/satovi";
    }

    @GetMapping("/uredi/{id}")
    public String prikaziUredi(@PathVariable Long id, Model model) {
        Sat sat = satRepository.findById(id).orElse(null);
        model.addAttribute("sat", sat);
        model.addAttribute("brandovi", brandRepository.findAll());
        return "urediSat";
    }
}