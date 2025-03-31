import auth.LoginManager;
import event.CalendarManager;
import ui.MenuManager;
import ui.TerminalUI;
import utilisateur.Utilisateur;
import utilisateur.UtilisateurRepository;

public class Application {
    private final TerminalUI ui = new TerminalUI();
    private final CalendarManager calendar = new CalendarManager();
    private final UtilisateurRepository userRepo = new UtilisateurRepository();
    private final LoginManager loginManager = new LoginManager(ui, userRepo);
    private final MenuManager menuManager = new MenuManager(ui, calendar);

    public void start() {
        Utilisateur user = loginManager.executeUntilSuccess();
        menuManager.runSession(user);
    }
}

