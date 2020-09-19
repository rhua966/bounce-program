import java.lang.reflect.*;
import java.util.*;
class HelperTest {
public static void checkForField(String className, String[] expected, int status, String statusName) throws ClassNotFoundException, NoSuchFieldException {
  Class<?> classToBeCheck = Class.forName(className);
  for (String name: expected) {
    Field f = classToBeCheck.getDeclaredField(name);
    if ( (f.getModifiers()& status) != status)
      System.out.printf("'%s' must be declared as %s.\n", name, statusName);
  }
}
public static void checkForMethod(String className, String[] expected, int status, String statusName) throws ClassNotFoundException, NoSuchMethodException {
  Class <?> classToBeCheck = Class.forName(className);
  for (String name: expected) {
    Method m = classToBeCheck.getDeclaredMethod(name);
    if ((m.getModifiers() & status)  != status)
      System.out.printf("'%s' method must be declared as %s.\n", name, statusName);
  }
}
public static void checkForExpectedMethod(String className, String[] expected) throws ClassNotFoundException {
  Class<?> classToBeCheck = Class.forName(className);
   Method[] list = classToBeCheck.getDeclaredMethods();
   ArrayList<String> methods = new ArrayList<String>();
   for (Method f: list) methods.add(f.getName());
   for (String name: expected) {
     if (!(methods.contains(name)))
 	   System.out.printf("You should implement the '%s' method in the '%s' class.\n", name, className);
 	}
 }

public static void checkForUnExpectedMethod(String className, String[] unexpected) throws ClassNotFoundException {
  Class<?> classToBeCheck = Class.forName(className);
  Method[] list = classToBeCheck.getDeclaredMethods();
  ArrayList<String> methods = new ArrayList<String>();
  for (Method f: list) methods.add(f.getName());
  for (String name: unexpected) {
    if (methods.contains(name))
      System.out.printf("You should NOT implement the '%s' method in the '%s' class.\n", name, className);
  }
}

public static void checkForInterface(String className) throws ClassNotFoundException {
  Class <?> classToBeCheck = Class.forName(className);
  if (!classToBeCheck.isInterface())
    System.out.printf("'%s' must be an interface.\n", className);
}
}