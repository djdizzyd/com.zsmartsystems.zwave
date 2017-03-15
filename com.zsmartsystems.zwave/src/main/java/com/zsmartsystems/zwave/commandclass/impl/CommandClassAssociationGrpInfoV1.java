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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_ASSOCIATION_GRP_INFO</b> version <b>1</b>.<br>
 *
 * Command Class Association Group Info<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassAssociationGrpInfoV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassAssociationGrpInfoV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_ASSOCIATION_GRP_INFO
     */
    public final static int COMMAND_CLASS_KEY = 0x59;

    /**
     * Association Group Name Get Command Constant
     */
    public final static int ASSOCIATION_GROUP_NAME_GET = 0x01;
    /**
     * Association Group Name Report Command Constant
     */
    public final static int ASSOCIATION_GROUP_NAME_REPORT = 0x02;
    /**
     * Association Group Info Get Command Constant
     */
    public final static int ASSOCIATION_GROUP_INFO_GET = 0x03;
    /**
     * Association Group Info Report Command Constant
     */
    public final static int ASSOCIATION_GROUP_INFO_REPORT = 0x04;
    /**
     * Association Group Command List Get Command Constant
     */
    public final static int ASSOCIATION_GROUP_COMMAND_LIST_GET = 0x05;
    /**
     * Association Group Command List Report Command Constant
     */
    public final static int ASSOCIATION_GROUP_COMMAND_LIST_REPORT = 0x06;

    /**
     * Creates a new message with the ASSOCIATION_GROUP_NAME_GET command.<br>
     *
     * Association Group Name Get<br>
     *
     *
     * @param groupingIdentifier {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAssociationGroupNameGet(Integer groupingIdentifier) {
        logger.debug("Creating command message ASSOCIATION_GROUP_NAME_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ASSOCIATION_GROUP_NAME_GET);

        // Process 'Grouping Identifier'
        outputData.write(groupingIdentifier);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ASSOCIATION_GROUP_NAME_GET command<br>
     *
     * Association Group Name Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAssociationGroupNameGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Grouping Identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ASSOCIATION_GROUP_NAME_REPORT command.<br>
     *
     * Association Group Name Report<br>
     *
     *
     * @param groupingIdentifier {@link Integer}
     * @param lengthOfName {@link Integer}
     * @param name {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAssociationGroupNameReport(Integer groupingIdentifier, Integer lengthOfName, byte[] name) {
        logger.debug("Creating command message ASSOCIATION_GROUP_NAME_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ASSOCIATION_GROUP_NAME_REPORT);

        // Process 'Grouping Identifier'
        outputData.write(groupingIdentifier);

        // Process 'Length of Name'
        outputData.write(lengthOfName);

        // Process 'Name'
        try {
            outputData.write(name);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ASSOCIATION_GROUP_NAME_REPORT command<br>
     *
     * Association Group Name Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * <li>LENGTH_OF_NAME {@link Integer}
     * <li>NAME {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAssociationGroupNameReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Grouping Identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Length of Name'
        response.put("LENGTH_OF_NAME", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Name'
        int valName = 0;
        int lenName = payload[msgOffset - 1];
        for (int cntName = 0; cntName < lenName; cntName++) {
            valName += payload[msgOffset + cntName];
        }
        response.put("NAME", valName);
        msgOffset += lenName;

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ASSOCIATION_GROUP_INFO_GET command.<br>
     *
     * Association Group Info Get<br>
     *
     *
     * @param listMode {@link Boolean}
     * @param refreshCache {@link Boolean}
     * @param groupingIdentifier {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAssociationGroupInfoGet(Boolean listMode, Boolean refreshCache, Integer groupingIdentifier) {
        logger.debug("Creating command message ASSOCIATION_GROUP_INFO_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ASSOCIATION_GROUP_INFO_GET);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= listMode ? 0x40 : 0;
        valProperties1 |= refreshCache ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Grouping Identifier'
        outputData.write(groupingIdentifier);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ASSOCIATION_GROUP_INFO_GET command<br>
     *
     * Association Group Info Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>LIST_MODE {@link Boolean}
     * <li>REFRESH_CACHE {@link Boolean}
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAssociationGroupInfoGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("LIST_MODE", Boolean.valueOf((payload[2] & 0x40) != 0));
        response.put("REFRESH_CACHE", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Grouping Identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ASSOCIATION_GROUP_INFO_REPORT command.<br>
     *
     * Association Group Info Report<br>
     *
     *
     * @param groupCount {@link Integer}
     * @param dynamicInfo {@link Boolean}
     * @param listMode {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAssociationGroupInfoReport(Integer groupCount, Boolean dynamicInfo, Boolean listMode) {
        logger.debug("Creating command message ASSOCIATION_GROUP_INFO_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ASSOCIATION_GROUP_INFO_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= groupCount & 0x3F;
        valProperties1 |= dynamicInfo ? 0x40 : 0;
        valProperties1 |= listMode ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'vg1'

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ASSOCIATION_GROUP_INFO_REPORT command<br>
     *
     * Association Group Info Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>GROUP_COUNT {@link Integer}
     * <li>DYNAMIC_INFO {@link Boolean}
     * <li>LIST_MODE {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAssociationGroupInfoReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("GROUP_COUNT", Integer.valueOf(payload[2] & 0x3F));
        response.put("DYNAMIC_INFO", Boolean.valueOf((payload[2] & 0x40) != 0));
        response.put("LIST_MODE", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'vg1'

        // Create a list to hold the group vg1
        List<Map<String, Object>> variantList = new ArrayList<Map<String, Object>>();

        int offset = 3;
        while (offset < payload.length) {
            // Create a map to hold the members of this variant
            Map<String, Object> variant = new HashMap<String, Object>();

            // Process 'Grouping Identifier'
            variant.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[3]));

            // Process 'Mode'
            variant.put("MODE", Integer.valueOf(payload[4]));

            // Process 'Profile1'
            switch ((int) payload[5]) {
                case (byte) 0x00:
                    variant.put("PROFILE1", "PROFILE_GENERAL");
                    break;
                case (byte) 0x20:
                    variant.put("PROFILE1", "PROFILE_CONTROL");
                    break;
                case (byte) 0x31:
                    variant.put("PROFILE1", "PROFILE_SENSOR");
                    break;
                case (byte) 0x71:
                    variant.put("PROFILE1", "PROFILE_NOTIFICATION");
                    break;
                default:
                    logger.debug("Unknown value {} for constant 'PROFILE1'", String.format("%02X", payload[5]));
                    variant.put("PROFILE1", "UNKNOWN_" + String.format("%02X", payload[5]));
                    break;
            }

            // Process 'Profile2'

            // Process 'Event Code'
            variant.put("EVENT_CODE", Integer.valueOf(payload[8] << 8 + payload[9]));

            // Add to the list
            variantList.add(variant);

            // Add the length of this variant
            offset += (payload[offset + 0] & 0x3F) >> 0;
        }

        // Add the variant list to the response
        response.put("VG1", variantList);

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ASSOCIATION_GROUP_COMMAND_LIST_GET command.<br>
     *
     * Association Group Command List Get<br>
     *
     *
     * @param allowCache {@link Boolean}
     * @param groupingIdentifier {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAssociationGroupCommandListGet(Boolean allowCache, Integer groupingIdentifier) {
        logger.debug("Creating command message ASSOCIATION_GROUP_COMMAND_LIST_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ASSOCIATION_GROUP_COMMAND_LIST_GET);

        // Process 'Properties1'
        outputData.write(allowCache ? 0x80 : 0);

        // Process 'Grouping Identifier'
        outputData.write(groupingIdentifier);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ASSOCIATION_GROUP_COMMAND_LIST_GET command<br>
     *
     * Association Group Command List Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ALLOW_CACHE {@link Boolean}
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAssociationGroupCommandListGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("ALLOW_CACHE", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Grouping Identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ASSOCIATION_GROUP_COMMAND_LIST_REPORT command.<br>
     *
     * Association Group Command List Report<br>
     *
     *
     * @param groupingIdentifier {@link Integer}
     * @param listLength {@link Integer}
     * @param command {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAssociationGroupCommandListReport(Integer groupingIdentifier, Integer listLength,
            byte[] command) {
        logger.debug("Creating command message ASSOCIATION_GROUP_COMMAND_LIST_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ASSOCIATION_GROUP_COMMAND_LIST_REPORT);

        // Process 'Grouping Identifier'
        outputData.write(groupingIdentifier);

        // Process 'List Length'
        outputData.write(listLength);

        // Process 'Command'
        try {
            outputData.write(command);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ASSOCIATION_GROUP_COMMAND_LIST_REPORT command<br>
     *
     * Association Group Command List Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * <li>LIST_LENGTH {@link Integer}
     * <li>COMMAND {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAssociationGroupCommandListReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Grouping Identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'List Length'
        response.put("LIST_LENGTH", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Command'
        int valCommand = 0;
        int lenCommand = payload[msgOffset - 1];
        for (int cntCommand = 0; cntCommand < lenCommand; cntCommand++) {
            valCommand = (valCommand << 8) + payload[msgOffset + cntCommand];
        }
        response.put("COMMAND", valCommand);
        msgOffset += lenCommand;

        // Return the map of processed response data;
        return response;
    }

}