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
package org.eclipse.persistence.testing.models.jpa.relationships;

import static jakarta.persistence.GenerationType.TABLE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.eclipse.persistence.annotations.CloneCopyPolicy;

@Entity
@Table(name="CMP3_NAMCO")
@CloneCopyPolicy(method="cloneNamco", workingCopyMethod="cloneWorkingCopyNamco")
public class Namco implements Distributor, Cloneable {
    private Integer distributorId;
    private String name;

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

    @Id
    @GeneratedValue(strategy=TABLE, generator="DISTRIBUTOR_TABLE_GENERATOR")
    @Column(name="ID")
    public Integer getDistributorId() {
        return distributorId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public void setName(String name) {
        this.name = name;
    }


}
