/**
 * The abstract class Token represents a token used for authentication or authorization purposes.
 * This class serves as a base class for specific token implementations.
 */
package Weather.core.abstraction;

public abstract class Token {

    /** The token string. */
    protected String token;

    /**
     * Retrieves the token string.
     *
     * @return the token string
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Sets the token string.
     * This method must be implemented by subclasses to set the token value appropriately.
     */
    protected abstract void setToken();
}
