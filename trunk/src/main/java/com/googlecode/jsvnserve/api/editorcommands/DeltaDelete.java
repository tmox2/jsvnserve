/*
 * Copyright 2009 The jSVNServe Team
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
 *
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */

package com.googlecode.jsvnserve.api.editorcommands;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.googlecode.jsvnserve.SVNSessionStreams;
import com.googlecode.jsvnserve.element.ListElement;
import com.googlecode.jsvnserve.element.WordElement.Word;

/**
 * Represents the delete from the command editor.
 *
 * @author jSVNServe Team
 * @version $Id$
 */
public class DeltaDelete
        extends AbstractDelta
{
    DeltaDelete(final String _path,
                final String _lastAuthor,
                final Long _committedRevision,
                final Date _committedDate)
    {
        super(null, _path, null, null, _lastAuthor, _committedRevision, _committedDate);
    }

    @Override
    protected void writeOpen(final SVNSessionStreams _streams,
                             final String _parentToken)
            throws UnsupportedEncodingException, IOException
    {
        _streams.writeItemList(
                new ListElement(Word.DELETE_ENTRY,
                                new ListElement(getPath(),
                                    new ListElement(getCommittedRevision()),
                                                _parentToken)));
    }

    @Override
    protected void writeClose(final SVNSessionStreams _streams)
    {
    }
}
