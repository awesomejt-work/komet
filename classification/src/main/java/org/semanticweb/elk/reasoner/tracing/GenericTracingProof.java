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
package org.semanticweb.elk.reasoner.tracing;

import org.liveontologies.puli.Proof;

/**
 * An object which can be used to retrieve {@link TracingInference}s producing a
 * given {@link Conclusion}.
 * 
 * @author Peter Skocovsky
 *
 * @param <I>
 *            The type of the inferences.
 */
public interface GenericTracingProof<I extends TracingInference>
		extends Proof<I> {
	// Restriction to tracing inferences.
}
