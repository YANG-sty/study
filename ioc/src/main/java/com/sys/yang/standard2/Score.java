package com.sys.yang.standard2;

/**
 * @author yangLongFei 2020-12-24-16:52
 */
public class Score {
    private String type;
    private char level;

    public Score() {
    }

    public Score(String type, char level) {
        this.type = type;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Score{" +
                "type='" + type + '\'' +
                ", level=" + level +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(char level) {
        this.level = level;
    }
}
