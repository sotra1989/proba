package entiteti;

public class Musterija extends Korisnik {
    public Musterija() {
    }

    public Musterija(String korisnickoIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String brojTelefona) {
        super(korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona);
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
    }

    @Override
    public String serialize() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", "musterija", getKorisnickoIme(), getLozinka(), getIme(), getPrezime(), getJmbg(), getAdresa(),
                getPol().toString(), getBrojTelefona());
    }

}
