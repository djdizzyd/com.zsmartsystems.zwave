/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_METER</b> version <b>1</b>.<br>
 *
 * Command Class Meter<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassMeterV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassMeterV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_METER
     */
    public final static int COMMAND_CLASS_KEY = 0x32;

    /**
     * Meter Get Command Constant
     */
    public final static int METER_GET = 0x01;
    /**
     * Meter Report Command Constant
     */
    public final static int METER_REPORT = 0x02;

    /**
     * Creates a new message with the METER_GET command.<br>
     *
     * Meter Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterGet() {
        logger.debug("Creating command message METER_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_GET command<br>
     *
     * Meter Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the METER_REPORT command.<br>
     *
     * Meter Report<br>
     *
     *
     * @param meterType {@link String}
     * @param size {@link Integer}
     * @param scale {@link Integer}
     * @param precision {@link Integer}
     * @param meterValue {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterReport(String meterType, Integer size, Integer scale, Integer precision,
            byte[] meterValue) {
        logger.debug("Creating command message METER_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_REPORT);

        // Process 'Meter Type'
        switch (meterType) {
            case "ELECTRIC_METER":
                outputData.write(0x01);
                break;
            case "GAS_METER":
                outputData.write(0x02);
                break;
            case "WATER_METER":
                outputData.write(0x03);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for meterType: " + meterType);
        }

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= size & 0x07;
        valProperties1 |= ((scale << 3) & 0x18);
        valProperties1 |= ((precision << 5) & 0xE0);
        outputData.write(valProperties1);

        // Process 'Meter Value'
        try {
            outputData.write(meterValue);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_REPORT command<br>
     *
     * Meter Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>METER_TYPE {@link String}
     * <li>SIZE {@link Integer}
     * <li>SCALE {@link Integer}
     * <li>PRECISION {@link Integer}
     * <li>METER_VALUE {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Meter Type'
        switch ((int) payload[msgOffset]) {
            case (byte) 0x01:
                response.put("METER_TYPE", "ELECTRIC_METER");
                break;
            case (byte) 0x02:
                response.put("METER_TYPE", "GAS_METER");
                break;
            case (byte) 0x03:
                response.put("METER_TYPE", "WATER_METER");
                break;
            default:
                logger.debug("Unknown value {} for constant 'METER_TYPE'", String.format("%02X", payload[msgOffset]));
                response.put("METER_TYPE", "UNKNOWN_" + String.format("%02X", payload[msgOffset]));
                break;
        }
        msgOffset += 1;

        // Process 'Properties1'
        response.put("SIZE", Integer.valueOf(payload[msgOffset] & 0x07));
        response.put("SCALE", Integer.valueOf((payload[msgOffset] & 0x18 >> 3)));
        response.put("PRECISION", Integer.valueOf((payload[msgOffset] & 0xE0 >> 5)));
        msgOffset += 1;

        // Process 'Meter Value'
        int valMeterValue = 0;
        int lenMeterValue = payload[msgOffset - 1] & 0x07;
        for (int cntMeterValue = 0; cntMeterValue < lenMeterValue; cntMeterValue++) {
            valMeterValue = (valMeterValue << 8) + payload[msgOffset + cntMeterValue];
        }
        response.put("METER_VALUE", valMeterValue);
        msgOffset += lenMeterValue;

        // Return the map of processed response data;
        return response;
    }

}