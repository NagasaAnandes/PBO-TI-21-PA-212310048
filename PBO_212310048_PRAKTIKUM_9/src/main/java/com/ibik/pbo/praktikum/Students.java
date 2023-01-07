package com.ibik.pbo.praktikum;

public class Students {
    private Integer id;
    private String npm;
    private String fullname;
    private String score;

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNpm() {
        return npm;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}