/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author usuario
 */
public class ReadWritePropertiesFile {

    public static Properties Read(String file) {
        Properties p = new Properties();
        FileInputStream f = null;
        try {
            f = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            p.load(f);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public static Boolean Write(Properties p, String file) {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            return false;
        }
        try {
            p.store(f, null);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public static String ReadProperty(String file, String property) {
        Properties p = ReadWritePropertiesFile.Read(file);
        try {
            return p.getProperty(property);
        } catch (Exception e) {
            return null;
        }
    }

    public static void WriteProperty(String file, String property, String value) {
        Properties p = ReadWritePropertiesFile.Read(file);
        try {
            p.setProperty(property, value);
            ReadWritePropertiesFile.Write(p, file);
        } catch (Exception e) {

        }
    }
}
