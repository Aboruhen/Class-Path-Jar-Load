package uberuse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException, InterruptedException {

        System.out.println("Run with guava 10.0");
        JarFile jarFile = new JarFile("uber-jar-1.0-SNAPSHOT.jar");
        Enumeration<JarEntry> e = jarFile.entries();

        URL[] urls = { new URL("jar:file:" + "uber-jar-1.0-SNAPSHOT.jar!/") };
        URLClassLoader cl = URLClassLoader.newInstance(urls, null);
        try {
            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                cl.loadClass(className);
            }
        } catch (Throwable ignore){
        }
        Class<?> uberCheck = cl.loadClass("uberfat.UberMain");
        Object o = uberCheck.newInstance();
        Method method = uberCheck.getDeclaredMethod("stopWatch");
        Object invoke = method.invoke(o);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("elapsed nano:" + invoke);
        System.out.println("guava 10 finished");
    }

}
