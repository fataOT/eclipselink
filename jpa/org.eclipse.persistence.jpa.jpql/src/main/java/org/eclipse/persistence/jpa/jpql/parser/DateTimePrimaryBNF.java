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
 * The query BNF for a date/time primary expression.
 * <p>
 * JPA 1.0:
 * <div><b>BNF:</b> <code>datetime_primary ::= state_field_path_expression |
 *                                                    input_parameter |
 *                                                    functions_returning_datetime |
 *                                                    aggregate_expression</code><p></div>
 *
 * JPA 2.0:
 * <div><b>BNF:</b> <code>datetime_primary ::= state_field_path_expression |
 *                                                    input_parameter |
 *                                                    functions_returning_datetime |
 *                                                    aggregate_expression |
 *                                                    case_expression |
 *                                                    date_time_timestamp_literal</code><p></div>
 *
 * @version 2.4
 * @since 2.3
 * @author Pascal Filion
 */
@SuppressWarnings("nls")
public final class DateTimePrimaryBNF extends JPQLQueryBNF {

    /**
     * The unique identifier of this BNF rule.
     */
    public static final String ID = "datetime_primary";

    /**
     * Creates a new <code>DatetimePrimaryBNF</code>.
     */
    public DateTimePrimaryBNF() {
        super(ID);
    }

    @Override
    protected void initialize() {
        super.initialize();

        registerChild(InputParameterBNF.ID);
        registerChild(FunctionsReturningDatetimeBNF.ID);
        registerChild(AggregateExpressionBNF.ID);
        registerChild(StateFieldPathExpressionBNF.ID);
    }
}
