/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.oxm.mappings.simpletypes.childcollection;

// JDK imports
import java.io.InputStream;

// TopLink imports
import org.eclipse.persistence.oxm.XMLMarshaller;
import org.eclipse.persistence.exceptions.XMLMarshalException;
import org.eclipse.persistence.testing.oxm.mappings.XMLMappingTestCases;

public class ChildCollectionTestCases extends XMLMappingTestCases {
    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/oxm/mappings/simpletypes/childcollection/SimpleChildCollectionTest.xml";
    private final static String CONTROL_EMPLOYEE_NAME = "Jane Doh";
    private final static String CONTROL_EMPLOYEE_PHONE_1 = "(613)444-1234";
    private final static String CONTROL_EMPLOYEE_PHONE_2 = "(613)555-1234";
    private final static String CONTROL_EMPLOYEE_PHONE_3 = "(613)666-1234";
    private XMLMarshaller xmlMarshaller;

    public ChildCollectionTestCases(String name) throws Exception {
        super(name);
        setControlDocument(XML_RESOURCE);
        setProject(new EmployeeProject());
    }

    @Override
    protected Object getControlObject() {
        Employee employee = new Employee();
        employee.setName(CONTROL_EMPLOYEE_NAME);

        java.util.Vector phoneNumbers = new java.util.Vector();
        phoneNumbers.addElement(new Phone(CONTROL_EMPLOYEE_PHONE_1));
        phoneNumbers.addElement(new Phone(CONTROL_EMPLOYEE_PHONE_2));
        phoneNumbers.addElement(new Phone(CONTROL_EMPLOYEE_PHONE_3));
        employee.setPhones(phoneNumbers);

        return employee;
    }

}
