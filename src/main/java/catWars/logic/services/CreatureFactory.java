package catWars.logic.services;

import catWars.model.cats.Creature;
import catWars.model.cats.CreatureTemplate;

public class CreatureFactory {
    private final CreatureService service;

    public CreatureFactory(CreatureService service) {
        this.service = service;
    }

    public Creature createFromTemplate(String name) {
        CreatureTemplate t = service.getTemplateByName(name);
        return new Creature(t); // Creature — твой игровой объект
    }
}
