/*
 * Ce fichier représente la classe ListeComptes, utilisée pour gérer la liste des comptes bancaires.
 * Elle permet de récupérer la liste des comptes et de supprimer un compte spécifique.
 */
package ma.emsi.tpbanquemahmoud.jsf;

import ma.emsi.tbbanquemahmoud.util.Util;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import ma.emsi.tpbanquemahmoud.entity.CompteBancaire;
import ma.emsi.tpbanquemahmoud.service.GestionnaireCompte;

@Named(value = "listeComptes")
@Dependent
public class ListeComptes implements Serializable {

    public ListeComptes() {
    }

    private List<CompteBancaire> listeComptes;

    @Inject
    private GestionnaireCompte gc;

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
