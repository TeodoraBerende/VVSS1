package biblioteca.repository;

import biblioteca.model.Carte;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartiRepositoryMock implements IRepository {

    private List<Carte> carti=new ArrayList<Carte>();
    private int maxim=1;

    public CartiRepositoryMock(){
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


}
