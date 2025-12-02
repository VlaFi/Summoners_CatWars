package catWars.logic.services;

import catWars.db.CreatureTemplateDao;
import catWars.model.cats.CreatureTemplate;

import java.util.List;

public class CreatureService {

    private final CreatureTemplateDao dao = new CreatureTemplateDao();

    public List<CreatureTemplate> loadTemplates() {
        return dao.getAll();
    }

    public CreatureTemplate getTemplateByName(String name) {
        return dao.getByName(name);
    }
}
