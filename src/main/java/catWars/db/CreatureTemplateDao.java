package catWars.db;

import catWars.model.cats.CreatureTemplate;
import catWars.logic.abilities.Ability;
import catWars.logic.abilities.AbilityFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreatureTemplateDao {

    public CreatureTemplate loadById(int id) {
        CreatureTemplate template = null;

        String sqlTemplate =
                "SELECT id, name, stars, base_hp, base_atk, base_def, base_speed " +
                        "FROM creature_templates WHERE id = ?";

        String sqlAbilities =
                "SELECT a.id, a.name, a.type, a.power, a.cooldown " +
                        "FROM creature_template_abilities cta " +
                        "JOIN abilities a ON cta.ability_id = a.id " +
                        "WHERE cta.creature_id = ? ORDER BY cta.ability_id";

        try (Connection conn = DbConnection.getConnection()) {

            try (PreparedStatement ps = conn.prepareStatement(sqlTemplate)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        template = new CreatureTemplate(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("stars"),
                                rs.getDouble("base_hp"),
                                rs.getDouble("base_atk"),
                                rs.getDouble("base_def"),
                                rs.getDouble("base_speed"),
                                null
                        );
                    }
                }
            }

            if (template == null) return null;

            List<Ability> abilities = new ArrayList<>();
            try (PreparedStatement ps = conn.prepareStatement(sqlAbilities)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String type = rs.getString("type");
                        double power = rs.getDouble("power");
                        Ability ability = AbilityFactory.create(type, power);
                        ability.setId(rs.getInt("id"));
                        ability.setName(rs.getString("name"));
                        ability.setCooldown(rs.getInt("cooldown"));
                        abilities.add(ability);
                    }
                }
            }

            template.setAbilities(abilities);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return template;
    }

    public List<CreatureTemplate> getAll() {
        List<CreatureTemplate> list = new ArrayList<>();
        String sql = "SELECT id FROM creature_templates ORDER BY id";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                CreatureTemplate t = loadById(id);
                if (t != null) list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CreatureTemplate loadByName(String name) {
        String sql = "SELECT id FROM creature_templates WHERE name = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    return loadById(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
