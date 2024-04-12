package Weather.core.base;

public abstract class Token {
    protected String token;

    public String getToken() {
        return this.token;
    }

    protected abstract void setToken();
}
