package action;

import event.CalendarManager;
import ui.TerminalUI;

import java.util.HashMap;
import java.util.Map;

public class VisualisationActionFactory {
    private final TerminalUI ui;
    private final CalendarManager calendar;
    private final Map<String, MenuAction> actions;
    private final MenuAction defaultAction;

    public VisualisationActionFactory(TerminalUI ui, CalendarManager calendar) {
        this.ui = ui;
        this.calendar = calendar;
        this.actions = new HashMap<>();
        actions.put("1", new VisualiserTousAction(ui, calendar));
        actions.put("2", new VisualiserMoisAction(ui, calendar));
        actions.put("3", new VisualiserSemaineAction(ui, calendar));
        actions.put("4", new VisualiserJourAction(ui, calendar));
        this.defaultAction = new DefaultMenuAction(ui);
    }

    public MenuAction getAction(String key) {
        return actions.getOrDefault(key, defaultAction);
    }
}

