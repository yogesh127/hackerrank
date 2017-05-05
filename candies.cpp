#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    long long n;
    cin>>n;
    long long rating[n],candies[n],i;//rating and candies 
    for(i=0;i<n;i++)
        {
        cin>>rating[i];//take rating input 
        candies[i]=1;//all have one candy intially
    }
    //check from left to right
    for(i=1;i<n;i++)
        {
        if(rating[i]>rating[i-1])
            candies[i]+=candies[i-1];
    }
    //check from right to left
    for(i=n-1-1;i>=0;i--)
        {
        if(rating[i]>rating[i+1]&&candies[i]<candies[i+1]+1)
            candies[i]=candies[i+1]+1;
    }
    //taking total candies in sum
    long long sum=0;
    for(i=0;i<n;i++)
        sum+=candies[i];
    cout<<sum;
    return 0;
}

