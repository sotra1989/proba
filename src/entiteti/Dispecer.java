package entiteti;

public class Dispecer extends Korisnik {
    private double plata;
    private String brojTelefonskeLinije;
    private Odeljenje odeljenje;

    public Dispecer() {
    }

    public Dispecer(String korisnickoIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String brojTelefona, double plata, String brojTelefonskeLinije, Odeljenje odeljenje) {
        super(korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona);
        this.plata = plata;
        this.brojTelefonskeLinije = brojTelefonskeLinije;
        this.odeljenje = odeljenje;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public String getBrojTelefonskeLinije() {
        return brojTelefonskeLinije;
    }

    public void setBrojTelefonskeLinije(String brojTelefonskeLinije) {
        this.brojTelefonskeLinije = brojTelefonskeLinije;
    }

    public Odeljenje getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(Odeljenje odeljenje) {
        this.odeljenje = odeljenje;
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
        setBrojTelefonskeLinije(split[10]);
        setOdeljenje(Odeljenje.valueOf(split[11]));
    }

    @Override
    public String serialize() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", "dispecer", getKorisnickoIme(), getLozinka(), getIme(), getPrezime(), getJmbg(), getAdresa(),
                getPol().toString(), getBrojTelefona(), plata, brojTelefonskeLinije, odeljenje.toString());

    }


}
