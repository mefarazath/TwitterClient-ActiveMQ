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

/**
 * Created by farazath on 1/23/15.
 */
public class TwitterConfiguration {

    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;
    private String userToSearch;
    private int maxTweets;
    private long[] followers;

    TwitterConfiguration(){

    }

    public String getConsumerKey() {
        return consumerKey;
    }
    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }
    public String getConsumerSecret() {
        return consumerSecret;
    }
    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }
    public String getUserToSearch() {
        return userToSearch;
    }
    public void setUserToSearch(String userToSearch) {
        this.userToSearch = userToSearch;
    }
    public long[] getFollowers() {
        return followers;
    }
    public void setFollowers(long[] followers) {
        this.followers = followers;
    }
    public int getMaxTweets() {
        return maxTweets;
    }
    public void setMaxTweets(int maxTweets) {
        this.maxTweets = maxTweets;
    }
}