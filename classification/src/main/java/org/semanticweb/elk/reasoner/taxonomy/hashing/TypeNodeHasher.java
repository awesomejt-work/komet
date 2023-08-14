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
package org.semanticweb.elk.reasoner.taxonomy.hashing;

import org.semanticweb.elk.owl.interfaces.ElkEntity;
import org.semanticweb.elk.reasoner.taxonomy.model.Node;
import org.semanticweb.elk.reasoner.taxonomy.model.TypeNode;
import org.semanticweb.elk.util.hashing.HashGenerator;
import org.semanticweb.elk.util.hashing.Hasher;

/**
 * Helper class for hashing TypeNodes based on getMembers(),
 * getDirectSubNodes(), getDirectSuperNodes(), and getDirectInstanceNodes().
 * 
 * @author Frantisek Simancik
 * 
 */
public class TypeNodeHasher implements
		Hasher<TypeNode<? extends ElkEntity, ? extends ElkEntity>> {

	/**
	 * We use one static instance for hashing all nodes.
	 */
	public static TypeNodeHasher INSTANCE = new TypeNodeHasher();

	private TypeNodeHasher() {
	}

	@Override
	public int hash(TypeNode<? extends ElkEntity, ? extends ElkEntity> node) {
		int memberHash = NodeHasher.INSTANCE.hash(node);

		int subClassHash = "subClassOf".hashCode();
		for (Node<? extends ElkEntity> o : node.getDirectSubNodes()) {
			subClassHash = HashGenerator.combineMultisetHash(false,
					subClassHash, NodeHasher.INSTANCE.hash(o));
		}

		int superClassHash = "superClassOf".hashCode();
		for (Node<? extends ElkEntity> o : node.getDirectSuperNodes()) {
			superClassHash = HashGenerator.combineMultisetHash(false,
					superClassHash, NodeHasher.INSTANCE.hash(o));
		}

		int instanceHash = "instanceOf".hashCode();
		for (Node<? extends ElkEntity> o : node.getDirectInstanceNodes()) {
			instanceHash = HashGenerator.combineMultisetHash(false,
					instanceHash, NodeHasher.INSTANCE.hash(o));
		}

		return HashGenerator.combineListHash(memberHash, subClassHash,
				superClassHash, instanceHash);
	}

}
