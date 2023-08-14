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
package org.liveontologies.puli.statistics;

public class StatsException extends RuntimeException {
	private static final long serialVersionUID = 3694803038220659642L;

	public StatsException() {
		super();
	}

	public StatsException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public StatsException(final String message) {
		super(message);
	}

	public StatsException(final Throwable cause) {
		super(cause);
	}

}
