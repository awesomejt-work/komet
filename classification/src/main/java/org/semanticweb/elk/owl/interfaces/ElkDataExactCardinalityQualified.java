/*
 * Copyright © 2015 Integrated Knowledge Management (support@ikm.dev)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * @author Markus Kroetzsch, Aug 8, 2011
 */
package org.semanticweb.elk.owl.interfaces;

import org.semanticweb.elk.owl.visitors.ElkDataExactCardinalityQualifiedVisitor;

/**
 * Corresponds to an
 * <a href= "http://www.w3.org/TR/owl2-syntax/#Exact_Cardinality_2">exact
 * cardinality restriction<a> in the OWL 2 specification in the case the
 * qualified data range is not empty.
 * 
 * @author Markus Kroetzsch
 */
public interface ElkDataExactCardinalityQualified
		extends ElkDataExactCardinality,
		ElkCardinalityRestrictionQualified<ElkDataPropertyExpression, ElkDataRange> {

	/**
	 * Accept an {@link ElkDataExactCardinalityQualifiedVisitor}.
	 * 
	 * @param visitor
	 *            the visitor that can work with this object type
	 * @return the output of the visitor
	 */
	public <O> O accept(ElkDataExactCardinalityQualifiedVisitor<O> visitor);

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	interface Factory {

		/**
		 * Create an {@link ElkDataExactCardinalityQualified}.
		 * 
		 * @param property
		 *            the {@link ElkDataPropertyExpression} for which the object
		 *            should be created
		 * @param cardinality
		 *            the cardinality for which the object should be created
		 * @param range
		 *            the {@link ElkDataRange} for which the object should be
		 *            created
		 * @return an {@link ElkDataExactCardinalityQualified} corresponding to
		 *         the input
		 */
		public ElkDataExactCardinalityQualified getDataExactCardinalityQualified(
				ElkDataPropertyExpression property,
				int cardinality, ElkDataRange range);

	}

}
