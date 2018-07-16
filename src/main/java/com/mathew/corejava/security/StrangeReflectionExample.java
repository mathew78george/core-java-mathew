package com.mathew.corejava.security;

import java.lang.reflect.Field;

public class StrangeReflectionExample {

  public Character aCharacter;

  public static void main(String[] args) {
    StrangeReflectionExample instance = new StrangeReflectionExample();
    try {
      Field field = StrangeReflectionExample.class.getField("aCharacter");
      Field type = Field.class.getDeclaredField("type");
      type.setAccessible(true);
      type.set(field, String.class);
      field.set(instance, 'A');
    } catch(NoSuchFieldException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch(SecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
