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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_TARIFF_CONFIG</b> version <b>1</b>.<br>
 * <p>
 * Command Class Tariff Config<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassTariffConfigV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassTariffConfigV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_TARIFF_CONFIG
     */
    public final static int COMMAND_CLASS_KEY = 0x4A;

    /**
     * Tariff Tbl Supplier Set Command Constant
     */
    public final static int TARIFF_TBL_SUPPLIER_SET = 0x01;
    /**
     * Tariff Tbl Set Command Constant
     */
    public final static int TARIFF_TBL_SET = 0x02;
    /**
     * Tariff Tbl Remove Command Constant
     */
    public final static int TARIFF_TBL_REMOVE = 0x03;

    /**
     * Creates a new message with the TARIFF_TBL_SUPPLIER_SET command.<br>
     * <p>
     * Tariff Tbl Supplier Set<br>
     *
     * @param year {@link Integer}
     * @param month {@link Integer}
     * @param day {@link Integer}
     * @param hourLocalTime {@link Integer}
     * @param minuteLocalTime {@link Integer}
     * @param secondLocalTime {@link Integer}
     * @param standingChargePeriod {@link Integer}
     * @param standingChargePrecision {@link Integer}
     * @param standingChargeValue {@link Long}
     * @param numberOfSupplierCharacters {@link Integer}
     * @param supplierCharacter {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTariffTblSupplierSet(Integer year, Integer month, Integer day, Integer hourLocalTime,
            Integer minuteLocalTime, Integer secondLocalTime, Integer standingChargePeriod,
            Integer standingChargePrecision, Long standingChargeValue, Integer numberOfSupplierCharacters,
            byte[] supplierCharacter) {
        logger.debug("Creating command message TARIFF_TBL_SUPPLIER_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TARIFF_TBL_SUPPLIER_SET);

        // Process 'Year'
        outputData.write((year >> 8) & 0xff);
        outputData.write(year & 0xff);

        // Process 'Month'
        outputData.write(month);

        // Process 'Day'
        outputData.write(day);

        // Process 'Hour Local Time'
        outputData.write(hourLocalTime);

        // Process 'Minute Local Time'
        outputData.write(minuteLocalTime);

        // Process 'Second Local Time'
        outputData.write(secondLocalTime);

        // Process 'Currency'

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= standingChargePeriod & 0x1F;
        valProperties1 |= ((standingChargePrecision << 5) & 0xE0);
        outputData.write(valProperties1);

        // Process 'Standing Charge Value'
        outputData.write((byte) ((standingChargeValue >> 24) & 0xff));
        outputData.write((byte) ((standingChargeValue >> 16) & 0xff));
        outputData.write((byte) ((standingChargeValue >> 8) & 0xff));
        outputData.write((byte) (standingChargeValue & 0xff));

        // Process 'Properties2'
        outputData.write(numberOfSupplierCharacters & 0x1F);

        // Process 'Supplier Character'
        try {
            outputData.write(supplierCharacter);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TARIFF_TBL_SUPPLIER_SET command<br>
     * <p>
     * Tariff Tbl Supplier Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>YEAR {@link Integer}
     * <li>MONTH {@link Integer}
     * <li>DAY {@link Integer}
     * <li>HOUR_LOCAL_TIME {@link Integer}
     * <li>MINUTE_LOCAL_TIME {@link Integer}
     * <li>SECOND_LOCAL_TIME {@link Integer}
     * <li>STANDING_CHARGE_PERIOD {@link Integer}
     * <li>STANDING_CHARGE_PRECISION {@link Integer}
     * <li>STANDING_CHARGE_VALUE {@link Long}
     * <li>NUMBER_OF_SUPPLIER_CHARACTERS {@link Integer}
     * <li>SUPPLIER_CHARACTER {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTariffTblSupplierSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Year'
        response.put("YEAR", Integer.valueOf(((payload[msgOffset] & 0xff) << 8) + (payload[msgOffset + 1] & 0xff)));
        msgOffset += 2;

        // Process 'Month'
        response.put("MONTH", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Day'
        response.put("DAY", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Hour Local Time'
        response.put("HOUR_LOCAL_TIME", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Minute Local Time'
        response.put("MINUTE_LOCAL_TIME", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Second Local Time'
        response.put("SECOND_LOCAL_TIME", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Currency'
        msgOffset += 3;

        // Process 'Properties1'
        response.put("STANDING_CHARGE_PERIOD", Integer.valueOf(payload[msgOffset] & 0x1F));
        response.put("STANDING_CHARGE_PRECISION", Integer.valueOf((payload[msgOffset] & 0xE0 >> 5)));
        msgOffset += 1;

        // Process 'Standing Charge Value'
        response.put("STANDING_CHARGE_VALUE", Long.valueOf((payload[msgOffset] << 24) + (payload[msgOffset + 1] << 16) + (payload[msgOffset + 2] << 8) + payload[msgOffset + 3]));
        msgOffset += 4;

        // Process 'Properties2'
        response.put("NUMBER_OF_SUPPLIER_CHARACTERS", Integer.valueOf(payload[msgOffset] & 0x1F));
        msgOffset += 1;

        // Process 'Supplier Character'
        int valSupplierCharacter = 0;
        int lenSupplierCharacter = payload[3] & 0x1F;
        for (int cntSupplierCharacter = 0; cntSupplierCharacter < lenSupplierCharacter; cntSupplierCharacter++) {
            valSupplierCharacter = (valSupplierCharacter << 8) + payload[msgOffset + cntSupplierCharacter];
        }
        response.put("SUPPLIER_CHARACTER", valSupplierCharacter);
        msgOffset += lenSupplierCharacter;

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the TARIFF_TBL_SET command.<br>
     * <p>
     * Tariff Tbl Set<br>
     *
     * @param rateParameterSetId {@link Integer}
     * @param tariffPrecision {@link Integer}
     * @param tariffValue {@link Long}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTariffTblSet(Integer rateParameterSetId, Integer tariffPrecision, Long tariffValue) {
        logger.debug("Creating command message TARIFF_TBL_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TARIFF_TBL_SET);

        // Process 'Rate Parameter Set ID'
        outputData.write(rateParameterSetId);

        // Process 'Properties1'
        outputData.write(((tariffPrecision << 5) & 0xE0));

        // Process 'Tariff Value'
        outputData.write((byte) ((tariffValue >> 24) & 0xff));
        outputData.write((byte) ((tariffValue >> 16) & 0xff));
        outputData.write((byte) ((tariffValue >> 8) & 0xff));
        outputData.write((byte) (tariffValue & 0xff));

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TARIFF_TBL_SET command<br>
     * <p>
     * Tariff Tbl Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>RATE_PARAMETER_SET_ID {@link Integer}
     * <li>TARIFF_PRECISION {@link Integer}
     * <li>TARIFF_VALUE {@link Long}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTariffTblSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Rate Parameter Set ID'
        response.put("RATE_PARAMETER_SET_ID", Integer.valueOf(payload[2]));

        // Process 'Properties1'
        response.put("TARIFF_PRECISION", Integer.valueOf((payload[3] & 0xE0 >> 5)));

        // Process 'Tariff Value'
        response.put("TARIFF_VALUE", Long.valueOf((payload[4] << 24) + (payload[5] << 16) + (payload[6] << 8) + payload[7]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the TARIFF_TBL_REMOVE command.<br>
     * <p>
     * Tariff Tbl Remove<br>
     *
     * @param rateParameterSetIds {@link Integer}
     * @param rateParameterSetId {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTariffTblRemove(Integer rateParameterSetIds, byte[] rateParameterSetId) {
        logger.debug("Creating command message TARIFF_TBL_REMOVE version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TARIFF_TBL_REMOVE);

        // Process 'Properties1'
        outputData.write(rateParameterSetIds & 0x3F);

        // Process 'Rate Parameter Set ID'
        try {
            outputData.write(rateParameterSetId);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TARIFF_TBL_REMOVE command<br>
     * <p>
     * Tariff Tbl Remove<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>RATE_PARAMETER_SET_IDS {@link Integer}
     * <li>RATE_PARAMETER_SET_ID {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTariffTblRemove(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("RATE_PARAMETER_SET_IDS", Integer.valueOf(payload[msgOffset] & 0x3F));
        msgOffset += 1;

        // Process 'Rate Parameter Set ID'
        response.put("RATE_PARAMETER_SET_ID", Integer.valueOf(payload[msgOffset]));
        msgOffset += payload[msgOffset - 1];

        // Return the map of processed response data;
        return response;
    }

}
