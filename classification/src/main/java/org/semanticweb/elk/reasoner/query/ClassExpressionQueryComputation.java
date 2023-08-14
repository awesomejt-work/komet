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
package org.semanticweb.elk.reasoner.query;

import java.util.Collection;

import org.semanticweb.elk.reasoner.ProgressMonitor;
import org.semanticweb.elk.reasoner.ReasonerComputationWithInputs;
import org.semanticweb.elk.reasoner.indexing.model.IndexedClassExpression;
import org.semanticweb.elk.reasoner.reduction.TransitiveReductionOutputVisitor;
import org.semanticweb.elk.reasoner.saturation.SaturationState;
import org.semanticweb.elk.reasoner.saturation.SaturationStatistics;
import org.semanticweb.elk.util.concurrent.computation.ConcurrentExecutor;
import org.semanticweb.elk.util.concurrent.computation.InterruptMonitor;

/**
 * Computes the direct super-, direct sub-, and equivalent classes of the class
 * expressions supplied as input.
 * 
 * @author Peter Skocovsky
 */
public class ClassExpressionQueryComputation extends
		ReasonerComputationWithInputs<IndexedClassExpression, ClassExpressionQueryComputationFactory> {

	public ClassExpressionQueryComputation(
			final Collection<IndexedClassExpression> inputs,
			final InterruptMonitor interrupter,
			final ConcurrentExecutor executor, final int maxWorkers,
			final ProgressMonitor progressMonitor,
			final SaturationState<?> saturationState,
			final TransitiveReductionOutputVisitor<IndexedClassExpression> outputProcessor) {
		super(inputs,
				new ClassExpressionQueryComputationFactory(interrupter,
						saturationState, maxWorkers, outputProcessor),
				executor, maxWorkers, progressMonitor);
	}

	public void printStatistics() {
		processorFactory.printStatistics();
	}

	public SaturationStatistics getRuleAndConclusionStatistics() {
		return processorFactory.getRuleAndConclusionStatistics();
	}

}