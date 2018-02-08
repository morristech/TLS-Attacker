/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.protocol.message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pierre Tilhaus
 */
public class PskEcDheServerKeyExchangeMessageTest {

    PskEcDheServerKeyExchangeMessage message;

    @Before
    public void setUp() {
        message = new PskEcDheServerKeyExchangeMessage();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class PskEcDheServerKeyExchangeMessage.
     */
    @Test
    public void testToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPskEcDheServerKeyExchangeMessage:");
        sb.append("\n  Curve Type: ").append("null");
        sb.append("\n  Named Curve: ").append("null");
        sb.append("\n  Public Key: ").append("null");

        assertEquals(message.toString(), sb.toString());
    }

}
