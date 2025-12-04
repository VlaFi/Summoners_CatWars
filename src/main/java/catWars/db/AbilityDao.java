package catWars.db;

import catWars.logic.abilities.Ability;
import catWars.logic.abilities.AbilityFactory;

import java.sql.*;
import java.util.*;

public class AbilityDao {

    public List<Ability> loadAllAbilities() {
        List<Ability> list = new ArrayList<>();

        String sql = "SELECT id, name, type, power, cooldown FROM abilities ORDER BY id";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                double power = rs.getDouble("power");

                Ability ability = AbilityFactory.create(type, power);
                ability.setId(id);
                ability.setName(rs.getString("name"));
                ability.setCooldown(rs.getInt("cooldown"));

                list.add(ability);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
