/*
 * Copyright © 2016-2017 European Support Limited
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

package org.amdocs.zusammen.adaptor.inbound.impl.item;

import org.amdocs.zusammen.adaptor.inbound.api.item.ItemVersionAdaptor;
import org.amdocs.zusammen.adaptor.inbound.api.types.item.MergeResult;
import org.amdocs.zusammen.adaptor.inbound.impl.convertor.MergeResultConvertor;
import org.amdocs.zusammen.core.api.item.ItemVersionManager;
import org.amdocs.zusammen.core.api.item.ItemVersionManagerFactory;
import org.amdocs.zusammen.core.api.types.CoreMergeResult;
import org.amdocs.zusammen.datatypes.Id;
import org.amdocs.zusammen.datatypes.SessionContext;
import org.amdocs.zusammen.datatypes.Space;
import org.amdocs.zusammen.datatypes.UserInfo;
import org.amdocs.zusammen.datatypes.item.ItemVersion;
import org.amdocs.zusammen.datatypes.item.ItemVersionData;

import java.util.Collection;

public class ItemVersionAdaptorImpl implements ItemVersionAdaptor {

  @Override
  public Collection<ItemVersion> list(SessionContext context, Space space, Id itemId) {
    return getItemVersionManager(context).list(context, space, itemId);
  }

  @Override
  public ItemVersion get(SessionContext context, Space space, Id itemId, Id versionId) {
    return getItemVersionManager(context).get(context, space, itemId, versionId);
  }

  @Override
  public Id create(SessionContext context, Id itemId, Id baseVersionId,
                   ItemVersionData data) {
    return getItemVersionManager(context).create(context, itemId, baseVersionId, data);
  }

  @Override
  public void update(SessionContext context, Id itemId, Id versionId,
                     ItemVersionData data) {
    getItemVersionManager(context).update(context, itemId, versionId, data);
  }

  @Override
  public void delete(SessionContext context, Id itemId, Id versionId) {
    getItemVersionManager(context).delete(context, itemId, versionId);
  }

  @Override
  public void publish(SessionContext context, Id itemId, Id versionId, String message) {
    getItemVersionManager(context).publish(context, itemId, versionId, message);
  }

  @Override
  public MergeResult sync(SessionContext context, Id itemId, Id versionId) {
    CoreMergeResult coreMergeResult =
        getItemVersionManager(context).sync(context, itemId, versionId);
    return MergeResultConvertor.getMergeResult(coreMergeResult);
  }

  @Override
  public MergeResult merge(SessionContext context, Id itemId, Id versionId, Id sourceVersionId) {
    CoreMergeResult coreMergeResult =
        getItemVersionManager(context).merge(context, itemId, versionId, sourceVersionId);
    return MergeResultConvertor.getMergeResult(coreMergeResult);
  }

  private SessionContext createSessionContext(UserInfo user) {
    SessionContext context = new SessionContext();
    context.setUser(user);
    return context;
  }

  private ItemVersionManager getItemVersionManager(SessionContext context) {
    return ItemVersionManagerFactory.getInstance().createInterface(context);
  }
}
