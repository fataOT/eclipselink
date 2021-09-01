/*
 * Copyright (c) 2006, 2020 Oracle and/or its affiliates. All rights reserved.
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
//     Oracle - initial API and implementation
//
package org.eclipse.persistence.jpa.jpql.parser;

/**
 * The query BNF for the position parameters of the <code><b>SUBSTRING</b></code> expression.
 * <p>
 * JPA 1.0:
 * <div><b>BNF</b> ::= SUBSTRING(string_primary, simple_arithmetic_expression, simple_arithmetic_expression)</div>
 * <p>
 * JPA 2.0:
 * <div><b>BNF</b> ::= SUBSTRING(string_primary, simple_arithmetic_expression [, simple_arithmetic_expression])</div>
 * <p>
 * JPA 2.1:
 * <div><b>BNF</b> ::= SUBSTRING(string_expression, arithmetic_expression [, arithmetic_expression])</div>
 * <p>
 *
 * @version 2.5
 * @since 2.4
 * @author Pascal Filion
 */
@SuppressWarnings("nls")
public final class InternalSubstringPositionExpressionBNF extends JPQLQueryBNF {

    /**
     * The unique identifier of this BNF rule.
     */
    public static final String ID = "substring_position";

    /**
     * Creates a new <code>InternalSubstringPositionExpressionBNF</code>.
     */
    public InternalSubstringPositionExpressionBNF() {
        super(ID);
    }

    @Override
    protected void initialize() {
        super.initialize();
        setFallbackBNFId(ID);
        setFallbackExpressionFactoryId(LiteralExpressionFactory.ID);
        registerChild(SimpleArithmeticExpressionBNF.ID);
    }
}
