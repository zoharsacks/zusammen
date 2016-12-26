/*
 * Copyright © 2016 Amdocs Software Systems Limited
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

package org.amdocs.tsuzammen.adaptor.outbound.api;


import org.amdocs.tsuzammen.commons.datatypes.Id;
import org.amdocs.tsuzammen.commons.datatypes.SessionContext;
import org.amdocs.tsuzammen.commons.datatypes.impl.item.CoreEntity;
import org.amdocs.tsuzammen.commons.datatypes.item.ElementContext;
import org.amdocs.tsuzammen.commons.datatypes.item.Info;

import java.net.URI;
import java.util.Collection;

public interface CollaborationAdaptor {

  void createItem(SessionContext context, Id itemId, Info info);

  void saveItem(SessionContext context, Id itemId, Info itemInfo);

  void deleteItem(SessionContext context, Id itemId);

  void createItemVersion(SessionContext context, Id itemId, Id baseVersionId,
                         Id versionId, Info info);

  void saveItemVersion(SessionContext context, Id itemId, Id versionId,
                       Info versionInfo);

  void deleteItemVersion(SessionContext context, Id itemId, Id versionId);

  void publishItemVersion(SessionContext context, Id itemId, Id versionId, String message);

  void syncItemVersion(SessionContext context, Id itemId, Id versionId);

  void revertItemVersion(SessionContext context, Id itemId, Id versionId,
                         String targetRevisionId);

  Collection listItemVersionRevisions(SessionContext context, Id itemId, Id versionId);

  Collection listItemVersionMissingRevisions(SessionContext context, Id itemId,
                                             Id versionId);

  Collection listItemVersionOverRevisions(SessionContext context, Id itemId, Id versionId);

  void createEntity(SessionContext context, ElementContext elementContext,
                    URI namespace, CoreEntity entity);

  void saveEntity(SessionContext context, ElementContext elementContext,
                  URI namespace, CoreEntity entity);

  void deleteEntity(SessionContext context, ElementContext elementContext,
                    URI namespace, String entityId);

  void commitEntities(SessionContext context, ElementContext elementContext,
                      String message);
}
