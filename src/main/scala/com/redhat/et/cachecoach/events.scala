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

sealed case class SourceLine(file: String, line: Int) {}

abstract class SparkEvent {}
case class SparkListenerLogStart(event: String, sparkVersion: String) extends SparkEvent {}
case class SparkListenerStageCompleted(stageInfo: String, event: String) extends SparkEvent {}
case class SparkListenerEnvironmentUpdate(jvmInformation: String, classpathEntries: String, sparkProperties: String, event: String, systemProperties: String) extends SparkEvent {}
case class SparkListenerExecutorAdded(timestamp: String, executorInfo: String, event: String, executorID: String) extends SparkEvent {}
case class SparkListenerJobStart(submissionTime: String, stageIDs: String, properties: String, jobID: String, stageInfos: String, event: String) extends SparkEvent {}
case class SparkListenerStageSubmitted(stageInfo: String, event: String, properties: String) extends SparkEvent {}
case class SparkListenerTaskStart(stageAttemptID: String, taskInfo: String, event: String, stageID: String) extends SparkEvent {}
case class SparkListenerTaskEnd(stageAttemptID: String, taskInfo: String, taskType: String, stageID: String, taskEndReason: String, taskMetrics: String, event: String) extends SparkEvent {}
case class SparkListenerBlockManagerAdded(timestamp: String, blockManagerID: String, event: String, maximumMemory: String) extends SparkEvent {}
case class SparkListenerApplicationEnd(timestamp: String, event: String) extends SparkEvent {}
case class SparkListenerJobEnd(jobID: String, jobResult: String, event: String, completionTime: String) extends SparkEvent {}
case class SparkListenerApplicationStart(timestamp: String, appID: String, event: String, appName: String, user: String) extends SparkEvent {}
case class SparkListenerUnpersistRDD(rddID: String, event: String) extends SparkEvent {}