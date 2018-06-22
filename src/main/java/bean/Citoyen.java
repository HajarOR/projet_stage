/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Lenovo
 */
@Entity
public class Citoyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String cin;
    private String tele;
    private String nom;
    @OneToMany(mappedBy = "citoyen")
    private List<Reclamation> reclamations;

    @OneToMany(mappedBy = "citoyen")
    private List<Demande> demandes;

    public Citoyen() {
    }

    public Citoyen(String cin) {
        this.cin = cin;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cin != null ? cin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the cin fields are not set
        if (!(object instanceof Citoyen)) {
            return false;
        }
        Citoyen other = (Citoyen) object;
        if ((this.cin == null && other.cin != null) || (this.cin != null && !this.cin.equals(other.cin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Citoyen{" + "cin=" + cin + ", tele=" + tele + ", nom=" + nom + '}';
    }

}
