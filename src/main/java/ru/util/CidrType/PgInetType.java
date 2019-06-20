package ru.util.CidrType;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;


public class PgInetType implements UserType {

    @Override
    public int[] sqlTypes() {

        //Because inet,macaddr,cdir...and unkwon type for java, yo must
        // define Types.OTHER
        return new int[]{Types.OTHER};
    }

    @Override
    public Class returnedClass() {
        //Object created to be handled for java
        return PgInet.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return ObjectUtils.nullSafeEquals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        if (x != null)
            return x.hashCode();
        else
            return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        PgInet address=null;
        String ip=resultSet.getString(strings[0]);

        if(ip!=null)
            address=new PgInet(ip);

        return address;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        if(o==null)
            preparedStatement.setNull(i, Types.VARCHAR);
        else
            preparedStatement.setObject(i, getInet(o,  preparedStatement.getConnection()));
    }


    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if(value==null)
            return null;
        else{
            PgInet PgInetNew=new PgInet();
            PgInet PgInetOriginal=(PgInet)value;

            PgInetNew.setAddress(PgInetOriginal.getAddress());

            return PgInetNew;
        }
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return deepCopy(serializable);
    }

    @Override
    public Object replace(Object original, Object o1, Object o2) throws HibernateException {
        return deepCopy(original);
    }

    private Object getInet(Object value, Connection connection) {
        //Expected object on postgresql

        Object tempInet = null;
        ClassLoader connectionClassLoader = connection.getClass().getClassLoader();

        try {

            //Class which will create the postgresql

            Class aPGObjectClass =connectionClassLoader.loadClass("org.postgresql.util.PGobject");
            Constructor ct = aPGObjectClass.getConstructor(null);
            try {
                tempInet = ct.newInstance(null);
            } catch (InstantiationException | IllegalAccessException
                    | IllegalArgumentException | InvocationTargetException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }

            Method setTypeMethod = aPGObjectClass.getMethod("setType", String.class);
            try {

                //Setting postgresql type, inet in this case

                setTypeMethod.invoke(tempInet, new Object[]{"inet"});
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            Method setValueMethod = aPGObjectClass.getMethod("setValue", String.class);
            try {
                setValueMethod.invoke(tempInet, new Object[]{value.toString()});
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (ClassNotFoundException ignored) {

        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tempInet;
    }

}