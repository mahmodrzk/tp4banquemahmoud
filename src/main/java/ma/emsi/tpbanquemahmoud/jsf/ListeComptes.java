/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.emsi.tpbanquemahmoud.jsf;

import ma.emsi.tbbanquemahmoud.util.Util;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import ma.emsi.tpbanquemahmoud.entity.CompteBancaire;
import ma.emsi.tpbanquemahmoud.service.GestionnaireCompte;


/**
 *
 * @author ADMIN
 */
@Named(value = "listeComptes")
@Dependent
public class ListeComptes implements Serializable {
    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    private List<CompteBancaire> listeComptes;

    @Inject
    private GestionnaireCompte gc;

    /**
     *
     * Retourne la liste des comptes pour affichage dans une DataTable.
     *
     * @return
     */
    public List<CompteBancaire> getAllComptes() {
        if (listeComptes == null) {
            listeComptes = gc.getAllComptes();
        }
        return listeComptes;
    }

    public String supprimerCompte(CompteBancaire compteBancaire) {
        gc.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
        return "listeComptes?faces-redirect=true";
    }
}

