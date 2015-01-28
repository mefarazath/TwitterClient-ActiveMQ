/*
 *
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * /
 */

package org.wso2.cep.uima.demo.Util;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by farazath on 1/5/15.
 */
public class Tweet implements Serializable{

    private String text;
    private Date createdAt;
    private long id;

   
	public Tweet(Long id, Date createdAt, String text) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
    }

	public long getId() {
		return id;
	}
	
    public String getText() {
        return text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return text+"  ["+createdAt.toString()+"]   id: "+id;
    }

}
