package com.example.sadatech.volleylibrary.dbhelper;

/**
 * Created by Toshiba-PC on 8/9/2016.
 */
public class Model {
    String key,value;

    public Model(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Model() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
