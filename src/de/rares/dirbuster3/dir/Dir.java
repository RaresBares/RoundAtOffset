package de.rares.dirbuster3.dir;

import java.util.ArrayList;

public class Dir {
    public ArrayList<Dir> childs;
    public String name;
    public Dir parent;
    public Dir(String name) {
        this.name = name;
    }
    public boolean hasParent(){
        if(parent != null){
            return true;
        }else {
            return false;
        }
    }
}
