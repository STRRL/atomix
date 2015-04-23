/*
 * Copyright 2015 the original author or authors.
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
package net.kuujo.copycat.event;

import net.kuujo.copycat.cluster.ManagedCluster;
import net.kuujo.copycat.resource.DiscreteResourceConfig;

/**
 * Event log configuration.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class EventLogConfig extends DiscreteResourceConfig {

  @Override
  protected void setName(String name) {
    super.setName(name);
  }

  @Override
  protected void setCluster(ManagedCluster cluster) {
    super.setCluster(cluster);
  }

  @Override
  protected void setPartitions(int partitions) {
    super.setPartitions(partitions);
  }

}
