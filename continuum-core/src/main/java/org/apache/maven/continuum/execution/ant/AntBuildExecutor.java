package org.apache.maven.continuum.execution.ant;

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

import org.apache.maven.continuum.execution.AbstractBuildExecutor;
import org.apache.maven.continuum.execution.ContinuumBuildExecutionResult;
import org.apache.maven.continuum.execution.ContinuumBuildExecutor;
import org.apache.maven.continuum.execution.ContinuumBuildExecutorException;
import org.apache.maven.continuum.project.AntProject;
import org.apache.maven.continuum.project.ContinuumProject;
import org.codehaus.plexus.util.StringUtils;

import java.io.File;

/**
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @version $Id$
 */
public class AntBuildExecutor
    extends AbstractBuildExecutor
    implements ContinuumBuildExecutor
{
    // ----------------------------------------------------------------------
    //
    // ----------------------------------------------------------------------

    public static final String CONFIGURATION_EXECUTABLE = "executable";

    public static final String CONFIGURATION_TARGETS = "targets";

    public static final String ID = "ant";

    // ----------------------------------------------------------------------
    //
    // ----------------------------------------------------------------------

    public AntBuildExecutor()
    {
        super( ID, true );
    }

    // ----------------------------------------------------------------------
    // ContinuumBuilder Implementation
    // ----------------------------------------------------------------------

    public ContinuumBuildExecutionResult build( ContinuumProject p, File buildOutput )
        throws ContinuumBuildExecutorException
    {
        AntProject project = (AntProject) p;

        String executable = project.getExecutable();

        String arguments = StringUtils.clean( project.getCommandLineArguments() ) + " " +
                           StringUtils.clean( project.getTargets() );

        return executeShellCommand( project,
                                    executable,
                                    arguments,
                                    buildOutput );
    }

    public void updateProjectFromCheckOut( File workingDirectory, ContinuumProject p )
        throws ContinuumBuildExecutorException
    {
        AntProject project = (AntProject) p;

        if ( project.getTargets() == null )
        {
            project.setTargets( "" );
        }
    }
}
