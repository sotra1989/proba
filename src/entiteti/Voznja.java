package entiteti;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Voznja {

    private long id;
    private LocalDateTime datumIvremePorudzbine;
    private String adresaPolaska;
    private String adresaDestinacije;
    private Musterija musterija;
    private Vozac vozac;
    private int brojPredjenihKilometara;
    private int trajanjeVoznje;
    private Status status;

    public Voznja() {
    }

    public Voznja(long id, LocalDateTime datumIvremePorudzbine, String adresaPolaska, String adresaDestinacije, Musterija musterija, Vozac vozac, int brojPredjenihKilometara, int trajanjeVoznje, Status status) {
        this.id = id;
        this.datumIvremePorudzbine = datumIvremePorudzbine;
        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        this.musterija = musterija;
        this.vozac = vozac;
        this.brojPredjenihKilometara = brojPredjenihKilometara;
        this.trajanjeVoznje = trajanjeVoznje;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDatumIvremePorudzbine() {
        return datumIvremePorudzbine;
    }

    public void setDatumIvremePorudzbine(LocalDateTime datumIvremePorudzbine) {
        this.datumIvremePorudzbine = datumIvremePorudzbine;
    }

    public String getAdresaPolaska() {
        return adresaPolaska;
    }

    public void setAdresaPolaska(String adresaPolaska) {
        this.adresaPolaska = adresaPolaska;
    }

    public String getAdresaDestinacije() {
        return adresaDestinacije;
    }

    public void setAdresaDestinacije(String adresaDestinacije) {
        this.adresaDestinacije = adresaDestinacije;
    }

    public Musterija getMusterija() {
        return musterija;
    }

    public void setMusterija(Musterija musterija) {
        this.musterija = musterija;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public int getBrojPredjenihKilometara() {
        return brojPredjenihKilometara;
    }

    public void setBrojPredjenihKilometara(int brojPredjenihKilometara) {
        this.brojPredjenihKilometara = brojPredjenihKilometara;
    }

    public int getTrajanjeVoznje() {
        return trajanjeVoznje;
    }

    public void setTrajanjeVoznje(int trajanjeVoznje) {
        this.trajanjeVoznje = trajanjeVoznje;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void deserialize(String s) {
        String[] split = s.split(",");
        setId(Long.parseLong(split[0]));
        setDatumIvremePorudzbine(LocalDateTime.parse(split[1], DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm")));
        setAdresaPolaska(split[2]);
        setAdresaDestinacije(split[3]);

        setBrojPredjenihKilometara(Integer.parseInt(split[6]));
        setTrajanjeVoznje(Integer.parseInt(split[7]));
        setStatus(Status.valueOf(split[8]));


    }

    public String serialize() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", id, datumIvremePorudzbine.format(DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm")),
                adresaPolaska, adresaDestinacije, musterija.getKorisnickoIme(), vozac.getKorisnickoIme(), brojPredjenihKilometara, trajanjeVoznje, status.toString());

    }
}
