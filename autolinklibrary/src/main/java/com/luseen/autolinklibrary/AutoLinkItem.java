package com.luseen.autolinklibrary;

/**
 * Created by Chatikyan on 25.09.2016-19:43.
 */

class AutoLinkItem {

    private AutoLinkMode autoLinkMode;

    private String matchedText;
    private String shortText;
    private int startPoint, endPoint;

    AutoLinkItem(int startPoint, int endPoint, String matchedText, AutoLinkMode autoLinkMode) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.matchedText = matchedText;
        this.autoLinkMode = autoLinkMode;

        int length = matchedText.length();
        if (length > 30 && autoLinkMode == AutoLinkMode.MODE_URL) {
            shortText = matchedText.substring(0, 15) + "..." + matchedText.substring(length - 12);
            this.endPoint = startPoint + shortText.length();
        }
    }

    AutoLinkMode getAutoLinkMode() {
        return autoLinkMode;
    }

    String getMatchedText() {
        return matchedText;
    }

    String getShortText() {
        return shortText;
    }

    int getStartPoint() {
        return startPoint;
    }

    int getEndPoint() {
        return endPoint;
    }

    /**
     * Shift left the span since we may shorten some other span before.
     */
    void shiftLeft(int pos) {
        startPoint = startPoint - pos;
        endPoint = endPoint - pos;
    }
}
