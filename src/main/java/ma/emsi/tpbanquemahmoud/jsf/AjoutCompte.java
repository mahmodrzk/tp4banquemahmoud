/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.emsi.tpbanquemahmoud.jsf;

import jakarta.faces.view.ViewScoped;
import jakarta.transaction.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import ma.emsi.tbbanquemahmoud.util.Util;
import ma.emsi.tpbanquemahmoud.entity.CompteBancaire;
import ma.emsi.tpbanquemahmoud.service.GestionnaireCompte;

/**
 *
 * @author MOHAMED
 */
@Named(value = "ajoutCompte")
@ViewScoped
public class AjoutCompte implements Serializable {

    private String nom;
    @PositiveOrZero
    private int montant;
    
    @Inject
    private GestionnaireCompte gc;
    /**
     * Crée une nouvelle instance de la classe AjoutCompte.
     */
    public AjoutCompte() {
    }

    /**
     * Obtient le nom du compte.
     *
     * @return Le nom du compte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du compte.
     *
     * @param nom Le nom du compte.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le montant initial du compte.
     *
     * @return Le montant initial du compte.
     */
    public int getMontant() {
        return montant;
    }

    /**
     * Définit le montant initial du compte.
     *
     * @param montant Le montant initial du compte.
     */
    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    /**
     * Ajoute un nouveau compte bancaire avec les informations fournies.
     *
     * @return La page de la liste des comptes après la création du compte.
     */
    @Transactional
    public String ajouter() {
        gc.creerCompte(new CompteBancaire(nom, montant));
        Util.addFlashInfoMessage("Compte créé avec succès");
        return "listeComptes?faces-redirect=true";
    }
    
    
}
