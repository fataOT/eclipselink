/*******************************************************************************
 * Copyright (c) 2011, 2012 Oracle and/or its affiliates. All rights reserved.
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

import org.eclipse.persistence.jpa.jpql.spi.JPAVersion;

/**
 * A JPQL grammar defines how a JPQL query can be parsed. The {@link ExpressionRegistry} contains
 * the {@link JPQLQueryBNF BNFs} and the {@link ExpressionFactory expression factories} used to
 * create the object representation of the JPQL query.
 * <p>
 * Various JPQL grammars have been defined:
 * <ul>
 * <li>{@link JPQLGrammar1_0} defines the JPQL grammar based on JPA 1.0;</li>
 * <li>{@link JPQLGrammar2_0} defines the JPQL grammar based on JPA 2.0;</li>
 * <li>{@link EclipseLinkJPQLGrammar1} defines the JPQL grammar based on JPA 1.0 and EclipseLink 1.x;</li>
 * <li>{@link EclipseLinkJPQLGrammar2_0} defines the JPQL grammar based on JPA 2.0 and the additional EclipseLink 2.0 support;</li>
 * <li>{@link EclipseLinkJPQLGrammar2_1} defines the JPQL grammar based on JPA 2.0 and the additional EclipseLink 2.1 support.</li>
 * <li>{@link EclipseLinkJPQLGrammar2_2} defines the JPQL grammar based on JPA 2.0 and the additional EclipseLink 2.2 support.</li>
 * <li>{@link EclipseLinkJPQLGrammar2_3} defines the JPQL grammar based on JPA 2.0 and the additional EclipseLink 2.3 support.</li>
 * <li>{@link EclipseLinkJPQLGrammar2_4} defines the JPQL grammar based on JPA 2.0 and the additional EclipseLink 2.4 support.</li>
 * <li>{@link DefaultJPQLGrammar} defines the JPQL grammar based on the latest JPA version;</li>
 * <li>{@link DefaultEclipseLinkJPQLGrammar} defines the JPQL grammar based on the latest JPA and
 * the latest EclipseLink;</li>
 * </ul>
 *
 * Provisional API: This interface is part of an interim API that is still under development and
 * expected to change significantly before reaching stability. It is available at this early stage
 * to solicit feedback from pioneering adopters on the understanding that any code that uses this
 * API will almost certainly be broken (repeatedly) as the API evolves.
 *
 * @version 2.4
 * @since 2.4
 * @author Pascal Filion
 */
public interface JPQLGrammar {

	/**
	 * Returns the registry containing the {@link JPQLQueryBNF JPQLQueryBNFs} and the {@link
	 * org.eclipse.persistence.jpa.jpql.parser.ExpressionFactory ExpressionFactories} that are used
	 * to properly parse a JPQL query.
	 *
	 * @return The registry containing the information related to the JPQL grammar
	 */
	ExpressionRegistry getExpressionRegistry();

	/**
	 * Returns the {@link JPAVersion} of the Java Persistence supported by this grammar.
	 *
	 * @return The {@link JPAVersion JPA version} supported by this grammar
	 */
	JPAVersion getJPAVersion();

	/**
	 * Returns the version of the persistence provider.
	 *
	 * @return The version of the persistence provider, if one is extending the default JPQL grammar
	 * defined in the Java Persistence specification, otherwise returns an empty string
	 * @since 2.4
	 */
	String getProviderVersion();
}