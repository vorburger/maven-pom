package org.apache.maven.doxia;

/*
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

import org.apache.maven.doxia.site.renderer.SiteRenderer;
import org.codehaus.plexus.PlexusTestCase;

import java.io.File;

/**
 * @author <a href="mailto:jason@maven.org">Jason van Zyl</a>
 * @version $Id:SiteRenderingTest.java 348605 2005-11-24 12:02:44 +1100 (Thu, 24 Nov 2005) brett $
 */
public class SiteRenderingTest
    extends PlexusTestCase
{
    public void testApt()
        throws Exception
    {
        SiteRenderer r = (SiteRenderer) lookup( SiteRenderer.ROLE );

        File siteDirectory = new File( getBasedir(), "src/test/site" );

        File generatedSiteDirectory = new File( getBasedir(), "src/test/site-generated" );

        File outputDirectory = new File( getBasedir(), "target/site" );

        if ( !outputDirectory.exists() )
        {
            outputDirectory.mkdirs();
        }

        File resourcesDirectory = new File( siteDirectory, "resources" );

        r.render( siteDirectory.getPath(), generatedSiteDirectory.getPath(), outputDirectory.getPath(),
                  resourcesDirectory );
    }
}
