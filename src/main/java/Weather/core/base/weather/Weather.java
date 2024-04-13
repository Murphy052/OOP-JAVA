package Weather.core.base.weather;

public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;

    // Getter and setter for 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for 'main'
    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    // Getter and setter for 'description'
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for 'icon'
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
