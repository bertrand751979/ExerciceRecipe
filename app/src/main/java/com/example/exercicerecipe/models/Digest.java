package com.example.exercicerecipe.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Digest implements Serializable {
    public String label;
    public String tag;
    public String schemaOrgTag;
    public double total;
    public boolean hasRDI;
    public double daily;
    public String unit;
    public ArrayList<Sub> sub;

    public Digest(String label, String tag, String schemaOrgTag, double total, boolean hasRDI, double daily, String unit, ArrayList<Sub> sub) {
        this.label = label;
        this.tag = tag;
        this.schemaOrgTag = schemaOrgTag;
        this.total = total;
        this.hasRDI = hasRDI;
        this.daily = daily;
        this.unit = unit;
        this.sub = sub;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSchemaOrgTag() {
        return schemaOrgTag;
    }

    public void setSchemaOrgTag(String schemaOrgTag) {
        this.schemaOrgTag = schemaOrgTag;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isHasRDI() {
        return hasRDI;
    }

    public void setHasRDI(boolean hasRDI) {
        this.hasRDI = hasRDI;
    }

    public double getDaily() {
        return daily;
    }

    public void setDaily(double daily) {
        this.daily = daily;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ArrayList<Sub> getSub() {
        return sub;
    }

    public void setSub(ArrayList<Sub> sub) {
        this.sub = sub;
    }
}
