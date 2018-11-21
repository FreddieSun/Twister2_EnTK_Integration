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
package edu.iu.dsc.tws.examples.batch.kmeans;

/**
 * This class is to declare the variables required for the K-Means Clustering Process.
 */
public final class KMeansConstants {

  public static final String ARGS_WORKERS = "workers";
  public static final String ARGS_ITR = "iter";
  public static final String ARGS_FNAME = "fname";
  public static final String ARGS_POINTS = "pointsfile";
  public static final String ARGS_CENTERS = "centersfile";
  public static final String ARGS_DIMENSIONS = "dim";
  public static final String ARGS_CLUSTERS = "clusters";
  public static final String ARGS_NUMBER_OF_POINTS = "points";
  public static final String ARGS_FILESYSTEM = "filesys"; // "local" or "hdfs"
  public static final String ARGS_POINTS_SEED_VALUE = "pseedvalue";
  public static final String ARGS_CENTERS_SEED_VALUE = "cseedvalue";
  public static final String ARGS_DATA_INPUT = "input"; //"generate" or "read"
  public static final String ARGS_PARALLELISM_VALUE = "parallelism";

  protected KMeansConstants() {
  }
}
