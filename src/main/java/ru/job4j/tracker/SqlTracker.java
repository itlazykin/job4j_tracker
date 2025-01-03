package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO items(name, created) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.execute();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(Integer id, Item item) {
        boolean result = findById(id) != null;
        if (result) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("UPDATE items set name = ? where id = ?")) {
                preparedStatement.setString(1, item.getName());
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        if (findById(id) != null) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM items")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result.add(createItem(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            preparedStatement.setString(1, key);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result.add(createItem(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(Integer id) {
        Item item = null;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM items WHERE id = ?"
                     )) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                item = createItem(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    private Item createItem(ResultSet rs) {
        Item result = null;
        try {
            result = new Item(rs.getInt(1),
                    rs.getString(2),
                    rs.getTimestamp(3).toLocalDateTime()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}