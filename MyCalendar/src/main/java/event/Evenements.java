package event;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Evenements {

    private List<Event> events;

    public Evenements() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvenement(Event event) {
        this.events.add(event);
    }

    public void afficher() {
        events.forEach(e -> System.out.println(e.description()));
    }

    public List<Event> eventDansPeriode(DateEvenement debut, DateEvenement fin) {
        return events.stream()
                .filter(e -> e.dansPeriode(debut,fin))
                .collect(Collectors.toList());
    }

}
