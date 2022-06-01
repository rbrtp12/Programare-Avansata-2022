package ro.info.uaic;

import java.io.File;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        File classFile = new File(path);

        tryout(classFile);
    }

    public static void tryout(File classFile) {


        Random random = new Random();
        /**
         * check if the path is a file or folder
         */
        if (classFile.isFile() && !isFolder(classFile)) {
            System.out.println("\nFile: ");

            /**
             * get class name
             */
            String className = classFile.getName();
            className = className.split("\\.")[0];

            /**
             * construct package name
             */
            classFile = classFile.getParentFile();
            StringBuilder packageName = new StringBuilder(classFile.getName());
            classFile = classFile.getParentFile();

            boolean isFound = false;
            Class clazz = null;

            while (!isFound) {

                /**
                 * check path recursively until we can load a .class
                 */
                try {
                    URL url = classFile.toURI().toURL();
                    URL[] urls = new URL[]{url};

                    ClassLoader loader = new URLClassLoader(urls);
                    clazz = loader.loadClass(packageName + "." + className);

                    isFound = true;
                } catch (MalformedURLException | ClassNotFoundException | NoClassDefFoundError e) {
                    isFound = false;

                    packageName.insert(0, classFile.getName() + ".");
                    classFile = classFile.getParentFile();
                }
            }
            if (isFound) printClassDetails(clazz);
            else {
                System.out.println("Class hasn't been loaded");
                return;
            }

            /**
             * get all methods of the found class
             */
            Method[] methods = clazz.getDeclaredMethods();
            int passed = 0, failed = 0;


            for (Method method : methods) {

                Annotation[] annotations = method.getAnnotations();


                /**
                 * check if @Test, static and 0 params
                 */
                for (Annotation annotation : annotations) {

                    if (annotation instanceof Test && method.getParameterCount() == 0 && Modifier.isStatic(method.getModifiers())) {
                        Object obj = null;
                        try {
                            method.invoke(null);
                            System.out.println("Test " + method + " passed.");
                            passed++;
                        } catch (Exception e) {
                            System.out.println("Test " + method + " failed.");
                            failed++;
                        }
                    } else if (annotation instanceof Test && method.getParameterCount() > 0) {

                        ArrayList<Integer> mockParameters = new ArrayList<>();

                        Parameter[] parameters = method.getParameters();
                        for (Parameter parameter : parameters) {
                            if (!parameter.getType().getName().equals("int")) {
                                break;
                            } else {
                                mockParameters.add(random.nextInt(2));
                            }
                        }

                        try {
                            method.invoke(null, mockParameters.toArray());
                            System.out.println("Test " + method + " passed.");
                            passed++;
                        } catch (Exception e) {
                            System.out.println("Test " + method + " failed.");
                            failed++;
                        }
                    }
                }
            }
            if (passed != 0 || failed != 0)
                System.out.println(passed + " tests have passed and " + failed + " have failed.");

        } else if (isFolder(classFile)) {
            System.out.println("Folder: ");

            File[] files = classFile.listFiles();

            for (File file : files) {
                tryout(file);
            }
        } else {
            System.out.println("Nush ce e asta serifule");
        }

    }

    public static void printClassDetails(Class clazz) {

        System.out.print("Compiled from: ");
        System.out.println(clazz.getName());

        System.out.print("Package name: ");
        System.out.println(clazz.getPackageName());

        System.out.print("Class fields: ");
        System.out.println(Arrays.toString(clazz.getDeclaredFields()));

        Method[] methods = clazz.getDeclaredMethods();

        System.out.print("Class methods: ");
        for (Method method : methods) {
            System.out.print(method + " ");
        }
        System.out.println("");
    }

    public static boolean isFolder(File file) {

        if (file.getName().split("\\.").length == 2) return false;

        return true;

    }

    @Test
    public static void divideTest(int a, int b) {
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divided by zero!");
        }
    }

}
