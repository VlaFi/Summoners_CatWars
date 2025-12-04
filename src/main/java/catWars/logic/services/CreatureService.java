package catWars.logic.services;

import catWars.model.cats.Creature;
import java.util.*;

public class CreatureService {

    private final Map<String, Creature> creatures = new HashMap<>();
    private final AbilityService abilityService;

    public CreatureService(AbilityService abilityService) {
        this.abilityService = abilityService;
        loadCreatures();
    }

    private void loadCreatures() {
        creatures.put("DamageCat",
                new Creature("DamageCat", 100, 15, List.of("Damage"))
        );
        creatures.put("HealerCat",
                new Creature("HealerCat", 90, 10, List.of("Heal"))
        );
    }

    public Creature findByName(String name) {
        return creatures.get(name);
    }
}
