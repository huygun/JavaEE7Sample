/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.teias.egitim.adresdefteri;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import tr.gov.teias.egitim.adresdefteri.entities.Adres;

/**
 *
 * @author bekir
 */
@Named
@SessionScoped
public class AdresController implements Serializable{
    
    @Inject
    private AdresRepository repository;
    
    private List<Adres> adresler;

    private Adres current;
    
    
    public List<Adres> getAdresler() {
        if( adresler == null ){
            populateAdresler();
        }
        
        return adresler;
    }

    public void setAdresler(List<Adres> adresler) {
        this.adresler = adresler;
    }
    
    protected void populateAdresler(){
        adresler = repository.findAll( 0, 100 );
    }

    public Adres getCurrent() {
        return current;
    }

    public void setCurrent(Adres current) {
        this.current = current;
    }
    
    
    public void newAdres(){
        current = new Adres();
    }
    
    public void edit( Long id ){
        current = repository.findBy(id);
    }
    
    @Transactional
    public void save(){
        repository.save(current);
    }
    
    @Transactional
    public void delete(){
        repository.remove(current);
        current = null;
    }
    
}
