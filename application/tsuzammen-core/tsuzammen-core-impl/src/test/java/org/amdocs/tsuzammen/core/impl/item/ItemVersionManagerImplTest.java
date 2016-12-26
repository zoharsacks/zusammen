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

package org.amdocs.tsuzammen.core.impl.item;

import org.amdocs.tsuzammen.commons.datatypes.Id;
import org.amdocs.tsuzammen.commons.datatypes.SessionContext;
import org.amdocs.tsuzammen.commons.datatypes.UserInfo;
import org.amdocs.tsuzammen.commons.datatypes.item.Info;
import org.amdocs.tsuzammen.core.impl.TestUtils;
import org.amdocs.tsuzammen.core.impl.item.mocks.CollaborationAdaptorEmptyImpl;
import org.amdocs.tsuzammen.core.impl.item.mocks.ItemVersionStateAdaptorEmptyImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ItemVersionManagerImplTest {
  public static final UserInfo USER = new UserInfo("ItemVersionManagerImplTest_user");

  private ItemVersionManagerImpl itemVersionManagerImpl = spy(new ItemVersionManagerImpl());

  private ItemVersionStateAdaptorEmptyImpl stateAdaptorEmpty =
      spy(new ItemVersionStateAdaptorEmptyImpl());
  private CollaborationAdaptorEmptyImpl collaborationAdaptorEmpty =
      spy(new CollaborationAdaptorEmptyImpl());

  @BeforeClass
  public void init() {
    when(itemVersionManagerImpl.getCollaborationAdaptor(anyObject()))
        .thenReturn(collaborationAdaptorEmpty);

    when(itemVersionManagerImpl.getStateAdaptor(anyObject())).thenReturn(stateAdaptorEmpty);
  }

  @Test
  public void testCreate() throws Exception {
    SessionContext context = TestUtils.createSessionContext(USER, "test");
    Info versionInfo = TestUtils.createInfo("v1");

    Id itemId = new Id();
    Id versionId =
        itemVersionManagerImpl.create(context, itemId, null, versionInfo);
    Assert.assertNotNull(versionId);
  }

  @Test
  public void testSaveInfo() throws Exception {

  }

  @Test
  public void testDelete() throws Exception {

  }

  @Test
  public void testPublish() throws Exception {

  }

  @Test
  public void testSync() throws Exception {

  }

  @Test
  public void testRevert() throws Exception {

  }

  @Test
  public void testGet() throws Exception {

  }

  @Test
  public void testGetInfo() throws Exception {

  }
}