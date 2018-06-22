/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Lenovo
 */
@Entity
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private int numDemande;
    private int numAutorisation;
    private String type;
    private String nomSociete;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDemande;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAutorisation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAnnulation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRefus;
    @ManyToOne
    private Citoyen citoyen;
    @ManyToOne
    private Activite activite;

    public Demande() {
    }

    public Demande(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumDemande() {
        return numDemande;
    }

    public void setNumDemande(int numDemande) {
        this.numDemande = numDemande;
    }

    public int getNumAutorisation() {
        return numAutorisation;
    }

    public void setNumAutorisation(int numAutorisation) {
        this.numAutorisation = numAutorisation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Date getDateAutorisation() {
        return dateAutorisation;
    }

    public void setDateAutorisation(Date dateAutorisation) {
        this.dateAutorisation = dateAutorisation;
    }

    public Date getDateAnnulation() {
        return dateAnnulation;
    }

    public void setDateAnnulation(Date dateAnnulation) {
        this.dateAnnulation = dateAnnulation;
    }

    public Date getDateRefus() {
        return dateRefus;
    }

    public void setDateRefus(Date dateRefus) {
        this.dateRefus = dateRefus;
    }

    public Citoyen getCitoyen() {
        return citoyen;
    }

    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Demande{" + "id=" + id + ", numDemande=" + numDemande + ", numAutorisation=" + numAutorisation + ", type=" + type + ", nomSociete=" + nomSociete + ", dateDemande=" + dateDemande + ", dateAutorisation=" + dateAutorisation + ", dateAnnulation=" + dateAnnulation + ", dateRefus=" + dateRefus + '}';
    }

}
