/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luke
 */
@Entity
@Table(name = "ODPOWIEDZI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odpowiedzi.findAll", query = "SELECT o FROM Odpowiedzi o")
    , @NamedQuery(name = "Odpowiedzi.findByIdodpowiedzi", query = "SELECT o FROM Odpowiedzi o WHERE o.idodpowiedzi = :idodpowiedzi")
    , @NamedQuery(name = "Odpowiedzi.findByTresc", query = "SELECT o FROM Odpowiedzi o WHERE o.tresc = :tresc")
    , @NamedQuery(name = "Odpowiedzi.findByNrporzadkowyodpowiedzi", query = "SELECT o FROM Odpowiedzi o WHERE o.nrporzadkowyodpowiedzi = :nrporzadkowyodpowiedzi")})
public class Odpowiedzi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDODPOWIEDZI")
    private Integer idodpowiedzi;
    @Size(max = 45)
    @Column(name = "TRESC")
    private String tresc;
    @Column(name = "NRPORZADKOWYODPOWIEDZI")
    private Integer nrporzadkowyodpowiedzi;
    @JoinColumn(name = "PYTANIA_IDPYTANIA", referencedColumnName = "IDPYTANIA")
    @ManyToOne(optional = false)
    private Pytania pytaniaIdpytania;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odpowiedziIdodpowiedzi")
    private Collection<Wypelnienia> wypelnieniaCollection;

    public Odpowiedzi() {
    }

    public Odpowiedzi(Integer idodpowiedzi) {
        this.idodpowiedzi = idodpowiedzi;
    }

    public Integer getIdodpowiedzi() {
        return idodpowiedzi;
    }

    public void setIdodpowiedzi(Integer idodpowiedzi) {
        this.idodpowiedzi = idodpowiedzi;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Integer getNrporzadkowyodpowiedzi() {
        return nrporzadkowyodpowiedzi;
    }

    public void setNrporzadkowyodpowiedzi(Integer nrporzadkowyodpowiedzi) {
        this.nrporzadkowyodpowiedzi = nrporzadkowyodpowiedzi;
    }

    public Pytania getPytaniaIdpytania() {
        return pytaniaIdpytania;
    }

    public void setPytaniaIdpytania(Pytania pytaniaIdpytania) {
        this.pytaniaIdpytania = pytaniaIdpytania;
    }

    @XmlTransient
    public Collection<Wypelnienia> getWypelnieniaCollection() {
        return wypelnieniaCollection;
    }

    public void setWypelnieniaCollection(Collection<Wypelnienia> wypelnieniaCollection) {
        this.wypelnieniaCollection = wypelnieniaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idodpowiedzi != null ? idodpowiedzi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odpowiedzi)) {
            return false;
        }
        Odpowiedzi other = (Odpowiedzi) object;
        if ((this.idodpowiedzi == null && other.idodpowiedzi != null) || (this.idodpowiedzi != null && !this.idodpowiedzi.equals(other.idodpowiedzi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Odpowiedzi[ idodpowiedzi=" + idodpowiedzi + " ]";
    }
    
}
