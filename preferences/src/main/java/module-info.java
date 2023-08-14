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
import dev.ikm.komet.preferences.PreferencesService;
import dev.ikm.komet.preferences.PreferencesServiceFactory;

module dev.ikm.komet.preferences {
    exports dev.ikm.komet.preferences;
    requires org.slf4j;
    requires java.prefs;
    requires dev.ikm.tinkar.entity;
    requires java.xml;
    requires static com.google.auto.service;

    provides PreferencesService with PreferencesServiceFactory;
    uses PreferencesService;
}
