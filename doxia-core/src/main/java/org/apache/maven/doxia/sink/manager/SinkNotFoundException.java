package org.apache.maven.doxia.sink.manager;/*
 * Copyright 2004-2005 The Apache Software Foundation.
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

/**
 * @author <a href="mailto:jason@maven.org">Jason van Zyl</a>
 * @version $Id:SinkNotFoundException.java 348605 2005-11-24 12:02:44 +1100 (Thu, 24 Nov 2005) brett $
 */
public class SinkNotFoundException
    extends Exception
{
    public SinkNotFoundException( String message )
    {
        super( message );
    }

    public SinkNotFoundException( Throwable cause )
    {
        super( cause );
    }

    public SinkNotFoundException( String message, Throwable cause )
    {
        super( message, cause );
    }
}
