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
package org.eclipse.persistence.testing.tests.nchar;

import org.eclipse.persistence.testing.framework.TestSystem;
import org.eclipse.persistence.sessions.DatabaseSession;

/**
 * <b>Purpose</b>: To define a LOB testing system behavior.
 * <p><b>Responsibilities</b>:    <ul>
 * <li> Login and return an initialize database session.
 * <li> Create the database.
 * </ul>
 */
public class NcharTestSystem extends TestSystem {

    public NcharTestSystem() {
        project = new CharNcharProject();
    }

    @Override
    public void addDescriptors(DatabaseSession session) {
        if (project == null) {
            project = new CharNcharProject();
        }

        session.addDescriptors(project);
    }

    @Override
    public void createTables(DatabaseSession session) {
        new CharNcharTableCreator().replaceTables(session);
    }

}
