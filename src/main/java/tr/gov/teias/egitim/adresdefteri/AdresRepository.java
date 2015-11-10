/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.teias.egitim.adresdefteri;

import java.util.List;
import javax.enterprise.context.Dependent;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import tr.gov.teias.egitim.adresdefteri.entities.Adres;

/**
 * Adres kayıtları için repository servisi
 * 
 * @author bekir
 */
@Repository
@Dependent
public abstract class AdresRepository extends AbstractEntityRepository<Adres, Long>{

    /**
     * Verilen tckn'ye sahip adres kayıt listesini döndürür.
     * @param tckn 11 digit tc kimlik no 
     * @return eğer kayıt bulamazsa içi boş liste döner
     */
    public abstract List<Adres> findByTckn( String tckn ); 
    
}
