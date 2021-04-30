package entiteti;

public class Vozac extends Korisnik {
    private long id;
    private double plata;
    private int brojClanskeKarte;
    private Automobil automobil;

    public Vozac() {
    }

    public Vozac(String korisnickoIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String brojTelefona, double plata, int brojClanskeKarte, Automobil automobil) {
        super(korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona);
        this.plata = plata;
        this.brojClanskeKarte = brojClanskeKarte;
        this.automobil = automobil;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public int getBrojClanskeKarte() {
        return brojClanskeKarte;
    }

    public void setBrojClanskeKarte(int brojClanskeKarte) {
        this.brojClanskeKarte = brojClanskeKarte;
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public void setAutomobil(Automobil automobil) {
        this.automobil = automobil;
    }

    @Override
    public void deserialize(String s) {
        String[] split = s.split(",");
        setKorisnickoIme(split[1]);
        setLozinka(split[2]);
        setIme(split[3]);
        setPrezime(split[4]);
        setJmbg(split[5]);
        setAdresa(split[6]);
        setPol(Pol.valueOf(split[7]));
        setBrojTelefona(split[8]);
        setPlata(Double.parseDouble(split[9]));
        setBrojClanskeKarte(Integer.parseInt(split[10]));
    }

    @Override
    public String serialize() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", "vozac", getKorisnickoIme(), getLozinka(), getIme(), getPrezime(), getJmbg(), getAdresa(),
                getPol().toString(), getBrojTelefona(), plata, brojClanskeKarte, automobil.getId());
    }

}
