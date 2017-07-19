package anki.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by leamsiollaid on 12/07/2017.
 */
public class Properties {
    private String fichier;
    private String key;

    public Properties(String f){
        this.fichier=f;
    }

    public Properties(String key, String fichier) {
        this.key = key;
        this.fichier = fichier;
    }

    public String [] read(String key,String sep){
        java.util.Properties p = new java.util.Properties();
        try {
            p.load(new FileInputStream(this.fichier));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  p.getProperty(key).split(sep);
    }

    public String [] read(String sep){
        java.util.Properties p = new java.util.Properties();
        try {
            p.load(new FileInputStream(this.fichier));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  p.getProperty(this.key).split(sep);
    }

    public void write(String key, String valeur){
        java.util.Properties config = new java.util.Properties();
        FileInputStream fis = null;
        try {
            config = new java.util.Properties();
            fis = new FileInputStream(this.fichier);
            config.load(fis);
            String tmp=config.getProperty(key);
            fis.close();
            FileOutputStream fos = new FileOutputStream(this.fichier);
            if(!tmp.equals("")) tmp+=":";
            config.setProperty(key, tmp +valeur);
            config.store(fos, "Derniere mise a jour :");
            fos.close();

            fos = null;
            fis = null;
            config = null;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(String valeur){
        java.util.Properties config = new java.util.Properties();
        FileInputStream fis = null;
        try {
            config = new java.util.Properties();
            fis = new FileInputStream(this.fichier);
            config.load(fis);
            String tmp=config.getProperty(this.key);
            fis.close();
            FileOutputStream fos = new FileOutputStream(this.fichier);
            if(!tmp.equals("")) tmp+=":";
            config.setProperty(this.key, tmp +valeur);
            config.store(fos, "Derniere mise a jour :");
            fos.close();

            fos = null;
            fis = null;
            config = null;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
