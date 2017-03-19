/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_ANTITHEFT</b> version <b>1</b>.<br>
 * <p>
 * Command Class Anti-theft<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassAntitheftV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassAntitheftV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_ANTITHEFT
     */
    public final static int COMMAND_CLASS_KEY = 0x5D;

    /**
     * Anti-theft Set Command Constant
     */
    public final static int ANTITHEFT_SET = 0x01;
    /**
     * Anti-theft Get Command Constant
     */
    public final static int ANTITHEFT_GET = 0x02;
    /**
     * Anti-theft Report Command Constant
     */
    public final static int ANTITHEFT_REPORT = 0x03;

    /**
     * Creates a new message with the ANTITHEFT_SET command.<br>
     * <p>
     * Anti-theft Set<br>
     *
     * @param numberOfMagicCodeBytes {@link Integer}
     * @param enable {@link Boolean}
     * @param magicCode {@link byte[]}
     * @param manufacturerId {@link Integer}
     * @param antiTheftHintNumberBytes {@link Integer}
     * @param antiTheftHintByte {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAntitheftSet(Integer numberOfMagicCodeBytes, Boolean enable, byte[] magicCode,
            Integer manufacturerId, Integer antiTheftHintNumberBytes, byte[] antiTheftHintByte) {
        logger.debug("Creating command message ANTITHEFT_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ANTITHEFT_SET);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= numberOfMagicCodeBytes & 0x7F;
        valProperties1 |= enable ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Magic Code'
        try {
            outputData.write(magicCode);
        } catch (IOException e) {
        }

        // Process 'Manufacturer ID'
        outputData.write((manufacturerId >> 8) & 0xff);
        outputData.write(manufacturerId & 0xff);

        // Process 'Anti-theft Hint Number Bytes'
        outputData.write(antiTheftHintNumberBytes);

        // Process 'Anti-theft Hint Byte'
        try {
            outputData.write(antiTheftHintByte);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ANTITHEFT_SET command<br>
     * <p>
     * Anti-theft Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>NUMBER_OF_MAGIC_CODE_BYTES {@link Integer}
     * <li>ENABLE {@link Boolean}
     * <li>MAGIC_CODE {@link byte[]}
     * <li>MANUFACTURER_ID {@link Integer}
     * <li>ANTI_THEFT_HINT_NUMBER_BYTES {@link Integer}
     * <li>ANTI_THEFT_HINT_BYTE {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAntitheftSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("NUMBER_OF_MAGIC_CODE_BYTES", Integer.valueOf(payload[msgOffset] & 0x7F));
        response.put("ENABLE", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Magic Code'
        response.put("MAGIC_CODE", Integer.valueOf(payload[msgOffset]));
        msgOffset += payload[msgOffset - 1];

        // Process 'Manufacturer ID'
        response.put("MANUFACTURER_ID", Integer.valueOf(((payload[msgOffset] & 0xff) << 8) + (payload[msgOffset + 1] & 0xff)));
        msgOffset += 2;

        // Process 'Anti-theft Hint Number Bytes'
        response.put("ANTI_THEFT_HINT_NUMBER_BYTES", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Anti-theft Hint Byte'
        int valAntiTheftHintByte = 0;
        int lenAntiTheftHintByte = payload[3];
        for (int cntAntiTheftHintByte = 0; cntAntiTheftHintByte < lenAntiTheftHintByte; cntAntiTheftHintByte++) {
            valAntiTheftHintByte = (valAntiTheftHintByte << 8) + payload[msgOffset + cntAntiTheftHintByte];
        }
        response.put("ANTI_THEFT_HINT_BYTE", valAntiTheftHintByte);
        msgOffset += lenAntiTheftHintByte;

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ANTITHEFT_GET command.<br>
     * <p>
     * Anti-theft Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAntitheftGet() {
        logger.debug("Creating command message ANTITHEFT_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ANTITHEFT_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ANTITHEFT_GET command<br>
     * <p>
     * Anti-theft Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAntitheftGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ANTITHEFT_REPORT command.<br>
     * <p>
     * Anti-theft Report<br>
     *
     * @param antiTheftProtectionStatus {@link Integer}
     * @param manufacturerId {@link Integer}
     * @param antiTheftHintNumberBytes {@link Integer}
     * @param antiTheftHintByte {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAntitheftReport(Integer antiTheftProtectionStatus, Integer manufacturerId,
            Integer antiTheftHintNumberBytes, byte[] antiTheftHintByte) {
        logger.debug("Creating command message ANTITHEFT_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ANTITHEFT_REPORT);

        // Process 'Anti-theft Protection Status'
        outputData.write(antiTheftProtectionStatus);

        // Process 'Manufacturer ID'
        outputData.write((manufacturerId >> 8) & 0xff);
        outputData.write(manufacturerId & 0xff);

        // Process 'Anti-theft Hint Number Bytes'
        outputData.write(antiTheftHintNumberBytes);

        // Process 'Anti-theft Hint Byte'
        try {
            outputData.write(antiTheftHintByte);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ANTITHEFT_REPORT command<br>
     * <p>
     * Anti-theft Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ANTI_THEFT_PROTECTION_STATUS {@link Integer}
     * <li>MANUFACTURER_ID {@link Integer}
     * <li>ANTI_THEFT_HINT_NUMBER_BYTES {@link Integer}
     * <li>ANTI_THEFT_HINT_BYTE {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAntitheftReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Anti-theft Protection Status'
        response.put("ANTI_THEFT_PROTECTION_STATUS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Manufacturer ID'
        response.put("MANUFACTURER_ID", Integer.valueOf(((payload[msgOffset] & 0xff) << 8) + (payload[msgOffset + 1] & 0xff)));
        msgOffset += 2;

        // Process 'Anti-theft Hint Number Bytes'
        response.put("ANTI_THEFT_HINT_NUMBER_BYTES", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Anti-theft Hint Byte'
        int valAntiTheftHintByte = 0;
        int lenAntiTheftHintByte = payload[3];
        for (int cntAntiTheftHintByte = 0; cntAntiTheftHintByte < lenAntiTheftHintByte; cntAntiTheftHintByte++) {
            valAntiTheftHintByte = (valAntiTheftHintByte << 8) + payload[msgOffset + cntAntiTheftHintByte];
        }
        response.put("ANTI_THEFT_HINT_BYTE", valAntiTheftHintByte);
        msgOffset += lenAntiTheftHintByte;

        // Return the map of processed response data;
        return response;
    }

}
