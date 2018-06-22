package controller.util;

import bean.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    private static final SessionUtil instance = new SessionUtil();

    private SessionUtil() {
    }
    private static List<Utilisateur> users = new ArrayList<>();

//    public static void registerUser(Utilisateur user) {
//        //clone user before
//        setAttribute("user", user);
//        if (isConnected(user) == true) {
//            users.add(user);
//        }
//    }
//
//    private static boolean isConnected(Utilisateur user) {
//        Optional<Utilisateur> u = users.stream().filter(x -> x.getLogin().equals(user.getLogin())).findFirst();
//        if (u == null) {
//            return false;
//        }
//        return true;
//    }

    public static Utilisateur getConnectedUser() {
        return (Utilisateur) getAttribute("user");
    }

    public static void setAttribute(String cle, Object valeur) {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null && fc.getExternalContext() != null) {
            getSession(fc).setAttribute(cle, valeur);
        }
    }

    private static HttpSession getSession(FacesContext fc) {
        return (HttpSession) fc.getExternalContext().getSession(false);
    }

    public static Object getAttribute(String cle) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object res = null;
        if (isContextOk(fc)) {
            res = getSession(fc).getAttribute(cle);
        }
        return res;
    }

    private static boolean isContextOk(FacesContext fc) {
        boolean res = (fc != null
                && fc.getExternalContext() != null
                && fc.getExternalContext().getSession(false) != null);
        return res;
    }

    public static void redirect(String pagePath) throws IOException {
//        if (!pagePath.endsWith(".xhtml")) {
//            pagePath += ".xhtml";
//        }
        FacesContext.getCurrentInstance().getExternalContext().redirect(pagePath);

    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

}
