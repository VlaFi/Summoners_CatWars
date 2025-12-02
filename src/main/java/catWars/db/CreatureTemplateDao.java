package catWars.db;

import catWars.model.cats.CreatureTemplate;
import java.sql.*;
import java.util.*;

public class CreatureTemplateDao {

    public List<CreatureTemplate> getAll() {
        List<CreatureTemplate> list = new ArrayList<>();

        String sql = "SELECT * FROM creature_templates";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new CreatureTemplate(
                        rs.getString("name"),
                        rs.getInt("stars"),
                        rs.getDouble("base_hp"),
                        rs.getDouble("base_atk"),
                        rs.getDouble("base_def"),
                        rs.getDouble("base_speed"),
                        null // способности добавлю позже
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public CreatureTemplate getByName(String name) {
        String sql = "SELECT * FROM creature_templates WHERE name = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CreatureTemplate(
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
