/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl.loopback;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import com.zsmartsystems.zwave.commandclass.impl.CommandClassDoorLockV3;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_DOOR_LOCK</b> version <b>3</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassDoorLockV3LoopbackTest {
    /**
     * Performs an in/out test of the DOOR_LOCK_OPERATION_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param doorLockMode {@link String}
     */
    public static void testDoorLockOperationSetLoopback(String doorLockMode) {
        byte[] testPayload = CommandClassDoorLockV3.getDoorLockOperationSet(doorLockMode);

        Map<String, Object> response = CommandClassDoorLockV3.handleDoorLockOperationSet(testPayload);
        assertEquals(doorLockMode, (String) response.get("DOOR_LOCK_MODE"));
    }

    /**
     * Performs an in/out test of the DOOR_LOCK_OPERATION_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param currentDoorLockMode {@link String}
     * @param insideDoorHandlesMode {@link Integer}
     * @param outsideDoorHandlesMode {@link Integer}
     * @param doorCondition {@link Integer}
     * @param lockTimeoutMinutes {@link Integer}
     * @param lockTimeoutSeconds {@link Integer}
     * @param targetDoorLockMode {@link String}
     * @param duration {@link String}
     */
    public static void testDoorLockOperationReportLoopback(String currentDoorLockMode, Integer insideDoorHandlesMode,
            Integer outsideDoorHandlesMode, Integer doorCondition, Integer lockTimeoutMinutes,
            Integer lockTimeoutSeconds, String targetDoorLockMode, String duration) {
        byte[] testPayload = CommandClassDoorLockV3.getDoorLockOperationReport(currentDoorLockMode,
                insideDoorHandlesMode, outsideDoorHandlesMode, doorCondition, lockTimeoutMinutes, lockTimeoutSeconds,
                targetDoorLockMode, duration);

        Map<String, Object> response = CommandClassDoorLockV3.handleDoorLockOperationReport(testPayload);
        assertEquals(currentDoorLockMode, (String) response.get("CURRENT_DOOR_LOCK_MODE"));
        assertEquals(insideDoorHandlesMode, (Integer) response.get("INSIDE_DOOR_HANDLES_MODE"));
        assertEquals(outsideDoorHandlesMode, (Integer) response.get("OUTSIDE_DOOR_HANDLES_MODE"));
        assertEquals(doorCondition, (Integer) response.get("DOOR_CONDITION"));
        assertEquals(lockTimeoutMinutes, (Integer) response.get("LOCK_TIMEOUT_MINUTES"));
        assertEquals(lockTimeoutSeconds, (Integer) response.get("LOCK_TIMEOUT_SECONDS"));
        assertEquals(targetDoorLockMode, (String) response.get("TARGET_DOOR_LOCK_MODE"));
        assertEquals(duration, (String) response.get("DURATION"));
    }

    /**
     * Performs an in/out test of the DOOR_LOCK_CONFIGURATION_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param operationType {@link String}
     * @param insideDoorHandlesState {@link Integer}
     * @param outsideDoorHandlesState {@link Integer}
     * @param lockTimeoutMinutes {@link Integer}
     * @param lockTimeoutSeconds {@link Integer}
     */
    public static void testDoorLockConfigurationSetLoopback(String operationType, Integer insideDoorHandlesState,
            Integer outsideDoorHandlesState, Integer lockTimeoutMinutes, Integer lockTimeoutSeconds) {
        byte[] testPayload = CommandClassDoorLockV3.getDoorLockConfigurationSet(operationType, insideDoorHandlesState,
                outsideDoorHandlesState, lockTimeoutMinutes, lockTimeoutSeconds);

        Map<String, Object> response = CommandClassDoorLockV3.handleDoorLockConfigurationSet(testPayload);
        assertEquals(operationType, (String) response.get("OPERATION_TYPE"));
        assertEquals(insideDoorHandlesState, (Integer) response.get("INSIDE_DOOR_HANDLES_STATE"));
        assertEquals(outsideDoorHandlesState, (Integer) response.get("OUTSIDE_DOOR_HANDLES_STATE"));
        assertEquals(lockTimeoutMinutes, (Integer) response.get("LOCK_TIMEOUT_MINUTES"));
        assertEquals(lockTimeoutSeconds, (Integer) response.get("LOCK_TIMEOUT_SECONDS"));
    }

    /**
     * Performs an in/out test of the DOOR_LOCK_CONFIGURATION_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param operationType {@link String}
     * @param insideDoorHandlesState {@link Integer}
     * @param outsideDoorHandlesState {@link Integer}
     * @param lockTimeoutMinutes {@link Integer}
     * @param lockTimeoutSeconds {@link Integer}
     */
    public static void testDoorLockConfigurationReportLoopback(String operationType, Integer insideDoorHandlesState,
            Integer outsideDoorHandlesState, Integer lockTimeoutMinutes, Integer lockTimeoutSeconds) {
        byte[] testPayload = CommandClassDoorLockV3.getDoorLockConfigurationReport(operationType, insideDoorHandlesState,
                outsideDoorHandlesState, lockTimeoutMinutes, lockTimeoutSeconds);

        Map<String, Object> response = CommandClassDoorLockV3.handleDoorLockConfigurationReport(testPayload);
        assertEquals(operationType, (String) response.get("OPERATION_TYPE"));
        assertEquals(insideDoorHandlesState, (Integer) response.get("INSIDE_DOOR_HANDLES_STATE"));
        assertEquals(outsideDoorHandlesState, (Integer) response.get("OUTSIDE_DOOR_HANDLES_STATE"));
        assertEquals(lockTimeoutMinutes, (Integer) response.get("LOCK_TIMEOUT_MINUTES"));
        assertEquals(lockTimeoutSeconds, (Integer) response.get("LOCK_TIMEOUT_SECONDS"));
    }

}
