/*
 * Copyright (c) 1998, 2022 Oracle and/or its affiliates. All rights reserved.
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

import org.eclipse.persistence.annotations.ExistenceChecking;

import static org.eclipse.persistence.annotations.ExistenceType.ASSUME_EXISTENCE;

/**
 * Local interface for the small project bean.
 * This is the bean's public/local interface for the clients usage.
 * All locals must extend the jakarta.ejb.EJBLocalObject.
 * The bean itself does not have to implement the local interface, but must implement all of the methods.
 */
@Entity
@Table(name="MBR3_PROJECT")
@DiscriminatorValue("S")
@ExistenceChecking(ASSUME_EXISTENCE)
public class SmallProject extends Project {
}
