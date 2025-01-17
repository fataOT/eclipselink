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
//     03/26/2008-1.0M6 Guy Pelletier
//       - 211302: Add variable 1-1 mapping support to the EclipseLink-ORM.XML Schema
//     12/2/2009-2.1 Guy Pelletier
//       - 296289: Add current annotation metadata support on mapped superclasses to EclipseLink-ORM.XML Schema
package org.eclipse.persistence.testing.models.jpa.xml.relationships;

public class Namco extends DistributingCompany implements Distributor, Cloneable {
    public Namco() {}

    @Override
    public Namco clone(){
        try{
            return (Namco)super.clone();
        } catch (CloneNotSupportedException exc){
            return null;
        }
    }

    public Namco cloneNamco(){
        return this.clone();
    }

    public Namco cloneWorkingCopyNamco(){
        return this.clone();
    }
}
