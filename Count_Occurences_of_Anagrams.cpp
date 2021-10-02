#include<bits/stdc++.h>
using namespace std;
#define IO() ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)

int main(){

	IO();

	string s = "forxxorfxdofr";
	string anagram = "for";
	int k = anagram.size();

	unordered_map<char,int> m;
	for(auto &i: anagram){
		m[i]++;
	}
	int count = m.size();

	// vector<int> v;

	int i = 0, j = 0, ans = 0;
	while(j < s.size()){
		// calculations
		if(m.find(s[j]) != m.end()){
			m[s[j]]--;
			if(m[s[j]] == 0) count--;
		}

		if(j - i + 1 < k ) j++;

		else if(j - i + 1 == k){
			// take answer from calculations
			if(count == 0) {
				ans++;
				// v.push_back(i);
			}
			
			if(m.find(s[i]) != m.end()){
				m[s[i]]++;
				if(m[s[i]] == 1) count++;
			}
			//slide the window
			i++; j++;
		}
	}
	cout<<ans;
	// for(auto i : v){
	// 	cout << i << " ";
	// }


	return 0;
}
