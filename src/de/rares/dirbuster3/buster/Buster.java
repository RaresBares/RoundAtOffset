package de.rares.dirbuster3.buster;

import de.rares.dirbuster3.DirBuster3;
import de.rares.dirbuster3.dir.Dir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Buster extends Thread {
    File list;
    Dir parent;
    String url;

    public Buster(File list, Dir parent) {
        this.list = list;
        this.parent = parent;
        generateURL();
    }

    private void generateURL() {
        Dir localParent = parent;
        do {
            url = localParent.name + "/" + url;
        }
        while (localParent.hasParent());
        url = DirBuster3.url + "/" + url;
    }
    public boolean test(URL url){
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if(conn.getResponseCode() == 200){
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(list);
            while (scanner.hasNextLine()){
               String  dirnam = scanner.nextLine();
                String localUrl = url + "/"+dirnam;
                if(test(new URL(localUrl))){
                    Dir dir = new Dir(dirnam);
                    parent.childs.add(dir);
                    new Buster(list,new Dir(dirnam)).run();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
