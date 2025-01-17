/*
 * Copyright (c) 2011, 2022 Oracle and/or its affiliates. All rights reserved.
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
package org.eclipse.persistence.testing.models.jpa.composite.advanced.member_3;

import jakarta.persistence.*;

import org.eclipse.persistence.testing.models.jpa.composite.advanced.member_2.Employee;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name="MBR3_HPROJECT")
@DiscriminatorValue("H")
public class HugeProject extends LargeProject {
    private Employee evangelist;

    public HugeProject() {
        super();
    }

    public HugeProject(String name) {
        super(name);
    }

    @OneToOne(fetch=LAZY)
    @JoinColumn(name="EVANGELIST_ID")
    public Employee getEvangelist() {
        return this.evangelist;
    }

    public void setEvangelist(Employee employee) {
        this.evangelist = employee;
    }
}
