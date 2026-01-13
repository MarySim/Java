import java.lang.reflect.Method;

public class Invoker {
    public static void invokeAnnotatedMethods() {
        MyClass myClass = new MyClass();
        Method[] methods = MyClass.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Repeat.class)) {
                Repeat repeat = method.getAnnotation(Repeat.class);
                method.setAccessible(true);

                System.out.println("Метод: " + method.getName() +
                        ", вызовов: " + repeat.times());

                for (int i = 0; i < repeat.times(); i++) {
                    try {
                        Class<?>[] paramTypes = method.getParameterTypes();
                        Object[] parameters = new Object[paramTypes.length];

                        for (int j = 0; j < paramTypes.length; j++) {
                            if (paramTypes[j] == String.class) {
                                parameters[j] = "тест" + (i + 1);
                            } else if (paramTypes[j] == int.class) {
                                parameters[j] = i + 1;
                            }
                        }

                        method.invoke(myClass, parameters);

                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }
                System.out.println("---");
            }
        }
    }
}