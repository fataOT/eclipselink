/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.persistence.jpa.jpql.parser;

/**
 * The query BNF for a string primary expression.
 * <p>
 * JPA 1.0:
 * <div nowrap><b>BNF:</b> <code>string_primary ::= state_field_path_expression |
 *                                                  string_literal |
 *                                                  input_parameter |
 *                                                  functions_returning_strings |
 *                                                  aggregate_expression</code>
 * <p>
 * JPA 2.0:
 * <div nowrap><b>BNF:</b> <code>string_primary ::= state_field_path_expression |
 *                                                  string_literal |
 *                                                  input_parameter |
 *                                                  functions_returning_strings |
 *                                                  aggregate_expression |
 *                                                  case_expression</code>
 * <p>
 * JPA 2.1:
 * string_primary becomes string_expression
 * <div nowrap><b>BNF:</b> <code>string_primary ::= state_field_path_expression |
 *                                                  string_literal |
 *                                                  input_parameter |
 *                                                  functions_returning_strings |
 *                                                  aggregate_expression |
 *                                                  case_expression |
 *                                                  function_invocation |
 *                                                  (subquery)</code>
 * <p>
 *
 * @version 2.4
 * @since 2.3
 * @author Pascal Filion
 */
@SuppressWarnings("nls")
public final class StringPrimaryBNF extends JPQLQueryBNF {

	/**
	 * The unique identifier of this BNF rule.
	 */
	public static final String ID = "string_primary";

	/**
	 * Creates a new <code>StringPrimaryBNF</code>.
	 */
	public StringPrimaryBNF() {
		super(ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initialize() {
		super.initialize();
		setFallbackBNFId(ID);
		setFallbackExpressionFactoryId(PreLiteralExpressionFactory.ID);
		registerChild(StateFieldPathExpressionBNF.ID);
		registerChild(StringLiteralBNF.ID);
		registerChild(InputParameterBNF.ID);
		registerChild(FunctionsReturningStringsBNF.ID);
		registerChild(AggregateExpressionBNF.ID);
	}
}