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
package edu.iu.dsc.tws.examples.task.streaming;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import edu.iu.dsc.tws.api.task.TaskGraphBuilder;
import edu.iu.dsc.tws.data.api.DataType;
import edu.iu.dsc.tws.examples.task.BenchTaskWorker;
import edu.iu.dsc.tws.examples.verification.VerificationException;
import edu.iu.dsc.tws.executor.core.OperationNames;
import edu.iu.dsc.tws.task.api.IMessage;
import edu.iu.dsc.tws.task.streaming.BaseStreamSink;
import edu.iu.dsc.tws.task.streaming.BaseStreamSource;

public class STPartitionExample extends BenchTaskWorker {

  private static final Logger LOG = Logger.getLogger(STPartitionExample.class.getName());

  @Override
  public TaskGraphBuilder buildTaskGraph() {
    List<Integer> taskStages = jobParameters.getTaskStages();
    int sourceParallelism = taskStages.get(0);
    int sinkParallelism = taskStages.get(1);
    DataType dataType = DataType.INTEGER;
    String edge = "edge";
    BaseStreamSource g = new SourceStreamTask(edge);
    BaseStreamSink r = new PartitionSinkTask();
    taskGraphBuilder.addSource(SOURCE, g, sourceParallelism);
    computeConnection = taskGraphBuilder.addSink(SINK, r, sinkParallelism);
    computeConnection.partition(SOURCE, edge, dataType);
    return taskGraphBuilder;
  }

  protected static class PartitionSinkTask extends BaseStreamSink {
    private static final long serialVersionUID = -254264903510284798L;

    private int count = 0;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public boolean execute(IMessage message) {
      if (count % jobParameters.getPrintInterval() == 0) {
        if (message.getContent() instanceof Iterator) {
          Iterator it = (Iterator) message.getContent();
          if (it.hasNext()) {
            Object object = it.next();
            experimentData.setOutput(object);
            try {
              verify(OperationNames.PARTITION);
            } catch (VerificationException e) {
              LOG.info("Exception Message : " + e.getMessage());
            }
            LOG.info("Itr : " + object.getClass().getName());
            count += 1;
          }
        }
      }
      /*if (count % jobParameters.getPrintInterval() == 0) {
        LOG.info(String.format("%d %d Streaming Message Partition Received count: %d",
            context.getWorkerId(),
            context.taskId(), count));
      }*/
      return true;
    }
  }
}
