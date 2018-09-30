/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.imaging.icc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.checkerframework.common.value.qual.IntRange;

class CachingInputStream extends InputStream {
    private final InputStream is;
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    public CachingInputStream(final InputStream is) {
        this.is = is;
    }

    public byte[] getCache() {
        return baos.toByteArray();
    }

    @Override
    public @IntRange(from=-1, to=255) int read() throws IOException {
        final int result = is.read();
        baos.write(result);
        return result;
    }

    @Override
    public int available() throws IOException {
        return is.available();
    }

    @Override
    public void close() throws IOException {
        is.close();
    }

}
