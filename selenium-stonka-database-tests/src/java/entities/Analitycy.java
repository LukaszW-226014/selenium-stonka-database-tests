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
@Table(name = "ANALITYCY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Analitycy.findAll", query = "SELECT a FROM Analitycy a")
    , @NamedQuery(name = "Analitycy.findByIdanalitycy", query = "SELECT a FROM Analitycy a WHERE a.idanalitycy = :idanalitycy")
    , @NamedQuery(name = "Analitycy.findByImie", query = "SELECT a FROM Analitycy a WHERE a.imie = :imie")
    , @NamedQuery(name = "Analitycy.findByNazwisko", query = "SELECT a FROM Analitycy a WHERE a.nazwisko = :nazwisko")
    , @NamedQuery(name = "Analitycy.findByEmail", query = "SELECT a FROM Analitycy a WHERE a.email = :email")
    , @NamedQuery(name = "Analitycy.findByPesel", query = "SELECT a FROM Analitycy a WHERE a.pesel = :pesel")
    , @NamedQuery(name = "Analitycy.findByHaslo", query = "SELECT a FROM Analitycy a WHERE a.haslo = :haslo")})
public class Analitycy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDANALITYCY")
    private Integer idanalitycy;
    @Size(max = 45)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 45)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 45)
    @Column(name = "PESEL")
    private String pesel;
    @Size(max = 45)
    @Column(name = "HASLO")
    private String haslo;
    @JoinColumn(name = "ADMINISTRATORZY_IDADMINISTRATOR", referencedColumnName = "IDADMINISTRATORZY")
    @ManyToOne(optional = false)
    private Administratorzy administratorzyIdadministrator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analitycyIdanalityk")
    private Collection<Ankiety> ankietyCollection;

    public Analitycy() {
    }

    public Analitycy(Integer idanalitycy) {
        this.idanalitycy = idanalitycy;
    }

    public Integer getIdanalitycy() {
        return idanalitycy;
    }

    public void setIdanalitycy(Integer idanalitycy) {
        this.idanalitycy = idanalitycy;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Administratorzy getAdministratorzyIdadministrator() {
        return administratorzyIdadministrator;
    }

    public void setAdministratorzyIdadministrator(Administratorzy administratorzyIdadministrator) {
        this.administratorzyIdadministrator = administratorzyIdadministrator;
    }

    @XmlTransient
    public Collection<Ankiety> getAnkietyCollection() {
        return ankietyCollection;
    }

    public void setAnkietyCollection(Collection<Ankiety> ankietyCollection) {
        this.ankietyCollection = ankietyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanalitycy != null ? idanalitycy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Analitycy)) {
            return false;
        }
        Analitycy other = (Analitycy) object;
        if ((this.idanalitycy == null && other.idanalitycy != null) || (this.idanalitycy != null && !this.idanalitycy.equals(other.idanalitycy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Analitycy[ idanalitycy=" + idanalitycy + " ]";
    }
    
}
