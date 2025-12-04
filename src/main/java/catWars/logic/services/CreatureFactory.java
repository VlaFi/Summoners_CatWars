package catWars.logic.services;

import catWars.db.CreatureTemplateDao;
import catWars.model.cats.CreatureInstance;
import catWars.model.cats.CreatureTemplate;

public class CreatureFactory {
    private final CreatureTemplateDao templateDao;

    public CreatureFactory(CreatureTemplateDao templateDao) {
        this.templateDao = templateDao;
    }

    public CreatureInstance createInstanceFromTemplateName(String name) {
        CreatureTemplate t = templateDao.loadByName(name);
        if (t == null) return null;
        return new CreatureInstance(t);
    }
}
