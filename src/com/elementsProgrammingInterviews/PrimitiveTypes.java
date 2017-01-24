package com.elementsProgrammingInterviews;

/**
 * Created by richa on 1/24/17.
 *
 */
public class PrimitiveTypes {

    /**
     *  Parity = 1 if the number of set bits in the number is even. Parity = 0 if the number of set bits in the number is odd
     *  Find the parity of a non negative number
     *
     * @param num - number
     * @return - parity
     */
    public int findParity(int num){

        int result = 0;
        while(num > 0){
            result = result ^ (num & 1);
            num = num >> 1;
        }

        return result;
    }

    /**
     *  Swaps the bits at the indices i and j of a number
     *
     * @param num - number
     * @param i - index to be swapped
     * @param j - index to be swapped
     * @return - number with indices swapped
     */
    public int swapBits(int num, int i, int j){

        if(((num >> i) & 1) != ((num >> j) & 1)){
            num ^= (1 << i) | (1 << j);
        }

        return num;
    }

    

}
