package com.example.exercicerecipe.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Root implements Serializable {
    public String q;
    public int from;
    //@JsonProperty("to")
    public int myto;
    public boolean more;
    public int count;
    public ArrayList<Hit> hits;

    public Root(String q, int from, int myto, boolean more, int count, ArrayList<Hit> hits) {
        this.q = q;
        this.from = from;
        this.myto = myto;
        this.more = more;
        this.count = count;
        this.hits = hits;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getMyto() {
        return myto;
    }

    public void setMyto(int myto) {
        this.myto = myto;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Hit> getHits() {
        return hits;
    }

    public void setHits(ArrayList<Hit> hits) {
        this.hits = hits;
    }
}
