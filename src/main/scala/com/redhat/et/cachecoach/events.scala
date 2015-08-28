/*
 * This file is part of the Cache Coach utility.
 *
 * Copyright (c) 2015 Red Hat, Inc. and William C. Benton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redhat.et.cachecoach;

sealed case class StackTraceEntry(method: String, file: String, line: Int) {}

sealed case class StorageLevel(useDisk: Boolean, useMemory: Boolean, useExternalBlockStore: Boolean, deserialized: Boolean, replication: Int) {}

sealed case class RDDInfo(id: Int, name: String, scope: String, parents: List[Int], externalBlockStoreSize: Int, storageLevel: StorageLevel, diskSize: Long, memorySize: Long, numberOfPartitions: Long, numberOfCachedPartitions: Long) {}

sealed case class StageInfo(stageAttemptID: Int, submissionTime: Long, numberOfTasks: Int, parentIDs: List[Int], stageID: Int, rddInfo: List[RDDInfo], stageName: String, completionTime: Long, details: List[StackTraceEntry],
accumulables: List[Any]) {}

/** An entry in a Spark event log */
abstract class SparkEvent {}

sealed case class SparkListenerLogStart(sparkVersion: String) extends SparkEvent {}
sealed case class SparkListenerStageCompleted(stageInfo: String) extends SparkEvent {}
sealed case class SparkListenerEnvironmentUpdate(jvmInformation: String, classpathEntries: String, sparkProperties: String, systemProperties: String) extends SparkEvent {}
sealed case class SparkListenerExecutorAdded(timestamp: Long, executorInfo: String, executorID: String) extends SparkEvent {}
sealed case class SparkListenerJobStart(submissionTime: Long, stageIDs: String, properties: String, jobID: String, stageInfos: String) extends SparkEvent {}
sealed case class SparkListenerStageSubmitted(stageInfo: String, properties: String) extends SparkEvent {}
sealed case class SparkListenerTaskStart(stageAttemptID: String, taskInfo: String, stageID: String) extends SparkEvent {}
sealed case class SparkListenerTaskEnd(stageAttemptID: String, taskInfo: String, taskType: String, stageID: String, taskEndReason: String, taskMetrics: String) extends SparkEvent {}
sealed case class SparkListenerBlockManagerAdded(timestamp: Long, blockManagerID: String, maximumMemory: String) extends SparkEvent {}
sealed case class SparkListenerApplicationEnd(timestamp: Long) extends SparkEvent {}
sealed case class SparkListenerJobEnd(jobID: String, jobResult: String, completionTime: Long) extends SparkEvent {}
sealed case class SparkListenerApplicationStart(timestamp: Long, appID: String, appName: String, user: String) extends SparkEvent {}
sealed case class SparkListenerUnpersistRDD(rddID: String) extends SparkEvent {}