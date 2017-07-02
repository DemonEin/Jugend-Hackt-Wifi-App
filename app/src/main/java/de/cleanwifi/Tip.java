package de.cleanwifi;



public class Tip {
    private String title;
    private String message;
    private int index;


    public Tip setTitle(String title) {
        this.title = title;
        return this;
    }
    public String getTitle() {
        return this.title;
    }

    public Tip(String title, String message, int index) {
        this.title = title;
        this.message = message;
        this.index = index;
    }

    public Tip setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }


    public Tip setIndex(int index) {
        this.index = index;
        return this;
    }
    public int getIndex() {
        return this.index;
    }

}
