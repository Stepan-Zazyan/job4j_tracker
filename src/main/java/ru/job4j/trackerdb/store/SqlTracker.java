package ru.job4j.trackerdb.store;

import ru.job4j.trackerdb.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private void addItemByStatement(
            List<Item> list, PreparedStatement statement) throws SQLException {
        try (ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                list.add(new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created").toLocalDateTime())
                );
            }
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("INSERT INTO public.items (name, created) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("UPDATE public.items "
                             + "SET name = ?, created = ? WHERE id = ?;")) {
            statement.setInt(3, id);
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement statement =
                     cn.prepareStatement("DELETE from public.items WHERE id = ?;")) {
            statement.setInt(1, id);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("SELECT * from public.items;")) {
            addItemByStatement(list, statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("SELECT * from public.items;")) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    if (Objects.equals(rs.getString("name"), key)) {
                        list.add(new Item(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created").toLocalDateTime())
                        );
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement statement =
                     cn.prepareStatement("SELECT * from public.items WHERE id = ?;")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }
}