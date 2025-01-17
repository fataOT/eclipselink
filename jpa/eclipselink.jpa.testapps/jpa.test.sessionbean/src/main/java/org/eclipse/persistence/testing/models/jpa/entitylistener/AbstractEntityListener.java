/*
 * Copyright (c) 2016, 2022 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

package org.eclipse.persistence.testing.models.jpa.entitylistener;

import org.eclipse.persistence.testing.models.jpa.sessionbean.InjectedBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;

/* Trigger Bug #495587 */
public class AbstractEntityListener<E extends EntityListenerHolderInterface> {
    public static boolean INJECTED_RETURN_VALUE = false;
    public static int POST_CONSTRUCT_CALLS = 0;
    public static int PRE_DESTROY_CALLS = 0;

    public AbstractEntityListener() {
    }

    @Inject
    protected InjectedBean injected;

    @PrePersist
    public void prePersist(E object) {
        INJECTED_RETURN_VALUE = injected.isCalled();
    }

    @PostPersist
    public void postPersist(E object) {
    }

    @PreDestroy
    public void preDestroy() {
        PRE_DESTROY_CALLS++;
    }

    @PostConstruct
    public void postConstruct() {
        POST_CONSTRUCT_CALLS++;
    }
}
