package com.baeldung.junit5.registerextension;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * This extension is meant to demonstrate the use of RegisterExtension.
 */
public class RegisterExtensionSampleExtension implements BeforeAllCallback, BeforeEachCallback {

    private final String type;

    public RegisterExtensionSampleExtension(String type) {
        this.type = type;
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("Type " + type + " In beforeAll : " + extensionContext.getDisplayName());
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Type " + type + " In beforeEach : " + extensionContext.getDisplayName());
    }

    public String getType() {
        return type;
    }
}
