package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richa on 3/25/17.
 *
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

 Machine 1 (sender) has the function:

 string encode(vector<string> strs) {
 // ... your code
 return encoded_string;
 }
 Machine 2 (receiver) has the function:
 vector<string> decode(string s) {
 //... your code
 return strs;
 }
 So Machine 1 does:

 string encoded_string = encode(strs);
 and Machine 2 does:

 vector<string> strs2 = decode(encoded_string);
 strs2 in Machine 2 should be the same as strs in Machine 1.

 Implement the encode and decode methods.
 */
public class EncodeDecodeStrings {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for(String s : strs) {
                sb.append(s.length()).append('/').append(s);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> ret = new ArrayList<String>();
            if(s.length() == 0){
                return ret;
            }
            int i = 0;
            while(i < s.length()) {
                int slash = s.indexOf('/', i);
                int size = Integer.valueOf(s.substring(i, slash));
                ret.add(s.substring(slash + 1, slash + size + 1));
                i = slash + size + 1;
            }
            return ret;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
}
