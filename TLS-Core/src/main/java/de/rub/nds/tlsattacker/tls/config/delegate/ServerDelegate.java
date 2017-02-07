/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.config.delegate;

import com.beust.jcommander.Parameter;
import de.rub.nds.tlsattacker.transport.ConnectionEnd;
import de.rub.nds.tlsattacker.tls.workflow.TlsConfig;
import java.io.File;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class ServerDelegate extends Delegate {

    @Parameter(names = "-port", description = "ServerPort")
    // TODO validator
    protected Integer port = null;

    public ServerDelegate() {
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void applyDelegate(TlsConfig config) {
        if (port != null) {
            config.setServerPort(port);
        }
        config.setMyConnectionEnd(ConnectionEnd.SERVER);
    }

}
