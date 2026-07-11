int lengthOfLongestSubstring(char *s) {
    int last[256] = {0};
    int left = 0;
    int maxLen = 0;

    for (int right = 0; s[right] != '\0'; right++) {
        unsigned char ch = s[right];

        if (last[ch] > left) {
            left = last[ch];
        }

        int currentLen = right - left + 1;

        if (currentLen > maxLen) {
            maxLen = currentLen;
        }

        last[ch] = right + 1;
    }

    return maxLen;
}