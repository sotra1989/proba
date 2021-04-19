package entiteti;

public class Automobil {

    private long id;
    private String model;
    private String proizvodjac;
    private int godinaProizvodnje;
    private String brojRegistarskeOznake;
    private String brojTaksiVozila;
    private VrstaAutomobila vrstaAutomobila;

    public Automobil() {
    }

    public Automobil(long id, String model, String proizvodjac, int godinaProizvodnje, String brojRegistarskeOznake, String brojTaksiVozila, VrstaAutomobila vrstaAutomobila) {
        this.id = id;
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godinaProizvodnje = godinaProizvodnje;
        this.brojRegistarskeOznake = brojRegistarskeOznake;
        this.brojTaksiVozila = brojTaksiVozila;
        this.vrstaAutomobila = vrstaAutomobila;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String getBrojRegistarskeOznake() {
        return brojRegistarskeOznake;
    }

    public void setBrojRegistarskeOznake(String brojRegistarskeOznake) {
        this.brojRegistarskeOznake = brojRegistarskeOznake;
    }

    public String getBrojTaksiVozila() {
        return brojTaksiVozila;
    }

    public void setBrojTaksiVozila(String brojTaksiVozila) {
        this.brojTaksiVozila = brojTaksiVozila;
    }

    public VrstaAutomobila getVrstaAutomobila() {
        return vrstaAutomobila;
    }

    public void setVrstaAutomobila(VrstaAutomobila vrstaAutomobila) {
        this.vrstaAutomobila = vrstaAutomobila;
    }

    public void deserialize(String s) {
        String[] split = s.split(",");
        setId(Long.parseLong(split[0]));
        setModel(split[1]);
        setProizvodjac(split[2]);
        setGodinaProizvodnje(Integer.parseInt(split[3]));
        setBrojRegistarskeOznake(split[4]);
        setBrojTaksiVozila(split[5]);
        setVrstaAutomobila(VrstaAutomobila.valueOf(split[6]));
    }

    public String serialize() {
        return String.format("%s,%s,%s,%s,%s,%s,%s\n", id, model, proizvodjac, godinaProizvodnje, brojRegistarskeOznake, brojTaksiVozila, vrstaAutomobila.toString());
    }

}
