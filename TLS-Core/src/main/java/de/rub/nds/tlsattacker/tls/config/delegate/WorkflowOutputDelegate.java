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
import de.rub.nds.tlsattacker.tls.workflow.TlsConfig;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class WorkflowOutputDelegate extends Delegate {

    @Parameter(names = "-workflow_output", description = "This parameter allows you to serialize the whole workflow trace into a specific XML file")
    private String workflowOutput = null;

    public WorkflowOutputDelegate() {
    }

    public String getWorkflowOutput() {
        return workflowOutput;
    }

    public void setWorkflowOutput(String workflowOutput) {
        this.workflowOutput = workflowOutput;
    }

    @Override
    public void applyDelegate(TlsConfig config) {
        if (workflowOutput != null) {
            config.setWorkflowOutput(workflowOutput);
        }
    }

}
