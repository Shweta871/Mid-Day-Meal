
/*

 */

/*

 */

package com.branding.middaymeal.pojo;

public class PastRecordFeedItem {
    private String liveFeedData;
    private boolean descrepancy;

    public boolean isDescrepancy() {
        return descrepancy;
    }

    public void setDescrepancy(boolean descrepancy) {
        this.descrepancy = descrepancy;
    }

    public String getLiveFeedData() {
        return liveFeedData;
    }

    public void setLiveFeedData(String liveFeedData) {
        this.liveFeedData = liveFeedData;
    }
}
