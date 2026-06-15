# PJVS_projekt
# WatchUp 

WatchUp je jednostavna Spring Boot web aplikacija za upravljanje inventurom i skladištem satova. Cilj je olakšati praćenje količine i cijene satova koji se trenutno nalaze u poslovnici ( i skladištu poslovnice). 

##  Značajke aplikacije

- **Početna stranica**: Kratki opis i brza poveznicama za navigaciju
- **Pregled inventure**: Tablični prikaz svih satova iz baze s automatskim izračunom ukupne količine komada na skladištu.
- **Pretraga**: Brzo filtriranje satova prema modelu ili nazivu brenda (sustav ignorira velika/mala slova).
- **Detalji zapisa**: Pregled svih informacija o pojedinom satu, uključujući i državu podrijetla brenda.
- **CRUD upravljanje**: Potpuna podrška za dodavanje novih artikala te uređivanje postojećih podataka.
- **Validacija unosa**: Provjera obaveznih polja
- **Sigurno brisanje**: Skočni prozor koji traži potvrdu korisnika prije trajnog brisanja zapisa iz baze podataka.
- **Sprječavanje duplikata**: Sustav automatski prepoznaje ako pokušate dodati sat istog modela i brenda koji već postoji u bazi te ispisuje upozorenje
## Pokretanje

- **Preuzmite** .zip datoteku projekta i raspakirajte je 
- **Otvorite** dobivenu mapu u svom razvojnom okruženju (IntelliJ IDEA,VS Code..)
- **Pokrenite aplikaciju** kroz IDE desnim klikom na klasu WatchUpApplication.java -> Run As -> Spring Boot App.
- **Otvorite web preglednik** i idite na adresu: http://localhost:8080




Studentica: Iva Batur 
Kolegij: Programiranje na Java virtualnom stroju 
Mentor: dr. sc. Romeo Šajina
Fakultet Informatike u Puli, 2026.


