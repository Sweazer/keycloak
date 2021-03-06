package org.keycloak.theme;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public interface Theme {

    public enum Type { LOGIN, ACCOUNT, ADMIN, EMAIL, WELCOME, COMMON };

    public String getName();

    public String getParentName();

    public String getImportName();

    public Type getType();

    public URL getTemplate(String name) throws IOException;

    public InputStream getTemplateAsStream(String name) throws IOException;

    public URL getResource(String path) throws IOException;

    public InputStream getResourceAsStream(String path) throws IOException;

    /**
     * Same as getMessages(baseBundlename, locale), but uses a default baseBundlename
     * such as "messages".
     *
     * @param locale The locale of the desired message bundle.
     * @return The localized messages from the bundle.
     * @throws IOException If bundle can not be read.
     */
    public Properties getMessages(Locale locale) throws IOException;

    /**
     * Retrieve localized messages from a message bundle.
     *
     * @param baseBundlename The base name of the bundle, such as "messages" in
     * messages_en.properties.
     * @param locale The locale of the desired message bundle.
     * @return The localized messages from the bundle.
     * @throws IOException If bundle can not be read.
     */
    public Properties getMessages(String baseBundlename, Locale locale) throws IOException;

    public Properties getProperties() throws IOException;

}
