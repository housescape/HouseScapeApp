package pl.sda.housescape.steps;

public class Image {
    private String name;
    private String url;

    public Image(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
