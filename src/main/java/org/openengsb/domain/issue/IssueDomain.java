/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openengsb.domain.issue;

import java.util.List;
import java.util.HashMap;

import org.openengsb.core.api.Domain;
import org.openengsb.domain.issue.models.Issue;
import org.openengsb.domain.issue.models.IssueAttribute;

// @extract-start IssueDomain
public interface IssueDomain extends Domain {

    /**
     * creates an issue on the server and returned the generated id
     */
    String createIssue(Issue issue);

    /**
     * add a comment to an issue, specified by his id
     */
    void addComment(String id, String comment);

    /**
     * update an issue, specified by his id, the comment param can be null, changes: key of map is what field has to be
     * changed,
     */
    void updateIssue(String id, String comment, HashMap<IssueAttribute, String> changes);


    /**
     * move all issues from one release ( specified by releaseFromId ) to another release ( specified by releaseToId )
     */
    void moveIssuesFromReleaseToRelease(String releaseFromId, String releaseToId);

    /**
     * close a release specified by his id
     */
    void closeRelease(String id);

    /**
     * generates an report for all closed issues belonging the the specified release
     */
    List<String> generateReleaseReport(String releaseId);

    /**
     * adds a component
     */
    void addComponent(String component);
    
    /**
     * removes a component
     */
    void removeComponent(String component);
}
// @extract-end
