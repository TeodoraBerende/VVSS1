package biblioteca.repository;

import biblioteca.model.Carte;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartiRepositoryMock implements IRepository {

    private List<Carte> carti=new ArrayList<Carte>();
    private int maxim=1;

    public CartiRepositoryMock(){
        carti.add(new Carte(1,"Povesti", Arrays.asList("Mihai Eminescu","Ion Caragiale","Ion Creanga"),"1973","Corint",Arrays.asList("povesti","povestiri")));
        carti.add(new Carte(2,"Poezii", Arrays.asList("Sadoveanu"),"1973","Corint",Arrays.asList("poezii")));
        carti.add(new Carte(3,"Enigma Otiliei", Arrays.asList("George Calinesc"),"1948","Litera",Arrays.asList("enigma","otilia")));
        carti.add(new Carte(4,"Povesti", Arrays.asList("Mihai Eminescu","Ion Creanga","Tudor"),"1990","Corint",Arrays.asList("povesti","povestiri")));
        carti.add(new Carte(7,"1984", Arrays.asList("George Orwell"),"2013","Corint",Arrays.asList("contemporan")));

        for (Carte c:carti){
            if(c.getId()>maxim){
                maxim=c.getId();
            }
        }
    }

    @Override
    public void adaugaCarte(Carte c) {
        maxim++;
        c.setId(maxim);
        carti.add(c);
    }

    @Override
    public List<Carte> getAllCarti() {
        return carti;
    }

    public int getMaxim(){
        return maxim;
    }

    public List<Carte> cautaCarteDupaAutor(String autor) {
        List<Carte> cartiGasite = new ArrayList<Carte>();
        int i=0;
        while (i<carti.size()) {
            boolean flag = false;
            List<String> autori = carti.get(i).getAutori();
            int j = 0;
            while (j < autori.size() && !flag) {
                String[] nume = autori.get(j).split(" ");
                for (String numeAutor : nume) {
                    if (numeAutor.length() >= autor.length()) {
                        if (numeAutor.toLowerCase().substring(0, autor.length()).equals(autor.toLowerCase())) {
                            flag = true;
                        }
                    }
                }
                j++;
            }
            if (flag == true) {
                cartiGasite.add(carti.get(i));
            }
            i++;
        }
        return cartiGasite;
    }

    public void removeAll(){
        carti.clear();
    }


}
