/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Utilisateur;
import controller.util.HashageUtil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "com.mycompany_ProjetStage_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    public int seConnecter(Utilisateur utilisateur) {
        Utilisateur loadedUser = find(utilisateur.getLogin());
        if (loadedUser.getLogin() == null) {
            return -1;
        } else if (!loadedUser.getPassword().equals(HashageUtil.sha256(utilisateur.getPassword()))) {
            return -2;
        } else {
            return 1;
        }
    }

    public int creerCompte(Utilisateur user) {
        if (user != null && !"".equals(user.getLogin()) && !"".equals(user.getPassword())) {
            Utilisateur utilisateur = find(user.getLogin());
            if (utilisateur == null) {
                user.setPassword(HashageUtil.sha256(user.getPassword()));
                create(user);
                return 1;
            } else {
                return -1;
            }
        }
        return -2;
    }
}
