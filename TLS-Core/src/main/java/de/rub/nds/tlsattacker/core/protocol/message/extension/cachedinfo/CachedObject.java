/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.protocol.message.extension.cachedinfo;

import de.rub.nds.modifiablevariable.ModifiableVariableFactory;
import de.rub.nds.modifiablevariable.ModifiableVariableProperty;
import de.rub.nds.modifiablevariable.bool.ModifiableBoolean;
import de.rub.nds.modifiablevariable.bytearray.ModifiableByteArray;
import de.rub.nds.modifiablevariable.integer.ModifiableInteger;
import de.rub.nds.modifiablevariable.singlebyte.ModifiableByte;
import de.rub.nds.tlsattacker.core.protocol.ModifiableVariableHolder;
import java.io.Serializable;

/**
 *
 * @author Matthias Terlinde <matthias.terlinde@rub.de>
 */
public class CachedObject extends ModifiableVariableHolder implements Serializable {

    @ModifiableVariableProperty
    private ModifiableBoolean isClientState;
    @ModifiableVariableProperty
    private ModifiableByte cachedInformationType;
    @ModifiableVariableProperty
    // Hash Value Length 1 Byte
    private ModifiableInteger hashValueLength;
    @ModifiableVariableProperty
    private ModifiableByteArray hashValue;

    public CachedObject(boolean isClientState, byte cachedInformationType, Integer hashValueLength, byte[] hashValue) {
        this.isClientState = ModifiableVariableFactory.safelySetValue(this.isClientState, isClientState);
        this.cachedInformationType = ModifiableVariableFactory.safelySetValue(this.cachedInformationType,
                cachedInformationType);
        this.hashValueLength = ModifiableVariableFactory.safelySetValue(this.hashValueLength, hashValueLength);
        this.hashValue = ModifiableVariableFactory.safelySetValue(this.hashValue, hashValue);
    }

    public CachedObject() {
    }

    public ModifiableBoolean getIsClientState() {
        return isClientState;
    }

    public void setIsClientState(ModifiableBoolean isClientState) {
        this.isClientState = isClientState;
    }

    public void setIsClientState(boolean isClientState) {
        this.isClientState = ModifiableVariableFactory.safelySetValue(this.isClientState, isClientState);
    }

    public ModifiableByte getCachedInformationType() {
        return cachedInformationType;
    }

    public void setCachedInformationType(ModifiableByte cachedInformationType) {
        this.cachedInformationType = cachedInformationType;
    }

    public void setCachedInformationType(byte cachedInformationType) {
        this.cachedInformationType = ModifiableVariableFactory.safelySetValue(this.cachedInformationType,
                cachedInformationType);
    }

    public ModifiableInteger getHashValueLength() {
        return hashValueLength;
    }

    public void setHashValueLength(ModifiableInteger hashValueLength) {
        this.hashValueLength = hashValueLength;
    }

    public void setHashValueLength(int hashValueLength) {
        this.hashValueLength = ModifiableVariableFactory.safelySetValue(this.hashValueLength, hashValueLength);
    }

    public ModifiableByteArray getHashValue() {
        return hashValue;
    }

    public void setHashValue(ModifiableByteArray hashValue) {
        this.hashValue = hashValue;
    }

    public void setHashValue(byte[] hashValue) {
        this.hashValue = ModifiableVariableFactory.safelySetValue(this.hashValue, hashValue);
    }

}
