#include <string>
#include <vector>
#include <iostream>
#include <cstdlib>
using namespace std;

bool checker[26];

string solution(string s, string skip, int index) {
    string ans = "";
    
    for(int i = 0 ; i < skip.size();i++)
        checker[skip[i] - 'a'] = true;
    for(int i = 0 ; i < s.size();i++) {
        int cnt = 0;
        char cur = s[i];
        while(cnt != index) {
            cur += 1;
            if (cur > 'z')
                cur = 'a';
            if (checker[cur-'a']){
                continue;
            }
            else
                cnt++;
                if (cnt == index)
                    ans += cur;
        }
    }
    return ans;
}