package entiteti;

public class TaksiSluzba {

    private long id;
    private String pib;
    private String naziv;
    private String adresa;
    private int cenaStartaVoznje;
    private double cenaPoKilometru;

    public TaksiSluzba() {

    }

    public TaksiSluzba(long id, String pib, String naziv, String adresa, int cenaStartaVoznje, double cenaPoKilometru) {
        this.id = id;
        this.pib = pib;
        this.naziv = naziv;
        this.adresa = adresa;
        this.cenaStartaVoznje = cenaStartaVoznje;
        this.cenaPoKilometru = cenaPoKilometru;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getCenaStartaVoznje() {
        return cenaStartaVoznje;
    }

    public void setCenaStartaVoznje(int cenaStartaVoznje) {
        this.cenaStartaVoznje = cenaStartaVoznje;
    }

    public double getCenaPoKilometru() {
        return cenaPoKilometru;
    }

    public void setCenaPoKilometru(double cenaPoKilometru) {
        this.cenaPoKilometru = cenaPoKilometru;
    }


    public void deserialize(String s) {
        String[] split = s.split(",");
        setId(Long.parseLong(split[0]));
        setPib(split[1]);
        setNaziv(split[2]);
        setAdresa(split[3]);
        setCenaStartaVoznje(Integer.parseInt(split[4]));
        setCenaPoKilometru(Double.parseDouble(split[5]));

    }

    public String serialize() {
        return String.format("%s,%s,%s,%s,%s,%s\n", id, pib, naziv, adresa, cenaStartaVoznje, cenaPoKilometru);
    }


}