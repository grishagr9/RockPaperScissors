package org.example.classloader.ring;

import org.example.classloader.api.PlaybleRockPaperScissors;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MainRingApplication {

    public static void main(String[] args) {

    }

    /**
     *
     * @return get list plugin-classes
     */
    private PlaybleRockPaperScissors getPlugins(){
        File[] jars = getPluginFiles();

        Class[] pluginClasses = new Class[jars.length];
        for (int i = 0; i < jars.length; i++) {
            try {
                URL jarURL  = jars[i].toURI().toURL();
                URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL});
                pluginClasses[i] = classLoader.loadClass("");
            }catch (MalformedURLException | ClassNotFoundException e1){
                System.out.println(e1.getMessage());
            }
        }

         return null;
    }

    /**
     *
     * @return array of file-plugins from dir plugins
     */
    private File[] getPluginFiles(){
        File pluginDir = new File("plugins");

        return pluginDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".jar");
            }
        });
    }
}
