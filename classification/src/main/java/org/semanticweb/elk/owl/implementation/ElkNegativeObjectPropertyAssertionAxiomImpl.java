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
package org.semanticweb.elk.owl.implementation;

import org.semanticweb.elk.owl.interfaces.ElkIndividual;
import org.semanticweb.elk.owl.interfaces.ElkNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.elk.owl.interfaces.ElkObjectPropertyExpression;
import org.semanticweb.elk.owl.visitors.ElkNegativeObjectPropertyAssertionAxiomVisitor;
import org.semanticweb.elk.owl.visitors.ElkPropertyAssertionAxiomVisitor;

/**
 * Implementation of {@link ElkNegativeObjectPropertyAssertionAxiom}.
 * 
 * @author Markus Kroetzsch
 * @author "Yevgeny Kazakov"
 * 
 */
public class ElkNegativeObjectPropertyAssertionAxiomImpl
		extends
		ElkPropertyAssertionAxiomImpl<ElkObjectPropertyExpression, ElkIndividual, ElkIndividual>
		implements ElkNegativeObjectPropertyAssertionAxiom {

	ElkNegativeObjectPropertyAssertionAxiomImpl(
			ElkObjectPropertyExpression property, ElkIndividual subject,
			ElkIndividual object) {
		super(property, subject, object);
	}

	@Override
	public <O> O accept(ElkPropertyAssertionAxiomVisitor<O> visitor) {
		return accept((ElkNegativeObjectPropertyAssertionAxiomVisitor<O>) visitor);
	}

	@Override
	public <O> O accept(
			ElkNegativeObjectPropertyAssertionAxiomVisitor<O> visitor) {
		return visitor.visit(this);
	}

}
