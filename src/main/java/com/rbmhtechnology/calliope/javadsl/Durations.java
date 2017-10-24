/*
 * Copyright 2015 - 2017 Red Bull Media House GmbH <http://www.redbullmediahouse.com> - all rights reserved.
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

package com.rbmhtechnology.calliope.javadsl;

import scala.concurrent.duration.FiniteDuration;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public final class Durations {

  private Durations() {
  }

  public static FiniteDuration toFiniteDuration(final Duration duration) {
    return new FiniteDuration(duration.toNanos(), NANOSECONDS);
  }

  public static scala.concurrent.duration.Duration asScala(final Duration duration) {
    return scala.concurrent.duration.Duration.fromNanos(duration.toNanos());
  }
}
