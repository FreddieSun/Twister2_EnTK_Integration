//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//  http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
package edu.iu.dsc.tws.examples.task;

import java.io.Serializable;

public class CommInfo implements Serializable {
  private static final long serialVersionUID = 1L;

  private int sourceParallelism;

  private int sinkParallelism;

  private int itr;

  private int workers;

  private String operationMode;

  public CommInfo(int sourceParallelism, int sinkParallelism,
      int itr, int workers, String operationMode) {
    this.sourceParallelism = sourceParallelism;
    this.sinkParallelism = sinkParallelism;
    this.itr = itr;
    this.workers = workers;
    this.operationMode = operationMode;
  }

  public int getSourceParallelism() {
    return sourceParallelism;
  }

  public void setSourceParallelism(int sourceParallelism) {
    this.sourceParallelism = sourceParallelism;
  }

  public int getSinkParallelism() {
    return sinkParallelism;
  }

  public void setSinkParallelism(int sinkParallelism) {
    this.sinkParallelism = sinkParallelism;
  }

  public int getItr() {
    return itr;
  }

  public void setItr(int itr) {
    this.itr = itr;
  }

  public int getWorkers() {
    return workers;
  }

  public void setWorkers(int workers) {
    this.workers = workers;
  }

  public String getOperationMode() {
    return operationMode;
  }

  public void setOperationMode(String operationMode) {
    this.operationMode = operationMode;
  }
}
