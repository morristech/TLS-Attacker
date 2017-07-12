/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.workflow.action.executor;

import de.rub.nds.modifiablevariable.util.ArrayConverter;
import de.rub.nds.tlsattacker.core.constants.AlertDescription;
import de.rub.nds.tlsattacker.core.constants.AlertLevel;
import de.rub.nds.tlsattacker.core.protocol.message.AlertMessage;
import de.rub.nds.tlsattacker.core.protocol.message.ProtocolMessage;
import de.rub.nds.tlsattacker.core.record.AbstractRecord;
import de.rub.nds.tlsattacker.core.record.Record;
import de.rub.nds.tlsattacker.core.record.layer.TlsRecordLayer;
import de.rub.nds.tlsattacker.core.unittest.helper.FakeTransportHandler;
import de.rub.nds.modifiablevariable.util.ArrayConverter;
import de.rub.nds.tlsattacker.core.constants.ProtocolVersion;
import de.rub.nds.tlsattacker.core.workflow.TlsContext;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class DefaultActionExecutorTest {
    private static final Logger LOGGER = LogManager.getLogger(DefaultActionExecutorTest.class);

    private TlsContext context;
    private DefaultActionExecutor executor;
    private AlertMessage message;
    private Record record;

    @Before
    public void setUp() {
        context = new TlsContext();
        context.setTransportHandler(new FakeTransportHandler());
        context.setRecordLayer(new TlsRecordLayer(context));
        executor = new DefaultActionExecutor(context);
        message = new AlertMessage(context.getConfig());
        message.setConfig(AlertLevel.FATAL, AlertDescription.DECRYPT_ERROR);
        message.setDescription(AlertDescription.DECRYPT_ERROR.getValue());
        message.setLevel(AlertLevel.FATAL.getValue());
        record = new Record();
        record.setMaxRecordLengthConfig(32000);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sendMessages method, of class DefaultActionExecutor.
     */
    @Test
    public void testSendMessages() {
        context.setSelectedProtocolVersion(ProtocolVersion.TLS12);
        List<ProtocolMessage> protocolMessages = new LinkedList<>();
        protocolMessages.add(message);
        List<AbstractRecord> records = new LinkedList<>();
        records.add(record);
        executor.sendMessages(protocolMessages, records);
        byte[] sendByte = ((FakeTransportHandler) context.getTransportHandler()).getSendByte();
        LOGGER.info(ArrayConverter.bytesToHexString(sendByte));
        assertArrayEquals(new byte[] { 21, 03, 03, 00, 02, 02, 51 }, sendByte);
    }

    /**
     * Test of receiveMessages method, of class DefaultActionExecutor.
     */
    @Test
    public void testReceiveMessages() {
        ((FakeTransportHandler) context.getTransportHandler())
                .setFetchableByte(new byte[] { 21, 03, 03, 00, 02, 02, 51 });
        List<ProtocolMessage> shouldReceive = new LinkedList<>();
        shouldReceive.add(message);
        MessageActionResult result = executor.receiveMessages(shouldReceive);
        assertEquals(result.getMessageList().get(0), message);
    }

}
