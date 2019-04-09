/*
 * Copyright 2017-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.core.map;

import io.atomix.core.map.impl.DefaultDistributedNavigableMapService;
import io.atomix.core.map.impl.DefaultDistributedSortedMapBuilder;
import io.atomix.primitive.PrimitiveManagementService;
import io.atomix.primitive.PrimitiveType;
import io.atomix.primitive.service.PrimitiveService;
import io.atomix.utils.serializer.Namespace;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Distributed sorted map primitive type.
 */
public class DistributedSortedMapType<K extends Comparable<K>, V> implements PrimitiveType<DistributedSortedMapBuilder<K, V>, DistributedSortedMapConfig, DistributedSortedMap<K, V>> {
  private static final String NAME = "sorted-map";

  private static final DistributedSortedMapType INSTANCE = new DistributedSortedMapType();

  /**
   * Returns a new distributed tree map type.
   *
   * @param <K> the key type
   * @param <V> the value type
   * @return a new distributed tree map type
   */
  @SuppressWarnings("unchecked")
  public static <K extends Comparable<K>, V> DistributedSortedMapType<K, V> instance() {
    return INSTANCE;
  }

  @Override
  public String name() {
    return NAME;
  }

  @Override
  public Namespace namespace() {
    return AtomicNavigableMapType.instance().namespace();
  }

  @Override
  public PrimitiveService newService() {
    return new DefaultDistributedNavigableMapService();
  }

  @Override
  public DistributedSortedMapConfig newConfig() {
    return new DistributedSortedMapConfig();
  }

  @Override
  public DistributedSortedMapBuilder<K, V> newBuilder(String name, DistributedSortedMapConfig config, PrimitiveManagementService managementService) {
    return new DefaultDistributedSortedMapBuilder<>(name, config, managementService);
  }

  @Override
  public String toString() {
    return toStringHelper(this)
        .add("name", name())
        .toString();
  }
}
