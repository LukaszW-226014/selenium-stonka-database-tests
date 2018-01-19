/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luke
 */
@Entity
@Table(name = "KLIENCI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienci.findAll", query = "SELECT k FROM Klienci k")
    , @NamedQuery(name = "Klienci.findByIdklienci", query = "SELECT k FROM Klienci k WHERE k.idklienci = :idklienci")
    , @NamedQuery(name = "Klienci.findByImie", query = "SELECT k FROM Klienci k WHERE k.imie = :imie")
    , @NamedQuery(name = "Klienci.findByNazwisko", query = "SELECT k FROM Klienci k WHERE k.nazwisko = :nazwisko")
    , @NamedQuery(name = "Klienci.findByPesel", query = "SELECT k FROM Klienci k WHERE k.pesel = :pesel")
    , @NamedQuery(name = "Klienci.findByEmail", query = "SELECT k FROM Klienci k WHERE k.email = :email")
    , @NamedQuery(name = "Klienci.findByHaslo", query = "SELECT k FROM Klienci k WHERE k.haslo = :haslo")
    , @NamedQuery(name = "Klienci.findByDataurodzenia", query = "SELECT k FROM Klienci k WHERE k.dataurodzenia = :dataurodzenia")
    , @NamedQuery(name = "Klienci.findByUlica", query = "SELECT k FROM Klienci k WHERE k.ulica = :ulica")
    , @NamedQuery(name = "Klienci.findByNrdomu", query = "SELECT k FROM Klienci k WHERE k.nrdomu = :nrdomu")
    , @NamedQuery(name = "Klienci.findByMiejscowosc", query = "SELECT k FROM Klienci k WHERE k.miejscowosc = :miejscowosc")
    , @NamedQuery(name = "Klienci.findByKod", query = "SELECT k FROM Klienci k WHERE k.kod = :kod")
    , @NamedQuery(name = "Klienci.findByPocztowy", query = "SELECT k FROM Klienci k WHERE k.pocztowy = :pocztowy")})
public class Klienci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKLIENCI")
    private Integer idklienci;
    @Size(max = 45)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 45)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Size(max = 45)
    @Column(name = "PESEL")
    private String pesel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 45)
    @Column(name = "HASLO")
    private String haslo;
    @Size(max = 10)
    @Column(name = "DATAURODZENIA")
    private String dataurodzenia;
    @Size(max = 45)
    @Column(name = "ULICA")
    private String ulica;
    @Size(max = 5)
    @Column(name = "NRDOMU")
    private String nrdomu;
    @Size(max = 45)
    @Column(name = "MIEJSCOWOSC")
    private String miejscowosc;
    @Size(max = 2)
    @Column(name = "KOD")
    private String kod;
    @Size(max = 3)
    @Column(name = "POCZTOWY")
    private String pocztowy;

    public Klienci() {
    }

    public Klienci(Integer idklienci) {
        this.idklienci = idklienci;
    }

    public Integer getIdklienci() {
        return idklienci;
    }

    public void setIdklienci(Integer idklienci) {
        this.idklienci = idklienci;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getDataurodzenia() {
        return dataurodzenia;
    }

    public void setDataurodzenia(String dataurodzenia) {
        this.dataurodzenia = dataurodzenia;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrdomu() {
        return nrdomu;
    }

    public void setNrdomu(String nrdomu) {
        this.nrdomu = nrdomu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getPocztowy() {
        return pocztowy;
    }

    public void setPocztowy(String pocztowy) {
        this.pocztowy = pocztowy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idklienci != null ? idklienci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienci)) {
            return false;
        }
        Klienci other = (Klienci) object;
        if ((this.idklienci == null && other.idklienci != null) || (this.idklienci != null && !this.idklienci.equals(other.idklienci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Klienci[ idklienci=" + idklienci + " ]";
    }
    
}
