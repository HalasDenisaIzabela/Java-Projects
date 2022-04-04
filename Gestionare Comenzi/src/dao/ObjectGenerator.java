package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjectGenerator<T> {

    private final Class<T> type;

    public ObjectGenerator(Class<T> type) {
        this.type = type;
    }

    public List<T> createObjectsByResultSet(ResultSet resultSet) {
        List<T> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add(createObjectByResultSet(resultSet));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    public T createObjectByResultSet(ResultSet resultSet) {
        try {
            T instance = type.getConstructor().newInstance();
            for (Field field : type.getDeclaredFields()) {
                Object value = resultSet.getObject(field.getName());
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                Method method = propertyDescriptor.getWriteMethod();
                method.invoke(instance, value);
            }
            return instance;
        } catch (InstantiationException | SQLException | IllegalAccessException |
                IntrospectionException | InvocationTargetException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
