package repository;

import entiteti.Automobil;
import entiteti.Dispecer;
import entiteti.Korisnik;
import entiteti.Musterija;
import entiteti.TaksiSluzba;
import entiteti.Vozac;
import entiteti.Voznja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TxtRepository {

    public static List<Automobil> procitajVozila() {
        List<Automobil> automobili = new ArrayList<>();
        try {
            File file = new File("src/fajlovi/vozila.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data;
            while ((data = br.readLine()) != null) {
                Automobil automobil = new Automobil();
                automobil.deserialize(data);
                automobili.add(automobil);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return automobili;
    }

    public static void upisiVoznje(List<Voznja> voznje) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/fajlovi/voznje.txt")));
            for (Voznja voznja : voznje) {
                bw.write(voznja.serialize());
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Korisnik> procitajKorisnike() {
        List<Automobil> automobili = procitajVozila();
        List<Korisnik> korisnici = new ArrayList<>();
        try {
            File file = new File("src/fajlovi/korisnici.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data;
            while ((data = br.readLine()) != null) {

                Korisnik korisnik = null;
                if (data.startsWith("vozac")) {
                    korisnik = new Vozac();
                    korisnik.deserialize(data);
                    long autoId = Long.parseLong(data.split(",")[11]);
                    for (Automobil a : automobili) {
                        if (a.getId() == autoId) {
                            ((Vozac) korisnik).setAutomobil(a);
                        }
                    }

                } else if (data.startsWith("dispecer")) {
                    korisnik = new Dispecer();
                    korisnik.deserialize(data);
                } else {
                    korisnik = new Musterija();
                    korisnik.deserialize(data);
                }
                korisnici.add(korisnik);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return korisnici;
    }

    public static void upisiKorisnike(List<Korisnik> korisnici) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/fajlovi/korisnici.txt")));
            for (Korisnik korisnik : korisnici) {
                bw.write(korisnik.serialize());
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Voznja> procitajVoznje() {
        List<Korisnik> korisnici = procitajKorisnike();
        List<Voznja> voznje = new ArrayList<>();
        try {
            File file = new File("src/fajlovi/voznje.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data;
            while ((data = br.readLine()) != null) {
                String[] iseceno = data.split(",");
                Voznja voznja = new Voznja();
                voznja.deserialize(data);

                String korisnickoImeMusterija = iseceno[4];
                String korisnickoImeVozac = iseceno[5];

                for (Korisnik k : korisnici) {
                    if (k.getKorisnickoIme().equals(korisnickoImeMusterija)) {
                        voznja.setMusterija((Musterija) k);
                    }
                    if (k.getKorisnickoIme().equals(korisnickoImeVozac)) {
                        voznja.setVozac((Vozac) k);
                    }
                }
                voznje.add(voznja);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voznje;
    }

    public static void upisiVozila(List<Automobil> automobili) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/fajlovi/vozila.txt")));
            for (Automobil automobil : automobili) {
                bw.write(automobil.serialize());
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<TaksiSluzba> procitajTaksiSluzbe() {
        List<TaksiSluzba> taksiSluzbe = new ArrayList<>();
        try {
            File file = new File("src/fajlovi/taksiSluzba.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data;
            while ((data = br.readLine()) != null) {

                TaksiSluzba taksiSluzba = new TaksiSluzba();
                taksiSluzba.deserialize(data);
                taksiSluzbe.add(taksiSluzba);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taksiSluzbe;
    }

    public static void upisiTaksiSluzbe(List<TaksiSluzba> taksiSluzbe) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/fajlovi/taksiSluzba.txt")));
            for (TaksiSluzba taksiSluzba : taksiSluzbe) {
                bw.write(taksiSluzba.serialize());
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	System.out.println("Test rada sa fajlovima.... ");
        upisiVozila(procitajVozila());
        upisiKorisnike(procitajKorisnike());
        upisiVoznje(procitajVoznje());
        upisiTaksiSluzbe(procitajTaksiSluzbe());
    }
}