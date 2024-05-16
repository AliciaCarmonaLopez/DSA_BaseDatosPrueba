package edu.upc.eetac.dsa.db.orm.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }
    public static void setter(Object object, String property, Object value) {
        // Method // invoke
        String propToUppercase = property.substring(0, 1).toUpperCase() + property.substring(1);
        String setterName = "set" + propToUppercase;
        try {
            Method m = object.getClass().getDeclaredMethod(setterName);
            m.invoke(object, value);

        }catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public static void setter(Object object, String property, Object value) {
        // Method // invoke
        // property="name";
        // value ="toni"
        Employee e =
                e.setName("toni")


    }

    */


    public static Object getter(Object object, String property) throws NoSuchFieldException, IllegalAccessException {
        // Method // invoke
        // Method // invoke
        // Method // invoke
        String propToUppercase = property.substring(0, 1).toUpperCase() + property.substring(1);
        String getterName = "get" + propToUppercase;
        try {
            Method m = object.getClass().getDeclaredMethod(getterName);
            Object o = m.invoke(object);
            return o;

        }catch (NoSuchMethodException e){
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }




      //  Object valor = object.getClass().getDeclaredField(property).get(object);

       // return valor;
    }
}
