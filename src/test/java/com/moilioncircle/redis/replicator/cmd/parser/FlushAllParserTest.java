/*
 * Copyright 2016-2018 Leon Chen
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

package com.moilioncircle.redis.replicator.cmd.parser;

import com.moilioncircle.redis.replicator.cmd.impl.FlushAllCommand;
import com.moilioncircle.redis.replicator.cmd.impl.FlushDBCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class FlushAllParserTest extends AbstractParserTest {
    @Test
    public void parse() throws Exception {
        {
            FlushAllParser parser = new FlushAllParser();
            FlushAllCommand cmd = parser.parse(toObjectArray("flushall".split(" ")));
            assertEquals(null, cmd.isAsync());

            parser = new FlushAllParser();
            cmd = parser.parse(toObjectArray("flushall async".split(" ")));
            assertEquals(Boolean.TRUE, cmd.isAsync());
            System.out.println(cmd);
        }

        {
            FlushDBParser parser = new FlushDBParser();
            FlushDBCommand cmd = parser.parse(toObjectArray("flushdb".split(" ")));
            assertEquals(null, cmd.isAsync());

            parser = new FlushDBParser();
            cmd = parser.parse(toObjectArray("flushdb async".split(" ")));
            assertEquals(Boolean.TRUE, cmd.isAsync());
            System.out.println(cmd);
        }
    }

}