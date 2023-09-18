package orm;

import orm.anotations.Column;
import orm.anotations.Entity;
import orm.anotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private final static String INSERT_QUERY = "INSERT INTO %s(%s) VALUES (%s)";

    public static final String CREATE_VALUE_FORMAT = "%s %s";
    public static final String CREATE_TABLE_QUERY_FORMAT
            = "CREATE TABLE %s (id INT PRIMARY KEY AUTO_INCREMENT, %s);";
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        final Field idField = getIdField(entity.getClass());
        idField.setAccessible(true);
        idField.get(entity);
        Object idValue = idField.get(entity);

        if (idValue == null || (int) idValue == 0) {
            return insertEntity(entity);
        }
        return false;
    }

    private boolean insertEntity(E entity) throws SQLException {
//        String INSERT_QUERY = "INSERT INTO %s(%s) VALUES (%s)";
        String tableName = getTableName(entity.getClass());
        String fieldNamesWithoutId = getFieldNamesWithoutId(entity.getClass());
        String fieldValuesWithoutId = getFieldValuesWithoutId(entity);

        String query = String
                .format(INSERT_QUERY, tableName, fieldNamesWithoutId, fieldValuesWithoutId);
        PreparedStatement statement = this.connection.prepareStatement(query);
        return statement.executeUpdate() == 1;
    }

    private String getFieldValuesWithoutId(E entity) {
        Class<?> entityClass = entity.getClass();
        Field idField = getIdField(entityClass);

        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> !f.getName().equals(idField.getName()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> {
                    f.setAccessible(true);
                    try {
                        Object value = f.get(entity);
                        return String.format("'%s'", value.toString());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.joining(","));


    }

    private String getFieldNamesWithoutId(Class<?> entityClass) {
        Field idField = getIdField(entityClass);

        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> !f.getName().equals(idField.getName()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> f.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));
    }

    private String getTableName(Class<?> entityClass) {
        Entity annotation = entityClass.getAnnotation(Entity.class);
        if (annotation == null) {
            throw new UnsupportedOperationException("Entity must have annotation");
        }
        return annotation.name();
    }

    private Field getIdField(Class<?> entityClass) {
        Field[] declaredFields = entityClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Id.class)) {
                return declaredField;
            }
        }
        throw new UnsupportedOperationException("Entity does not have ID column");
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, null);
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String SELECT_QUERY_SINGLE = "SELECT * FROM %s %s LIMIT 1";
        String actualWhere = where == null ? "" : where;
        String tableName = getTableName(table);

        String query = String.format(SELECT_QUERY_SINGLE, tableName, actualWhere);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return createEntity(table, resultSet);
        }

        return null;
    }

    private E createEntity(Class<E> table, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        E entity = table.getDeclaredConstructor().newInstance();

        Arrays.stream((table.getDeclaredFields()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .forEach(f -> {
                    try {
                        fillFieldData(entity, f, resultSet);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        return entity;
    }

    private void fillFieldData(E entity, Field field, ResultSet resultSet) throws SQLException, IllegalAccessException {
        field.setAccessible(true);
        String fieldName = field.getAnnotation(Column.class).name();
        Object value;

        Class<?> fieldType = field.getType();

        if (fieldType == int.class) {
            value = resultSet.getInt(fieldName);
        } else if (fieldType == LocalDate.class) {
            String stringDate = resultSet.getString(fieldName);
            value = LocalDate.parse(stringDate);
        } else {
            value = resultSet.getString(fieldName);
        }
        field.set(entity, value);
    }

    @Override
    public void doCreate(Class<E> entityClass) throws SQLException {
        String tableName = getTableName(entityClass);
        String query = String.format(
                "CREATE TABLE %s ( id INT AUTO_INCREMENT PRIMARY KEY, %s);",
                tableName, getFieldNamesWithoutId(entityClass));

        PreparedStatement statement = connection.prepareStatement(query);

        statement.execute();
    }

//    private String getAllFieldsAndDataTypes(Class<E> entityClass) {
//        StringBuilder result = new StringBuilder();
//        Field[] fields = Arrays.stream(entityClass.getDeclaredFields())
//                .filter(field -> field.isAnnotationPresent(Column.class))
//                .toArray(Field[]::new);
//
//        Arrays.stream(fields).forEach(field -> {
//                    result.append(get)
//                }
//        );
//        return result.toString();
//    }



    public void doCreateTest(Class<E> entity) throws SQLException {
        final String tableName = getTableName(entity);
        final List<KeyValuePair> fieldsAndTypes = getAllFieldsAndDataTypes(entity);

        String fieldsAndTypesFormat = fieldsAndTypes.stream()
                .map(keyValuePair -> String.format(CREATE_VALUE_FORMAT, keyValuePair.key,
                        keyValuePair.value)).collect(Collectors.joining(","));

        String query = String.format(CREATE_TABLE_QUERY_FORMAT, tableName, fieldsAndTypes);

        connection.prepareStatement(query).execute();
    }

    private List<KeyValuePair> getAllFieldsAndDataTypes(Class<E> entity) {
        return getAllFieldsWithoutId(entity).stream()
                .map(f -> new KeyValuePair(getSQLColumnName(f), getSQLType(f.getType())))
                .toList();
    }

    private String getSQLColumnName(Field field) {
        return field.getAnnotationsByType(Column.class)[0].name();
    }

    private String getSQLType(Class<?> type) {
        if (type == Integer.class || type == int.class ||
        type == Long.class || type == long.class) {
            return "INT";
        } else if (type == LocalDate.class) {
            return "DATE";
        }
        return "VARCHAR(100)";
    }

    private List<Field> getAllFieldsWithoutId(Class<E> entity) {
       return Arrays.stream(entity.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class)
                        && f.isAnnotationPresent(Column.class)).toList();
    }

    public void doAlter(Class<E> entity) {
        final String tableName = getTableName(entity);

        addNewColumsStattementForNewFields(entity, tableName);
    }

    private void addNewColumsStattementForNewFields(Class<E> entity, String tableName) {
        getSQLColumnNames(entity, tableName);
    }

    private void getSQLColumnNames(Class<E> entity, String tableName) {
        Set<String> allFields = new HashSet<>();


    }

    private record KeyValuePair(String key, String value) {

    }
}
